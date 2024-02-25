package com.example.map;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class MenuButtonPane extends AnchorPane {
    private final AnchorPane backPane;
    public Button button;
    MenuButtonPane(String text)
    {
        super();
        setPrefSize(200,40);
        setStyle("-fx-background-color: transparent");
        backPane=new AnchorPane();
        backPane.setPrefSize(200,40);
        backPane.setStyle("-fx-background-color: transparent");
        button=new Button(text);
        button.setPrefSize(200,40);
        Font menuFont=Font.loadFont(MainApplication.fontPath,18);
        button.setFont(menuFont);
        button.setAlignment(Pos.CENTER_LEFT);
        button.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226);");
        getChildren().addAll(backPane,button);
        addListener();
    }
    void addListener()
    {
        String imagePath=MenuButtonPane.class.getResource("image/menu_pics/menu_option_highlight.png").toExternalForm();
        TranslateTransition rightTransition = new TranslateTransition(Duration.seconds(0.1),this);
        rightTransition.setToX(15);
        TranslateTransition leftTransition = new TranslateTransition(Duration.seconds(0.1),this);
        leftTransition.setToX(0);
        FadeTransition appearTransition=new FadeTransition(Duration.seconds(0.01),backPane);
        appearTransition.setToValue(1);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.3),backPane);
        fadeTransition.setToValue(0);
        setOnMouseEntered(event -> {
            rightTransition.play();
            appearTransition.play();
            backPane.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 200px 40px;-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226);");
        });
        setOnMouseExited(event -> {

            leftTransition.play();
            fadeTransition.play();
        });
    }
}
