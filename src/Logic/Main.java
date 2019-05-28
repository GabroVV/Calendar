package Logic;

import java.awt.EventQueue;

import GUI.*;

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
