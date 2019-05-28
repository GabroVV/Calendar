package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

public class DayViewWindow
{
	JFrame frame;
	JLabel header;
	Border border;
	
	DayViewWindow()
	{
		frame = new JFrame("Schedule of day");
		frame.setBounds(200, 100, 500, 500);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		header = new JLabel("Events happening on selected day:");
		header.setFont(new Font("Times New Roman", Font.BOLD, 30));
		header.setBounds(15, 20, 485, 50);
		header.setForeground(Color.WHITE);
		header.setVisible(true);
		frame.getContentPane().add(header);
		
	}
}
