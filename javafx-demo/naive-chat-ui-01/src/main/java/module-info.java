module sample {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    opens sample to javafx.fxml;
    exports sample;
}