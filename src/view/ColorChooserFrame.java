package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Okno odpowiedzialne za wybieranie koloru
 *
 */
public class ColorChooserFrame
{
	static Color chosenColor;
	JFrame frame;
	JColorChooser colorChooser;
	Button apply, cancel;
	
	/**
	 * Konstruktor klasy ColorChooserFrame
	 */
	ColorChooserFrame()
	{
		frame = new JFrame("Change background color");
		frame.setBounds(300, 200, 650, 550);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		addColorChooser();
		addButtons();
	
	
	cancel.addActionListener(new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			frame.dispose();
		}
	});
	
	apply.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				CalendarFrame.calendar.setForeground(colorChooser.getColor());
				frame.dispose();
		}
	});
}
	
	private void addColorChooser()
	{
		colorChooser = new JColorChooser();
		colorChooser.setBounds(0,0,620,400);
		colorChooser.setVisible(true);
		frame.getContentPane().add(colorChooser);
	}
	
	private void addButtons()
	{
		apply = new Button("Apply");
		apply.setBounds(150, 440, 100, 30);
		apply.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(apply);
		
		cancel = new Button("Cancel");
		cancel.setBounds(350, 440, 100, 30);
		cancel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(cancel);
	}
	
	/**
	 * Zwraca wybrany kolor
	 * @return wybrany kolor
	 */
	public static Color getChosenColor()
	{
		return chosenColor;
	}
}
