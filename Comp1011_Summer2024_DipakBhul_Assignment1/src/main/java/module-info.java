module com.example.comp1011_summer2024_dipakbhul_assignment1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.comp1011_summer2024_dipakbhul_assignment1 to javafx.fxml;
    exports com.example.comp1011_summer2024_dipakbhul_assignment1;

    exports com.example.comp1011_summer2024_dipakbhul_assignment1.controllers;
    opens com.example.comp1011_summer2024_dipakbhul_assignment1.controllers to javafx.fxml;

    exports com.example.comp1011_summer2024_dipakbhul_assignment1.Model;
    opens com.example.comp1011_summer2024_dipakbhul_assignment1.Model to javafx.fxml;
}
