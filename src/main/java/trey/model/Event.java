package trey.model;

public class Event {

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
		builder.append("Event [eventId=").append(eventId).append(", customerId=").append(customerId)
				.append(", eventType=").append(eventType).append("]");
		return builder.toString();
	}

}
