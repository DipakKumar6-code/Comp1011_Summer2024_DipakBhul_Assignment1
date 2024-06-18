package com.example.comp1011_summer2024_dipakbhul_assignment1.Model;


import java.time.LocalDateTime;

public class Flight {
//    Basic instance variables of Flight
    private int id;
    private String flightNumber;
    private String airline;
    private String source;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String flightStatus;
    private int delay;

//    Default constructor
    public Flight(){}

//    Flight constructor with 7 parameters inside it
    public Flight(String flightNumber, String airline, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, int delay) {
        setFlightNumber(flightNumber);
        setAirline(airline);
        setSourceAirport(source);
        setDestination(destination);
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        setDelay(delay);
    }

    // Getters and Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setSourceAirport(String source) {
        this.source = source;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getFlightStatus(){
        return source;
    }
    public void setFlightStatus(String status) {
        this.flightStatus = status;
    }


    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
    public String getOrigin() {
        return source;
    }

}

