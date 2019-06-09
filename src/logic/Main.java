package logic;

import java.awt.EventQueue;

import view.*;
import data.*;

/**
 * G³ówna klasa programu
 *
 */
public class Main
{
	
	/**
	 * Umo¿liwia wybór dzia³ania aplikacji poprzez wprowadzenie odpowiedniego argumentu konfiguracji: 1 - aplikacja z graficznym interfejsem u¿ytkownika, 
	 * 2 - aplikacja z interfejsem tekstowym
	 * @param args tablica Stringów
	 */
	public static void main(String[] args)
	{
		try
		{
			EventCollection events = new EventCollection();
			if (args.length == 0)
			{
				throw new ArrayIndexOutOfBoundsException("Configuration argument required");
			}
			else if (args[0].equals("g"))
			{
				
				EventQueue.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		            	CalendarFrame calendarFrame = new CalendarFrame(events);
		            }
		        });
			}
			else if (args[0].equals("t"))
			{
				TextInterface tui = new TextInterface(events);
				while(true) {
					tui.displayMenu();
					int action = tui.getUserInput();
					tui.executeAction(action);
				}
			}
			else System.out.println("Wrong configuration argument."
					+ "\nChoose g if you want to use GUI"
					+ "\nChoose t if you want to use TUI");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
