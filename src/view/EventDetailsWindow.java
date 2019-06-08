package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import data.EventCollection;
import data.MyEvent;

public class EventDetailsWindow
{
	JFrame frame;
	JLabel titleText, descriptionText, placeText, startDateText, stopDateText;
	TextField titleContent, descriptionContent, placeContent, startDateContent, stopDateContent;
	JButton close, delete;
	EventCollection events;
	JList<String> list;
	int selectedIndex;
	EventDetailsWindow(EventCollection events,EventCollection eventsOnDay, JList<String> list)
	{
		this.events = events;
		this.list = list;
		this.selectedIndex = list.getSelectedIndex();
		frame = new JFrame("Event details");
		frame.setBounds(300,200,800,550);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		titleText = new JLabel("Title");
		titleText.setBounds(20,15,100,25);
		titleText.setVisible(true);
		titleText.setFont(new Font("Times New Roman", Font.BOLD, 30));
		titleText.setForeground(Color.WHITE);
		frame.getContentPane().add(titleText);
		
		titleContent = new TextField(eventsOnDay.getEvent(list.getSelectedIndex()).getTitle());
		titleContent.setBounds(25,45,700,60);
		titleContent.setVisible(true);
		titleContent.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		titleContent.setFocusable(false);
		frame.getContentPane().add(titleContent);
		
		descriptionText = new JLabel("Description");
		descriptionText.setBounds(20,130,200,30);
		descriptionText.setVisible(true);
		descriptionText.setFont(new Font("Times New Roman", Font.BOLD, 30));
		descriptionText.setForeground(Color.WHITE);
		frame.getContentPane().add(descriptionText);
		
		descriptionContent = new TextField(eventsOnDay.getEvent(list.getSelectedIndex()).getDescription());
		descriptionContent.setBounds(25,165,700,120);
		descriptionContent.setVisible(true);
		descriptionContent.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		descriptionContent.setFocusable(false);
		frame.getContentPane().add(descriptionContent);
		
		placeText = new JLabel("Place");
		placeText.setBounds(20,300,200,30);
		placeText.setVisible(true);
		placeText.setFont(new Font("Times New Roman", Font.BOLD, 30));
		placeText.setForeground(Color.WHITE);
		frame.getContentPane().add(placeText);
		
		placeContent = new TextField(eventsOnDay.getEvent(list.getSelectedIndex()).getPlace());
		placeContent.setBounds(25,335,700,40);
		placeContent.setVisible(true);
		placeContent.setFont(new Font("Times New Roman", Font.ITALIC, 24));
		placeContent.setFocusable(false);
		frame.getContentPane().add(placeContent);
		
		startDateText = new JLabel("Beggining");
		startDateText.setBounds(20,400,130,40);
		startDateText.setVisible(true);
		startDateText.setFont(new Font("Times New Roman", Font.BOLD, 30));
		startDateText.setForeground(Color.WHITE);
		frame.getContentPane().add(startDateText);
		
		startDateContent = new TextField(MyEvent.displayDate(eventsOnDay.getEvent(list.getSelectedIndex()).getStartDate()));
		startDateContent.setBounds(172,405,205,38);
		startDateContent.setVisible(true);
		startDateContent.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		startDateContent.setFocusable(false);
		frame.getContentPane().add(startDateContent);
		
		stopDateText = new JLabel("Ending");
		stopDateText.setBounds(424,400,110,40);
		stopDateText.setVisible(true);
		stopDateText.setFont(new Font("Times New Roman", Font.BOLD, 30));
		stopDateText.setForeground(Color.WHITE);
		frame.getContentPane().add(stopDateText);

		stopDateContent = new TextField(MyEvent.displayDate(eventsOnDay.getEvent(list.getSelectedIndex()).getEndDate()));
		stopDateContent.setBounds(534,405,205,38);
		stopDateContent.setVisible(true);
		stopDateContent.setFont(new Font("Times New Roman", Font.ITALIC, 26));
		stopDateContent.setFocusable(false);
		frame.getContentPane().add(stopDateContent);
		
		addButtons();
		
		close.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				frame.dispose();
			}
		});
		
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				int selectedOption = JOptionPane.showConfirmDialog(frame, "Are you sure?","Exit",JOptionPane.YES_NO_OPTION);
				if (selectedOption == JOptionPane.YES_OPTION)
					{

						events.removeEvent(eventsOnDay.getEvent(selectedIndex));
						
						JOptionPane.showMessageDialog(frame, "Event has been deleted","",JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
					}
			}
		});
	}
	
	private void addButtons()
	{
		close = new JButton("Close");
		close.setBounds(200, 462, 115, 35);
		close.setFont(new Font("Times New Roman", Font.BOLD, 22));
		frame.getContentPane().add(close);
		
		delete = new JButton("Delete event");
		delete.setBounds(400, 462, 180, 35);
		delete.setFont(new Font("Times New Roman", Font.BOLD, 22));
		frame.getContentPane().add(delete);
	}
}
