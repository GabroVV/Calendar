package data;

import java.util.*;

public class EventCollection{
	List<MyEvent> events;
	

	public List<MyEvent> getEvents() {
		return events;
	}

	public void setEvents(List<MyEvent> events) {
		this.events = events;
	}

	public EventCollection(){
		events = new ArrayList<MyEvent>();
	}
	
	public boolean addEvent(MyEvent e) {
		return events.add(e);
	}
	
	public boolean removeEvent(MyEvent e) {
		return events.remove(e);
	}
	
	public MyEvent getEvent(int i) {
		return events.get(i);
	}
}
