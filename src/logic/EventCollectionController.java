package logic;
import java.util.Collections;

import data.*;

public class EventCollectionController {
	
	public void sortEventsByDate(EventCollection collection) {
		Collections.sort(collection.getEvents());
	}

}
