package trey.model;

public class Event {

	// private static final String DELIMITER = ",";

	public static enum EventType {
		name, address;
	}

	public static enum Status {
		incomplete, pending, complete;
	}

	private long eventId;
	private long customerId;
	private EventType eventType;
	private Status status;

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerEvent [eventId=").append(eventId).append(", customerId=").append(customerId)
				.append(", eventType=").append(eventType).append("]");
		return builder.toString();
	}

	// public static String marshal(CustomerEvent event) {
	// StringBuilder sb = new StringBuilder(256);
	// sb.append(event.getEventId()).append(",").append(event.getCustomerId()).append(",")
	// .append(event.getEventType().name());
	// return sb.toString();
	// }
	//
	// public static CustomerEvent marshal(String text) {
	// String[] tokens = text.split(DELIMITER);
	// CustomerEvent event = new CustomerEvent();
	// event.setEventId(Long.valueOf(tokens[0]));
	// event.setCustomerId(Long.valueOf(tokens[1]));
	// event.setEventType(EventType.valueOf(tokens[2]));
	// return event;
	// }

}
