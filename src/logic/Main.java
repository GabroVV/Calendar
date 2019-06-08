package logic;

import java.awt.EventQueue;

import view.*;
import data.*;

public class Main
{

	public static void main(String[] args)
	{
		try
		{
			if (args.length == 0)
			{
				throw new ArrayIndexOutOfBoundsException("Configuration argument required");
			}
			else if (Integer.parseInt(args[0]) == 1)
			{
				EventCollection events = new EventCollection();
				EventQueue.invokeLater(new Runnable()
		        {
		            public void run()
		            {
		            	CalendarFrame calendarFrame = new CalendarFrame(events);
		            }
		        });
			}
			else if (Integer.parseInt(args[0]) == 2)
			{
				// TUI
			}
			else System.out.println("Wrong configuration argument."
					+ "\nChoose 1 if you want to use GUI"
					+ "\nChoose 2 if you want to use TUI");
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
