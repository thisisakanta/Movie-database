package com.example.demo5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Stage stage_new;
    public void start(Stage stage) throws IOException {
        stage_new=stage;
        Parent root=FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Scene scene1=new Scene(root);
        stage.setScene(scene1);
        stage.show();

    }
    public static void main(String[] args) {

        launch();
    }
}