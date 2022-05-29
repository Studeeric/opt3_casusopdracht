module com.gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gui to javafx.fxml;
    opens com.logic.machines to javafx.fxml, javafx.base;
    exports com;
    exports com.gui;
    exports com.logic;
    exports com.logic.machines;
    opens com to javafx.fxml;
}