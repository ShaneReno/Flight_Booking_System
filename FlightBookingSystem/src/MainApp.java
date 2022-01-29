import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		
		
		Scanner departureInput = new Scanner(System.in);
		Scanner destinationInput = new Scanner(System.in);
		
		System.out.println("Please enter your departing and destination countries of choice.");
		System.out.println("Subject to availability!");
		System.out.println("");
		System.out.println("Enter your departing country: ");
		String departureCountry = departureInput.next();
		
		System.out.println("Enter your destination country: ");
		String destinationCountry = destinationInput.next();
		
		
		try {
			//get connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking", "root", "Lockdown21!!");
			//Create statement
			Statement myStmt = myConn.createStatement();
			//Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from flights where departure_country ='"+departureCountry+"' and destination_country = '"+destinationCountry+"'");
			//Process result set
			while (myRs.next()) {
				System.out.println("Flight Number: " + myRs.getString("flight_no") + " FROM " + myRs.getString("departure_country") +  " TO " + myRs.getString("destination_country")
									+ " ON " + myRs.getString("departure_date") + " WITH AIRLINE: " + myRs.getString("airline") + " COSTING €" + myRs.getString("cost_in_euro"));
				
			}
		}
		catch (Exception exc){
			exc.printStackTrace();
			
		}
		
		
		departureInput.close();
	
		

	}

}
