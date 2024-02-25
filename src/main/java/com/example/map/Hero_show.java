package com.example.map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class Hero_show extends AnchorPane {
    int type;
    public static Label blood_value = new Label();
    public static Label parry = new Label();
    public Label character1;

    ProgressBar progressBar;

    public Hero_show(int type) {
        this.type = type;
        setCharacter();
    }

    public void setCharacter()
    {
        Pane character = new Pane();
        character1 = new Label();
        character.getChildren().add(character1);
        String path = "image/picture/hero/" + type + ".png";
        character.setPrefHeight(100);
        character.setPrefWidth(130);
        Image image = new Image(getClass().getResourceAsStream(path), 150, 130, false, false);
        character1.setGraphic(new ImageView(image));
        Timeline timeline1=new Timeline(
                new KeyFrame(Duration.ZERO, actionEvent->{
                    TranslateTransition up=new TranslateTransition(Duration.seconds(1.8),character1);
                    up.setFromY(0);
                    up.setToY(5);
                    up.play();
                }),
                new KeyFrame(Duration.seconds(1.8),actionEvent->{
                    TranslateTransition down=new TranslateTransition(Duration.seconds(1.8),character1);
                    down.setFromY(5);
                    down.setToY(0);
                    down.play();
                }),
                new KeyFrame(Duration.seconds(3.6),actionEvent->{

                })
        );
        timeline1.setCycleCount(999);
        timeline1.play();


        HBox num_box = new HBox();
        num_box.setAlignment(Pos.CENTER_RIGHT);
        HBox blood_bar = new HBox();
        progressBar = new ProgressBar();
        progressBar.setProgress(1);
        progressBar.setStyle("-fx-padding: 0.2");
        progressBar.setOpacity(0.65);
        progressBar.setPrefSize(120,15);
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(progressBar);
        borderPane.setPrefHeight(5);
        blood_bar.getChildren().addAll(borderPane);
        progressBar.setStyle("-fx-accent:rgb(204,12,12)");
        parry.setPrefSize(16,16);
        parry.setAlignment(Pos.CENTER);
        parry.setText("0");
        parry.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226)");
        parry.setVisible(false);
        num_box.getChildren().addAll(parry, blood_bar);
        num_box.setLayoutY(130);
        num_box.setLayoutX(30);

        blood_value.setStyle("-fx-alignment: center; -fx-text-fill: rgb(255,246,226)");
        blood_value.setPrefHeight(10);
        blood_value.setPrefWidth(130);
        blood_value.setLayoutX(40);
        blood_value.setLayoutY(130);
//        HBox buff_box = new HBox(2);
//        buff_box.setPrefWidth(130);
//        buff_box.setPrefHeight(16);
//        buff_box.setLayoutY(200);
//        Label[] buff = new Label[10];
//        for (int i = 0; i < 10; i++) {
//            if (i < 4) {
//                buff[i] = new Label();
//                ///////////////////////////////////////////////////////
//                String buff_path = "image/picture/buff/" + (i + 1) + ".jpg";
//                Image buff_image = new Image(getClass().getResource(buff_path).toExternalForm(), 17, 17, false, false);
//                buff[i].setGraphic(new ImageView(buff_image));
//                buff_box.getChildren().add(buff[i]);
//            }
//        }
        this.setLayoutX(90);
        this.setLayoutY(180);
        this.getChildren().addAll(character, num_box, blood_value);
        //this.getChildren().addAll( num_box, blood_value, buff_box);

    }

}







