import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		driverConnector sql = new driverConnector();

		Scanner departureInput = new Scanner(System.in);
		Scanner destinationInput = new Scanner(System.in);
		Scanner userInput = new Scanner(System.in);
		boolean running = true;

		while (running) {
			System.out.println("Welcome to FlySpy, your trusted travel agent.");
			System.out.println("Please choose from the list: ");
			System.out.println("");
			System.out.println("1.   View All Flights");
			System.out.println("2.   Book a flight");
			System.out.println("3.   View Your Booking");
			System.out.println("4.   Exit");
			int userChoice = userInput.nextInt();

			switch (userChoice) {
			case 1:
				sql.getAllFlights();
				break;
			case 2:
				System.out.println("Please enter your departing and destination countries of choice.");
				System.out.println("Subject to availability!");
				System.out.println("");
				System.out.println("Enter your departing country: ");
				String departureCountry = departureInput.next();

				System.out.println("Enter your destination country: ");
				String destinationCountry = destinationInput.next();
				System.out.println("Please enter the flight number you wish to purchase: ");
				sql.getQuery(departureCountry, destinationCountry);
				System.out.println("Please enter the flight number you wish to purchase: ");
				String flightNo = userInput.next();
				sql.getFlightBooking(flightNo);
				
				break;
			case 3:
				System.out.println("YET TO BE IMPLEMENTED");
				break;
			case 4:
				//Display the goodbye message as well as turning the running boolean to false, 
				//thus ending the while loop
				System.out.println("Exiting. Thank you for using FlySpy.");
				running = false;
			}
		}

		departureInput.close();
		destinationInput.close();
		userInput.close();

	}

}
