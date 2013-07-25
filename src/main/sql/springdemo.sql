-- springdemo
insert into customer (first_name, last_name, zip) values ('John', 'Doe', '12345');
insert into customer (first_name, last_name, zip) values ('Jane', 'Smith', '67890');

insert into customer_event (customer_id, event_type) values (1, 'name');
insert into customer_event (customer_id, event_type) values (2, 'address');

select * from customer_event order by event_id desc;
select * from customer cust inner join customer_event event on cust.customer_id = event.event_id order by cust.customer_id, event.event_id;

-- quarantine
call quarantined_springdemo.copy_event(2);

select * from quarantined_springdemo.customer_event order by event_id desc;


select * from customer;
update customer set first_name = 'John', zip = '12345' where customer_id = 1;
update customer set first_name = 'Johnny' where customer_id = 1;
update customer set first_name = 'J', zip = '24680' where customer_id = 1;

select * from customer_event order by event_id desc;

