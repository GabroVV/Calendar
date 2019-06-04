package data;

import java.util.*;

public class EventCollection{
	List<MyEvent> events;
	
	public EventCollection(){
		events = new ArrayList<MyEvent>();
	}

	public List<MyEvent> getEvents() {
		return events;
	}

	public void setEvents(List<MyEvent> events) {
		this.events = events;
	}

	
	public boolean addEvent(MyEvent e) {
		return events.add(e);
	}
	
	public boolean removeEvent(MyEvent e) {
		if (events.size() == 0)
			throw new IndexOutOfBoundsException();
		else
			return events.remove(e);
	}
	
	public MyEvent getEvent(int i) {
		return events.get(i);
	}
	
	@Override
	public String toString()
	{
		String tmp = "";
		
		for (int i=0; i<events.size(); i++)
			tmp += events.get(i).toString();
		
		return tmp;
	}
}
