package com.findling.mobileBookstore;

import com.findling.mobileBookstore.model.BookList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/home.fxml"));
        primaryStage.setTitle("Mobile Bookstore");
        primaryStage.setScene(new Scene(root, 575, 450));
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }


}
