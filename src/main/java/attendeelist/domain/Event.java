package attendeelist.domain;

import java.util.List;

public class Event {
	
	private String id;
	private List<Attendee> attendee;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Attendee> getAttendee() {
		return attendee;
	}

	public void setAttendee(List<Attendee> attendee) {
		this.attendee = attendee;
	}

}
