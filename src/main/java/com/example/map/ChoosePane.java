package com.example.map;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class ChoosePane extends AnchorPane {
    private final Button button;
    private String imagePath;
    public static String framePath=ChoosePane.class.getResource("image/menu_pics/menuPanelFrame.png").toExternalForm();
    ChoosePane(int i, String url, String title, String detail)
    {
        setPrefSize(200,350);
        Font titleFont=Font.loadFont(MainApplication.fontPath,18);
        Font detailFont=Font.loadFont(MainApplication.fontPath,16);
        button=new Button();
        button.setPrefSize(200,350);
        if (i==0)
        {
            imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel.png").toExternalForm();
        }
        else if (i==1)
        {
            imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel2.png").toExternalForm();
        }
        else
        {
            imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel3.png").toExternalForm();
        }
        button.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 200px 350px;-fx-background-color: transparent; ");
        Label titleLabel=new Label(title);
        titleLabel.setPrefSize(200,50);
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setStyle("-fx-text-fill: rgb(239,200,81)");
        Label imageLabel=new Label();
        imageLabel.setPrefSize(164,100);
        imageLabel.setLayoutX(18);
        imageLabel.setLayoutY(53);
        imageLabel.setStyle("-fx-background-image: url('"+url+"');-fx-background-size: 164px 100px");
        Label imageFrame=new Label();
        imageFrame.setPrefSize(170,105);
        imageFrame.setLayoutX(15);
        imageFrame.setLayoutY(50);
        imageFrame.setStyle("-fx-background-image: url('"+framePath+"');-fx-background-color: transparent;-fx-background-size: 170px 105px");
        Label detailLabel=new Label(detail);
        detailLabel.setPrefSize(160,150);
        detailLabel.setLayoutX(20);
        detailLabel.setLayoutY(150);
        detailLabel.setWrapText(true);
        detailLabel.setAlignment(Pos.CENTER);
        detailLabel.setFont(detailFont);
        detailLabel.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226);");
        getChildren().addAll(button,titleLabel,imageLabel,imageFrame,detailLabel);
        addListener(i);
    }
    void addListener(int i)
    {
        setOnMouseEntered(event -> {
            if (i==0)
            {
                imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanelX.png").toExternalForm();
            }
            else if (i==1)
            {
                imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel2X.png").toExternalForm();
            }
            else
            {
                imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel3X.png").toExternalForm();
            }
            button.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 200px 350px;-fx-background-color: transparent;-fx-scale-x: 1.02 ;-fx-scale-y: 1.02");
        });
        setOnMouseExited(event -> {
            if (i==0)
            {
                imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel.png").toExternalForm();
            }
            else if (i==1)
            {
                imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel2.png").toExternalForm();
            }
            else
            {
                imagePath=ChoosePane.class.getResource("image/menu_pics/menuPanel3.png").toExternalForm();
            }
            button.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 200px 350px;-fx-background-color: transparent");
        });
    }
}
