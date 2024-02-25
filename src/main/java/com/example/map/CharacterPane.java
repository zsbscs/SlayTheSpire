package com.example.map;

import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class CharacterPane extends AnchorPane {
    CharacterPane(String name, int hp, int money, String detail, String remainsurl, String remainsname, String remainsdetail, String backurl)
    {
        super();
        setPrefSize(1000,600);
        AnchorPane blackPane=new AnchorPane();
        blackPane.setPrefSize(1000,600);
        blackPane.setStyle("-fx-background-color: black");

        AnchorPane backPane=new AnchorPane();
        backPane.setPrefSize(1000,600);
        backPane.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+backurl+"');-fx-background-size: 1000px 600px");

        //文字布局

        VBox detailPane=new VBox();
        detailPane.setPrefSize(300,250);
        detailPane.setSpacing(0);
        detailPane.setLayoutX(-300);
        detailPane.setLayoutY(150);
        //名字栏
        Label nameLabel=new Label(name);
        nameLabel.setPrefSize(300,50);
        nameLabel.setAlignment(Pos.CENTER_LEFT);
        Font bigFont=Font.loadFont(MainApplication.fontPath,40);
        nameLabel.setFont(bigFont);
        nameLabel.setStyle("-fx-text-fill: rgb(239,200,81);-fx-background-color: transparent");
        //属性栏
        HBox propertyPane=new HBox();
        propertyPane.setPrefSize(300,50);
        propertyPane.setSpacing(30);
        propertyPane.setAlignment(Pos.CENTER_LEFT);
        Font smallFont=Font.loadFont(MainApplication.fontPath,14);
        HBox hpPane=new HBox();
        hpPane.setPrefSize(120,50);
        hpPane.setAlignment(Pos.CENTER);
        hpPane.setSpacing(0);
        Label hpImage=new Label();
        hpImage.setPrefSize(30,30);
        String hpPath=CharacterPane.class.getResource("image/game_pics/panelHeart.png").toExternalForm();
        hpImage.setStyle("-fx-background-image: url('"+hpPath+"');-fx-background-size: 30px 30px");
        Label hpLabel=new Label("生命："+hp+"/"+hp);
        hpLabel.setFont(smallFont);
        hpLabel.setPrefSize(90,50);
        hpLabel.setAlignment(Pos.CENTER);
        hpLabel.setStyle("-fx-text-fill: rgb(250,128,114);");
        hpPane.getChildren().addAll(hpImage,hpLabel);
        HBox moneyPane=new HBox();
        moneyPane.setPrefSize(100,50);
        moneyPane.setAlignment(Pos.CENTER);
        moneyPane.setSpacing(0);
        Label moneyImage=new Label();
        moneyImage.setPrefSize(30,30);
        String moneyPath=CharacterPane.class.getResource("image/game_pics/panelGoldBag.png").toExternalForm();
        moneyImage.setStyle("-fx-background-image: url('"+moneyPath+"');-fx-background-size: 30px 30px");
        Label moneyLabel=new Label("金币："+money);
        moneyLabel.setAlignment(Pos.CENTER);
        moneyLabel.setPrefSize(70,50);
        moneyLabel.setFont(smallFont);
        moneyLabel.setStyle("-fx-text-fill: rgb(239,200,81)");
        moneyPane.getChildren().addAll(moneyImage,moneyLabel);
        propertyPane.getChildren().addAll(hpPane,moneyPane);
        //介绍栏
        Label detailLabel=new Label(detail);
        detailLabel.setPrefSize(300,70);
        detailLabel.setAlignment(Pos.TOP_CENTER);
        detailLabel.setFont(smallFont);
        detailLabel.setWrapText(true);
        detailLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
        //初始遗物
        AnchorPane remainsPane=new AnchorPane();
        remainsPane.setPrefSize(300,80);
        Label remainsImage=new Label();
        remainsImage.setPrefSize(50,50);
        remainsImage.setLayoutY(10);
        remainsImage.setStyle("-fx-background-image: url('"+remainsurl+"');-fx-background-size: 50px 50px");
        Label remainsName=new Label(remainsname);
        remainsName.setPrefSize(200,25);
        remainsName.setLayoutX(60);
        remainsName.setAlignment(Pos.CENTER_LEFT);
        remainsName.setFont(smallFont);
        remainsName.setStyle("-fx-text-fill: rgb(239,200,81)");
        Label remainsDetail=new Label(remainsdetail);
        remainsDetail.setPrefSize(200,55);
        remainsDetail.setLayoutX(60);
        remainsDetail.setLayoutY(25);
        remainsDetail.setWrapText(true);
        remainsDetail.setAlignment(Pos.TOP_LEFT);
        remainsDetail.setFont(smallFont);
        remainsDetail.setStyle("-fx-text-fill: rgb(255,246,226);");
        remainsPane.getChildren().addAll(remainsImage,remainsName,remainsDetail);
        detailPane.getChildren().addAll(nameLabel,propertyPane,detailLabel,remainsPane);
        TranslateTransition appearTransition=new TranslateTransition(Duration.seconds(0.3),detailPane);
        appearTransition.setToX(400);
        appearTransition.play();
        getChildren().addAll(blackPane,backPane,detailPane);
    }
}
