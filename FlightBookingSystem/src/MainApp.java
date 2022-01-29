import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) throws SQLException {
		
		driverConnector sql = new driverConnector();
		
		
		Scanner departureInput = new Scanner(System.in);
		Scanner destinationInput = new Scanner(System.in);
		
		System.out.println("Please enter your departing and destination countries of choice.");
		System.out.println("Subject to availability!");
		System.out.println("");
		System.out.println("Enter your departing country: ");
		String departureCountry = departureInput.next();
		
		System.out.println("Enter your destination country: ");
		String destinationCountry = destinationInput.next();
		
		
		sql.getQuery(departureCountry, destinationCountry);
		
		
		
	
		departureInput.close();
	
		

	}

}
