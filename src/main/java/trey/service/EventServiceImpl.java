package trey.service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import trey.dao.EventDao;
import trey.model.Event;

public class EventServiceImpl implements EventService {

	private static final Logger LOG = Logger.getLogger(EventServiceImpl.class);

	private EventDao eventDao;
	private CustomerService customerService;

	private JmsTemplate jmsTemplate;
	private Destination processingQueue;

	public void startNextEvent() {
		final Event event = eventDao.getNextEvent();

		if (event != null) {
			jmsTemplate.send(processingQueue, new MessageCreator() {

				public Message createMessage(Session session) throws JMSException {
					TextMessage message = session.createTextMessage(String.valueOf(event.getEventId()));
					LOG.info("Sending message for Event: " + event);
					return message;
				}
			});
		}
	}

	public Event completePendingEvent() {
		String text = (String) jmsTemplate.receiveAndConvert(processingQueue);
		LOG.info("Received eventId: " + text);
		long eventId = Long.valueOf(text);
		Event event = eventDao.markEventComplete(eventId);

		customerService.getCustomer(event.getCustomerId());
		// do something interesting with the customer...

		return event;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setProcessingQueue(Destination processingQueue) {
		this.processingQueue = processingQueue;
	}

}
