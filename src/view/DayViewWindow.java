package view;

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
	JList<String> list;
	JButton OK;
	
	DayViewWindow()
	{
		frame = new JFrame("Schedule of day");
		frame.setBounds(200, 100, 490, 535);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		
		header = new JLabel("Events happening on selected day:");
		header.setFont(new Font("Times New Roman", Font.BOLD, 30));
		header.setBounds(20, 20, 485, 50);
		header.setForeground(Color.WHITE);
		header.setVisible(true);
		frame.getContentPane().add(header);
		
		list = new JList<String>();
		list.setBounds(20, 90, 435, 330);
		list.setBorder(BorderFactory.createLoweredBevelBorder());
		list.setVisible(true);
		frame.getContentPane().add(list);
		
		OK = new JButton("OK");
		OK.setBounds(188, 445, 100, 30);
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
