package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
 
public class ColorChooser extends JPanel implements ChangeListener 
{
	private static final long serialVersionUID = 1L;
	
	protected JColorChooser chooser;
 
    public ColorChooser() 
    {
        super(new BorderLayout());
 
        //Set up color chooser for setting color
        chooser = new JColorChooser(Color.LIGHT_GRAY);
        chooser.getSelectionModel().addChangeListener(this);
 
        add(chooser);
    }
 
    public void stateChanged(ChangeEvent e) 
    {
        Color newColor = chooser.getColor();
    }
    
    public Color getChoosenColor()
    {
    	return chooser.getColor();
    }
}
