//This controller file controls action events. It integrates the SQL database into the table.

package com.example.flightbookingsystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HelloController implements Initializable {
    driverConnector sql = new driverConnector();


    public void viewAllFlightsBTN(ActionEvent e){
        sql.getAllFlights();
    }


    @FXML
    private TableView<ModelTable> table;

    @FXML
    private TableColumn<ModelTable, String> col_flight_No;
    @FXML
    private TableColumn<driverConnector, String> col_departure;
    @FXML
    private TableColumn<driverConnector, String> col_destination;
    @FXML
    private TableColumn<driverConnector, String> col_date;
    @FXML
    private TableColumn<driverConnector, String> col_time;
    @FXML
    private TableColumn<driverConnector, String> col_airline;
    @FXML
    private TableColumn<driverConnector, String> col_cost;


    @FXML
    private void refreshTable(){

    }


    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();


    public void initialize(URL url, ResourceBundle resourceBundle){

        try {
            Connection con = driverConnector.getConnection();

            ResultSet rs = con.createStatement().executeQuery("select * from flights");

            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("flight_no"), rs.getString("departure_country"), rs.getString("destination_country")
                        ,rs.getString("departure_date"), rs.getString("departure_time"),rs.getString("airline"),rs.getString("cost_in_euro") ));
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(HelloController.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_flight_No.setCellValueFactory(new PropertyValueFactory<ModelTable, String>("flight_no"));
        col_departure.setCellValueFactory(new PropertyValueFactory<driverConnector, String>("departure_country"));
        col_destination.setCellValueFactory(new PropertyValueFactory<driverConnector, String>("destination_country"));
        col_date.setCellValueFactory(new PropertyValueFactory<driverConnector, String>("departure_date"));
        col_time.setCellValueFactory(new PropertyValueFactory<driverConnector, String>("departure_time"));
        col_airline.setCellValueFactory(new PropertyValueFactory<driverConnector, String>("airline"));
        col_cost.setCellValueFactory(new PropertyValueFactory<driverConnector, String>("cost_in_euro"));

        table.setItems(oblist);


    }


}