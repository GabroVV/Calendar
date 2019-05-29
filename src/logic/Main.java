package logic;

import java.awt.EventQueue;

import view.*;

public class Main
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
            	CalendarFrame calendarFrame = new CalendarFrame();
            }
        });
	
	}

}
