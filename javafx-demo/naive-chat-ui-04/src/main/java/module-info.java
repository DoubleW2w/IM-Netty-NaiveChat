module com.doublew2w {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.doublew2w to javafx.fxml;
    exports com.doublew2w;
}
