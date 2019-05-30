package data;
import java.util.*;
public class Event implements Comparable<Event> {
	String title;
	String description;
	String place;
	boolean alarmTrigger;
	Calendar alarmDate;
	Calendar startDate;
	Calendar endDate;
	
	public Event() {
		
	}
	
	public Event(String title, String description, String place, boolean alarmTrigger, Calendar alarmDate,
			Calendar startDate, Calendar endDate) {
		super();
		this.title = title;
		this.description = description;
		this.place = place;
		this.alarmTrigger = alarmTrigger;
		this.alarmDate = alarmDate;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public boolean isAlarmTrigger() {
		return alarmTrigger;
	}
	public void setAlarmTrigger(boolean alarmTrigger) {
		this.alarmTrigger = alarmTrigger;
	}
	public Calendar getAlarmDate() {
		return alarmDate;
	}
	public void setAlarmDate(Calendar alarmDate) {
		this.alarmDate = alarmDate;
	}
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	@Override
	public int compareTo(Event e) {
		
		return startDate.compareTo(endDate);
	}
	
}
