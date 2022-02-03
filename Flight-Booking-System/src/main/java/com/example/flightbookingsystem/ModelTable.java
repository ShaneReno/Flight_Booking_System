package com.example.flightbookingsystem;

public class ModelTable {

    String flight_no, departure_country, destination_country,departure_date,departure_time,airline,cost_in_euro;

    public ModelTable(String flight_no, String departure_country, String destination_country, String departure_date, String departure_time, String airline, String cost_in_euro){
        this.flight_no = flight_no;
        this.departure_country = departure_country;
        this.destination_country = destination_country;
        this.departure_date= departure_date;
        this.departure_time = departure_time;
        this.airline = airline;
        this.cost_in_euro = cost_in_euro;
    }

    public String getFlight_no(){
        return flight_no;
    }

    private void setFlight_no(String flight_no){
        this.flight_no = flight_no;
    }

    public String getDeparture_country(){
        return departure_country;
    }

    private void setDeparture_country(String departure_country){
        this.departure_country = departure_country;
    }

    public String getDestination_country(){
        return destination_country;
    }

    private void setDestination_country(String destination_country){
        this.destination_country = destination_country;
    }

    public String getDeparture_date(){
        return departure_date;
    }

    private void setDeparture_date(String departure_date){
        this.departure_date = departure_date;
    }

    public String getDeparture_time(){
        return departure_time;
    }

    private void setDeparture_time(String departure_time){
        this.departure_time = departure_time;
    }

    public String getAirline(){
        return airline;
    }

    private void setAirline(String airline){
        this.airline = airline;
    }

    public String getCost_in_euro(){
        return cost_in_euro;
    }

    private void setCost_in_euro(String cost_in_euro){
        this.cost_in_euro = cost_in_euro;
    }







}
