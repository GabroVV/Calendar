package logic;
import java.sql.*;
import java.util.*;
import data.*;

/**
 * Klasa obs�uguj�ca operacje na bazie danych
 *
 */
public class OperationsDatabase {
	private String userName;
	private String password;
	private Statement statement = null;
    Connection conn = null;

    /**
     * Konstruktor klasy OperationDatabase
     * @param username nazwa u�ytkownika
     * @param password has�o
     */
	public OperationsDatabase(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	
	/**
	 * Nawi�zuje po��czenie z baz� danych
	 * @throws SQLException je�li nie uda�o si� po��czy� z baz� danych
	 */
	public void getConnection() throws SQLException {

	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);
	    conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/calendardb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",connectionProps);
	    System.out.println("Connected to database");
	}

	/**
	 * Dodaje wydarzenie do bazy danych
	 * @param e wybrane wydarzenie
	 */
	public void addEventToDB(MyEvent e) {
		try {
		
			PreparedStatement preparedstatement = conn.prepareStatement("INSERT INTO calendardb.events (title,description,place,alarmTrigger,start,end,alarm) values (?,?,?,?,?,?,?)");
			preparedstatement.setString(1, e.getTitle());
			preparedstatement.setString(2, e.getDescription());
			preparedstatement.setString(3, e.getDescription());
			preparedstatement.setString(4,Boolean.toString(e.isAlarmTrigger()));
			preparedstatement.setString(5, DateToReadableString.dateToString(e.getStartDate()));
			preparedstatement.setString(6, DateToReadableString.dateToString(e.getEndDate()));
			preparedstatement.setString(7, DateToReadableString.dateToString(e.getAlarmDate()));
			preparedstatement.executeUpdate();
			
			System.out.println("Event added to database");
		}
		catch(SQLException exc){
			System.out.println(exc);
		}
	}
	
	/**
	 * Ko�czy po��czenie z baz� danych
	 */
	public void closeConnection(){
		try {
			conn.close();
		}
		catch(SQLException exc){
			System.out.println(exc);
		}
	}
	
	/**
	 * Usuwa wszystkie rekordy z bazy danych
	 */
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
	
	/**
	 * Wczytuje wydarzenia z bazy danych
	 * @param events lista wydarze�
	 */
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
