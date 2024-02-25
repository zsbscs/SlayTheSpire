package com.example.map;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    public static Stage stage=null;


    public static String fontPath=MainApplication.class.getResource("image/fonts/NotoSansCJKtc-Regular.otf").toExternalForm();
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;
        stage.setResizable(false);
        stage.setTitle("Slay the Spire");
        MenuScene menuScene=new MenuScene(false);
        //AnchorPane anchorPane=new AnchorPane();
        //GameScene menuScene=new GameScene(anchorPane,"sb",1);
        stage.setScene(menuScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}