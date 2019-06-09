package logic;
import java.util.*;
import data.*;

/**
 * Klasa klasyfikuj�ca wydarzenia wzgl�dem czasu
 *
 */
public class EventCollectionController {
	
	/**
	 * Sortuje wydarzenia po dacie rozpocz�cia
	 * @param collection lista wszystkich wydarze�
	 */
	public static void sortEventsByDate(EventCollection collection) {
		Collections.sort(collection.getEvents());
	}
	
	/**
	 * Zwraca liste zawierajaca wydarzenia odbywajacie sie w trakcie podanego dnia.
	 * @param source lista wszystkich wydarze�
	 * @param givenDate wybrana data
	 * @return lista wydarze�
	 */
	public EventCollection getEventsOnDate(EventCollection source, Calendar givenDate) {
		EventCollection result = new EventCollection();
		for(int i=0; i<source.getEvents().size();i++) {
			if(eventIsOnGivenDate(source.getEvent(i),givenDate)){
				result.addEvent(source.getEvent(i));
			}
		}
		return result;
	}

	/**
	 * Sprawdza czy wydarzenia odbywa sie w trakcie podanego dnia
	 * @param event wybrane wydarzenie
	 * @param date wybrana data
	 * @return true je�li wydarzenie odbywa si� w danym czasie
	 */
	public boolean eventIsOnGivenDate(MyEvent event, Calendar date) {
		if(event.getStartDate().get(Calendar.YEAR) > date.get(Calendar.YEAR) || 
		   event.getEndDate().get(Calendar.YEAR) < date.get(Calendar.YEAR)){		
			return false;
		}
		
		if(event.getStartDate().get(Calendar.MONTH) > date.get(Calendar.MONTH) || 
				   event.getEndDate().get(Calendar.MONTH) < date.get(Calendar.MONTH)){		
					return false;
				}
		
		if(event.getStartDate().get(Calendar.DAY_OF_MONTH) > date.get(Calendar.DAY_OF_MONTH) || 
				   event.getEndDate().get(Calendar.DAY_OF_MONTH) < date.get(Calendar.DAY_OF_MONTH)){		
					return false;
				}		
		return true;
	}
	
	/**
	 * Usuwa wydarzenia ko�cz�ce si� przed podanym dniem
	 * @param source lista wszystkich wydarze�
	 * @param givenDate wybrana data
	 */
	public void removeEventsBeforeDate(EventCollection source, Calendar givenDate) {
		for(int i=source.getEvents().size()-1; i>=0;i--)
		{	
			if(source.getEvents().get(i).getEndDate().before(givenDate)) {
				source.getEvents().remove(i);
			}
		}
	}
	
}
