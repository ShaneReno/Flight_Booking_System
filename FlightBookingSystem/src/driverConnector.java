import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class driverConnector {

	public String getQuery(String departureCountry, String destinationCountry) {

		try {
			// Establish connection - This uses the basic root name and a unique password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking", "root",
					"datahouse");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from flights where departure_country ='" + departureCountry
					+ "' and destination_country = '" + destinationCountry + "'");

			// error handling
			if (myRs.next() == false) {
				System.out.println("There are no flights between your inputted countries. Try again.");
				System.out.println("");
			}

			// Process result set
			while (myRs.next()) {
				// While the next result from the executed query is processed:
				// Declare and initialize a string that concatenates the SQL entity attributes
				// into a neatly formatted schedule
				// Print this out

				String outputter = "Flight Number: " + myRs.getString("flight_no") + " FROM "
						+ myRs.getString("departure_country") + " TO " + myRs.getString("destination_country") + " ON "
						+ myRs.getString("departure_date") + " AT "
						+ myRs.getString("departure_time").substring(0, myRs.getString("departure_time").length() - 3)
						+ " WITH AIRLINE: " + myRs.getString("airline") + " COSTING " + myRs.getString("cost_in_euro")
						+ " Euro.";
				System.out.println(outputter);
			}

		} catch (

		Exception exc) {
			exc.printStackTrace();

		}
		return null;
	}

	public String getAllFlights() {

		try {
			// Establish connection - This uses the basic root name and a unique password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking", "root",
					"datahouse");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from flights");

			// Process result set
			while (myRs.next()) {
				// While the next result from the executed query is processed:
				// Declare and initialize a string that concatenates the SQL entity attributes
				// into a neatly formatted schedule
				// Print this out

				String outputter = "Flight Number: " + myRs.getString("flight_no") + " FROM "
						+ myRs.getString("departure_country") + " TO " + myRs.getString("destination_country") + " ON "
						+ myRs.getString("departure_date") + " AT "
						+ myRs.getString("departure_time").substring(0, myRs.getString("departure_time").length() - 3)
						+ " WITH AIRLINE: " + myRs.getString("airline") + " COSTING "
						+ myRs.getString("cost_in_euro") + " Euro.";
				System.out.println(outputter);
			}

		} catch (

		Exception exc) {
			exc.printStackTrace();

		}
		return null;
	}

	public String getFlightBooking(String flightNo) {

		try {
			// Establish connection - This uses the basic root name and a unique password
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightbooking", "root",
					"datahouse");
			// Create statement
			Statement myStmt = myConn.createStatement();
			// Execute SQL Query
			ResultSet myRs = myStmt.executeQuery("select * from flights where flight_no = '"+flightNo + "'");

			// Process result set
			while (myRs.next()) {
				// While the next result from the executed query is processed:
				// Declare and initialize a string that concatenates the SQL entity attributes
				// into a neatly formatted schedule
				// Print this out

				String outputter = "Flight Number: " + myRs.getString("flight_no") + " FROM "
						+ myRs.getString("departure_country") + " TO " + myRs.getString("destination_country") + " ON "
						+ myRs.getString("departure_date") + " AT "
						+ myRs.getString("departure_time").substring(0, myRs.getString("departure_time").length() - 3)
						+ " WITH AIRLINE: " + myRs.getString("airline") + " COSTING "
						+ myRs.getString("cost_in_euro");
				System.out.println("Would you like to book this flight: " + outputter + " ?");
			}

		} catch (

		Exception exc) {
			exc.printStackTrace();

		}
		return null;
	}

}
