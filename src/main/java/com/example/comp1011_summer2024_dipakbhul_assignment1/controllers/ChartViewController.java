package com.example.comp1011_summer2024_dipakbhul_assignment1.controllers;

import com.example.comp1011_summer2024_dipakbhul_assignment1.HelloApplication;
import com.example.comp1011_summer2024_dipakbhul_assignment1.Model.Flight;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller class for managing the BarChart view of flight data.
 */
public class ChartViewController {
    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private RadioButton airlineRd;

    @FXML
    private RadioButton onTimeRd;

    @FXML
    private RadioButton delayRd;

    @FXML
    private Button flightBtn;

    private ToggleGroup toggleGroup;

    private HelloApplication mainApp;

    private FlightController flightController = new FlightController();

    /**
     * Sets the main application instance
     * @param mainApp The instance variable of the main application
     */
    public void setFlightApp(HelloApplication mainApp) {
        this.mainApp = mainApp;
        initializeRadioBtn();
        populateChart();
    }

    /**
     * Initializing the radio buttons and their toggle groups.
     */
    private void initializeRadioBtn() {
        toggleGroup = new ToggleGroup();
        airlineRd.setToggleGroup(toggleGroup);
        onTimeRd.setToggleGroup(toggleGroup);
        delayRd.setToggleGroup(toggleGroup);

        // Add listener to update the chart and button text when a radio button is selected
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> showChartBasedOnSelection());

        // By default selection
        airlineRd.setSelected(true);
    }

    /**
     * Populates the chart based on the selected radio button.
     */
    private void populateChart() {
        showChartBasedOnSelection();
    }

    /**
     * Launches the table view upon button click.
     */
    @FXML
    private void launchTableView() {
        mainApp.launchTableView();
    }

    /**
     * Updates the chart based on the selected radio button.
     */
    private void showChartBasedOnSelection() {
        String selectedType = getSelectedType();

        // Clear any previous data
        barChart.getData().clear();

        // Retrieve data from FlightController class based on selected type
        ObservableList<Flight> flights = flightController.getAllFlights();

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        if (selectedType.equals("Airlines")) {
            flightBtn.setText("No. of Flights by Airlines");
            Map<String, Integer> airlineCountMap = new HashMap<>();

            flights.stream()
                    .filter(flight -> flight.getDestination().equals("YYZ")) // Filter by destination YYZ
                    .forEach(flight -> {
                        String airline = flight.getAirline();
                        int count = airlineCountMap.getOrDefault(airline, 0) + 1;
                        airlineCountMap.put(airline, count);
                    });

            airlineCountMap.forEach((airline, count) -> series.getData().add(new XYChart.Data<>(airline, count)));

        } else if (selectedType.equals("On Time")) {
            flightBtn.setText("No. of Flights by On Time");
            Map<String, Integer> onTimeCountMap = new HashMap<>();

            flights.stream()
                    .filter(flight -> flight.getDestination().equals("YYZ"))
                    .filter(flight -> flight.getFlightStatus().equals("On Time"))
                    .forEach(flight -> {
                        String airline = flight.getAirline();
                        int count = onTimeCountMap.getOrDefault(airline, 0) + 1;
                        onTimeCountMap.put(airline, count);
                    });

            onTimeCountMap.forEach((airline, count) -> series.getData().add(new XYChart.Data<>(airline, count)));

        } else if (selectedType.equals("Delayed")) {
            flightBtn.setText("No. of Flights by Delayed");
            Map<String, Integer> delayedCountMap = new HashMap<>();

            flights.stream()
                    .filter(flight -> flight.getDestination().equals("YYZ"))
                    .filter(flight -> flight.getFlightStatus().equals("Delayed"))
                    .forEach(flight -> {
                        String airline = flight.getAirline();
                        int count = delayedCountMap.getOrDefault(airline, 0) + 1;
                        delayedCountMap.put(airline, count);
                    });

            delayedCountMap.forEach((airline, count) -> series.getData().add(new XYChart.Data<>(airline, count)));
        }

        barChart.getData().add(series);

        // Adjust the Y-axis dynamically based on the maximum count value
        adjustVerticalAxis(series);
    }

    /**
     * Adjusts the vertical axis of the bar chart based on the maximum count value.
     *
     * @param series The series containing the data for the bar chart
     */
    private void adjustVerticalAxis(XYChart.Series<String, Number> series) {
        NumberAxis yAxis = (NumberAxis) barChart.getYAxis();
        yAxis.setAutoRanging(false);

        // Set the Y-axis bounds based on the maximum count value
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(20);
        yAxis.setTickUnit(1);
    }

    /**
     * Retrieves the selected radio button's text.
     *
     * @return The text of the selected radio button
     */
    private String getSelectedType() {
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        return selectedRadioButton.getText();
    }
}
