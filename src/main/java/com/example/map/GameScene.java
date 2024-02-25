package com.example.map;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class GameScene extends Scene {
    public static TranslateTransition returnTransition;
    public static TranslateTransition proceedTransition;
    public static AnchorPane blackPane=null;
    public static AnchorPane useBlackPane=null;
    public static GameScene gameScene=null;
    public static AnchorPane gamePane=null;
    public static AnchorPane usePane=null;
    public static AnchorPane btPane=null;
    public static Deck deck=null;
    public static Label moneyLabel=null;
    public static Label hpLabel=null;
    public static Label deckLabel=null;
    public static int money=99;
    public static String hp=null;
        GameScene(AnchorPane mainPane, String name, int character)
    {
        super(mainPane,1000,600);
        gameScene=this;
        gamePane=mainPane;
        setCursor(new ImageCursor(new Image(MenuScene.cursorPath)));
        blackPane=new AnchorPane();
        blackPane.setPrefSize(1000,600);
        blackPane.setStyle("-fx-background-color: rgb(0,0,0,0.8)");
        blackPane.setVisible(false);
        useBlackPane=new AnchorPane();
        useBlackPane.setPrefSize(1000,600);
        useBlackPane.setStyle("-fx-background-color: rgb(0,0,0,0.8)");
        useBlackPane.setVisible(false);
        Button btnReturn=new Button("返回");
        Button btnProceed=new Button("继续");
        returnTransition=new TranslateTransition(Duration.seconds(0.2),btnReturn);
        proceedTransition=new TranslateTransition(Duration.seconds(0.2),btnProceed);
        Map map=new Map();

        //状态栏

        Font gameFont=Font.loadFont(MainApplication.fontPath,15);
        HBox topPane2=new HBox();
        topPane2.setPrefSize(800,40);
        topPane2.setSpacing(0);
        topPane2.setAlignment(Pos.CENTER_LEFT);
        topPane2.setStyle("-fx-background-color: rgb(55,65,70)");
        Label nameLabel=new Label(name);
        nameLabel.setPrefSize(200,40);
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setFont(gameFont);
        nameLabel.setStyle("-fx-text-fill: white;-fx-font-size: 18");
        Label hpImage=new Label();
        hpImage.setPrefSize(36,36);
        hpImage.setTooltip(new Tooltip("生命值"));
        String hpPath=GameScene.class.getResource("image/game_pics/panelHeart.png").toExternalForm();
        hpImage.setStyle("-fx-background-image: url('"+hpPath+"');-fx-background-size: 36px 36px");
        hpImage.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            hpImage.setStyle("-fx-background-image: url('"+hpPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        hpImage.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            hpImage.setStyle("-fx-background-image: url('"+hpPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        hpLabel=new Label();
        if (MenuScene.choose==1)
        {
            hp="80/80";
            hpLabel.setText("80/80");
        }
        else if (MenuScene.choose==2)
        {
            hp="70/70";
            hpLabel.setText("70/70");
        }
        else if (MenuScene.choose==3)
        {
            hp="75/75";
            hpLabel.setText("75/75");
        }
        else
        {
            hpLabel.setText("999/999");
        }
        hpLabel.setFont(gameFont);
        hpLabel.setPrefSize(80,40);
        hpLabel.setAlignment(Pos.CENTER_LEFT);
        hpLabel.setStyle("-fx-text-fill: rgb(250,128,114);");
        hpLabel.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            hpImage.setStyle("-fx-background-image: url('"+hpPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        hpLabel.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            hpImage.setStyle("-fx-background-image: url('"+hpPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        Label moneyImage=new Label();
        moneyImage.setPrefSize(36,36);
        moneyImage.setTooltip(new Tooltip("钱袋"));
        String moneyPath=GameScene.class.getResource("image/game_pics/panelGoldBag.png").toExternalForm();
        moneyImage.setStyle("-fx-background-image: url('"+moneyPath+"');-fx-background-size: 36px 36px");
        moneyImage.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            moneyImage.setStyle("-fx-background-image: url('"+moneyPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        moneyImage.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            moneyImage.setStyle("-fx-background-image: url('"+moneyPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        moneyLabel=new Label("99");
        moneyLabel.setAlignment(Pos.CENTER_LEFT);
        moneyLabel.setPrefSize(60,40);
        moneyLabel.setFont(gameFont);
        moneyLabel.setStyle("-fx-text-fill: rgb(239,200,81)");
        moneyLabel.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            moneyImage.setStyle("-fx-background-image: url('"+moneyPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        moneyLabel.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            moneyImage.setStyle("-fx-background-image: url('"+moneyPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        HBox topPane3=new HBox();
        topPane3.setPrefSize(200,40);
        topPane3.setSpacing(0);
        topPane3.setAlignment(Pos.CENTER_LEFT);
        //药水
        Button btnPotion=new Button();
        btnPotion.setPrefSize(36,36);
        String emptyPotion=GameScene.class.getResource("image/game_pics/potion_placeholder.png").toExternalForm();
        btnPotion.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        btnPotion.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            btnPotion.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        btnPotion.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnPotion.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        Button btnPotion2=new Button();
        btnPotion2.setPrefSize(36,36);
        btnPotion2.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        btnPotion2.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            btnPotion2.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        btnPotion2.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnPotion2.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        Button btnPotion3=new Button();
        btnPotion3.setPrefSize(36,36);
        btnPotion3.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        btnPotion3.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            btnPotion3.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;-fx-scale-x: 1.2;-fx-scale-y: 1.2");
        });
        btnPotion3.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnPotion3.setStyle("-fx-background-image: url('"+emptyPotion+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        topPane3.getChildren().addAll(btnPotion,btnPotion2,btnPotion3);
        topPane2.getChildren().addAll(nameLabel,hpImage,hpLabel,moneyImage,moneyLabel,topPane3);
        //设置
        HBox topPane4=new HBox();
        topPane4.setPrefSize(200,40);
        topPane4.setLayoutX(800);
        topPane4.setAlignment(Pos.CENTER_RIGHT);
        topPane4.setSpacing(5);
        topPane4.setStyle("-fx-background-color: rgb(55,65,70)");
        AnchorPane settingCover=new AnchorPane();
        AnchorPane mapCover=new AnchorPane();
        deck=new Deck(null);
        //设置按钮
        Button btnSetting=new Button();
        btnSetting.setPrefSize(36,36);
        btnSetting.setTooltip(new Tooltip("设定"));
        String settingPath=GameScene.class.getResource("image/game_pics/settings.png").toExternalForm();
        btnSetting.setStyle("-fx-background-image: url('"+settingPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        btnSetting.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            RotateTransition rotateTransition=new RotateTransition(Duration.seconds(0.1));
            rotateTransition.setNode(btnSetting);
            rotateTransition.setToAngle(60);
            rotateTransition.play();
            btnSetting.setStyle("-fx-background-image: url('"+settingPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;");
        });
        btnSetting.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            RotateTransition rotateBackTransition=new RotateTransition(Duration.seconds(0.1));
            rotateBackTransition.setToAngle(0);
            rotateBackTransition.setNode(btnSetting);
            rotateBackTransition.play();
            btnSetting.setStyle("-fx-background-image: url('"+settingPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        settingCover.setPrefSize(1000,480);
        settingCover.setLayoutY(120);
        AnchorPane settingPane=new AnchorPane();
        settingPane.setPrefSize(300,400);
        settingPane.setLayoutX(350);
        String settingBackPath=GameScene.class.getResource("image/game_pics/settingBack.png").toExternalForm();
        settingPane.setStyle("-fx-background-image: url('"+settingBackPath+"');-fx-background-size: 300px 400px;-fx-background-color: transparent");
        Button abandonButton=new Button("放弃这局游戏");
        abandonButton.setPrefSize(250,50);
        abandonButton.setLayoutX(408);
        abandonButton.setLayoutY(-10);
        abandonButton.setAlignment(Pos.CENTER);
        Font abandonFont=Font.loadFont(MainApplication.fontPath,18);
        abandonButton.setFont(abandonFont);
        String abandonPath=GameScene.class.getResource("image/game_pics/abandon.png").toExternalForm();
        abandonButton.setStyle("-fx-background-image: url('"+abandonPath+"');-fx-background-size: 250px 50px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        abandonButton.setOnMouseEntered(event -> {
            String abandonPathX=GameScene.class.getResource("image/game_pics/abandonX.png").toExternalForm();
            abandonButton.setStyle("-fx-background-image: url('"+abandonPathX+"');-fx-background-size: 250px 50px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        abandonButton.setOnMouseExited(event -> {
            abandonButton.setStyle("-fx-background-image: url('"+abandonPath+"');-fx-background-size: 250px 50px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        abandonButton.setOnAction(event -> {
            MenuScene.backToMenuScene(false);
        });
        Button quitButton=new Button("保存并退出");
        quitButton.setPrefSize(320,200);
        quitButton.setLayoutX(440);
        quitButton.setLayoutY(190);
        quitButton.setAlignment(Pos.BOTTOM_CENTER);
        Font quitFont=Font.loadFont(MainApplication.fontPath,20);
        quitButton.setFont(quitFont);
        String quitPath=GameScene.class.getResource("image/game_pics/quitButton.png").toExternalForm();
        quitButton.setStyle("-fx-background-image: url('"+quitPath+"');-fx-background-size:320px 200px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        quitButton.setOnMouseEntered(event -> {
            String quitPathX=GameScene.class.getResource("image/game_pics/quitButtonX.png").toExternalForm();
            quitButton.setStyle("-fx-background-image: url('"+quitPathX+"');-fx-background-size:320px 200px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        quitButton.setOnMouseExited(event -> {
            quitButton.setStyle("-fx-background-image: url('"+quitPath+"');-fx-background-size:320px 200px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        quitButton.setOnAction(event -> {
            MenuScene.backToMenuScene(true);
            returnTransition.setToX(0);
            returnTransition.play();
            blackPane.setVisible(false);
            if (settingCover.isVisible())
            {
                settingCover.setVisible(false);
            }
            else if (deck.isVisible())
            {
                deck.setVisible(false);
            }
        });
        settingCover.getChildren().addAll(settingPane,abandonButton,quitButton);
        settingCover.setVisible(false);
        TranslateTransition settingTransition=new TranslateTransition(Duration.seconds(0.2),settingCover);
        settingTransition.setFromY(100);
        settingTransition.setToY(0);
        btnSetting.setOnAction(event -> {
            if (deck.isVisible())
            {
                deck.setVisible(false);
            }
            if (mapCover.isVisible())
            {
                mapCover.setVisible(false);
            }
            settingCover.setVisible(true);
            blackPane.setVisible(true);
            returnTransition.setToX(140);
            returnTransition.play();
            settingTransition.play();
        });
        //牌组按钮
        AnchorPane deckPane=new AnchorPane();
        deckPane.setPrefSize(36,36);
        Button btnCard=new Button();
        btnCard.setPrefSize(36,36);
        btnCard.setTooltip(new Tooltip("牌组"));
        String cardPath=GameScene.class.getResource("image/game_pics/deck.png").toExternalForm();
        btnCard.setStyle("-fx-background-image: url('"+cardPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        btnCard.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            RotateTransition rotateTransition=new RotateTransition(Duration.seconds(0.1));
            rotateTransition.setNode(btnCard);
            rotateTransition.setToAngle(-30);
            rotateTransition.play();
            btnCard.setStyle("-fx-background-image: url('"+cardPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;");
        });
        btnCard.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            RotateTransition rotateBackTransition=new RotateTransition(Duration.seconds(0.1));
            rotateBackTransition.setToAngle(0);
            rotateBackTransition.setNode(btnCard);
            rotateBackTransition.play();
            btnCard.setStyle("-fx-background-image: url('"+cardPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        deckLabel=new Label();
        deckLabel.setPrefSize(18,18);
        deckLabel.setLayoutX(18);
        deckLabel.setLayoutY(18);
        deckLabel.setAlignment(Pos.CENTER);
        Font deckFont=Font.loadFont(MainApplication.fontPath,14);
        deckLabel.setFont(deckFont);
        deckLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
        deckPane.getChildren().addAll(btnCard,deckLabel);
        //初始牌库
        if (character==1)
        {
            for (int i=0;i<5;i++)
            {
                deck.addCard(Integer.parseInt(AccountDao.getCardID2(1)));
            }
            for (int i=0;i<5;i++)
            {
                deck.addCard(Integer.parseInt(AccountDao.getCardID2(8)));
            }
        }
        deckLabel.setText(String.valueOf(deck.cardNumber));
        deck.setVisible(false);
        TranslateTransition deckTransition=new TranslateTransition(Duration.seconds(0.2),deck);
        deckTransition.setFromY(100);
        deckTransition.setToY(0);
        btnCard.setOnAction(event -> {
            if (settingCover.isVisible())
            {
                settingCover.setVisible(false);
            }
            blackPane.setVisible(true);
            returnTransition.setToX(140);
            returnTransition.play();
            deckTransition.play();
            deck.setVisible(true);
            deck.setLayoutY(100);
        });

        //地图按钮
        Button btnMap=new Button();
        btnMap.setPrefSize(36,36);
        btnMap.setTooltip(new Tooltip("地图"));
        String mapPath=GameScene.class.getResource("image/game_pics/map.png").toExternalForm();
        btnMap.setStyle("-fx-background-image: url('"+mapPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        btnMap.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            RotateTransition rotateTransition=new RotateTransition(Duration.seconds(0.1));
            rotateTransition.setNode(btnMap);
            rotateTransition.setToAngle(30);
            rotateTransition.play();
            btnMap.setStyle("-fx-background-image: url('"+mapPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent;");
        });
        btnMap.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            RotateTransition rotateBackTransition=new RotateTransition(Duration.seconds(0.1));
            rotateBackTransition.setToAngle(0);
            rotateBackTransition.setNode(btnMap);
            rotateBackTransition.play();
            btnMap.setStyle("-fx-background-image: url('"+mapPath+"');-fx-background-size: 36px 36px;-fx-background-color: transparent");
        });
        topPane4.getChildren().addAll(btnMap,deckPane,btnSetting);
        AnchorPane topPane=new AnchorPane(topPane2,topPane4);
        topPane.setPrefSize(1000,40);
        topPane.setStyle("-fx-effect: dropshadow(gaussian,black,20,0,0,0)");

        //遗物栏

        HBox remainsPane2=new HBox();
        HBox remainsPane3=new HBox();
        remainsPane2.setPrefSize(1000,40);
        remainsPane2.setLayoutY(0);
        remainsPane2.setSpacing(5);
        remainsPane3.setPrefSize(1000,40);
        remainsPane3.setLayoutY(40);
        remainsPane3.setSpacing(5);
        RemainsLabel[] remainsList=new RemainsLabel[25];
        RemainsLabel[] remainsList2=new RemainsLabel[25];
        for (int i=0;i<25;i++)
        {
            remainsList[i]=new RemainsLabel();
            remainsList2[i]=new RemainsLabel();
            remainsPane2.getChildren().add(remainsList[i]);
            remainsPane3.getChildren().add(remainsList2[i]);

        }
        AnchorPane remainsPane=new AnchorPane(remainsPane2,remainsPane3);
        remainsPane.setPrefSize(1000,80);
        remainsPane.setLayoutY(40);

        //交互

        //返回按钮
        btnReturn.setPrefSize(160,50);
        btnReturn.setLayoutX(-160);
        btnReturn.setLayoutY(450);
        Font menuFont=Font.loadFont(MainApplication.fontPath,18);
        btnReturn.setFont(menuFont);
        String imagePath=GameScene.class.getResource("image/menu_pics/cancelButton.png").toExternalForm();
        btnReturn.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        btnReturn.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            String imagePathX=MenuScene.class.getResource("image/menu_pics/cancelButtonX.png").toExternalForm();
            btnReturn.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePathX+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        });
        btnReturn.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnReturn.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        });
        btnReturn.setOnAction(event -> {
            returnTransition.setToX(0);
            returnTransition.play();
            blackPane.setVisible(false);
            if (settingCover.isVisible())
            {
                settingCover.setVisible(false);
            }
            if (deck.isVisible())
            {
                deck.setVisible(false);
            }
            if (Battle.deck1!=null)
            {
                if (Battle.deck1.isVisible())
                {
                    Battle.deck1.setVisible(false);
                }
            }
            if (Battle.deck2!=null)
            {
                if (Battle.deck2.isVisible())
                {
                    Battle.deck2.setVisible(false);
                }
            }
            if (Battle.battlePane!=null)
            {
                if (Battle.blackPane.isVisible())
                {
                    Battle.blackPane.setVisible(false);
                }
            }
        });
        //继续按钮
        btnProceed.setPrefSize(150,80);
        btnProceed.setLayoutX(1000);
        btnProceed.setLayoutY(400);
        btnProceed.setFont(menuFont);
        String imagePath2=GameScene.class.getResource("image/game_pics/proceedButton.png").toExternalForm();
        btnProceed.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath2+"');-fx-background-size: 150px 80px;-fx-text-fill: rgb(239,200,81)");
        btnProceed.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            String imagePath2X=MenuScene.class.getResource("image/game_pics/proceedButtonX.png").toExternalForm();
            btnProceed.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath2X+"');-fx-background-size: 150px 80px;-fx-text-fill: rgb(239,200,81)");
        });
        btnProceed.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnProceed.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath2+"');-fx-background-size: 150px 80px;-fx-text-fill: rgb(239,200,81)");
        });
        btnProceed.setOnAction(event -> {
            proceedTransition.setToX(0);
            proceedTransition.play();
            blackPane.setVisible(false);
            if (Reward.rewardPane!=null)
            {
                if (Reward.rewardPane.isVisible())
                {
                    TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),Reward.rewardPane);
                    translateTransition.setFromY(0);
                    translateTransition.setToY(-600);
                    translateTransition.statusProperty().addListener((observableValue, status, t1) ->
                    {
                        if (t1== Animation.Status.STOPPED)
                        {
                            Reward.rewardPane.setVisible(false);
                        }
                    });
                    translateTransition.play();
                }
            }
            if (Sale.salePane!=null)
            {
                if (Sale.salePane.isVisible())
                {
                    TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),Sale.salePane);
                    translateTransition.setFromY(0);
                    translateTransition.setToY(-600);
                    translateTransition.statusProperty().addListener((observableValue, status, t1) ->
                    {
                        if (t1== Animation.Status.STOPPED)
                        {
                            Sale.salePane.setVisible(false);
                        }
                    });
                    translateTransition.play();
                }
            }
            if (Rest.restPane!=null)
            {
                if (Rest.restPane.isVisible())
                {
                    FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(1),Rest.restPane);
                    fadeTransition1.setFromValue(1);
                    fadeTransition1.setToValue(0);
                    fadeTransition1.play();
                    fadeTransition1.statusProperty().addListener((observableValue, status, t1) ->
                    {
                        if (t1== Animation.Status.STOPPED)
                        {
                            Rest.restPane.setVisible(false);
                        }
                    });
                    fadeTransition1.play();
                }
            }
            if (Event.eventPane!=null)
            {
                TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),Event.eventPane);
                translateTransition.setFromY(0);
                translateTransition.setToY(-600);
                translateTransition.statusProperty().addListener((observableValue, status, t1) ->
                {
                    if (t1== Animation.Status.STOPPED)
                    {
                        Event.eventPane.setVisible(false);
                    }
                });
                translateTransition.play();
            }
            if (btPane.isVisible())
            {
                btPane.getChildren().clear();
                btPane.setVisible(false);
            }
            if (useBlackPane.isVisible())
            {
                useBlackPane.setVisible(false);
            }
        });

        usePane=new AnchorPane();
        usePane.setPrefSize(1000,600);
        usePane.getChildren().addAll(map,useBlackPane);
        btPane=new AnchorPane();
        btPane.setPrefSize(1000,600);
        btPane.setVisible(false);
        mainPane.getChildren().addAll(usePane,btPane,blackPane,topPane,remainsPane,btnProceed,deck,settingCover,btnReturn);
    }
    static void setMoney(int newMoney)
    {
        moneyLabel.setText(String.valueOf(newMoney));
        money=newMoney;
        Shake.shake(moneyLabel);
    }
}
