package trey.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import trey.model.Event;
import trey.model.Event.EventType;
import trey.model.Event.Status;

public class EventDaoImpl extends JdbcDaoSupport implements EventDao {

	public Event markEventComplete(long eventId) {
		getJdbcTemplate().update("update customer_event set status  = ? where event_id = ?", Status.complete.name(),
				eventId);
		return getEventById(eventId);
	}

	public Event getEventById(long eventId) {
		return getJdbcTemplate().queryForObject("select * from customer_event where event_id = ?",
				new Object[] { eventId }, new EventRowMapper());
	}

	public Event getNextEvent() {
		try {
			return getJdbcTemplate().queryForObject("call next_customer_event", new EventRowMapper());
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}

	private static class EventRowMapper implements RowMapper<Event> {
		public Event mapRow(ResultSet res, int rowNum) throws SQLException {
			Event event = new Event();
			event.setEventId(res.getLong("event_id"));
			event.setCustomerId(res.getLong("customer_id"));
			event.setEventType(EventType.valueOf(res.getString("event_type")));
			return event;
		}
	}

}
