package view;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Klasa adaptacyjna, implementuj�ca interfejs MouseListener
 *
 */
public class AdaptMouseListener implements MouseListener
{

	/**
	 * Konstruktor domy�lny
	 */
	public AdaptMouseListener() {}
	
	/**
	 * Obs�uga zdarze� po klikni�ciu przycisku myszy
	 */
	@Override
	public void mouseClicked(MouseEvent e) {}

	/**
	 * Obs�uga zdarze� po najechaniu kursorem myszy
	 */
	@Override
	public void mouseEntered(MouseEvent e) {}

	/**
	 * Obs�uga zdarze� po zabraniu kursora myszy
	 */
	@Override
	public void mouseExited(MouseEvent e) {}

	/**
	 * Obs�uga zdarze� po przytrzymaniu przycisku myszy
	 */
	@Override
	public void mousePressed(MouseEvent e) {}

	/**
	 * Obs�uga zdarze� po puszczeniu przycisku myszy
	 */
	@Override
	public void mouseReleased(MouseEvent e) {}

}
