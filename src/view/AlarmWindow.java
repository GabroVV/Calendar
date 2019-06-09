package view;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import data.MyEvent;

/**
 * Okno powiadamiaj¹ce o nadchodz¹cym wydarzeniu
 *
 */
public class AlarmWindow
{
	JFrame frame;
	JLabel text;
	JTextArea eventArea;
	JButton OK;
	JScrollPane scroll;
	
	/**
	 * Konstruktor klasy AlarmWindow
	 * @param event wybrane wydarzenie
	 */
	public AlarmWindow(MyEvent event)
	{
		frame = new JFrame("Alarm trigerred");
		frame.setBounds(300,200,450,450);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		text = new JLabel("Upcoming event!");
		text.setFont(new Font("Times New Roman", Font.BOLD, 30));
		text.setBounds(110, 10, 400, 50);
		text.setVisible(true);
		frame.getContentPane().add(text);
		
		eventArea = new JTextArea();
		eventArea.setBounds(20, 70, 400, 290);
		eventArea.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		eventArea.setBorder(BorderFactory.createLoweredBevelBorder());
		eventArea.setLineWrap(true);
		eventArea.setFocusable(false);
		eventArea.scrollRectToVisible(new Rectangle(20,100));
		frame.getContentPane().add(eventArea);
		scroll = new JScrollPane(eventArea);
		scroll.setBounds(20, 70, 400, 290);
		scroll.setVisible(true);
		frame.getContentPane().add(scroll);
		
		
		eventArea.append("Title: " + event.getTitle() + "\nDescription: " + event.getDescription() +
						"\nPlace: " + event.getPlace() + "\nStarting: " + MyEvent.displayDate(event.getStartDate()) +
						"\nEnding: " + MyEvent.displayDate(event.getEndDate()));
		
		OK = new JButton("OK");
		OK.setBounds(185, 375, 70, 30);
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
	}
}
