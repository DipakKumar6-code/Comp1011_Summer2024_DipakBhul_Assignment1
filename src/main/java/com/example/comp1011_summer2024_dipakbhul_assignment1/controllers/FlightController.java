package com.example.comp1011_summer2024_dipakbhul_assignment1.controllers;

import com.example.comp1011_summer2024_dipakbhul_assignment1.controllers.Database;
import com.example.comp1011_summer2024_dipakbhul_assignment1.Model.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * FlightController class retrieves flight data from the FlightDetails table in the PearsonAirport database.
 */
public class FlightController {

    /**
     * Retrieves a list of all flights from the FlightDetails table.
     * @return ObservableList of Flight objects containing flight details
     */
    public ObservableList<Flight> getAllFlights() {
        ObservableList<Flight> flights = FXCollections.observableArrayList();
        try (Connection connection = Database.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM FlightDetails")) {
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightNumber(resultSet.getString("flight_number"));
                flight.setAirline(resultSet.getString("airline"));
                flight.setSourceAirport(resultSet.getString("origin"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDepartureTime(resultSet.getTimestamp("departure_time").toLocalDateTime());
                flight.setArrivalTime(resultSet.getTimestamp("arrival_time").toLocalDateTime());
                flight.setFlightStatus(resultSet.getString("status"));
                flight.setDelay(resultSet.getInt("delay"));
                flights.add(flight);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return flights;
    }
}
