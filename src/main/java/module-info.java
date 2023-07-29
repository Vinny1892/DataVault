module com.nonpeer.datavault {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;

    opens com.nonpeer.datavault to javafx.fxml;
    exports com.nonpeer.datavault;
}