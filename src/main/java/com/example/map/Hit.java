package com.example.map;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

//伤害爆炸特效
public class Hit extends Label {
    public Hit(Pane pane, Line line){
        this.setLayoutX(line.getEndX()-90);
        this.setLayoutY(line.getEndY()-90);
        pane.getChildren().addAll(this);
            this.setVisible(true);
            Timeline hit_tl=new Timeline(
                    new KeyFrame(Duration.ZERO,event1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/1.png"),
                                        185,185,true,true)
                        ));
                    }),
                    new KeyFrame(Duration.seconds(0.05),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/2.png"),
                                        190,190,true,true)
                        ));
                    }),
                    new KeyFrame(Duration.seconds(0.1),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/3.png")
                                        ,192,192,true,true)
                        ));
                        this.setOpacity(0.8);
                    }),
                    new KeyFrame(Duration.seconds(0.15),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/4.png"),
                                        194,194,true,true)
                        ));
                    }),
                    new KeyFrame(Duration.seconds(0.2),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/5.png"),
                                        196,196,true,true)
                        ));
                    }),
                    new KeyFrame(Duration.seconds(0.25),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/6.png"),
                                        198,198,true,true)
                        ));
                    }),
                    new KeyFrame(Duration.seconds(0.3),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/7.png"),
                                        200,200,true,true)
                        ));
                        this.setOpacity(0.5);
                    }),
                    new KeyFrame(Duration.seconds(0.35),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/8.png"),
                                        202,202,true,true)
                        ));
                    }),
                    new KeyFrame(Duration.seconds(0.4),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/9.png"),
                                        204,204,true,true)
                        ));
                        this.setOpacity(0.3);
                    }),
                    new KeyFrame(Duration.seconds(0.45),ent1->{
                        this.setGraphic(new ImageView(
                                new Image(getClass().getResourceAsStream("image/picture/hit/10.png"),
                                        206,206,true,true)
                        ));
                        this.setVisible(false);

                    })

            );
            hit_tl.setCycleCount(1);
            hit_tl.play();
    }
}