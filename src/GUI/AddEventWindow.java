package GUI;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class AddEventWindow
{
	JFrame frame;
	JLabel titleString, descriptionString, placeString, dateString, beginningString, endString;
	TextField titleField, placeField;
	JTextArea descriptionArea;
	JButton closeButton;
	Choice choiceStartYear, choiceStartMonth, choiceStartDay, choiceEndYear, choiceEndMonth, choiceEndDay;
	
	AddEventWindow()
	{
		frame = new JFrame("Add event");
		frame.setBounds(100,100,600,600);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
	
		addLabels();
		addFields();
		addChoices();
		
		/*closeButton = new JButton("Close");
		closeButton.setBounds(100, 100, 50, 30);
		frame.getContentPane().add(closeButton);*/
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
		beginningString.setBounds(20,375,100,20);
		beginningString.setVisible(true);
		beginningString.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frame.getContentPane().add(beginningString);
		
		endString = new JLabel("End");
		endString.setBounds(20,415,100,20);
		endString.setVisible(true);
		endString.setFont(new Font("Times New Roman", Font.BOLD, 12));
		frame.getContentPane().add(endString);
	}
	
	private void addFields()
	{
		titleField = new TextField("");
		titleField.setBounds(20, 45, 500, 30);
		titleField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(titleField);
		
		// ZROBIC ZEBY NIE DALO SIE WYCHODZIC POZA GRANICE
		descriptionArea = new JTextArea("");
		descriptionArea.setBounds(20, 130, 500, 96);
		descriptionArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(descriptionArea);
			
		placeField = new TextField("");
		placeField.setBounds(20, 280, 500, 30);
		placeField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		frame.getContentPane().add(placeField);
	}
	
	private void addChoices()
	{
		choiceStartYear = new Choice();
	}
	
	
}
