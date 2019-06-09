package view;

import java.util.Calendar;
import java.util.Scanner;

import javax.xml.datatype.DatatypeConfigurationException;

import data.*;
import logic.*;


public class TextInterface {
	EventCollection events;
	Scanner reader;
	public TextInterface(EventCollection events){
		this.events = events;
		reader = new Scanner(System.in);
	}
	
	public void displayMenu() {
		System.out.println("Choose operation: ");
		System.out.println("1. Display all events");
		System.out.println("2. Add event");
		System.out.println("3. Load events from XML file");
		System.out.println("4. Save events to XML file");
		System.out.println("5. Delete events older than given date");
		
	}
	
	public char getUserInput() {
		char result = reader.next().charAt(0);		
		reader.nextLine();
		return result;
	}
	
	public void executeAction(int number) {
		switch(number) {
			case '1':{
				for(int i=0;i<events.getEvents().size();i++)
				{
					System.out.println(events.getEvent(i));
				}
				break;
			}
			case '2':{
				String title,description,place,alarmt = "e",alarm = null,start=null,end=null;
				Boolean alarmBool = false;
				Boolean goodFormat = false;
				Calendar alarmCalendar = null;
			
				System.out.println("Input title");
				title = reader.nextLine();
				
				System.out.println("Input description");
				description = reader.nextLine();
				
				System.out.println("Input place");
				place = reader.nextLine();
				
				while(goodFormat == false)
				{
					System.out.println("Input start date in DD/MM/YYYY HH:MM format");
					start = reader.nextLine();
					if(DateToReadableString.checkFormat(start)) {
						goodFormat = true;
					}
				}
				
				goodFormat = false;
				while(goodFormat == false)
				{
					System.out.println("Input end date in DD/MM/YYYY HH:MM format ");
					end = reader.nextLine();
					if(DateToReadableString.checkFormat(end)) {
						goodFormat = true;
					}
				}
			
				while((alarmt.equals("y") || alarmt.equals("n")) == false)
				{
					System.out.println("Input alarm (y/n)");
					alarmt = reader.nextLine();
					if(alarmt.equals("y")){
						alarmBool = true;
					}
					else {
						alarmBool = false;
					}
				}
			
				if(alarmBool) {
					goodFormat = false;
					while(goodFormat == false)
					{
						if(DateToReadableString.checkFormat(alarm)) {
							goodFormat = true;
							alarmCalendar = DateToReadableString.reverseStringToCalendar(alarm);
						}
					}
				}
				
				MyEvent e = new MyEvent(title,description,place,Boolean.getBoolean(alarmt),alarmCalendar,DateToReadableString.reverseStringToCalendar(start),DateToReadableString.reverseStringToCalendar(end));
				events.addEvent(e);
				
				break;
			}
			case '3':{
				OperationsXML.loadFromXML(events);
				System.out.println("Loaded events from XML file");
				break;
			}
			
			case '4':{
				try {
					OperationsXML.saveToXML(events);
				}
				catch(DatatypeConfigurationException e) {
					System.out.println("Failed to save to XML");
				}
				
				System.out.println("Saved events to XML file");
				break;
			}
			case '5':{
				System.out.println("Input date in DD/MM/YYYY HH:MM format");
				String datestr = reader.nextLine();
				Calendar date = DateToReadableString.reverseStringToCalendar(datestr);
				EventCollectionController evc = new EventCollectionController();
				evc.removeEventsBeforeDate(events, date);
				
				break;
			}
			default:{
				break;
			}
		}
	}
	
	
}

