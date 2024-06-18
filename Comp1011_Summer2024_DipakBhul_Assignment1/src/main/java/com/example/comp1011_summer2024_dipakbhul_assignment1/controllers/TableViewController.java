package com.example.comp1011_summer2024_dipakbhul_assignment1.controllers;

import com.example.comp1011_summer2024_dipakbhul_assignment1.HelloApplication;
import com.example.comp1011_summer2024_dipakbhul_assignment1.Model.Flight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

/**
 * Controller class for managing the TableView of flight data.
 */
public class TableViewController {

    @FXML
    private TableView<Flight> flightTable;

    @FXML
    private TableColumn<Flight, String> flightNumberCol;

    @FXML
    private TableColumn<Flight, String> airlineCol;

    @FXML
    private TableColumn<Flight, String> sourceColumn;

    @FXML
    private TableColumn<Flight, String> destinationCol;

    @FXML
    private TableColumn<Flight, String> departureTimeCol;

    @FXML
    private TableColumn<Flight, String> arrivalTimeCol;

    @FXML
    private TableColumn<Flight, String> flightStatusCol;

    @FXML
    private TableColumn<Flight, Integer> delayColumn;

    @FXML
    private Button loadAllBtn;

    private HelloApplication mainApp;
    private List<Flight> allFlights;
    private boolean loadAllFlights = false;

    /**
     * Sets the main application instance.
     * @param mainApp The instance variable of the main application
     */
    public void setFlightApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
        populateTable();
    }

    /**
     * Populates the TableView with flight data.
     */
    private void populateTable() {
        FlightController flightController = new FlightController();
        allFlights = flightController.getAllFlights();

        showInitialFlights();
    }

    /**
     * Displays the initial subset of flights in the TableView.
     */
    private void showInitialFlights() {
        ObservableList<Flight> initialFlights = FXCollections.observableArrayList(allFlights.subList(0, Math.min(10, allFlights.size())));
        flightTable.setItems(initialFlights);

        flightNumberCol.setCellValueFactory(new PropertyValueFactory<>("flightNumber"));
        airlineCol.setCellValueFactory(new PropertyValueFactory<>("airline"));
        sourceColumn.setCellValueFactory(new PropertyValueFactory<>("origin"));
        destinationCol.setCellValueFactory(new PropertyValueFactory<>("destination"));
        departureTimeCol.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
        arrivalTimeCol.setCellValueFactory(new PropertyValueFactory<>("arrivalTime"));
        flightStatusCol.setCellValueFactory(new PropertyValueFactory<>("flightStatus"));
        delayColumn.setCellValueFactory(new PropertyValueFactory<>("delay"));
    }

    /**
     * Loads all flight information into the TableView upon button click.
     */
    @FXML
    private void loadAllFlights() {
        if (!loadAllFlights) {
            ObservableList<Flight> allFlightsObservable = FXCollections.observableArrayList(allFlights);
            flightTable.setItems(allFlightsObservable);
            loadAllBtn.setText("Show Initial Flights");
            loadAllFlights = true;
        } else {
            showInitialFlights();
            loadAllBtn.setText("Load All Flight Details");
            loadAllFlights = false;
        }
    }

    /**
     * Switched to the ChartView if user wants based upon button click.
     */
    @FXML
    private void showChartView() {
        mainApp.showChartView();
    }
}
