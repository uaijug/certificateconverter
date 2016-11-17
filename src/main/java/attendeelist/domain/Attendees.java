package attendeelist.domain;

import com.google.gson.annotations.SerializedName;

public class Attendees {

	@SerializedName("attendees")
	private Event event;

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

}
