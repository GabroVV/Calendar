package view;

import java.util.Calendar;
import java.util.Scanner;

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
				String title,description,place,alarmt,alarm = null,start,end;
				Boolean alarmBool;
				System.out.println("Input title");
				title = reader.nextLine();
				System.out.println(title);
				
				System.out.println("Input description");
				description = reader.nextLine();
				System.out.println(description);
				
				System.out.println("Input place");
				place = reader.nextLine();
				System.out.println(place);
				
				System.out.println("Input start time");
				start = reader.nextLine();
				System.out.println(start);
				
				System.out.println("Input end time");
				end = reader.nextLine();
				System.out.println(end);
				
				System.out.println("Input alarm (y/n)");
				alarmt = reader.nextLine();
				System.out.println(alarmt);
				if(alarmt.equals("y")){
					alarmBool = true;
				}
				else {
					alarmBool = false;
				}
				
				if(alarmBool) {
					System.out.println("Input alarm time");
					alarm = reader.nextLine();
					System.out.println(alarm);
				}
				
				MyEvent e = new MyEvent(title,description,place,Boolean.getBoolean(alarmt),DateToReadableString.reverseStringToCalendar(alarm),DateToReadableString.reverseStringToCalendar(start),DateToReadableString.reverseStringToCalendar(end));
				events.addEvent(e);
				
				break;
			}
			case '3':{
				OperationsXML.loadFromXML(events);
				System.out.println("Loaded events from XML file");
				break;
			}
			default:{
				break;
			}
		}
	}
	
	
}

