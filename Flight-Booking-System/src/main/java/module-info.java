module com.example.flightbookingsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires jdk.internal.opt;
    requires java.sql;

    opens com.example.flightbookingsystem to javafx.fxml;
    exports com.example.flightbookingsystem;
}