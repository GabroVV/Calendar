package logic;
import java.sql.*;
import java.util.*;
import data.*;
public class OperationsDatabase {
	private String userName;
	private String password;
	private Statement statement = null;
    Connection conn = null;

	public OperationsDatabase(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	public void getConnection() throws SQLException {

	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);
	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/calendardb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",connectionProps);
	    System.out.println("Connected to database");
	}

	public void addEventToDB(MyEvent e) {
		try {
			statement = conn.createStatement();
			String sql = "INSERT INTO calendardb.events (title,description,place,alarmTrigger,start,end,alarm)" +
					" values ('"+e.getTitle()+"','"+e.getDescription()+"','"+e.getPlace()+"','"+Boolean.toString(e.isAlarmTrigger())+"','"+DateToReadableString.dateToString(e.getStartDate())+"','"+DateToReadableString.dateToString(e.getEndDate())+"','"+DateToReadableString.dateToString(e.getAlarmDate())+"')";
			statement.executeUpdate(sql);
			System.out.println(DateToReadableString.dateToString(e.getStartDate()));
		}
		catch(SQLException exc){
			System.out.println(exc);
		}
	}
	
	public void closeConnection(){
		try {
			conn.close();
		}
		catch(SQLException exc){
			System.out.println(exc);
		}
	}
	
	public void clearDatabase() {
		try {
			statement = conn.createStatement();
			String deleteAll ="DELETE FROM calendardb.events";
			statement.executeUpdate(deleteAll);
		}
		catch(SQLException exc){
			System.out.println(exc);
		}
	}
	
	public void pullEventsFromDatabase(EventCollection events) {
		try {
			statement = conn.createStatement();
			String sql = "SELECT * FROM calendardb.events";
			ResultSet rs = statement.executeQuery(sql);
				while(rs.next())
				{
					MyEvent event = new MyEvent();
					event.setTitle(rs.getString("title"));
					event.setDescription(rs.getString("description"));
					event.setPlace(rs.getString("place"));
					event.setAlarmTrigger(Boolean.parseBoolean(rs.getString("alarmtrigger")));
					event.setStartDate(DateToReadableString.reverseStringToCalendar(rs.getString("start")));
					event.setEndDate(DateToReadableString.reverseStringToCalendar(rs.getString("end")));
					if(event.isAlarmTrigger()) {
						event.setAlarmDate(DateToReadableString.reverseStringToCalendar(rs.getString("alarm")));
					}
					events.addEvent(event);
				}
			
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	}
}
