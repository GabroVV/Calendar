package data;
import java.util.*;
import logic.*;

/**
 * Klasa reprezentuj�ca wydarzenie
 *
 */
public class MyEvent implements Comparable<MyEvent> 
{
	String title;
	String description;
	String place;
	boolean alarmTrigger;
	Calendar alarmDate;
	Calendar startDate;
	Calendar endDate;
	
	int alarmHour;
	int alarmMinute;
	
	/**
	 * Konstruktor domy�lny
	 */
	public MyEvent() {}
	
	/**
	 * Konstruktor klasy MyEvent
	 * @param title tytu� wydarzenia
	 * @param description opis wydarzenia
	 * @param place miejsce wydarzenia
	 * @param alarmTrigger boolean, czy alarm jest ustawiony
	 * @param alarmDate data alarmu
	 * @param startDate data rozpocz�cia
	 * @param endDate data zako�czenia
	 */
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
		this.setAlarmHour();
		this.setAlarmMinute();
	}
	
	/**
	 * Zwraca tytu� wydarzenia
	 * @return tytu�
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Ustawia tytu� wydarzenia
	 * @param title tytu�
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Zwraca opis wydarzenia
	 * @return opis
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * Ustawia opis wydarzenia
	 * @param description opis
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Zwraca miejsce wydarzenia
	 * @return miejsce
	 */
	public String getPlace() {
		return place;
	}
	
	/**
	 * Ustawia miejsce wydarzenia
	 * @param place miejsce
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	/**
	 * Sprawdza czy alarm jest ustawiony
	 * @return true, je�li alarm jest ustawiony
	 */
	public boolean isAlarmTrigger() {
		return alarmTrigger;
	}
	
	/**
	 * Ustawia alarm
	 * @param alarmTrigger true �eby ustawi� alarm
	 */
	public void setAlarmTrigger(boolean alarmTrigger) {
		this.alarmTrigger = alarmTrigger;
	}
	
	/**
	 * Zwraca dat� alarmu
	 * @return data alarmu
	 */
	public Calendar getAlarmDate() {
		return alarmDate;
	}
	
	/**
	 * Ustawia dat� alarmu
	 * @param alarmDate data alarmu
	 */
	public void setAlarmDate(Calendar alarmDate) {
		this.alarmDate = alarmDate;
	}
	
	/**
	 * Zwraca dat� rozpocz�cia
	 * @return data rozpocz�cia
	 */
	public Calendar getStartDate() {
		return startDate;
	}
	
	/**
	 * Ustawia dat� rozpocz�cia
	 * @param startDate data rozpocz�cia
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Zwraca dat� zako�czenia
	 * @return data zako�czenia
	 */
	public Calendar getEndDate() {
		return endDate;
	}
	
	/**
	 * Ustawia dat� zako�czenia
	 * @param endDate data zako�czenia
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Zwraca godzin� alarmu
	 * @return godzina alarmu
	 */
	public int getAlarmHour()
	{
		return alarmHour;
	}
	
	/**
	 * Ustawia godzin� alarmu
	 */
	public void setAlarmHour()
	{
		this.alarmHour = alarmDate.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Zwraca minut� alarmu
	 * @return minuta alarmu
	 */
	public int getAlarmMinute()
	{
		return alarmMinute;
	}
	
	/**
	 * Ustawia minut� alarmu
	 */
	public void setAlarmMinute()
	{
		this.alarmMinute = alarmDate.get(Calendar.MINUTE);
	}

	/**
	 * Nadpisana metoda compareTo, por�wnuje daty rozpocz�cia
	 * @param e wydarzenie do por�wnania
	 * @return 1 je�li dane wydarzenie zaczyna si� wcze�niej od por�wnywanego, -1 je�li p�niej, 0 je�li zaczynaj� si� w tym samym czasie
	 */
	@Override
	public int compareTo(MyEvent e) {
		
		return startDate.compareTo(e.getStartDate());
	}
	
	/**
	 * Wy�wietla dat�
	 * @param date data
	 * @return opisana data
	 */
	public static String displayDate(Calendar date)
	{
		return  DateToReadableString.dateToString(date);
	}

	/**
	 * Nadpisana metoda toString(), wy�wietla szczeg�y wydarzenia
	 * @return opis wydarzenia
	 */
	@Override
	public String toString() 
	{
		String tmp;
		tmp = "MyEvent [title=" + title + ", description=" + description + ", place=" + place +
				", startDate=" + displayDate(startDate) +
				", endDate=" + displayDate(endDate) + ", alarmTrigger=" + alarmTrigger;
		
		if (alarmTrigger)
			tmp += ", alarmDate=" + displayDate(alarmDate);
			
		return tmp + "]";
	}
	
}
