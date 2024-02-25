package com.example.map;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AttackAnimation {

    public static void attack(Node node, boolean hero)
    {
        TranslateTransition right=new TranslateTransition(Duration.seconds(0.15),node);
        TranslateTransition left=new TranslateTransition(Duration.seconds(0.15),node);
        if (hero)
        {
            right.setToX(50);
            left.setToX(0);
            right.statusProperty().addListener((observableValue, status, t1) -> {
                if (t1== Animation.Status.STOPPED)
                {
                    left.play();
                }
            });
            right.play();
        }
        else
        {
            right.setToX(0);
            left.setToX(-50);
            left.statusProperty().addListener((observableValue, status, t1) -> {
                if (t1== Animation.Status.STOPPED)
                {
                    right.play();
                }
            });
            left.play();
        }
    }

    public static void beAttacked(Node node,boolean hero)
    {
        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.05),node);
        TranslateTransition translateTransition2=new TranslateTransition(Duration.seconds(0.05),node);
        TranslateTransition translateTransition3=new TranslateTransition(Duration.seconds(0.05),node);
        TranslateTransition translateTransition4=new TranslateTransition(Duration.seconds(0.05),node);
        if (hero)
        {
            translateTransition.setToX(-20);
            translateTransition2.setToX(0);
            translateTransition3.setToX(-20);
            translateTransition4.setToX(0);
            translateTransition.statusProperty().addListener((observableValue, status, t1) -> {
                if (t1== Animation.Status.STOPPED)
                {
                    translateTransition2.statusProperty().addListener((observableValue1, status1, t11) -> {
                        if (t11== Animation.Status.STOPPED)
                        {
                            translateTransition3.statusProperty().addListener((observableValue2, status2, t12) -> {
                                if (t12== Animation.Status.STOPPED)
                                {
                                    translateTransition4.play();
                                }
                            });
                            translateTransition3.play();
                        }
                    });
                    translateTransition2.play();
                }
            });
            translateTransition.play();
        }
        else
        {
            translateTransition.setToX(30);
            translateTransition2.setToX(0);
            translateTransition3.setToX(30);
            translateTransition4.setToX(0);
            translateTransition.statusProperty().addListener((observableValue, status, t1) -> {
                if (t1== Animation.Status.STOPPED)
                {
                    translateTransition2.statusProperty().addListener((observableValue1, status1, t11) -> {
                        if (t11== Animation.Status.STOPPED)
                        {
                            translateTransition3.statusProperty().addListener((observableValue2, status2, t12) -> {
                                if (t12== Animation.Status.STOPPED)
                                {
                                    translateTransition4.play();
                                }
                            });
                            translateTransition3.play();
                        }
                    });
                    translateTransition2.play();
                }
            });
            translateTransition.play();
        }
    }
}
