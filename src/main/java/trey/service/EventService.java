package trey.service;

import trey.model.Event;

public interface EventService {

	/**
	 * Mark the next event as pending and send to the processing queue.
	 */
	void startNextEvent();

	/**
	 * Read from the processing queue and mark the event as complete.
	 * 
	 * @return
	 */
	Event completePendingEvent();

}
