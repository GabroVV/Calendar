package view;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import data.*;
import logic.*;

/**
 * Okno z list¹ wydarzeñ danego dnia
 *
 */
public class DayViewWindow
{
	JFrame frame;
	JLabel header;
	Border border;
	JList<String> list;
	JButton OK;
	Calendar day;
	EventCollection events,eventsOnDay;
	EventCollectionController evc= new EventCollectionController();
	JScrollPane scroll;
	
	/**
	 * Konstruktor klasy DayViewWindow
	 * @param day wybrany dzieñ
	 * @param events lista wydarzeñ
	 */
	public DayViewWindow(Calendar day,EventCollection events)
	{
		this.day= day;
		this.events = events;
		frame = new JFrame("Schedule of day");
		frame.setBounds(200, 100, 490, 535);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		header = new JLabel("Events happening on selected day:");
		header.setFont(new Font("Times New Roman", Font.BOLD, 30));
		header.setBounds(20, 20, 485, 50);
		header.setForeground(Color.WHITE);
		header.setVisible(true);
		frame.getContentPane().add(header);
		
		Vector<String> eventNames = new Vector<String>();
		eventsOnDay = evc.getEventsOnDate(events,day);
		for(int i = 0;i <eventsOnDay.getEvents().size();i++)
		{
			eventNames.add(eventsOnDay.getEvent(i).getTitle());
		}
		
		
		list = new JList<String>(eventNames);
		list.setBounds(20, 90, 435, 330);
		list.setBorder(BorderFactory.createLoweredBevelBorder());
		list.setVisible(true);
		frame.getContentPane().add(list);
		
		scroll = new JScrollPane(list);
		scroll.setBounds(20, 90, 435, 330);
		scroll.setVisible(true);
		frame.getContentPane().add(scroll);
		
		OK = new JButton("OK");
		OK.setBounds(188, 445, 100, 30);
		OK.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(OK);
		
		
		OK.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
			}
		});
		
		list.addMouseListener(new AdaptMouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1)
				{
					
				}
			}
		});
		
		
		
		list.addListSelectionListener(new ListSelectionListener()
		{
			@Override
			public void valueChanged(ListSelectionEvent arg0)
			{
				if(arg0.getValueIsAdjusting())
				{
					
					EventDetailsWindow window = new EventDetailsWindow(events,eventsOnDay, list);
					window.frame.setVisible(true);
					try
					{
					list.clearSelection();
					}
					catch (ArrayIndexOutOfBoundsException e) {}
				}
			}
		});
	}
}
