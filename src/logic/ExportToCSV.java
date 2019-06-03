package logic;
import java.io.*;
import java.util.Calendar;

import data.*;
public class ExportToCSV {

	EventCollection events;
	
	public ExportToCSV(EventCollection events) {
		this.events = events;
	}
	
	public void execute() {
		   File file = new File("./ImportingDoGoooooogla.csv");
		   String data = new String("Subject,Start Date,Start Time,End Date,End Time,Description,Location\n");
		   for(int i=0;i<events.getEvents().size();i++)
		   {
			   Calendar start = events.getEvent(i).getStartDate();
			   Calendar end = events.getEvent(i).getEndDate();

			   String newLine = events.getEvent(i).getTitle()+","+
			   (start.get(Calendar.MONTH)+1)+"/"+start.get(Calendar.DAY_OF_MONTH)+"/"+start.get(Calendar.YEAR)+","+
			   start.get(Calendar.HOUR_OF_DAY)+":"+start.get(Calendar.MINUTE)+","+
						   
			   (end.get(Calendar.MONTH)+1)+"/"+end.get(Calendar.DAY_OF_MONTH)+"/"+end.get(Calendar.YEAR)+","+
			   end.get(Calendar.HOUR_OF_DAY)+":"+end.get(Calendar.MINUTE)+","+
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

	        catch (Exception se)
	        {System.err.println("Gotta catch em' all");}

	}

}
