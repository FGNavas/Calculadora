module com.example.calcluladora2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calcluladora2 to javafx.fxml;
    exports com.example.calcluladora2;
}