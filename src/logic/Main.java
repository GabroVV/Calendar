package logic;

import java.awt.EventQueue;

import view.*;
import data.*;

public class Main
{

	public static void main(String[] args)
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

}
