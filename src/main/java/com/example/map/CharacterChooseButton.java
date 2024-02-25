package com.example.map;

import javafx.scene.control.Button;

public class CharacterChooseButton extends Button {
    private String Normal;
    private String Focus;
    CharacterChooseButton(String url, String url2)
    {
        super();
        Normal=url;
        Focus=url2;
        setPrefSize(80,80);
        setStyle("-fx-background-image: url('"+Normal+"');-fx-background-size: 80px 80px;-fx-background-color: transparent");
        addListener();
    }
    void addListener()
    {
        setOnMouseEntered(event -> {
            setStyle("-fx-background-image: url('"+Focus+"');-fx-background-size: 80px 80px;-fx-background-color: transparent");
        });
        setOnMouseExited(event -> {
            if (!isFocused())
            {
                setStyle("-fx-background-image: url('"+Normal+"');-fx-background-size: 80px 80px;-fx-background-color: transparent");
            }
        });
    }
}
