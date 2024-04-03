module fireseal {
    requires javafx.controls;
    requires javafx.fxml;

    opens fireseal to javafx.fxml;
    exports fireseal;
}
