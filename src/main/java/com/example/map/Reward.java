package com.example.map;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Reward extends AnchorPane {
    private int money;
    public static AnchorPane rewardPane=null;
    Reward()
    {
        AnchorPane coverPane=new AnchorPane();
        setPrefSize(350,500);
        rewardPane=this;
        setLayoutX(325);
        setLayoutY(50);
        String imagePath=Reward.class.getResource("image/game_pics/settingBack.png").toExternalForm();
        String imagePath2=Reward.class.getResource("image/game_pics/selectBanner.png").toExternalForm();
        coverPane.setPrefSize(260,390);
        coverPane.setLayoutX(45);
        coverPane.setLayoutY(55);
        coverPane.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 260px 390px");
        Font rewardPath= Font.loadFont(MainApplication.fontPath,20);

        Label tipLabel=new Label();
        tipLabel.setPrefSize(400,120);
        tipLabel.setLayoutX(-28);
        tipLabel.setLayoutY(20);
        tipLabel.setAlignment(Pos.CENTER);
        tipLabel.setStyle("-fx-background-image: url('"+imagePath2+"');-fx-background-size: 400px 120px;");
        Label messageLabel=new Label();
        messageLabel.setLayoutX(135);
        messageLabel.setLayoutY(52);
        messageLabel.setAlignment(Pos.CENTER);
        messageLabel.setFont(rewardPath);
        int n=(int)Math.random()*10;
        if(n>5)
        {
            messageLabel.setText("好好搜刮!");
        }
        else
        {
            messageLabel.setText("好东西!");
        }

        Button btnCard=new Button("将一张卡牌加入你的牌组中");
        btnCard.setPrefSize(200,50);
        btnCard.setLayoutX(30);
        btnCard.setLayoutY(70);
        btnCard.setStyle("-fx-background-color: rgb(255,255,255,0.3);-fx-text-fill: rgb(255,246,226)");
        btnCard.setOnMouseEntered(event -> {
            btnCard.setStyle("-fx-background-color: rgb(255,255,255,0.2);-fx-text-fill: rgb(255,246,226)");
        });
        btnCard.setOnMouseExited(event -> {
            btnCard.setStyle("-fx-background-color: rgb(255,255,255,0.3);-fx-text-fill: rgb(255,246,226)");
        });
        btnCard.setOnAction(event -> {
            btnCard.setVisible(false);
            SelectCard selectCard=new SelectCard();
            getChildren().add(selectCard);
            TranslateTransition transition=new TranslateTransition(Duration.seconds(0.2),selectCard);
            transition.setFromY(100);
            transition.setToY(0);
            transition.play();
        });

        money=(int) (Math.random()*20+10);
        Button btnMoney=new Button(money+"金币");
        btnMoney.setPrefSize(200,50);
        btnMoney.setLayoutX(30);
        btnMoney.setLayoutY(130);
        btnMoney.setStyle("-fx-background-color: rgb(255,255,255,0.3);-fx-text-fill: rgb(255,246,226)");
        btnMoney.setOnMouseEntered(event -> {
            btnMoney.setStyle("-fx-background-color: rgb(255,255,255,0.2);-fx-text-fill: rgb(255,246,226)");
        });
        btnMoney.setOnMouseExited(event -> {
            btnMoney.setStyle("-fx-background-color: rgb(255,255,255,0.3);-fx-text-fill: rgb(255,246,226)");
        });
        btnMoney.setOnAction(event -> {
            btnMoney.setVisible(false);
            GameScene.setMoney(GameScene.money+money);
            Shake.shake(GameScene.moneyLabel);
        });


        coverPane.getChildren().addAll(btnCard,btnMoney);
        getChildren().addAll(coverPane,tipLabel,messageLabel);

        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.2), this);
        translateTransition.setFromY(100);
        translateTransition.setToY(0);
        translateTransition.play();
    }
}
