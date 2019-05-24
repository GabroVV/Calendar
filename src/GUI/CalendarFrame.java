package GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalendarFrame implements ActionListener
{
	JFrame frame;
	JMenuBar menuBar;
	JMenu menu, settings, help;
	JMenuItem addEvent, exit, backgroundColor, authors, aboutProgram;
	
	
	public CalendarFrame()
	{
	frame = new JFrame ("Calendar");
	frame.setSize(900, 600);
	frame.setLocation(500, 200);
	//frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
	frame.getContentPane().setBackground(Color.LIGHT_GRAY);
	
	createMenuBar();
	createMenuItems();
	addToMenuBar();
	
	
	// ACTIONS
	backgroundColor.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			JInternalFrame iFrame = new JInternalFrame("Change background color",false,true);	// only 'X' left
			JComponent newContentPane = new ColorChooser();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        iFrame.setContentPane(newContentPane);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        iFrame.setVisible(true);
	        frame.add(iFrame);
	        
//	        Button button = new Button("Apply");
//	        button.setLocation(200, 200);
//	        button.setSize(10, 10);
//	        iFrame.add(button);
//	        button.addActionListener(this);
		  
	        //frame.getContentPane().setBackground();
		}
	});
	
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
		exit = new JMenuItem("Exit");
		
		menu.add(addEvent);
		menu.addSeparator();
		menu.add(exit);
		
		
		// SETTINGS BAR
		settings = new JMenu("Settings");
		backgroundColor = new JMenuItem("Change background color");
		settings.add(backgroundColor);
		
		
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

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
