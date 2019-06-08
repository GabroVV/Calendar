package view;

import javax.swing.*;


import data.*;
import logic.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

public class SaveDatabaseWindow {
	JFrame frame;
	JLabel username,password;
	TextField usernameField;
	JPasswordField passwordField;
	JButton okButton, cancelButton;
	EventCollection events;

	SaveDatabaseWindow(EventCollection events){
		this.events = events;
		frame = new JFrame("Save to database");
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
	
		username = new JLabel("Username");
		username.setBounds(20,10,100,20);
		username.setVisible(true);
		username.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(username);
		
		password = new JLabel("Password");
		password.setBounds(20,85,100,20);
		password.setVisible(true);
		password.setFont(new Font("Times New Roman", Font.BOLD, 20));
		frame.getContentPane().add(password);
		
		usernameField = new TextField("");
		usernameField.setBounds(20, 40, 300, 30);
		usernameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(usernameField);
		
		passwordField = new JPasswordField("");
		passwordField.setBounds(20, 115, 300, 30);
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(passwordField);
		
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
		OperationsDatabase odb= new OperationsDatabase(usernameField.getText(),passwordField.getText());	
		try {
			odb.getConnection();
			odb.clearDatabase();
			for(int i =0;i<events.getEvents().size();i++)
			{
				odb.addEventToDB(events.getEvent(i));
			}
		}
		catch(SQLException ex){
			System.out.println(ex);
			JOptionPane.showMessageDialog(frame, "Failed to establish connection with database","Error",JOptionPane.INFORMATION_MESSAGE);
		}
		finally {
			odb.closeConnection();
		}
	}
}
