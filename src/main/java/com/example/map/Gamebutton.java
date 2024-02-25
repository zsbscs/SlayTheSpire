package com.example.map;

import  java.util.Vector;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Gamebutton extends AnchorPane {
        private static String Button_nmonster = Gamebutton.class.getResource("image/map/monster.png").toExternalForm();
        private static String Button_shop = Gamebutton.class.getResource("image/map/shop.png").toExternalForm();
        private static String Button_elite = Gamebutton.class.getResource("image/map/elite.png").toExternalForm();
        private static String Button_rest= Gamebutton.class.getResource("image/map/rest.png").toExternalForm();
        private static String Button_event = Gamebutton.class.getResource("image/map/event.png").toExternalForm();
        private static String Button_chest = Gamebutton.class.getResource("image/map/chest.png").toExternalForm();
        private static String Button_nmonsterX = Gamebutton.class.getResource("image/map/monsterX.png").toExternalForm();
        private static String Button_shopX = Gamebutton.class.getResource("image/map/shopX.png").toExternalForm();
        private static String Button_eliteX = Gamebutton.class.getResource("image/map/eliteX.png").toExternalForm();
        private static String Button_restX= Gamebutton.class.getResource("image/map/restX.png").toExternalForm();
        private static String Button_eventX = Gamebutton.class.getResource("image/map/eventX.png").toExternalForm();
        private static String Button_chestX = Gamebutton.class.getResource("image/map/chestX.png").toExternalForm();
        private static String Button_boss_guardian = Gamebutton.class.getResource("image/boss_outline/guardian.png").toExternalForm();
        private static String Button_boss_hexaghost = Gamebutton.class.getResource("image/boss_outline/hexaghost.png").toExternalForm();
        private static String Button_boss_slime = Gamebutton.class.getResource("image/boss_outline/slime.png").toExternalForm();
        private static String circle=Gamebutton.class.getResource("image/map/circle.png").toExternalForm();
        private static String Button_nmonsterStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_nmonster+"');-fx-background-size: 40px 40px";
        private static String Button_shopStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_shop+"');-fx-background-size: 40px 40px";
        private static String Button_eliteStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_elite+"');-fx-background-size: 40px 40px";
        private static String Button_restStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_rest+"');-fx-background-size: 40px 40px";
        private static String Button_eventStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_event+"');-fx-background-size: 40px 40px";
        private static String Button_chestStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_chest+"');-fx-background-size: 40px 40px";
        private static String Button_nmonsterStyleX = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_nmonsterX+"');-fx-background-size: 40px 40px;-fx-scale-x: 1.5;-fx-scale-y: 1.5";
        private static String Button_shopStyleX = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_shopX+"');-fx-background-size: 40px 40px;-fx-scale-x: 1.5;-fx-scale-y: 1.5";
        private static String Button_eliteStyleX = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_eliteX+"');-fx-background-size: 40px 40px;-fx-scale-x: 1.5;-fx-scale-y: 1.5";
        private static String Button_restStyleX = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_restX+"');-fx-background-size: 40px 40px;-fx-scale-x: 1.5;-fx-scale-y: 1.5";
        private static String Button_eventStyleX = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_eventX+"');-fx-background-size: 40px 40px;-fx-scale-x: 1.5;-fx-scale-y: 1.5";
        private static String Button_chestStyleX = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_chestX+"');-fx-background-size: 40px 40px;-fx-scale-x: 1.5;-fx-scale-y: 1.5";
        private static String Button_boss_guardianStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_boss_guardian+"')";
        private static String Button_boss_hexaghostStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_boss_hexaghost+"')";
        private static String Button_boss_slimeStyle = "-fx-background-color:transparent;" +
                "-fx-background-image:url('"+Button_boss_slime+"')";

        private double x;
        private double y;

        private String type;

        public int connect_child=0;
        public int connect_parent=0;
        private Vector<Gamebutton>parent=new Vector<Gamebutton>();

        private boolean pass;
        private Button button;
        private AnchorPane circlePane;
        private FadeTransition fadeTransition;


        Gamebutton(String type) {
                super();

                setPrefHeight(70);
                setPrefWidth(70);
                setDisable(true);
                circlePane=new AnchorPane();
                circlePane.setPrefSize(90,90);
                circlePane.setLayoutX(-10);
                circlePane.setLayoutY(-10);
                circlePane.setStyle("-fx-background-image: url('"+circle+"');-fx-background-size: 90px 90px");
                circlePane.setVisible(false);
                fadeTransition=new FadeTransition(Duration.seconds(0.5),circlePane);
                fadeTransition.setFromValue(0);
                fadeTransition.setToValue(1);

                button=new Button();
                button.setPrefSize(40,40);
                button.setLayoutX(15);
                button.setLayoutY(15);

                this.type=type;
                if (type.equals("monster")) {
                        button.setStyle(Button_nmonsterStyle);
                        setOnMouseEntered(event -> {
                                button.setStyle(Button_nmonsterStyleX);
                        });
                        setOnMouseExited(event -> {
                                button.setStyle(Button_nmonsterStyle);
                        });

                } else if (type.equals("shop")) {
                        button.setStyle(Button_shopStyle);
                        setOnMouseEntered(event -> {
                                button.setStyle(Button_shopStyleX);
                        });
                        setOnMouseExited(event -> {
                                button.setStyle(Button_shopStyle);
                        });

                } else if (type.equals("rest")){

                        button.setStyle(Button_restStyle);
                        setOnMouseEntered(event -> {
                                button.setStyle(Button_restStyleX);
                        });
                        setOnMouseExited(event -> {
                                button.setStyle(Button_restStyle);
                        });

                } else if (type.equals("elite")) {
                        button.setStyle(Button_eliteStyle);
                        setOnMouseEntered(event -> {
                                button.setStyle(Button_eliteStyleX);
                        });
                        setOnMouseExited(event -> {
                                button.setStyle(Button_eliteStyle);
                        });
                }
                else  if (type.equals("event")){
                        button.setStyle(Button_eventStyle);
                        setOnMouseEntered(event -> {
                                button.setStyle(Button_eventStyleX);
                        });
                        setOnMouseExited(event -> {
                                button.setStyle(Button_eventStyle);
                        });
                }
                else if (type.equals("chest")){
                        button.setStyle(Button_chestStyle);
                        setOnMouseEntered(event -> {
                                button.setStyle(Button_chestStyleX);
                        });
                        setOnMouseExited(event -> {
                                button.setStyle(Button_chestStyle);
                        });
                }
                else if(type.equals("boss")){
                        int boss=(int)(Math.random()*12);
                        button.setPrefWidth(250);
                        button.setPrefHeight(250);

                        if(boss>=0&&boss<=3){
                                button.setStyle(Button_boss_guardianStyle);
                        }
                        else if (boss>=4&&boss<=7) {
                                button.setStyle(Button_boss_hexaghostStyle);
                        }
                        else{button.setStyle(Button_boss_slimeStyle);}
                }
                getChildren().addAll(circlePane,button);


                //随机事件
                if (type.equals("event"))
                {
                        int random=(int)(Math.random()*15);
                        if(random>=0&&random<4) {
                                button.setOnAction(event -> {
                                        circlePane.setVisible(true);
                                        fadeTransition.play();
                                        if (!GameScene.useBlackPane.isVisible())
                                        {
                                                GameScene.useBlackPane.setVisible(true);
                                        }
                                        Event event_btn = new Event();
                                        TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.2),event_btn);
                                        translateTransition.setFromY(100);
                                        translateTransition.setToY(0);
                                        translateTransition.play();
                                        GameScene.usePane.getChildren().add(event_btn);
                                        for(int i=0;i<this.parent.size();i++){
                                                parent.get(i).setDisable(false);
                                        }
                                });

                        }
                        else if(random>=4&&random<6){
                                this.type="monster";
                        }
                        else if(random>=6&&random<8){
                                this.type="rest";
                        }
                        else if(random<10){
                                this.type="shop";
                        }
                        else{
                                this.type="chest";
                        }

                }
                thingsCompare();
        }

        public double getX(){
                return this.x;
        }
        public double getY(){
                return this.y;
        }
        public  void setX(double x){
                this.x=x;
        }
        public void setY(double y ){
                this.y=y;
        }
        public static Gamebutton choose(Gamebutton []gamebuttons,Gamebutton aim,int n) {
                double length=1000000;
                int num=0;

                for(int i=0;i<n;i++){
                        if(gamebuttons[i].connect_child<2&&aim.getlength(gamebuttons[i])<length)
                        {
                                length=aim.getlength(gamebuttons[i]);
                                num=i;

                        }

                }
                return gamebuttons[num];

        }
        public double getlength(Gamebutton btn){


                return Math.pow((this.getX()-btn.getX()),2)+
                        Math.pow((this.getY()- btn.getY()),2);
        }
        public void setParent(Gamebutton btn1){
                this.parent.add(btn1);

        }
        public String random_monster(String type){
                if(type.equals("monster")){
                        int random=(int)(Math.random()*5.1+1);
                        switch (random){
                                case 1:{
                                        return "daechong";
                                }
                                case 2:{
                                        return "Cultist";
                                }
                                case 3:{
                                        return "spikeslime";
                                }
                                case 4:{
                                        return "daechong";
                                }
                                case 5:{
                                        return "looter";
                                }
                                case 6:{
                                        return "mashroom";
                                }
                                case 7:{
                                        return "mashroom";
                                }
                                default:return "null";



                        }



                }
                else if(type.equals("elite")){
                        int random=(int)(Math.random()*2.1+8);
                        switch (random){
                                case 8:{return "Gremlin_Nob";}
                                case 9:{return "Lagavulin";}
                                case 10:{return "Sentry";}
                                default:return "null";
                        }

                }
                else return "null";




        }
             public void thingsCompare()
        {
                if (type.equals("monster")||type.equals("elite")||type.equals("boss"))
                {
                        button.setOnAction(event -> {
                                circlePane.setVisible(true);
                                fadeTransition.play();
                                Battle battle=new Battle(random_monster(type));
                                SceneChange.blackTo1To0(GameScene.usePane,battle,GameScene.btPane);
                                GameScene.btPane.setVisible(true);
                                Map.setDisableMap();
                                for(int i=0;i<this.parent.size();i++){
                                        parent.get(i).setDisable(false);

                                }

                                //Reward reward=new Reward();
                                //GameScene.usePane.getChildren().add(reward);
                        });
                }
                else if (type.equals("chest"))
                {
                        button.setOnAction(event -> {
                                circlePane.setVisible(true);
                                fadeTransition.play();
                                if (!GameScene.useBlackPane.isVisible())
                                {
                                        GameScene.useBlackPane.setVisible(true);
                                }
                                Reward reward=new Reward();
                                GameScene.proceedTransition.setToX(-160);
                                GameScene.proceedTransition.play();
                                GameScene.usePane.getChildren().add(reward);
                                Map.setDisableMap();
                                for(int i=0;i<this.parent.size();i++){
                                        parent.get(i).setDisable(false);

                                }
                                if (!Reward.rewardPane.isVisible())
                                {
                                        Reward.rewardPane.setVisible(true);
                                }
                        });
                }
                else if (type.equals("shop"))
                {
                        button.setOnAction(event -> {
                                circlePane.setVisible(true);
                                fadeTransition.play();
                                if (!GameScene.useBlackPane.isVisible())
                                {
                                        GameScene.useBlackPane.setVisible(true);
                                }
                                Sale sale=new Sale();
                                TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),sale);
                                translateTransition.setFromY(-600);
                                translateTransition.setToY(0);
                                translateTransition.play();
                                GameScene.proceedTransition.setToX(-160);
                                GameScene.proceedTransition.play();
                                GameScene.usePane.getChildren().add(sale);
                                Map.setDisableMap();
                                for(int i=0;i<this.parent.size();i++){
                                        parent.get(i).setDisable(false);

                                }
                                if (!Sale.salePane.isVisible())
                                {
                                        Sale.salePane.setVisible(true);
                                }
                        });
                }
                else if (type.equals("rest"))
                {
                        button.setOnAction(event -> {
                                circlePane.setVisible(true);
                                fadeTransition.play();
                                if (!GameScene.useBlackPane.isVisible())
                                {
                                        GameScene.useBlackPane.setVisible(true);
                                }
                                Rest rest=new Rest();
                                FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(1),rest);
                                fadeTransition1.setFromValue(0);
                                fadeTransition1.setToValue(1);
                                fadeTransition1.play();
                                GameScene.proceedTransition.setToX(-160);
                                GameScene.proceedTransition.play();
                                GameScene.usePane.getChildren().add(rest);
                                Map.setDisableMap();
                                for(int i=0;i<this.parent.size();i++){
                                        parent.get(i).setDisable(false);

                                }
                        });
                }
        }

}
