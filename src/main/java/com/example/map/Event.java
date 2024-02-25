package com.example.map;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

class Event extends AnchorPane {
     public static AnchorPane eventPane=null;
     private Button up;
     private Button down;
     private Button leave;



     public Event() {

         eventPane=this;

         String image_liarsGame=getClass().getResource("image/event/liarsGame.jpg").toExternalForm();
         String liarsGame = new String("你走进一间房间，看见地上有一个大洞。\n当你靠近洞时，一条巨大的蛇形生物从里面钻了出来。\n" +
                 "“嚯嚯嚯！你好，你好啊！这是谁呀？哎呀呀，你好冒险者，我就问一个简单的问题。\n" +
                 "最幸福的人生当然就是什么东西都能买得起的土豪生活了！　\n" +
                 "你同意吗？”");
         String liarsGame_agree = new String("同意。获得175金币。添加一张随机牌");
         String liarsGame_disagree = new String("反对。");

         String image_fishing=getClass().getResource("image/event/fishing.jpg").toExternalForm();
         String fishing = new String("当你走过一条长廊时，你看见空中漂浮着一根香蕉，一个甜甜圈，和一个盒子。\n" +
                 " 不……仔细一看，它们都是被用绳子系着，从天花板上的几个洞里悬挂下来的。\n" +
                 "你在接近这几样东西时，上方似乎传来一阵咯咯的笑声。\n" +
                 "你会怎么做？");
         String fishing_agree = new String("香蕉  回复最大生命值的1/3。");
         String fishing_disagree = new String("甜甜圈  最大生命值 +5。");

         String image_goop=getClass().getResource("image/event/goopPuddle.jpg").toExternalForm();
         String goop = new String("你掉进了一个水坑里。\n" +
                 " 可是坑里全是史莱姆黏液！\n" +
                 "你感觉到这黏液似乎会灼伤你，便拼命想要从坑中脱身。\n" +
                 "你的耳朵、鼻子和全身都被黏液给浸透了。\n" +
                 "爬出来后，你发现自己的金币似乎变少了。\n你回头一看，发现水坑里不但有你掉落的钱，还有不少其他不幸的冒险者们落下的金币。\n");
         String goop_agree = new String("收集金币  获得 75 金币。失去 11 生命。");
         String goop_disagree = new String("放手吧  失去 20 金币。");

         String image_goldenWing=getClass().getResource("image/event/goldenWing.jpg").toExternalForm();
         String goldenWing = new String("你掉进了一个水坑里。\n" +
                 " 在形状不同的巨石之间，你看见一尊做工精细的翅膀形状的蓝色雕像。\n" +
                 "你可以看见雕像的裂缝中有金币掉出来。\n   或许里面还有更多……");
         String goldenWing_agree = new String("祈祷  获得一张随机牌。失去 7 生命。");
         String goldenWing_disagree = new String("摧毁  获得 80 金币。失去25生命");

         String image_mushroom=getClass().getResource("image/event/bgShrooms.png").toExternalForm();
         String mushroom = new String("你走进一条遍地是五彩斑斓蘑菇的走廊，\n" +
                 "由于你对真菌学毫无研究，你无法辨识它们的种类。\n" +
                 "你想要离开这里，但却有一种奇怪的冲动想要去吃一个蘑菇……");
         String mushroom_agree = new String("踩扁  激怒蘑菇们。");
         String mushroom_disagree = new String("吃下  回复 25% 生命。");


         Image image_button = new Image(getClass().getResource("image/event/enabledButton.png").toExternalForm());







         setPrefSize(900,500);
         setLayoutX(50);
         setLayoutY(50);
         String imagePath=Event.class.getResource("image/event/panel.png").toExternalForm();
         setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 900px 500px");

         Label imageLabel=new Label();
         imageLabel.setPrefSize(300,300);
         imageLabel.setLayoutX(60);
         imageLabel.setLayoutY(110);

         Font font=Font.font(17);

         Label eventNameLabel=new Label();
         eventNameLabel.setPrefSize(500,50);
         eventNameLabel.setLayoutY(12);
         eventNameLabel.setAlignment(Pos.CENTER);
         eventNameLabel.setFont(font);

         eventNameLabel.setStyle("-fx-text-fill: yellow");

         Label textLabel=new Label();
         textLabel.setPrefSize(460,230);
         textLabel.setLayoutX(390);
         textLabel.setLayoutY(110);
         textLabel.setStyle("-fx-text-fill: white");
         textLabel.setFont(font);
         textLabel.setAlignment(Pos.TOP_LEFT);
         textLabel.setWrapText(true);

         textLabel.setStyle("-fx-text-fill: white");

         String buttonImage=Event.class.getResource("image/event/enabledButton.png").toExternalForm();
         String buttonImageX=Event.class.getResource("image/event/enabledButtonX.png").toExternalForm();
         up=new Button();
         down=new Button();
         leave=new Button();
         up.setPrefSize(460,42);
         up.setLayoutX(390);
         up.setLayoutY(355);
         up.setFont(font);
         up.setAlignment(Pos.CENTER_LEFT);

         up.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImage+"');-fx-background-size: 460px 42px");
         up.setOnMouseEntered(event -> {
             up.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImageX+"');-fx-background-size: 460px 42px");
         });
         up.setOnMouseExited(event -> {
             up.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImage+"');-fx-background-size: 460px 42px");
         });


         down.setPrefSize(460,42);
         down.setLayoutX(390);
         down.setLayoutY(400);
         down.setFont(font);
         down.setAlignment(Pos.CENTER_LEFT);

         down.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImage+"');-fx-background-size: 460px 42px");
         down.setOnMouseEntered(event -> {
             down.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImageX+"');-fx-background-size: 460px 42px");
         });
         down.setOnMouseExited(event -> {
             down.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImage+"');-fx-background-size: 460px 42px");
         });


         leave.setPrefSize(460,42);
         leave.setLayoutX(390);
         leave.setLayoutY(400);
         leave.setVisible(false);
         leave.setFont(font);
         leave.setAlignment(Pos.CENTER_LEFT);
         leave.setText("  [离开]");
         leave.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImage+"');-fx-background-size: 460px 42px");
         leave.setOnMouseEntered(event -> {
             leave.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImageX+"');-fx-background-size: 460px 42px");
         });
         leave.setOnMouseExited(event -> {
             leave.setStyle("-fx-background-color: transparent;-fx-text-fill: white;-fx-background-image: url('"+buttonImage+"');-fx-background-size: 460px 42px");
         });
         leave.setOnAction(event -> {
             setVisible(false);
             TranslateTransition translateTransition=new TranslateTransition(Duration.seconds(0.5),this);
             translateTransition.setFromY(0);
             translateTransition.setToY(-600);
             translateTransition.statusProperty().addListener((observableValue, status, t1) -> {
                 if (t1== Animation.Status.STOPPED)
                 {
                     GameScene.useBlackPane.setVisible(false);
                 }
             });
             translateTransition.play();
         });

         getChildren().addAll(eventNameLabel,imageLabel,textLabel,up,down,leave);




         int radom = (int) (Math.random() * 10);
         if (radom >= 0 && radom < 2) {
             eventNameLabel.setText("蛇的游戏");
             textLabel.setText(liarsGame);
             imageLabel.setStyle("-fx-background-size: 300px 300px;-fx-background-image: url('"+image_liarsGame+"')");



             up.setText("  ["+liarsGame_agree+"]");
             down.setText("  ["+liarsGame_disagree+"]");

             up.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     GameScene.money+=175;
                     GameScene.setMoney(GameScene.money);
                     int random=(int)(Math.random()*10+1);
                     CardPane card=new CardPane(Integer.parseInt(AccountDao.getCardID2(random)));
                     card.setLayoutX(390);
                     card.setLayoutY(150);
                     CardAnimation.cardDrop(card);
                     GameScene.deckLabel.setText(String.valueOf(GameScene.deck.cardNumber+1));
                     GameScene.deck.addCard(Integer.parseInt(AccountDao.getCardID2(random)));
                     getChildren().add(card);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });
                down.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        textLabel.setText("蛇很失望地看着你。");
                        up.setVisible(false);
                        down.setVisible(false);
                        leave.setVisible(true);
                    }
                });


         } else if (radom >= 2 && radom < 4) {
             eventNameLabel.setText("丰收");
             textLabel.setText(fishing);
             imageLabel.setStyle("-fx-background-size: 300px 300px;-fx-background-image: url('"+image_fishing+"')");
             up.setText("  ["+fishing_agree+"]");
             down.setText("  ["+fishing_disagree+"]");

             up.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                     int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                     if(now_blood+(int)(all_blood/3)>all_blood){

                         String s1=String.valueOf(all_blood);
                         String s2=String.valueOf(all_blood);
                         GameScene.hp=s1+"/"+s2;
                         GameScene.hpLabel.setText(GameScene.hp);
                     }
                     else {
                         now_blood+=(int)(all_blood/3);
                         String s1=String.valueOf(now_blood);
                         String s2=String.valueOf(all_blood);
                         GameScene.hp=s1+"/"+s2;
                         GameScene.hpLabel.setText(GameScene.hp);
                     }
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });
             down.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                     int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                     all_blood+=5;
                     now_blood+=5;
                     String s1=String.valueOf(now_blood);
                     String s2=String.valueOf(all_blood);
                     GameScene.hp=s1+"/"+s2;
                     GameScene.hpLabel.setText(GameScene.hp);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });

         } else if (radom >= 4 && radom < 6) {
             eventNameLabel.setText("史莱姆沼泽");
             textLabel.setText(goop);
             imageLabel.setStyle("-fx-background-size: 300px 300px;-fx-background-image: url('"+image_goop+"')");
             up.setText("  ["+goop_agree+"]");
             down.setText("  ["+goop_disagree+"]");

             up.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     GameScene.money+=75;
                     GameScene.setMoney(GameScene.money);
                     int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                     int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                     now_blood-=15;
                     String s1=String.valueOf(now_blood);
                     String s2=String.valueOf(all_blood);
                     GameScene.hp=s1+"/"+s2;
                     GameScene.hpLabel.setText(GameScene.hp);
                     Shake.shake(GameScene.hpLabel);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });

             down.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     GameScene.money-=20;
                     GameScene.setMoney(GameScene.money);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });



         } else if (radom >= 6 && radom < 8) {
             eventNameLabel.setText("黄金之翼");
             textLabel.setText(goldenWing);
             imageLabel.setStyle("-fx-background-size: 300px 300px;-fx-background-image: url('"+image_goldenWing+"')");
             up.setText("  ["+goldenWing_agree+"]");
             down.setText("  ["+goldenWing_disagree+"]");

             up.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     int random=(int)(Math.random()*11);
                     CardPane card=new CardPane(Integer.parseInt(AccountDao.getCardID2(random)));
                     card.setLayoutX(390);
                     card.setLayoutY(150);
                     CardAnimation.cardDrop(card);
                     GameScene.deckLabel.setText(String.valueOf(GameScene.deck.cardNumber+1));
                     GameScene.deck.addCard(Integer.parseInt(AccountDao.getCardID2(random)));
                     getChildren().add(card);
                     int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                     int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                     now_blood-=7;
                     String s1=String.valueOf(now_blood);
                     String s2=String.valueOf(all_blood);
                     GameScene.hp=s1+"/"+s2;
                     GameScene.hpLabel.setText(GameScene.hp);
                     Shake.shake(GameScene.hpLabel);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });
             down.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     GameScene.money+=80;
                     GameScene.setMoney(GameScene.money);
                     int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                     int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                     now_blood-=25;
                     String s1=String.valueOf(now_blood);
                     String s2=String.valueOf(all_blood);
                     GameScene.hp=s1+"/"+s2;
                     GameScene.hpLabel.setText(GameScene.hp);
                     Shake.shake(GameScene.hpLabel);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });








         } else if (radom >= 8 && radom <= 10) {
             eventNameLabel.setText("蘑菇");
             textLabel.setText(mushroom);
             imageLabel.setStyle("-fx-background-size: 300px 300px;-fx-background-image: url('"+image_mushroom+"')");
             up.setText("  ["+mushroom_agree+"]");
             down.setText("  ["+mushroom_disagree+"]");



             up.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {

                     Battle battle=new Battle("mashroom");
                     SceneChange.blackTo1To0(GameScene.usePane,battle,GameScene.btPane);
                     GameScene.btPane.setVisible(true);
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });
             down.setOnMouseClicked(new EventHandler<MouseEvent>() {
                 @Override
                 public void handle(MouseEvent mouseEvent) {
                     int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                     int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                     if(now_blood+25>all_blood){
                         String s1=String.valueOf(all_blood);
                         String s2=String.valueOf(all_blood);
                         GameScene.hp=s1+"/"+s2;
                         GameScene.hpLabel.setText(GameScene.hp);
                     }
                     else {
                         now_blood+=25;
                         String s1=String.valueOf(now_blood);
                         String s2=String.valueOf(all_blood);
                         GameScene.hp=s1+"/"+s2;
                         GameScene.hpLabel.setText(GameScene.hp);

                     }
                     up.setVisible(false);
                     down.setVisible(false);
                     leave.setVisible(true);
                 }
             });


         }




     }

 }








