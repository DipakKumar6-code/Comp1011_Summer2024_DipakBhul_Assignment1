package com.example.comp1011_summer2024_dipakbhul_assignment1;

import com.example.comp1011_summer2024_dipakbhul_assignment1.controllers.ChartViewController;
import com.example.comp1011_summer2024_dipakbhul_assignment1.controllers.TableViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        showChartView(); // show the ChartView initially
    }

    public static void main(String[] args) {
        launch();
    }

    public void showChartView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/comp1011_summer2024_dipakbhul_assignment1/ChartView.fxml"));
            Scene scene = new Scene(loader.load());
            ChartViewController controller = loader.getController();
            controller.setFlightApp(this);
            stage.setScene(scene);
            stage.setTitle("Pearson Airport: Flight Data Analysis");
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void launchTableView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/comp1011_summer2024_dipakbhul_assignment1/TableView.fxml"));
            Scene scene = new Scene(loader.load());
            TableViewController controller = loader.getController();
            controller.setFlightApp(this);
            stage.setScene(scene);
            stage.setTitle("Pearson Airport: Flight Data Analysis");
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
