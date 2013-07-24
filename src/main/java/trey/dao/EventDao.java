package trey.dao;

import trey.model.Event;

public interface EventDao {

	/**
	 * Update the event's status to complete.
	 * 
	 * @param eventId
	 * @return
	 */
	Event markEventComplete(long eventId);

	/**
	 * Fetch the event by id.
	 * 
	 * @param eventId
	 * @return
	 */
	Event getEventById(long eventId);

	/**
	 * Execute sproc to mark next event as pending and return it.
	 * 
	 * @return
	 */
	Event getNextEvent();

}
