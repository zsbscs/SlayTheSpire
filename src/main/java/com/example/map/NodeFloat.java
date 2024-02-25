package com.example.map;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class NodeFloat {
    public static void nodeFloat(String text, Pane pane)
    {
        Label label=new Label();
        label.setText(text);
        label.setPrefSize(100,50);
        label.setLayoutX(10);
        label.setLayoutY(10);
        Font font=new Font(MainApplication.fontPath,40);
        label.setFont(font);
        label.setAlignment(Pos.CENTER);
        label.setStyle("-fx-text-fill: rgb(255,246,226)");
        pane.getChildren().add(label);
        TranslateTransition quick=new TranslateTransition(Duration.seconds(0.5),label);
        quick.setToY(-120);
        ScaleTransition small=new ScaleTransition(Duration.seconds(0.5),label);
        small.setFromX(2);
        small.setToX(1);
        small.setFromY(2);
        small.setToY(1);
        TranslateTransition slow=new TranslateTransition(Duration.seconds(0.5),label);
        slow.setFromY(-120);
        slow.setToY(-150);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(0.5),label);
        fadeTransition.setToValue(0);
        small.play();
        quick.statusProperty().addListener((observableValue, status, t1) -> {
            if (t1== Animation.Status.STOPPED)
            {
                fadeTransition.play();
                slow.statusProperty().addListener((observableValue1, status1, t11) -> {
                    if (t11== Animation.Status.STOPPED)
                    {
                        label.setVisible(false);
                    }
                });
                slow.play();
            }
        });
        quick.play();
    }
}
