package logic;

/**
 * Wyj¹tek obs³uguj¹cy daty
 *
 */
public class DateException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor klasy DateException
	 * @param string tekst wyj¹tku
	 */
	public DateException(String string)
	{
		super(string);
	}
}
