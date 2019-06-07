package view;

import java.awt.*;
import logic.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.xml.datatype.DatatypeConfigurationException;
import com.toedter.calendar.JCalendar;
import data.EventCollection;

public class CalendarFrame
{
	JFrame frame;
	JMenuBar menuBar;
	JMenu menu, settings, help, saveTo, loadFrom;
	JMenuItem addEvent, deleteEvents, showEvents, exit, fontColor, authors, aboutProgram, saveXML, saveDatabase,saveCSV, loadXML, loadDatabase;
	static JCalendar calendar;
	ImageIcon icon;
	EventCollection events;
	Timer timer;
	
	
	public CalendarFrame(EventCollection events)
	{
	frame = new JFrame ("Calendar");
	frame.setSize(900, 600);
	frame.setLocation(500, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	icon = new ImageIcon(".\\icon.png");
	frame.setIconImage(icon.getImage());
	frame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	this.events = events;
	addCalendar();
	
	createMenuBar();
	createMenuItems();
	addToMenuBar();
	
	
	// ACTIONS
	authors.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					JOptionPane.showMessageDialog(frame, "Calendar made by Jakub Bogdan & Gabriel Nowak","Authors",JOptionPane.INFORMATION_MESSAGE);
				}
			});
	
	aboutProgram.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			JOptionPane.showMessageDialog(frame, "A simple calendar. User can add events, set alarms, load and save data to XML or database.","Description",JOptionPane.INFORMATION_MESSAGE);
		}
	});
	
	exit.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			int selectedOption = JOptionPane.showConfirmDialog(frame, "Do you want to close calendar?","Exit",JOptionPane.YES_NO_OPTION);
			if (selectedOption == JOptionPane.YES_OPTION)
				frame.dispose();
		}
		
	});
	
	addEvent.addActionListener(new ActionListener() 
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
				AddEventWindow eventWindow = new AddEventWindow(events);
				eventWindow.frame.setVisible(true);
		}
		});
	
	deleteEvents.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
			{
				DeleteEventWindow eventWindow = new DeleteEventWindow(events);
				eventWindow.frame.setVisible(true);
			}
	});
	
	showEvents.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			AllEventsWindow eventsWindow = new AllEventsWindow(events);
			eventsWindow.frame.setVisible(true);
		}
	});
	
	fontColor.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					ColorChooserFrame chooserWindow = new ColorChooserFrame();
					chooserWindow.frame.setVisible(true);
				}
			});
	
	loadXML.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			logic.OperationsXML.loadFromXML(events);
			JOptionPane.showMessageDialog(frame, "Events imported succesfully", "File loaded", JOptionPane.INFORMATION_MESSAGE);
		}
	});
	
	saveXML.addActionListener(new ActionListener()
	{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					logic.OperationsXML.saveToXML(events);
				} catch (DatatypeConfigurationException e)
				{
					e.printStackTrace();
				}
			}
	});
	
	saveCSV.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			ExportToCSV csvController = new ExportToCSV(events);
			csvController.execute();
			JOptionPane.showMessageDialog(frame, "Events saved to .csv file ready to be imported to Google Calendar","Save to CSV",JOptionPane.INFORMATION_MESSAGE);
		}
	});
	
	calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener()
	{
		@Override
		public void propertyChange(PropertyChangeEvent arg0)
		{	
			
			Calendar day = new GregorianCalendar(calendar.getYearChooser().getYear(),calendar.getMonthChooser().getMonth(),calendar.getDayChooser().getDay());
			DayViewWindow dayViewWindow = new DayViewWindow(day,events);
			dayViewWindow.frame.setVisible(true);
		}
	});
	
	addTimer();
	frame.setVisible(true);
	}	// end of constructor

	
	
	private void createMenuBar()
	{
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
	}
	
	private void createMenuItems()
	{
		// MENU BAR
		menu = new JMenu("Menu");
		addEvent = new JMenuItem("Add event");
		deleteEvents = new JMenuItem("Delete events");
		showEvents = new JMenuItem("Show events");
		
		saveTo = new JMenu("Save to");
		saveXML = new JMenuItem("XML");
		saveDatabase = new JMenuItem("database");
		saveCSV = new JMenuItem("CSV");

		loadFrom = new JMenu("Load from");
		loadXML = new JMenuItem("XML");
		loadDatabase = new JMenuItem("database");
		
		exit = new JMenuItem("Exit");
		
		menu.add(addEvent);
		menu.add(deleteEvents);
		menu.add(showEvents);
		menu.addSeparator();
		menu.add(saveTo);
		saveTo.add(saveXML);
		saveTo.add(saveDatabase);
		saveTo.add(saveCSV);
		menu.add(loadFrom);
		loadFrom.add(loadXML);
		loadFrom.add(loadDatabase);
		menu.addSeparator();
		menu.add(exit);
		
		
		// SETTINGS BAR
		settings = new JMenu("Settings");
		fontColor = new JMenuItem("Change font color");
		settings.add(fontColor);
		
		
		// HELP BAR
		help = new JMenu("Help");
		aboutProgram = new JMenuItem("About program");
		authors = new JMenuItem("Authors");
		
		help.add(aboutProgram);
		help.add(authors);
		
	}
	
	private void addToMenuBar()
	{
		menuBar.add(menu);
		menuBar.add(settings);
		menuBar.add(help);
	}
	
	private void addCalendar()
	{
		calendar = new JCalendar();
		calendar.setFont(new Font("Times New Roman", Font.BOLD, 26));
		calendar.setLocale(new Locale("English"));
		calendar.getMonthChooser().setFont(new Font("Times New Roman", Font.BOLD, 20));
		calendar.getYearChooser().setFont(new Font("Times New Roman", Font.BOLD, 20));
		calendar.getDayChooser().setAlwaysFireDayProperty(true);
		frame.add(calendar);
	}
	
	private void addTimer()
	{
		timer = new Timer(60000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				checkTimer();
			}
		});
		timer.start();
	}
	
	private void checkTimer()
	
	{
		for (int i=0; i<events.getEvents().size(); i++)
		{
			if (events.getEvent(i).isAlarmTrigger() && (events.getEvent(i).getAlarmDate().getTime().getTime() - new Date().getTime()) < 60000)
			{
				AlarmWindow window = new AlarmWindow(events.getEvent(i));
				window.frame.setVisible(true);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
}
