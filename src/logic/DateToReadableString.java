package logic;

import java.util.Calendar;

public class DateToReadableString {
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

};
