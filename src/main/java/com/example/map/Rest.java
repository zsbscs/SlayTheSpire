package com.example.map;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Rest extends AnchorPane{
    public static AnchorPane restPane=null;
      Rest(){


          super();
          this.setPrefSize(1000,592);
          this.setLayoutX(0);
          this.setLayoutY(0);
          restPane=this;

          Image image_shoulder=new Image(getClass().getResource("image/rest/shoulder.png").toExternalForm());
          String image_restbtn=getClass().getResource("image/rest/sleep.png").toExternalForm();
          String image_restbtnX=getClass().getResource("image/rest/sleepX.png").toExternalForm();
            this.setBackground(new Background(new BackgroundImage(image_shoulder, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null)));
          Button rest=new Button();
          rest.setPrefSize(256,256);

          rest.setStyle("-fx-background-image: url('"+image_restbtn+"');-fx-background-size: 256px 256px;-fx-background-color: transparent");
          rest.setLayoutY(100);
          rest.setLayoutX(400);
          rest.setOnMouseEntered(event->{
              rest.setStyle("-fx-background-image: url('"+image_restbtnX+"');-fx-background-size: 256px 256px;-fx-background-color: transparent");
          });
          rest.setOnMouseExited(event->{
              rest.setStyle("-fx-background-image: url('"+image_restbtn+"');-fx-background-size: 256px 256px;-fx-background-color: transparent");
          });
          rest.setOnAction(event -> {
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
                rest.setVisible(false);
                SceneChange.blackTo1To0(GameScene.gamePane);
            });
            this.getChildren().add(rest);
      }

}
