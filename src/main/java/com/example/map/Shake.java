package com.example.map;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {


    public static void shake(Node node)
    {
        TranslateTransition shakeTransition=new TranslateTransition(Duration.seconds(0.03));
        TranslateTransition shakeTransition2=new TranslateTransition(Duration.seconds(0.03));
        TranslateTransition shakeTransition3=new TranslateTransition(Duration.seconds(0.03));
        TranslateTransition shakeTransition4=new TranslateTransition(Duration.seconds(0.03));
        shakeTransition.setNode(node);
        shakeTransition2.setNode(node);
        shakeTransition3.setNode(node);
        shakeTransition4.setNode(node);
        shakeTransition.setToX(-10);
        shakeTransition.setToY(10);
        shakeTransition2.setToX(0);
        shakeTransition2.setToY(0);
        shakeTransition3.setToX(-10);
        shakeTransition3.setToY(10);
        shakeTransition4.setToX(0);
        shakeTransition4.setToY(0);
        shakeTransition.statusProperty().addListener((observableValue, oldstatus, newstatus) -> {
            if (newstatus== Animation.Status.STOPPED)
            {
                shakeTransition2.statusProperty().addListener((observableValue2, oldstatus2, newstatus2) -> {
                    if (newstatus2== Animation.Status.STOPPED)
                    {
                        shakeTransition3.statusProperty().addListener((observableValue3, oldstatus3, newstatus3) -> {
                            if (newstatus3== Animation.Status.STOPPED)
                            {
                                shakeTransition4.play();
                            }
                        });
                        shakeTransition3.play();
                    }
                });
                shakeTransition2.play();
            }
        });
        shakeTransition.play();
    }
}
