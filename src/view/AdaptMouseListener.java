package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Klasa adaptacyjna, implementuj¹ca interfejs MouseListener
 *
 */
public class AdaptMouseListener implements MouseListener
{

	/**
	 * Konstruktor domyœlny
	 */
	public AdaptMouseListener() {}
	
	/**
	 * Obs³uga zdarzeñ po klikniêciu przycisku myszy
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

	/**
	 * Obs³uga zdarzeñ po najechaniu kursorem myszy
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/**
	 * Obs³uga zdarzeñ po zabraniu kursora myszy
	 */
	@Override
	public void mouseExited(MouseEvent e) {}

	/**
	 * Obs³uga zdarzeñ po przytrzymaniu przycisku myszy
	 */
	@Override
	public void mousePressed(MouseEvent e) {}

	/**
	 * Obs³uga zdarzeñ po puszczeniu przycisku myszy
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}

}
