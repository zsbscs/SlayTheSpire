package com.example.map;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class SceneChange {
    public static void blackTo0(Pane pane)
    {
        Pane newPane=new Pane();
        newPane.setPrefSize(1000,600);
        newPane.setStyle("-fx-background-color: black");
        pane.getChildren().add(newPane);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),newPane);
        fadeTransition.setToValue(0);
        fadeTransition.statusProperty().addListener((observableValue, oldstatus, newstatus) -> {
            if (newstatus== Animation.Status.STOPPED)
            {
                newPane.setVisible(false);
                newPane.setDisable(true);
            }
        });
        fadeTransition.play();
    }
    public static void blackTo1To0(Pane pane)
    {
        Pane newPane=new Pane();
        newPane.setPrefSize(1000,600);
        newPane.setStyle("-fx-background-color: black");
        pane.getChildren().add(newPane);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),newPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.statusProperty().addListener((observableValue, oldstatus, newstatus) -> {
            if (newstatus== Animation.Status.STOPPED)
            {
                blackTo0(pane);
                newPane.setVisible(false);
                newPane.setDisable(true);
            }
        });
        fadeTransition.play();
    }
    public static void blackTo1To0(Pane paneTo1,Pane paneTo0)
    {
        Pane newPane=new Pane();
        newPane.setPrefSize(1000,600);
        newPane.setStyle("-fx-background-color: black");
        paneTo1.getChildren().add(newPane);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),newPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.statusProperty().addListener((observableValue, oldstatus, newstatus) -> {
            if (newstatus== Animation.Status.STOPPED)
            {
                blackTo0(paneTo0);
                MainApplication.stage.setScene(paneTo0.getScene());
                newPane.setVisible(false);
                newPane.setDisable(true);
            }
        });
        fadeTransition.play();
    }
    public static void blackTo1To0(Pane paneTo1, Pane paneTo0, Pane toPane)
    {
        Pane newPane=new Pane();
        newPane.setPrefSize(1000,600);
        newPane.setStyle("-fx-background-color: black");
        paneTo1.getChildren().add(newPane);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),newPane);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.statusProperty().addListener((observableValue, oldstatus, newstatus) -> {
            if (newstatus== Animation.Status.STOPPED)
            {
                if (toPane.getScene()!=null)
                {
                    toPane.getChildren().add(paneTo0);
                    MainApplication.stage.setScene(toPane.getScene());
                }
                blackTo0(paneTo0);
                newPane.setVisible(false);
                newPane.setDisable(true);
            }
        });
        fadeTransition.play();
    }
}
