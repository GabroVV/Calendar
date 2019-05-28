package GUI;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.*;

public class CalendarFrame implements ActionListener
{
	JFrame frame;
	JMenuBar menuBar;
	JMenu menu, settings, help, saveTo, loadFrom;
	JMenuItem addEvent, deleteEvents, exit, fontColor, authors, aboutProgram, saveXML, saveDatabase, loadXML, loadDatabase;
	static JCalendar calendar;
	
	
	public CalendarFrame()
	{
	frame = new JFrame ("Calendar");
	frame.setSize(900, 600);
	frame.setLocation(500, 200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
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
			JOptionPane.showMessageDialog(frame, "A simple calendar, where you can add events.","Description",JOptionPane.INFORMATION_MESSAGE);
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
				AddEventWindow eventWindow = new AddEventWindow();
				eventWindow.frame.setVisible(true);
		}
		});
	
	deleteEvents.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
			{
				DeleteEventWindow eventWindow = new DeleteEventWindow();
				eventWindow.frame.setVisible(true);
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
	
	calendar.getDayChooser().addPropertyChangeListener("day", new PropertyChangeListener()
			{
				@Override
				public void propertyChange(PropertyChangeEvent arg0)
				{
					DayViewWindow dayViewWindow = new DayViewWindow();
					dayViewWindow.frame.setVisible(true);
				}
			});
	
	
	
	frame.setVisible(true);
	}	// end of constructor

	
	public void createMenuBar()
	{
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
	}
	
	public void createMenuItems()
	{
		// MENU BAR
		menu = new JMenu("Menu");
		addEvent = new JMenuItem("Add event");
		deleteEvents = new JMenuItem("Delete events");
		
		saveTo = new JMenu("Save to");
		saveXML = new JMenuItem("XML");
		saveDatabase = new JMenuItem("database");
		
		loadFrom = new JMenu("Load from");
		loadXML = new JMenuItem("XML");
		loadDatabase = new JMenuItem("database");
		
		exit = new JMenuItem("Exit");
		
		menu.add(addEvent);
		menu.add(deleteEvents);
		menu.add(saveTo);
		saveTo.add(saveXML);
		saveTo.add(saveDatabase);
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
	
	public void addToMenuBar()
	{
		menuBar.add(menu);
		menuBar.add(settings);
		menuBar.add(help);
	}
	
	public void addCalendar()
	{
		calendar = new JCalendar();
		calendar.setFont(new Font("Times New Roman", Font.BOLD, 26));
		calendar.setLocale(new Locale("English"));
		calendar.getMonthChooser().setFont(new Font("Times New Roman", Font.BOLD, 20));
		calendar.getYearChooser().setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.add(calendar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
