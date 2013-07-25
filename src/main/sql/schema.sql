create table springdemo.customer (
	customer_id int(11) auto_increment not null,
	first_name varchar(255) not null,
	last_name varchar(255) not null,
	zip varchar(10) not null,
	primary key(customer_id)
);

create table springdemo.customer_event (
	event_id int(11) auto_increment not null,
	customer_id int(11) not null,
	event_type enum('name', 'address') not null,
	status enum('incomplete', 'pending', 'complete') not null default 'incomplete',
	primary key(event_id),
	foreign key (customer_id) references customer(customer_id)
);

create table quarantined_springdemo.customer_event (
	event_id int(11) auto_increment not null,
	customer_id int(11) not null,
	event_type enum('name', 'address') not null,
	status enum('incomplete', 'pending', 'complete') not null default 'incomplete',
	primary key(event_id)
);

-- ********** springdemo sprocs

delimiter //
create procedure springdemo.next_customer_event()
begin
	declare tempId int default 0;
	declare done int default 0;

	declare cur cursor for
		select event_id from customer_event where status = 'incomplete' order by event_id limit 1;
	declare continue handler for not found set done = 1;

	start transaction;
		open cur;

		repeat
			fetch cur into tempId;
			update customer_event set status = 'pending' where event_id = tempId;
		until done = 1 end repeat;
		close cur;

		select * from customer_event where event_id = tempId;

	commit;
end //
delimiter ;


delimiter //
create trigger trg_update_customer after update on customer for each row
begin
	if (new.first_name <> old.first_name or new.last_name <> old.last_name) then
		insert into customer_event (customer_id, event_type) values (new.customer_id, 'name');
	end if;

	if (new.zip <> old.zip) then
		insert into customer_event (customer_id, event_type) values (new.customer_id, 'address');
	end if;
end //
delimiter ;

-- ********** quarantined sprocs

delimiter //
create procedure quarantined_springdemo.next_customer_event ()
begin
	declare tempId int default 0;
	declare done int default 0;

	declare cur cursor for
		select event_id from customer_event where status = 'incomplete' order by event_id limit 1;
	declare continue handler for not found set done = 1;

	start transaction;
		open cur;

		repeat
			fetch cur into tempId;
			update customer_event set status = 'pending' where event_id = tempId;
		until done = 1 end repeat;
		close cur;

		select * from customer_event where event_id = tempId;

	commit;
end //
delimiter ;


drop procedure if exists quarantined_springdemo.copy_event;

delimiter //
create procedure quarantined_springdemo.copy_event (in real_event_id int(11))
begin
	declare tempCustId int default 0;
	declare tempEventType varchar(20) default 0;
	declare done int default 0;

	declare cur cursor for
		select customer_id, event_type from springdemo.customer_event where event_id = real_event_id;
	declare continue handler for not found set done = 1;

	start transaction;
		open cur;

		fetch cur into tempCustId, tempEventType;
		insert into quarantined_springdemo.customer_event (customer_id, event_type, status) values (tempCustId, tempEventType, 'incomplete');
		close cur;

		select * from quarantined_springdemo.customer_event where event_id = last_insert_id();

	commit;
end //
delimiter ;
