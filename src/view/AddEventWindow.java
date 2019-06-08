package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import com.toedter.calendar.*;
import data.*;
import logic.*;
public class AddEventWindow
{
	JFrame frame;
	JLabel titleString, descriptionString, placeString, dateString, beginningString, endString;
	TextField titleField, placeField;
	JTextArea descriptionArea;
	JButton applyButton, cancelButton;
	JDateChooser dateStartChooser, dateEndChooser, alarmChooser;
	JComboBox<String> startHour, endHour, startMinute, endMinute, alarmHour, alarmMinute;
	Checkbox alarmCheckbox;
	EventCollection events;
	
	AddEventWindow(EventCollection events)
	{
		this.events = events;
		frame = new JFrame("Add event");
		frame.setBounds(100,100,600,650);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
	
		addLabels();
		addFields();
		addDateChoosers();
		addAlarm();
		addButtons();
		
		
		alarmCheckbox.addItemListener(new ItemListener()
				{
					@Override
					public void itemStateChanged(ItemEvent arg0)
					{
						alarmChooser.setEnabled(!alarmChooser.isEnabled());
						alarmHour.setEnabled(!alarmHour.isEnabled());
						alarmMinute.setEnabled(!alarmMinute.isEnabled());
					}
				});
		
		applyButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				Calendar dateStartCalendar = dateStartChooser.getCalendar();
				Calendar dateEndCalendar = dateEndChooser.getCalendar();
				
				
				try
				{
					if (dateStartChooser.getDate() == null || dateEndChooser.getDate() == null)
					{
						throw new DateException("Start and end dates must be set");
					}
					else
					{
						if (dateStartChooser.getDate().after(dateEndChooser.getDate()))
						{
							throw new DateException("Event must begin before its end");
						}
						else
						{
							if (isDateTheSame() && !isHourStartBeforeEnd
								(
									Integer.parseInt((String)startHour.getSelectedItem()),
									Integer.parseInt((String)startMinute.getSelectedItem()), 
									Integer.parseInt((String)endHour.getSelectedItem()), 
									Integer.parseInt((String)endMinute.getSelectedItem())
								))
							{
								throw new DateException("Event must begin before its end");
							}
							else
							{
								dateStartCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt((String)startHour.getSelectedItem()));
								dateStartCalendar.set(Calendar.MINUTE, Integer.parseInt((String)startMinute.getSelectedItem()));
								
								dateEndCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt((String)endHour.getSelectedItem()));
								dateEndCalendar.set(Calendar.MINUTE, Integer.parseInt((String)endMinute.getSelectedItem()));
								Calendar alarmCalendar = null;
								
								if(alarmCheckbox.getState() == true) 
								{
									alarmCalendar = alarmChooser.getCalendar();
									alarmCalendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt((String)alarmHour.getSelectedItem()));
									alarmCalendar.set(Calendar.MINUTE, Integer.parseInt((String)alarmMinute.getSelectedItem()));
								}
						

								if(titleField.getText().isEmpty() == false) 
								{
									MyEvent event = new MyEvent(
											titleField.getText(),
											descriptionArea.getText(),
											placeField.getText(),
											alarmCheckbox.getState(),
											alarmCalendar,
											dateStartCalendar,
											dateEndCalendar);
									event.setAlarmHour(Integer.parseInt((String)alarmHour.getSelectedItem()));
									event.setAlarmMinute(Integer.parseInt((String)alarmMinute.getSelectedItem()));
									
									events.addEvent(event);
									System.out.println("Event added");
									frame.dispose();
								}
								else 
								{
									System.out.println("Title is required");
								}
							}
						}
						
					}
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
	
	private void addLabels()
	{
		titleString = new JLabel("Title");
		titleString.setBounds(20,15,100,20);
		titleString.setVisible(true);
		titleString.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(titleString);
		
		descriptionString = new JLabel("Description");
		descriptionString.setBounds(20,100,100,20);
		descriptionString.setVisible(true);
		descriptionString.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(descriptionString);
		
		placeString = new JLabel("Place");
		placeString.setBounds(20,250,100,20);
		placeString.setVisible(true);
		placeString.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(placeString);
		
		dateString = new JLabel("Date");
		dateString.setBounds(20,340,100,20);
		dateString.setVisible(true);
		dateString.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(dateString);
		
		beginningString = new JLabel("Beginning");
		beginningString.setBounds(20,380,100,20);
		beginningString.setVisible(true);
		beginningString.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(beginningString);
		
		endString = new JLabel("End");
		endString.setBounds(20,428,100,20);
		endString.setVisible(true);
		endString.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(endString);
	}
	
	private void addFields()
	{
		titleField = new TextField("");
		titleField.setBounds(20, 45, 500, 30);
		titleField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(titleField);
		
		descriptionArea = new JTextArea();
		descriptionArea.setBounds(20, 130, 500, 96);
		descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		descriptionArea.setBorder(BorderFactory.createLoweredBevelBorder());
		descriptionArea.setLineWrap(true);
		
		descriptionArea.addKeyListener(new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent arg0)
					{
						if (arg0.getKeyCode() == KeyEvent.VK_TAB)
							descriptionArea.transferFocus();}
					
					@Override
					public void keyReleased(KeyEvent arg0) {}

					@Override
					public void keyTyped(KeyEvent arg0) {}
			
				});
		
		frame.getContentPane().add(descriptionArea);
			
		placeField = new TextField("");
		placeField.setBounds(20, 280, 500, 30);
		placeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(placeField);
	}
	
	private void addDateChoosers()
	{
		dateStartChooser = new JDateChooser();
		dateStartChooser.setBounds(130, 375, 140, 30);
		dateStartChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateStartChooser.setLocale(new Locale("English"));
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateStartChooser.getDateEditor();
		editor.setEditable(false);
		frame.getContentPane().add(dateStartChooser);
		
		dateEndChooser = new JDateChooser();
		dateEndChooser.setBounds(130, 420, 140, 30);
		dateEndChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dateEndChooser.setLocale(new Locale("English"));
		JTextFieldDateEditor editor2 = (JTextFieldDateEditor) dateEndChooser.getDateEditor();
		editor2.setEditable(false);
		frame.getContentPane().add(dateEndChooser);
		
		startHour = new JComboBox<String>();
		startHour.setBounds(310, 375, 50, 30);
		for (int i=0; i<24; i++)
		{
			if (i<10)
				startHour.addItem("0" + Integer.toString(i));
			else
				startHour.addItem(Integer.toString(i));
		}
		frame.getContentPane().add(startHour);
		
		startMinute = new JComboBox<String>();
		startMinute.setBounds(370, 375, 50, 30);
		for (int i=0; i<60; i++)
		{
			if (i<10)
				startMinute.addItem("0" + Integer.toString(i));
			else
				startMinute.addItem(Integer.toString(i));
		}
		frame.getContentPane().add(startMinute);
		
		endHour = new JComboBox<String>();
		endHour.setBounds(310, 420, 50, 30);
		for (int i=0; i<24; i++)
		{
			if (i<10)
				endHour.addItem("0" + Integer.toString(i));
			else
				endHour.addItem(Integer.toString(i));
		}
		frame.getContentPane().add(endHour);
		
		endMinute = new JComboBox<String>();
		endMinute.setBounds(370, 420, 50, 30);
		for (int i=0; i<60; i++)
		{
			if (i<10)
				endMinute.addItem("0" + Integer.toString(i));
			else
				endMinute.addItem(Integer.toString(i));
		}
		frame.getContentPane().add(endMinute);
	}
	
	private void addAlarm()
	{
		alarmCheckbox = new Checkbox("Set alarm", false);
		alarmCheckbox.setBounds(20, 480, 100, 30);
		alarmCheckbox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frame.getContentPane().add(alarmCheckbox);
		
		alarmChooser = new JDateChooser();
		alarmChooser.setBounds(130, 480, 140, 30);
		alarmChooser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		alarmChooser.setLocale(new Locale("English"));
		alarmChooser.setEnabled(false);
		JTextFieldDateEditor editor3 = (JTextFieldDateEditor) alarmChooser.getDateEditor();
		editor3.setEditable(false);
		frame.getContentPane().add(alarmChooser);
		
		alarmHour = new JComboBox<String>();
		alarmHour.setBounds(310, 480, 50, 30);
		for (int i=0; i<24; i++)
		{
			if (i<10)
				alarmHour.addItem("0" + Integer.toString(i));
			else
				alarmHour.addItem(Integer.toString(i));
		}
		alarmHour.setEnabled(false);
		frame.getContentPane().add(alarmHour);
		
		alarmMinute = new JComboBox<String>();
		alarmMinute.setBounds(370, 480, 50, 30);
		for (int i=0; i<60; i++)
		{
			if (i<10)
				alarmMinute.addItem("0" + Integer.toString(i));
			else
				alarmMinute.addItem(Integer.toString(i));
		}
		alarmMinute.setEnabled(false);
		frame.getContentPane().add(alarmMinute);
	}
	
	private void addButtons()
	{
		applyButton = new JButton("Apply");
		applyButton.setBounds(140, 560, 100, 30);
		applyButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(applyButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(340, 560, 100, 30);
		cancelButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(cancelButton);
	}
	
	private boolean isDateTheSame()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dateStartChooser.getDate());
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(dateEndChooser.getDate());
		
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
