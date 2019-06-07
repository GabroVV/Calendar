package view;

import data.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

import data.EventCollection;
import logic.EventCollectionController;

public class AllEventsWindow
{
	JFrame frame;
	Vector<String> eventDetails, eventToFilter;
	JScrollPane scroll;
	JTextArea eventsArea;
	JButton close, OK;
	TextField filterField;
	
	AllEventsWindow(EventCollection events)
	{
		frame = new JFrame("All events");
		frame.setBounds(300,200,450,600);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		EventCollectionController.sortEventsByDate(events);
		
		eventDetails = new Vector<String>();
		eventToFilter = new Vector<String>();
		
		for (int i=0; i<events.getEvents().size(); i++)
		{
			eventDetails.add(
			"Title: " + events.getEvent(i).getTitle() + "\nDescription: " + events.getEvent(i).getDescription() +
			"\nPlace: " + events.getEvent(i).getPlace() + "\nStarting: " + MyEvent.displayDate(events.getEvent(i).getStartDate()) +
			"\nEnding: " + MyEvent.displayDate(events.getEvent(i).getEndDate()));
			
			
			eventToFilter.add(
			events.getEvent(i).getTitle() + events.getEvent(i).getDescription() +
			events.getEvent(i).getPlace());
		}
		
		
		eventsArea = new JTextArea();
		eventsArea.setBounds(20, 70, 400, 440);
		eventsArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		eventsArea.setBorder(BorderFactory.createLoweredBevelBorder());
		eventsArea.setLineWrap(true);
		eventsArea.setFocusable(false);
		eventsArea.scrollRectToVisible(new Rectangle(20,100));
		
		for (int i=0; i<eventDetails.size(); i++)
			eventsArea.append(eventDetails.get(i) + "\n\n");
		
		scroll = new JScrollPane(eventsArea);
		scroll.setBounds(20, 70, 400, 440);
		scroll.setVisible(true);
		frame.getContentPane().add(scroll);
		
		addButtons();
		
		filterField = new TextField("Search events");
		filterField.setBounds(20, 20, 160, 30);
		filterField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(filterField);
		
		filterField.addMouseListener(new AdaptMouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				filterField.setText("");
			}
		});
		
		close.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
			}
		});
		
		OK.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				eventsArea.setText("");
				for (int i=0; i<eventToFilter.size(); i++)
				{
					if (eventToFilter.get(i).toLowerCase().contains(filterField.getText().toLowerCase()))
						{
							eventsArea.append(eventDetails.get(i) + "\n\n");
						}
				}
			}
		});
	}
	
	private void addButtons()
	{
		close = new JButton("Close");
		close.setBounds(170, 520, 100, 30);
		close.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(close);
		
		OK = new JButton("OK");
		OK.setBounds(185, 20, 55, 30);
		OK.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frame.getContentPane().add(OK);
	}
}
