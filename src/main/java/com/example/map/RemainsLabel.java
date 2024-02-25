package com.example.map;

import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class RemainsLabel extends Label {
    RemainsLabel()
    {
        super();
        setPrefSize(36,36);
        setStyle("-fx-background-color: transparent");
    }
    void setRemains(String url)
    {
        setStyle("-fx-background-color: transparent;-fx-background-image: url('"+url+"');-fx-background-size: 36px 36px");
        addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            setStyle("-fx-background-color: transparent;-fx-background-image: url('"+url+"');-fx-background-size: 36px 36px;-fx-scale-x: 1,1;-fx-scale-y: 1,1");
        });
        addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            setStyle("-fx-background-color: transparent;-fx-background-image: url('"+url+"');-fx-background-size: 36px 36px");
        });
    }
}
