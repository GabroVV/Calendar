package data;

import java.util.*;

/**
 * Klasa przechowuj¹ca wydarzenia
 *
 */
public class EventCollection{

	List<MyEvent> events;
	
	/**
	 * Konstruktor klasy EventCollection, tworzy listê wydarzeñ
	 */
	public EventCollection(){
		events = new ArrayList<MyEvent>();
	}

	/**
	 * Zwraca listê wydarzeñ
	 * @return lista wydarzeñ
	 */
	public List<MyEvent> getEvents() {
		return events;
	}
	
	/**
	 * Zapisuje wydarzenia do listy
	 * @param events lista wydarzeñ
	 */
	public void setEvents(List<MyEvent> events) {
		this.events = events;
	}

	/**
	 * Dodaje wydarzenie do listy
	 * @param e dane wydarzenie
	 * @return true, jeœli zapisywanie powiedzie siê
	 */
	public boolean addEvent(MyEvent e) {
		return events.add(e);
	}
	
	public boolean addEvent(String title, String description, String place, boolean alarmTrigger, Calendar alarmDate,Calendar startDate, Calendar endDate)
	{
		return events.add(new MyEvent(title, description, place, alarmTrigger, alarmDate,startDate,  endDate));
	}
	
	/**
	 * Usuwa wydarzenie z listy
	 * @param e wybrane wydarzenie
	 * @return true, jeœli usuwanie powiedzie siê
	 */
	public boolean removeEvent(MyEvent e) {
		if (events.size() == 0)
			throw new IndexOutOfBoundsException();
		else
			return events.remove(e);
	}
	
	/**
	 * Zwraca wybrane wydarzenie
	 * @param i indeks wydarzenia
	 * @return wydarzenie
	 */
	public MyEvent getEvent(int i) {
		return events.get(i);
	}
	
	/**
	 * Nadpisana metoda toString()
	 * @return opis wydarzenia
	 */
	@Override
	public String toString()
	{
		String tmp = "";
		
		for (int i=0; i<events.size(); i++)
			tmp += events.get(i).toString();
		
		return tmp;
	}
}
