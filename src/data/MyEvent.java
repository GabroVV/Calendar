package data;
import java.util.*;
import logic.*;

/**
 * Klasa reprezentuj¹ca wydarzenie
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
	 * Konstruktor domyœlny
	 */
	public MyEvent() {}
	
	/**
	 * Konstruktor klasy MyEvent
	 * @param title tytu³ wydarzenia
	 * @param description opis wydarzenia
	 * @param place miejsce wydarzenia
	 * @param alarmTrigger boolean, czy alarm jest ustawiony
	 * @param alarmDate data alarmu
	 * @param startDate data rozpoczêcia
	 * @param endDate data zakoñczenia
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
	 * Zwraca tytu³ wydarzenia
	 * @return tytu³
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Ustawia tytu³ wydarzenia
	 * @param title tytu³
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
	 * @return true, jeœli alarm jest ustawiony
	 */
	public boolean isAlarmTrigger() {
		return alarmTrigger;
	}
	
	/**
	 * Ustawia alarm
	 * @param alarmTrigger true ¿eby ustawiæ alarm
	 */
	public void setAlarmTrigger(boolean alarmTrigger) {
		this.alarmTrigger = alarmTrigger;
	}
	
	/**
	 * Zwraca datê alarmu
	 * @return data alarmu
	 */
	public Calendar getAlarmDate() {
		return alarmDate;
	}
	
	/**
	 * Ustawia datê alarmu
	 * @param alarmDate data alarmu
	 */
	public void setAlarmDate(Calendar alarmDate) {
		this.alarmDate = alarmDate;
	}
	
	/**
	 * Zwraca datê rozpoczêcia
	 * @return data rozpoczêcia
	 */
	public Calendar getStartDate() {
		return startDate;
	}
	
	/**
	 * Ustawia datê rozpoczêcia
	 * @param startDate data rozpoczêcia
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	/**
	 * Zwraca datê zakoñczenia
	 * @return data zakoñczenia
	 */
	public Calendar getEndDate() {
		return endDate;
	}
	
	/**
	 * Ustawia datê zakoñczenia
	 * @param endDate data zakoñczenia
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	/**
	 * Zwraca godzinê alarmu
	 * @return godzina alarmu
	 */
	public int getAlarmHour()
	{
		return alarmHour;
	}
	
	/**
	 * Ustawia godzinê alarmu
	 */
	public void setAlarmHour()
	{
		this.alarmHour = alarmDate.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * Zwraca minutê alarmu
	 * @return minuta alarmu
	 */
	public int getAlarmMinute()
	{
		return alarmMinute;
	}
	
	/**
	 * Ustawia minutê alarmu
	 */
	public void setAlarmMinute()
	{
		this.alarmMinute = alarmDate.get(Calendar.MINUTE);
	}

	/**
	 * Nadpisana metoda compareTo, porównuje daty rozpoczêcia
	 * @param e wydarzenie do porównania
	 * @return 1 jeœli dane wydarzenie zaczyna siê wczeœniej od porównywanego, -1 jeœli póŸniej, 0 jeœli zaczynaj¹ siê w tym samym czasie
	 */
	@Override
	public int compareTo(MyEvent e) {
		
		return startDate.compareTo(e.getStartDate());
	}
	
	/**
	 * Wyœwietla datê
	 * @param date data
	 * @return opisana data
	 */
	public static String displayDate(Calendar date)
	{
		return  DateToReadableString.dateToString(date);
	}

	/**
	 * Nadpisana metoda toString(), wyœwietla szczegó³y wydarzenia
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
