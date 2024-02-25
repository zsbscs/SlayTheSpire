package com.example.map;

import javafx.animation.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class CardAnimation {
    public static void cardDrop(Pane pane)
    {
        FadeTransition cardFade=new FadeTransition(Duration.seconds(0.5),pane);
        cardFade.setFromValue(1);
        cardFade.setToValue(0);
        TranslateTransition cardUpTransition=new TranslateTransition(Duration.seconds(0.1),pane);
        cardUpTransition.setFromX(0);
        cardUpTransition.setToX(80);
        cardUpTransition.setFromY(0);
        cardUpTransition.setToY(-220);
        TranslateTransition cardDownTransition=new TranslateTransition(Duration.seconds(0.4),pane);
        cardDownTransition.setFromX(80);
        cardDownTransition.setToX(500);
        cardDownTransition.setFromY(-220);
        cardDownTransition.setToY(-100);
        cardDownTransition.setDelay(Duration.seconds(0.1));
        RotateTransition rotateTransition=new RotateTransition(Duration.seconds(0.4),pane);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(2160);
        rotateTransition.setDelay(Duration.seconds(0.1));
        ScaleTransition cardUpScale=new ScaleTransition(Duration.seconds(0.1),pane);
        cardUpScale.setFromX(1);
        cardUpScale.setToX(0.9);
        cardUpScale.setFromY(1);
        cardUpScale.setToY(0.9);
        ScaleTransition cardDownScale=new ScaleTransition(Duration.seconds(0.4),pane);
        cardDownScale.setFromX(0.9);
        cardDownScale.setToX(0);
        cardDownScale.setFromY(0.9);
        cardDownScale.setToY(0);
        cardDownScale.setDelay(Duration.seconds(0.1));


        cardFade.play();
        cardUpTransition.play();
        cardDownTransition.play();
        cardUpScale.play();
        cardDownScale.play();
        rotateTransition.play();
    }
}
