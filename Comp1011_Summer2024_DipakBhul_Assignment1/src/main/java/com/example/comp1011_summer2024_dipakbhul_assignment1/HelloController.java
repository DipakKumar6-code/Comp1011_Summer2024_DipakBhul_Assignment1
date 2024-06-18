package com.example.comp1011_summer2024_dipakbhul_assignment1;
import com.example.comp1011_summer2024_dipakbhul_assignment1.Model.Flight;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to Toronto Pearson International Airport!");
        Flight flight = new Flight();
    }
}