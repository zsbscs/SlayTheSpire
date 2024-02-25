package com.example.map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

public class SelectCard extends AnchorPane {
    SelectCard()
    {
        setPrefSize(1000,165);
        setLayoutX(-325);
        setLayoutY(150);
        HBox blackPane=new HBox();
        blackPane.setPrefSize(1000,165);
        blackPane.setSpacing(25);
        blackPane.setAlignment(Pos.CENTER);
        blackPane.setStyle("-fx-background-color: rgb(0,0,0,0.8)");
        getChildren().add(blackPane);
        CardPane[] cardList=new CardPane[3];
        int[] numberList=new int[3];
        for (int i=0;i<3;i++)
        {
            //随机3张卡
            int number=(int)(Math.random()*10+1);
            CardPane card=new CardPane(Integer.parseInt(AccountDao.getCardID2(number)));
            cardList[i]=card;
            numberList[i]=number;
            blackPane.getChildren().add(card);
        }

        cardList[0].setOnMouseClicked(event -> {
            GameScene.deckLabel.setText(String.valueOf(GameScene.deck.cardNumber+1));
            GameScene.deck.addCard(Integer.parseInt(AccountDao.getCardID2(numberList[0])));
            CardAnimation.cardDrop(cardList[0]);
            cardList[1].setVisible(false);
            cardList[2].setVisible(false);
            blackPane.setStyle("-fx-background-color: transparent");
            Timeline timeline=new Timeline(
                    new KeyFrame(Duration.seconds(0.5),actionEvent->{
                        setVisible(false);
                    })
            );
            timeline.setCycleCount(1);
            timeline.play();
        });
        cardList[1].setOnMouseClicked(event -> {
            GameScene.deckLabel.setText(String.valueOf(GameScene.deck.cardNumber+1));
            GameScene.deck.addCard(Integer.parseInt(AccountDao.getCardID2(numberList[1])));
            CardAnimation.cardDrop(cardList[1]);
            cardList[0].setVisible(false);
            cardList[2].setVisible(false);
            blackPane.setStyle("-fx-background-color: transparent");
            Timeline timeline=new Timeline(
                    new KeyFrame(Duration.seconds(0.5),actionEvent->{
                        setVisible(false);
                    })
            );
            timeline.setCycleCount(1);
            timeline.play();
        });
        cardList[2].setOnMouseClicked(event -> {
            GameScene.deckLabel.setText(String.valueOf(GameScene.deck.cardNumber+1));
            GameScene.deck.addCard(Integer.parseInt(AccountDao.getCardID2(numberList[2])));
            CardAnimation.cardDrop(cardList[2]);
            cardList[0].setVisible(false);
            cardList[1].setVisible(false);
            blackPane.setStyle("-fx-background-color: transparent");
            Timeline timeline=new Timeline(
                    new KeyFrame(Duration.seconds(0.5),actionEvent->{
                        setVisible(false);
                    })
            );
            timeline.setCycleCount(1);
            timeline.play();
        });
    }
}
