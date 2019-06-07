package view;

import javax.swing.*;


import data.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SaveDatabaseWindow {
	JFrame frame;
	JLabel text;
	JButton okButton, cancelButton;
	EventCollection events;

	SaveDatabaseWindow(EventCollection events){
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
				okButtonHandler();
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
		
	}
	
	private void okButtonHandler() {
		
	}
}
