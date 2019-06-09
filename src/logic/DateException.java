package logic;

/**
 * Wyj�tek obs�uguj�cy daty
 *
 */
public class DateException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor klasy DateException
	 * @param string tekst wyj�tku
	 */
	public DateException(String string)
	{
		super(string);
	}
}
