package com.example.map;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Sale extends VBox {
    public static VBox salePane=null;
    public HBox[] saleList;
    public int toNextLine=0;
    public int useLine=0;
    Sale()
    {
        setPrefSize(1000,560);
        setSpacing(30);
        setLayoutY(40);
        salePane=this;
        setAlignment(Pos.CENTER);
        String imagePath=Sale.class.getResource("image/game_pics/saleback.png").toExternalForm();
        setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 1000px 560px");

        saleList=new HBox[2];
        for (int i=0;i<2;i++)
        {
            saleList[i]=new HBox();
            saleList[i].setPrefSize(1000,180);
            saleList[i].setAlignment(Pos.CENTER);
            saleList[i].setSpacing(25);
            getChildren().add(saleList[i]);
        }
        for (int i=0;i<10;i++)
        {
            addCard();
        }
    }
    void addCard()
    {
        //随机获得一个编号,从而得到一张卡
        int n=(int)(Math.random()*10.1+1);
        int num=Integer.parseInt(AccountDao.getCardID2(n));
        CardPane card=new CardPane(num);


        if (toNextLine==5)
        {
            useLine++;
            toNextLine=0;
        }
        saleList[useLine].getChildren().add(card);
        toNextLine++;

        int n2=(int)(Math.random()*50.1+50);
        TipLabel tipLabel=new TipLabel(String.valueOf(n2),true);
        card.getChildren().add(tipLabel);
        card.setOnMouseEntered(event-> {
            tipLabel.setVisible(true);
            card.setStyle("-fx-scale-x: 1.3;-fx-scale-y: 1.3;-fx-background-color: transparent");
        });
        card.setOnMouseExited(event-> {
            tipLabel.setVisible(false);
            card.setStyle("-fx-background-color: transparent");
        });
        card.setOnMouseClicked(event-> {
            if (GameScene.money>=n2)
            {
                GameScene.money-=n2;
                GameScene.moneyLabel.setText(String.valueOf(GameScene.money));
                GameScene.deck.addCard(num);
                CardAnimation.cardDrop(card);
                GameScene.deckLabel.setText(String.valueOf(GameScene.deck.cardNumber));
            }
            else
            {
                Shake.shake(GameScene.moneyLabel);
            }
        });
    }
}
