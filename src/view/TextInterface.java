package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.xml.datatype.DatatypeConfigurationException;

import data.*;
import logic.*;

/**
 * Klasa obs³uguj¹ca tekstowy interfejs u¿ytkownika
 *
 */
public class TextInterface {
	EventCollection events;
	Scanner reader;
	
	/**
	 * Konstruktor klasy TextInterface
	 * @param events lista wydarzeñ
	 */
	public TextInterface(EventCollection events){
		this.events = events;
		reader = new Scanner(System.in);
	}
	
	/**
	 * Wyœwietla interfejs tekstowy
	 */
	public void displayMenu() {
		System.out.println("Choose operation: ");
		System.out.println("1. Display all events");
		System.out.println("2. Add event");
		System.out.println("3. Delete event");
		System.out.println("4. Load events from XML file");
		System.out.println("5. Save events to XML file");
		System.out.println("6. Delete events older than given date");
		System.out.println("7. Display info");
		
	}
	
	/**
	 * Pobiera wybór od u¿ytkownika
	 * @return znak wpisany przez u¿ytkownika
	 */
	public char getUserInput() {
		char result = reader.next().charAt(0);		
		reader.nextLine();
		return result;
	}
	
	/**
	 * Wykonuje operacje wybrane przez u¿ytkownika
	 * @param number numer wybranej funkcjonalnoœci
	 */
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
				
				Calendar dateStart = DateToReadableString.reverseStringToCalendar(start);
				Calendar dateEnd = DateToReadableString.reverseStringToCalendar(end);
				
				try
				{
					if (dateStart.after(dateEnd))
					{
						throw new DateException("Event must begin before its end");
					}
					else
					{
						if (isDateTheSame(dateStart, dateEnd) && !isHourStartBeforeEnd
							(
								Integer.parseInt(start.substring(11,13)),
								Integer.parseInt(start.substring(14,16)),
								Integer.parseInt(end.substring(11,13)),
								Integer.parseInt(end.substring(14,16))
							))
						{
							throw new DateException("Event must begin before its end");
						}
					}
				}
				catch (DateException e)
				{
					System.out.println(e.getMessage());
					break;
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
			case '4':{
				OperationsXML.loadFromXML(events);
				System.out.println("Loaded events from XML file");
				break;
			}
			
			case '5':{
				try {
					OperationsXML.saveToXML(events);
				}
				catch(DatatypeConfigurationException e) {
					System.out.println("Failed to save to XML");
				}
				
				System.out.println("Saved events to XML file");
				break;
			}
			case '6':{
				String datestr = null;
				boolean goodFormat = false;
				while(goodFormat == false)
				{
					System.out.println("Input date in DD/MM/YYYY HH:MM format");
					datestr = reader.nextLine();
					if(DateToReadableString.checkFormat(datestr)) {
						goodFormat = true;
					}
				}
				
				Calendar date = DateToReadableString.reverseStringToCalendar(datestr);
				EventCollectionController evc = new EventCollectionController();
				evc.removeEventsBeforeDate(events, date);
				
				break;
			}
			case '3':{
				System.out.println("Enter index of the event you want deleted");
				for(int i=0;i<events.getEvents().size();i++)
				{
					String eventDisplay = Integer.toString(i);		
					eventDisplay += ".  ";
					eventDisplay += events.getEvent(i);
					System.out.println(eventDisplay);
				}
				int choice;
				choice = reader.nextInt();
				reader.nextLine();
				if(choice<events.getEvents().size())
				{
					events.getEvents().remove(choice);
					System.out.println("Event deleted");

				}
				else
				{
					System.out.println("There is no such event");

				}
				
				break;
			}
			
			case '7':{
				System.out.println("Calendar made by Jakub Bogdan & Gabriel Nowak.\nUser can add events, set alarms, load and save data to XML.");
				break;
			}
			

			default:{
				break;
			}
		
		}
	}
	
		private boolean isDateTheSame(Calendar date1, Calendar date2)
		{
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date1.getTime());
			Calendar calendar2 = Calendar.getInstance();
			calendar2.setTime(date2.getTime());
			
			if (
					calendar.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH) && 
					calendar.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH) &&
					calendar.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
			   )
			{
				return true;
			}
			else return false;		
		}
		
		private boolean isHourStartBeforeEnd(int startHour, int startMinute, int endHour, int endMinute)
		{
			if (startHour == endHour)
			{
				if (startMinute <= endMinute)
					return true;
				else return false;
			}
			else if (startHour < endHour)
				return true;
			else return false;
		}
	
	
	
}

