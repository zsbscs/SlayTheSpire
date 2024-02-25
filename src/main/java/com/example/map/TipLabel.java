package com.example.map;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class TipLabel extends Label {
    TipLabel(String text,boolean money)
    {
        String imagePath=TipLabel.class.getResource("image/menu_pics/settingBack.png").toExternalForm();
        if (money)
        {
            setPrefSize(50,50);
            setLayoutX(-50);
            setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 50px 50px;-fx-text-fill: rgb(239,200,81)");
        }
        else
        {
            setPrefSize(100,80);
            setLayoutX(-100);
            setWrapText(true);
            setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 100px 80px;-fx-text-fill: rgb(255,246,226)");
        }
        setText(text);
        setAlignment(Pos.CENTER);
        setVisible(false);
    }
}
