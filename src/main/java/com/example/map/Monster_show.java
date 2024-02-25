package com.example.map;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Monster_show extends AnchorPane{
    public Label enemy1_block;
    public Label enemy1_character;
    static public ProgressBar enemy1_Bar = new ProgressBar();
    static public Label enemy1_blood_value;
    static public ImageView enemy1_attackIntention_imageView = new ImageView();
    int type;

    static int attackIntention=0;
    private Label intentionImageLabel;
    public HBox intentionPane;
    Monster_show(int type,int movement){

        this.type=type;
        attackIntention=movement;
        setCharacter(type);
    }

    void setCharacter(int id){

        ////////////////////////////////////////////
        //////////////////////////////////////////////////////
        //意图布局
        intentionPane=new HBox();
        intentionPane.setPrefSize(100,50);
        intentionPane.setLayoutX(30);
        Timeline timeline=new Timeline(
                new KeyFrame(Duration.ZERO,actionEvent->{
                    TranslateTransition down=new TranslateTransition(Duration.seconds(1),intentionPane);
                    down.setFromY(0);
                    down.setToY(20);
                    down.play();
                }),
                new KeyFrame(Duration.seconds(1),actionEvent->{
                    TranslateTransition up=new TranslateTransition(Duration.seconds(1),intentionPane);
                    up.setFromY(20);
                    up.setToY(0);
                    up.play();
                }),
                new KeyFrame(Duration.seconds(2),actionEvent->{

                })
        );
        timeline.setCycleCount(999);
        timeline.play();


//        enemy1_attackIntention.setGraphic(enemy1_attackIntention_imageView);
        //////////////////////////////////////////////////////

//        enemy1_attackIntention.setStyle("-fx-text-fill: red");
        enemy1_character = new Label();
        Image enemy1_image = new Image(getClass().getResource(Monster.GetImages(id,1)).toExternalForm(), 150, 150, false, false);
        ImageView enemy1_imageView = new ImageView(enemy1_image);
        enemy1_character.setGraphic(enemy1_imageView);
        Timeline timeline1=new Timeline(
                new KeyFrame(Duration.ZERO,actionEvent->{
                    TranslateTransition up=new TranslateTransition(Duration.seconds(1.5),enemy1_character);
                    up.setFromY(0);
                    up.setToY(5);
                    up.play();
                }),
                new KeyFrame(Duration.seconds(1.5),actionEvent->{
                    TranslateTransition down=new TranslateTransition(Duration.seconds(1.5),enemy1_character);
                    down.setFromY(5);
                    down.setToY(0);
                    down.play();
                }),
                new KeyFrame(Duration.seconds(3),actionEvent->{

                })
        );
        timeline1.setCycleCount(999);
        timeline1.play();


        HBox enemy1_num_box = new HBox();
        enemy1_num_box.setAlignment(Pos.CENTER_RIGHT);
        HBox enemy1_blood_bar = new HBox();
        enemy1_Bar.setProgress(1);
        enemy1_Bar.setStyle("-fx-padding: 0.2");
        enemy1_Bar.setOpacity(0.65);
        enemy1_Bar.setPrefSize(120,15);

        BorderPane enemy1_borderPane = new BorderPane();
        enemy1_borderPane.setCenter(enemy1_Bar);
        enemy1_borderPane.setPrefHeight(5);
        enemy1_Bar.setStyle("-fx-accent:rgb(250,128,114)");
        enemy1_blood_bar.getChildren().addAll(enemy1_borderPane);
        enemy1_block = new Label();
        enemy1_block.setPrefSize(16,16);
        enemy1_block.setAlignment(Pos.CENTER);

        enemy1_block.setText("0");
        enemy1_block.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226)");
        enemy1_block.setVisible(false);
        enemy1_num_box.getChildren().addAll(enemy1_block, enemy1_blood_bar);
        enemy1_blood_value = new Label();
       // enemy1_blood_value.setText("9/10");
        enemy1_blood_value.setStyle("-fx-alignment: center; -fx-text-fill: rgb(255,246,226)");
        enemy1_blood_value.setPrefHeight(10);
        enemy1_blood_value.setPrefWidth(130);
//        HBox enemy1_buff_box = new HBox(2);
//        enemy1_buff_box.setPrefWidth(130);
//        enemy1_buff_box.setPrefHeight(16);
//        Label[] enemy1_buff = new Label[10];
//        for (int i = 0; i < 10; i++) {
//            if (i < 4) {
//                enemy1_buff[i] = new Label();
//                String enemy1_buff_path = "image/picture/buff/" + (i + 1) + ".jpg";
//                Image enemy1_buff_image = new Image(getClass().getResource(enemy1_buff_path).toExternalForm(), 17, 17, false, false);
//                enemy1_buff[i].setGraphic(new ImageView(enemy1_buff_image));
//                enemy1_buff_box.getChildren().add(enemy1_buff[i]);
//            }
//        }
        this.setLayoutX(750);
        this.setLayoutY(90);
        enemy1_num_box.setLayoutY(210);
        enemy1_character.setLayoutY(62);
        enemy1_blood_value.setLayoutY(208);
        enemy1_blood_value.setLayoutX(-3);
        System.out.println(enemy1_blood_value.getLayoutX());
        //enemy1_character.setLayoutX(500);
        this.getChildren().addAll(intentionPane, enemy1_character, enemy1_num_box, enemy1_blood_value);
    }
//    public static void setImage(ImageView enemy1_attackIntention_imageView){
//        switch (Monster.movement){
//            case 0:{
//            if(Monster.attack>0&&Monster.attack<5){
//               Image image=new Image("image/tip/attack1.png",20,20,false,false);
////                enemy1_attackIntention_imageView.setImage(image);
////
////            }
////            else if(Monster.attack>=5&&Monster.attack<10){
////                Image image=new Image("image/tip/attack2.png",20,20,false,false);
////                enemy1_attackIntention_imageView.setImage(image);
////
////            }
////            else if(Monster.attack>=10&&Monster.attack<15){
////                Image image=new Image("image/tip/attack3.png",20,20,false,false);
////                enemy1_attackIntention_imageView.setImage(image);
////
////            }
////            else {
////                Image image=new Image("image/tip/attack4.png",20,20,false,false);
////                enemy1_attackIntention_imageView.setImage(image);
////
////            }
////
////
////            }
////            case 1:{
////
////
////
////            }
//
//
//        }
public void resetImage()
{
    FadeTransition fadeIn=new FadeTransition(Duration.seconds(0.5),intentionPane);
    fadeIn.setFromValue(0);
    fadeIn.setToValue(1);
    fadeIn.play();
    intentionPane.getChildren().clear();
    intentionImageLabel=new Label();
    intentionImageLabel.setPrefSize(40,40);
    intentionPane.getChildren().add(intentionImageLabel);
    String imagePath;
    switch (Monster.movement)
    {
        case 0:
        {
            //如果是攻击，加入数值
            Label numberLabel=new Label();
            numberLabel.setPrefSize(50,50);
            numberLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
            numberLabel.setText(String.valueOf(Monster.nextAttack));
            Font font=new Font(30);
            numberLabel.setFont(font);
            intentionPane.getChildren().add(numberLabel);
            if (Monster.nextAttack >= 0 && Monster.nextAttack < 5)
            {
                imagePath = Monster_show.class.getResource("image/tip/attack1.png").toExternalForm();
                intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

            }
            else if (Monster.nextAttack >= 5 && Monster.nextAttack < 10)
            {
                imagePath = Monster_show.class.getResource("image/tip/attack2.png").toExternalForm();
                intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

            }
            else if (Monster.nextAttack >= 10 && Monster.nextAttack < 15)
            {
                imagePath = Monster_show.class.getResource("image/tip/attack3.png").toExternalForm();
                intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

            }
            else
            {
                imagePath = Monster_show.class.getResource("image/tip/attack4.png").toExternalForm();
                intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

            }
            break;
        }
        default:
        {
            if (Monster.nextAttack!=0)
            {
                Label numberLabel=new Label();
                numberLabel.setPrefSize(50,50);
                numberLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
                numberLabel.setText(String.valueOf(Monster.nextAttack));
                Font font=new Font(30);
                numberLabel.setFont(font);
                intentionPane.getChildren().add(numberLabel);
                if(Monster.type.equals("daechong")){
                    imagePath = Monster_show.class.getResource("image/tip/attackDefend.png").toExternalForm();
                    intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

                }
                else if(Monster.type.equals("looter")){
                    imagePath = Monster_show.class.getResource("image/tip/buff.png").toExternalForm();
                    intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

                }
                else if(Monster.type.equals("mashroom")){
                    imagePath = Monster_show.class.getResource("image/tip/buff.png").toExternalForm();
                    intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

                }
                else if(Monster.type.equals("Gremlin_Nob")){
                    imagePath = Monster_show.class.getResource("image/tip/buff.png").toExternalForm();
                    intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

                }







            }
            else {
                if(Monster.type.equals("Cultist"))
            {
                imagePath = Monster_show.class.getResource("image/tip/buff.png").toExternalForm();
                intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");
            }

            else if (Monster.type.equals("spikeslime")){
                imagePath = Monster_show.class.getResource("image/tip/debuff1.png").toExternalForm();
                intentionImageLabel.setStyle("-fx-background-image: url('"+imagePath+"');-fx-background-size: 40px 40px");

            }



            }


        }
    }
}

}
