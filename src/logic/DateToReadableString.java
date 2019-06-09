package logic;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Klasa konwertuj¹ca datê do czytelnej postaci
 *
 */
public class DateToReadableString {
	
	/**
	 * Konstruktor domyœlny
	 */
	public DateToReadableString() {}
	
	/**
	 * Konwertuje datê do czytelnej postaci
	 * @param date data typu Calendar
	 * @return data typu String
	 */
	public static String dateToString(Calendar date) {
		if(date == null) {
			return null;
		}
		String day = ("0"+date.get(Calendar.DAY_OF_MONTH));
		   if(day.length() == 3)
		   {
			   day = day.substring(1, 3);
		   }
		String month = ("0"+(date.get(Calendar.MONTH)+1));
		   if(month.length() == 3)
		   {
			   month = month.substring(1, 3);
		   }		
		String hour = ("0"+date.get(Calendar.HOUR_OF_DAY));
		   if(hour.length() == 3)
		   {
			   hour = hour.substring(1, 3);
		   }
		   String minute = (date.get(Calendar.MINUTE)+"0").substring(0, 2);
		   
		String result=day+"/";
		result+=month+"/";
		result+=date.get(Calendar.YEAR);
		result+=" "+hour+":"+minute;
		return result;
	}
	
	/**
	 * Klasa konwertuj¹ca datê z typu String do typu Calendar
	 * @param s data typu String
	 * @return data typu Calendar
	 */
	public static Calendar reverseStringToCalendar(String s) {
		if(s.equals(null))
		{
			return null;
		}
		String year,month,day,hour,minute;
		year = s.substring(6,10);
		day  =s.substring(0,2);
		month =s.substring(3,5);
		hour =s.substring(11,13);
		minute =s.substring(14,16);
		GregorianCalendar result = new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month)-1,Integer.parseInt(day),Integer.parseInt(hour),Integer.parseInt(minute));
		return result;
	}
	
	public static boolean checkFormat(String s) {
		return s.matches("^\\d{2}/\\d{2}/\\d{4}\\s\\d{2}:\\d{2}");
	}

};
