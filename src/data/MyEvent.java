package data;
import java.util.*;
public class MyEvent implements Comparable<MyEvent> 
{
	String title;
	String description;
	String place;
	boolean alarmTrigger;
	Calendar alarmDate;
	Calendar startDate;
	Calendar endDate;
	
	public MyEvent() {}
	
	public MyEvent(String title, String description, String place, boolean alarmTrigger, Calendar alarmDate,
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
	public int compareTo(MyEvent e) {
		
		return startDate.compareTo(endDate);
	}

	@Override
	public String toString() {
		return "MyEvent [title=" + title + ", description=" + description + ", place=" + place + ", alarmTrigger="
				+ alarmTrigger + ", alarmDate=" + (alarmDate.get(Calendar.MONTH)+1) +"." + alarmDate.get(Calendar.DAY_OF_MONTH) +"." + alarmDate.get(Calendar.YEAR) +" " + alarmDate.get(Calendar.HOUR_OF_DAY)  +":" + alarmDate.get(Calendar.MINUTE) +
				", startDate=" + (startDate.get(Calendar.MONTH)+1) +"." + startDate.get(Calendar.DAY_OF_MONTH) +"." + startDate.get(Calendar.YEAR) +" " + startDate.get(Calendar.HOUR_OF_DAY)  +":" + startDate.get(Calendar.MINUTE) +
				", endDate=" + (endDate.get(Calendar.MONTH)+1) +"." + endDate.get(Calendar.DAY_OF_MONTH) +"." + endDate.get(Calendar.YEAR) +" " + endDate.get(Calendar.HOUR_OF_DAY)  +":" + endDate.get(Calendar.MINUTE) + "]";
	}
	
}
