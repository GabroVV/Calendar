package logic;
import java.io.*;
import java.util.Calendar;

import data.*;

/**
 * Klasa obs�uguj�ca eksportowanie wydarze� do pliku .csv
 *
 */
public class ExportToCSV {

	EventCollection events;
	
	/**
	 * Konstruktor klasy ExportToCSV
	 * @param events lista wydarze�
	 */
	public ExportToCSV(EventCollection events) {
		this.events = events;
	}
	
	/**
	 * Zapisuje list� wydarze� w pliku .csv
	 */
	public void execute() {
		   File file = new File("./GoogleCalendarImport.csv");
		   String data = new String("Subject,Start Date,Start Time,End Date,End Time,Description,Location\n");
		   for(int i=0;i<events.getEvents().size();i++)
		   {
			   Calendar start = events.getEvent(i).getStartDate();
			   Calendar end = events.getEvent(i).getEndDate();
		
			   String startHour = ("0"+start.get(Calendar.HOUR_OF_DAY));
			   if(startHour.length() == 3)
			   {
				   startHour = startHour.substring(1, 3);
			   }
			   String startMinute = (start.get(Calendar.MINUTE)+"0").substring(0, 2);
			   
			   String endHour = ("0"+end.get(Calendar.HOUR_OF_DAY));
			   if(endHour.length() == 3)
			   {
				   endHour = endHour.substring(1, 3);
			   }

			   String endMinute =(end.get(Calendar.MINUTE)+"0").substring(0, 2);

			   String newLine = events.getEvent(i).getTitle()+","+
			   (start.get(Calendar.MONTH)+1)+"/"+start.get(Calendar.DAY_OF_MONTH)+"/"+start.get(Calendar.YEAR)+","+
			   startHour+":"+startMinute+","+
						   
			   (end.get(Calendar.MONTH)+1)+"/"+end.get(Calendar.DAY_OF_MONTH)+"/"+end.get(Calendar.YEAR)+","+
			   endHour+":"+endMinute+","+
			   events.getEvent(i).getDescription()+","+
			   events.getEvent(i).getPlace()+"\n";
			   
			   data += newLine;
		   }
		   
		   try	{
	            file.createNewFile();
	            FileWriter fw = new FileWriter(file);
	            fw.write(data);
	            fw.close();
	        }
	        catch (IOException io)
	        {System.out.println(io.getMessage());}

	}

}
