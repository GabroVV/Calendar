package view;

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
	
	public int getUserInput() {
		int result = reader.nextInt();
		reader.nextLine();
		return result;
	}
	
	public void executeAction(int number) {
		switch(number) {
			case 1:{
				for(int i=0;i<events.getEvents().size();i++)
				{
					System.out.println(events.getEvent(i));
				}
			}
			case 3:{
				OperationsXML.loadFromXML(events);
				System.out.println("Loaded events from XML file");
			}
		}
	}
	
	
}

