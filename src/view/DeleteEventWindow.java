package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import logic.*;
import data.*;
public class DeleteEventWindow
{
	JFrame frame;
	JLabel text;
	JDateChooser dateChooser;
	JComboBox<String> hour, minute;
	JButton okButton, cancelButton;
	EventCollection events;
	
	DeleteEventWindow(EventCollection events)
	{
		this.events = events;
		frame = new JFrame("Delete events");
		frame.setBounds(300,200,400,230);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		addComponents();
		
		
		okButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
					{
						if (dateChooser.getDate() != null)
						{
							okButtonHandler();
							JOptionPane.showMessageDialog(frame, "Events deleted", "Delete events", JOptionPane.INFORMATION_MESSAGE);
							frame.dispose();
						}
						else throw new DateException("Date must be set");
					} 
					catch (DateException e)
					{
						System.out.println(e.getMessage());
					}
			}
		});
		
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
			}
		});
	}
	
	private void addComponents()
	{
		text = new JLabel("Delete events older than");
		text.setFont(new Font("Times New Roman", Font.BOLD, 26));
		text.setBounds(50, 20, 400, 50);
		text.setVisible(true);
		frame.getContentPane().add(text);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(60, 80, 120, 30);
		dateChooser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		dateChooser.setLocale(new Locale("English"));
		frame.getContentPane().add(dateChooser);
		
		hour = new JComboBox<String>();
		hour.setBounds(200, 80, 50, 30);
		for (int i=0; i<24; i++)
		{
			if (i<10)
				hour.addItem("0" + Integer.toString(i));
			else
				hour.addItem(Integer.toString(i));
		}
		frame.getContentPane().add(hour);
		
		minute = new JComboBox<String>();
		minute.setBounds(260, 80, 50, 30);
		for (int i=0; i<60; i++)
		{
			if (i<10)
				minute.addItem("0" + Integer.toString(i));
			else
				minute.addItem(Integer.toString(i));
		}
		frame.getContentPane().add(minute);
		
		okButton = new JButton("OK");
		okButton.setBounds(80, 150, 90, 25);
		okButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(okButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(210, 150, 90, 25);
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(cancelButton);
	}
	
	private void okButtonHandler() {
		Calendar date = dateChooser.getCalendar();
		date.set(Calendar.HOUR_OF_DAY, Integer.parseInt((String)hour.getSelectedItem()));
		date.set(Calendar.MINUTE, Integer.parseInt((String)minute.getSelectedItem()));
		
		EventCollectionController evc = new EventCollectionController();
		evc.removeEventsBeforeDate(events, date);
	}
}
