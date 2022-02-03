//MAIN APPLICATION FILE

package com.example.flightbookingsystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class FlightApplication extends Application implements EventHandler<ActionEvent> {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FlightApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("FlySpy Travel Agency");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        driverConnector sql = new driverConnector();
        launch();



        Scanner departureInput = new Scanner(System.in);
        Scanner destinationInput = new Scanner(System.in);
        Scanner userInput = new Scanner(System.in);
        boolean running = true;

        while (running) {
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

                    sql.getQuery(departureCountry, destinationCountry);
                    System.out.println("Please enter the flight number you wish to purchase: ");
                    String flightNo = userInput.next();
                    sql.getFlightBooking(flightNo);
                    // if yes, create object or entry in arraylist for account booking.
                    // TO DO

                    break;
                case 3:
                    System.out.println("YET TO BE IMPLEMENTED");
                    break;
                case 4:
                    // Display the goodbye message as well as turning the running boolean to false,
                    // thus ending the while loop
                    System.out.println("Exiting. Thank you for using FlySpy.");
                    running = false;
            }
        }

        departureInput.close();
        destinationInput.close();
        userInput.close();


    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Hello");

    }
}