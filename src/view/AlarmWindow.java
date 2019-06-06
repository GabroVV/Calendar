package view;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AlarmWindow
{
	JFrame frame;
	JLabel text;
	JTextArea eventArea;
	JButton OK;
	
	AlarmWindow()
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
		eventArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		eventArea.setBorder(BorderFactory.createLoweredBevelBorder());
		eventArea.setLineWrap(true);
		eventArea.setFocusable(false);
		eventArea.scrollRectToVisible(new Rectangle(20,100));
		frame.getContentPane().add(eventArea);
		
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
