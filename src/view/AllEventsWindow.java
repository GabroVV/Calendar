package view;

import data.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import data.EventCollection;

public class AllEventsWindow
{
	JFrame frame;
	Vector<String> eventNames;
	JScrollPane scroll;
	JTextArea eventsArea;
	JButton close;
	
	AllEventsWindow(EventCollection events)
	{
		frame = new JFrame("All events");
		frame.setBounds(300,200,450,600);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		eventNames = new Vector<String>();
		
		for (int i=0; i<events.getEvents().size(); i++)
		{
			eventNames.add(
			"Title: " + events.getEvent(i).getTitle() + "\nDescription: " + events.getEvent(i).getDescription() +
			"\nPlace: " + events.getEvent(i).getPlace() + "\nStarting: " + MyEvent.displayDate(events.getEvent(i).getStartDate()) +
			"\nEnding: " + MyEvent.displayDate(events.getEvent(i).getEndDate()));
		}
		
		eventsArea = new JTextArea();
		eventsArea.setBounds(20, 70, 400, 440);
		eventsArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		eventsArea.setBorder(BorderFactory.createLoweredBevelBorder());
		eventsArea.setLineWrap(true);
		eventsArea.setFocusable(false);
		eventsArea.scrollRectToVisible(new Rectangle(20,100));
		
		for (int i=0; i<eventNames.size(); i++)
			eventsArea.append(eventNames.get(i) + "\n\n");
		
		scroll = new JScrollPane(eventsArea);
		scroll.setBounds(20, 70, 400, 440);
		scroll.setVisible(true);
		frame.getContentPane().add(scroll);
		
		close = new JButton("Close");
		close.setBounds(170, 520, 100, 30);
		close.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(close);
		
		close.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
			}
		});
	}
}
