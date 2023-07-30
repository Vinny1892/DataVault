package com.nonpeer.datavault;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Gui extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GuiManagement.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), stage.getMaxWidth(), stage.getMaxHeight());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void launchGui(){
        launch();
    }
}