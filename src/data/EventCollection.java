package data;

import java.util.*;

public class EventCollection{
	List<Event> events;
	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	EventCollection(){
		events = new ArrayList<Event>();
	}
	
	public boolean addEvent(Event e) {
		return events.add(e);
	}
	
	public boolean removeEvent(Event e) {
		return events.remove(e);
	}
	
	public Event getEvent(int i) {
		return events.get(i);
	}
}
