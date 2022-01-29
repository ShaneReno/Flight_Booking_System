import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class driverConnector {
	
	
	public String getQuery(String departureCountry, String destinationCountry) {
	
	try {
		//get connection
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking", "root", "Lockdown21!!");
		//Create statement
		Statement myStmt = myConn.createStatement();
		//Execute SQL Query
		ResultSet myRs = myStmt.executeQuery("select * from flights where departure_country ='"+departureCountry+"' and destination_country = '"+destinationCountry+"'");
		//Process result set
		while (myRs.next()) {
			String outputter = "Flight Number: " + myRs.getString("flight_no") + " FROM " + myRs.getString("departure_country") +  " TO " + myRs.getString("destination_country")
								+ " ON " + myRs.getString("departure_date") + " WITH AIRLINE: " + myRs.getString("airline") + " COSTING €" + myRs.getString("cost_in_euro");
			System.out.println(outputter);
			
			
		}
	}
	catch (Exception exc){
		exc.printStackTrace();
		
	}
	return null;
	}

}
