package com.example.map;

import javafx.animation.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class useCard {
    public int energy=0;

    public Hero hero;
    double old_x;
    double old_y;
    CardPane pp;
    Line line;
    Line line1;
    Circle circle;
    Monster enemy1;
    Label[] chosen;
    Pane pane;
    HBox Card;
    int num_new;
    int loge;
    public useCard(CardPane p, HBox Card, Pane pane, Monster enemy1,Hero hero) {
        this.hero=hero;
        this.Card = Card;
        this.pane = pane;
        pp = p;
        this.enemy1 = enemy1;
        //num_new = num_new1;
        old_x = p.getLayoutX();
        old_y = p.getLayoutX();
        chosen = new Label[4];
        for (int i = 0; i < 4; i++) {
            chosen[i] = new Label();
            chosen[i].setPrefWidth(90);
            chosen[i].setPrefHeight(160);
            String path = new String("image/picture/border/border" + (i + 1) + ".png");
            Image chosen_image = new Image(getClass().getResourceAsStream(path), 36, 64, true, true);
            ImageView chosen_imageView = new ImageView(chosen_image);
            chosen[i].setGraphic(chosen_imageView);
            chosen[i].setVisible(false);
            pane.getChildren().addAll(chosen[i]);
        }
        chosen[0].setLayoutX(enemy1.show.getLayoutX() - 10);
        chosen[0].setLayoutY(enemy1.show.getLayoutY() + enemy1.show.getHeight() -105);
        chosen[1].setLayoutX(enemy1.show.getLayoutX() + enemy1.show.getWidth() - chosen[1].getWidth() -20);
        chosen[1].setLayoutY(enemy1.show.getLayoutY() + enemy1.show.getHeight() -105);
        chosen[2].setLayoutX(enemy1.show.getLayoutX() - 10);
        chosen[2].setLayoutY(enemy1.show.getLayoutY() - 55);
        chosen[3].setLayoutX(enemy1.show.getLayoutX() + enemy1.show.getWidth() - chosen[1].getWidth()-20);
        chosen[3].setLayoutY(enemy1.show.getLayoutY() - 55);
        line = new Line();
        circle = new Circle(12);
        line1 = new Line();
        pane.getChildren().addAll(line, circle, line1);
    }

        void setDragged() {
            pp.setOnMouseDragged((MouseEvent event) -> {
                if(pp.getType()==1) {
                    pp.setOpacity(1);
                    if (event.getSceneX() > enemy1.show.getLayoutX() &&
                            event.getSceneX() < enemy1.show.getLayoutX() + enemy1.show.getWidth() &&
                            event.getSceneY() > enemy1.show.getLayoutY() + 100 &&
                            event.getSceneY() < enemy1.show.getLayoutY() + enemy1.show.getHeight() + 100) {
                        for (int i = 0; i < 4; i++) {
                            chosen[i].setVisible(true);
                        }
                    } else {
                        for (int i = 0; i < 4; i++) {
                            chosen[i].setVisible(false);
                        }
                    }
                    pp.setScaleX(1.3);
                    pp.setScaleY(1.3);
                    line.setStartX(pp.getLayoutX() + 60);
                    line.setStartY(pp.getLayoutY() + 310);
                    line.setStrokeWidth(5);
                    line.setStroke(Color.RED);
                    line.setEndX(event.getSceneX());
                    line.setEndY(event.getSceneY() - 100);
                    line.setOpacity(0.3);
                    circle.setCenterX(event.getSceneX());
                    circle.setCenterY(event.getSceneY() - 100);
                    circle.setOpacity(0.7);
                    circle.setFill(Color.GRAY);
                    circle.setStroke(Color.RED);
                    line1.setStartX(pp.getLayoutX() + 60);
                    line1.setStartY(pp.getLayoutY() + 310);
                    line1.setStrokeWidth(3);
                    line1.setStroke(Color.YELLOW);
                    line1.setEndX(event.getSceneX());
                    line1.setEndY(event.getSceneY() - 100);
                    line1.setVisible(false);
                    if (pp.getLayoutY() < 270 || pp.getLayoutX() > 700 || pp.getLayoutX() < 80) {
                        pp.setScaleY(1.5);
                        pp.setScaleX(1.5);
                        line.setVisible(true);
                        circle.setVisible(true);
                    } else {
                        line.setVisible(false);
                        circle.setVisible(false);
                    }
                }
                else {
                    pp.setScaleX(1.3);
                    pp.setScaleY(1.3);
                    line.setStartX(pp.getLayoutX() + 60);
                    line.setStartY(pp.getLayoutY() + 310);
                    line.setStrokeWidth(5);
                    line.setStroke(Color.RED);
                    line.setEndX(event.getSceneX());
                    line.setEndY(event.getSceneY() - 100);
                    line.setOpacity(0.3);
                    line.setStroke(Color.BLUE);
                    circle.setCenterX(event.getSceneX());
                    circle.setCenterY(event.getSceneY() - 100);
                    circle.setOpacity(0.7);
                    circle.setFill(Color.GRAY);
                    circle.setStroke(Color.BLUE);
                    line1.setStartX(pp.getLayoutX() + 60);
                    line1.setStartY(pp.getLayoutY() + 310);
                    line1.setStrokeWidth(3);
                    line1.setStroke(Color.BLUE);
                    line1.setEndX(event.getSceneX());
                    line1.setEndY(event.getSceneY() - 100);
                    line1.setVisible(false);
                    if (pp.getLayoutY() < 270 || pp.getLayoutX() > 700 || pp.getLayoutX() < 80) {
                        pp.setScaleY(1.5);
                        pp.setScaleX(1.5);
                        line.setVisible(true);
                        circle.setVisible(true);
                    } else {
                        line.setVisible(false);
                        circle.setVisible(false);
                    }
                }
            });

        }

    void setRelease(Deck deck2) {
//        if(Battle.energy==0){
//            Card.setDisable(true);
//        }
        if (Battle.energy >= pp.energy) {
            pp.setOnMouseReleased((MouseEvent event) -> {
                        if (pp.getType() == 1) {
                            line.setVisible(false);
                            circle.setVisible(false);
                            if (event.getSceneX() > enemy1.show.getLayoutX() &&
                                    event.getSceneX() < enemy1.show.getLayoutX() + enemy1.show.getWidth() &&
                                    event.getSceneY() > enemy1.show.getLayoutY() + 100 &&
                                    event.getSceneY() < enemy1.show.getLayoutY() + enemy1.show.getHeight() + 100) {
                                ///////////////////////////攻击牌使用后的效果/////////////////////////////////
                                Battle.baseNumberLabel2.setText(String.valueOf(Battle.deck2.cardNumber + 1));
                                Shake.shake(GameScene.gamePane);
                                AttackAnimation.attack(Hero.show.character1, true);
                                AttackAnimation.beAttacked(Monster.show.enemy1_character, false);
                                Fight.useCard(hero, enemy1, pp);
                                Battle.setEnergy(pp.energy);

                                if(pp.getMainEffectValue()< enemy1.parry){
                                    enemy1.parry-=pp.getMainEffectValue();
                                }
                                else {
                                    enemy1.parry=0;
                                    Monster_show.enemy1_Bar.setStyle("-fx-accent:red");
                                }

                                if (pp.getType() == 1) {
                                    hero.attack = 0;
                                }

                                if (Monster.blood <= 0) {
                                    String s1=String.valueOf(Hero.Now_blood);
                                    String s2=String.valueOf(Hero.All_blood);
                                    GameScene.hp=s1+"/"+s2;
                                    GameScene.hpLabel.setText(GameScene.hp);
                                    Battle.translateTransition.play();
                                    Battle.fadeTransition.play();
                                    AnchorPane blackPane = new AnchorPane();
                                    blackPane.setPrefSize(1000, 600);
                                    blackPane.setStyle("-fx-background-color: rgb(0,0,0,0.8)");
                                    Timeline timeline=new Timeline(
                                            new KeyFrame(Duration.seconds(1),actionEvent->{
                                                Reward reward = new Reward();
                                                GameScene.proceedTransition.setToX(-160);
                                                GameScene.proceedTransition.play();
                                                Battle.battlePane.getChildren().addAll(blackPane, reward);
                                            })
                                    );
                                    timeline.setCycleCount(1);
                                    timeline.play();
                                }

                                hero.parry_get(hero.parry);
                                ///////////////////////////////////////////////////////
                                deck2.addCard(pp.id);

                                for (int i = 0; i < 4; i++) {
                                    chosen[i].setVisible(false);
                                }

                                if (enemy1.parry==0)
                                {
                                    enemy1.show.enemy1_block.setVisible(false);
                                }


                                //淡化效果
                                CardAnimation.cardDrop(pp);
                                Hit hit = new Hit(pane, line1);
                                if (Battle.energy <= 0) {
                                    Card.setDisable(true);
                                }

                                Timeline timeline = new Timeline(
                                        new KeyFrame(Duration.seconds(0.5), actionEvent -> {

                                            pane.getChildren().removeAll(line, circle);

                                            Card.getChildren().remove(pp);

                                            num_new = Card.getChildren().size();
                                            CardPane[] cards = new CardPane[num_new];
                                            for (int i = 0; i < num_new; i++) {
                                                cards[i] = (CardPane) (Card.getChildren().get(i));
                                            }
                                            //System.out.println(cards.length);
                                            Card.getChildren().clear();
                                            switch (num_new) {
                                                case 0, 1, 2, 3, 4, 5: {
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                                case 6, 7: {
                                                    Card.setSpacing(-28);
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                                case 8, 9: {
                                                    Card.setSpacing(-48);
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                                case 10: {
                                                    Card.setSpacing(-55);
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                            }
//                                        if(Battle.energy==0){
//                                            Card.setDisable(true);
//                                        }

                                        })

                                );
                                timeline.setCycleCount(1);
                                timeline.play();
                            } else {
                                pp.setScaleX(1);
                                pp.setScaleY(1);
                                if (pp.getLayoutY() >= 200) {
                                    pp.setLayoutX(old_x);
                                    pp.setLayoutY(old_y);
                                    pp.setScaleX(1);
                                    pp.setScaleY(1);
                                }

                            }
                        } else {
                            line.setVisible(false);
                            circle.setVisible(false);
                            if (event.getSceneY() < 380) {
                                ///////////////////////////非攻击牌使用后的效果/////////////////////////////////////////////
                                Battle.baseNumberLabel2.setText(String.valueOf(Battle.deck2.cardNumber + 1));
                                Fight.useCard(hero, enemy1, pp);
                                //效果漂浮
                                String effect=null;
                                if(pp.otherEffectType!=null)
                                {
                                    if (pp.otherEffectType.equals("strength")) {
                                        effect = "力量";
                                    }
                                    else if (pp.otherEffectType.equals("vulnerable")){
                                        effect="易伤";
                                    }
                                    else if(pp.otherEffectType.equals("parry")){
                                        effect="格挡";
                                    }
                                    else if (pp.otherEffectType.equals("weak")){
                                        effect="虚弱";

                                    }
                                    else if(pp.otherEffectType.equals("blood")){
                                        effect="自残";

                                    }
                                }



                                hero.parry_get(hero.parry);
                                Battle.setEnergy(pp.energy);
                                //////////////////////////////////////////////////////////////
                                if (hero.parry>0)
                                {
                                    Hero_show.parry.setVisible(true);
                                    ScaleTransition small=new ScaleTransition(Duration.seconds(0.3),Hero_show.parry);
                                    small.setFromX(2);
                                    small.setToX(1);
                                    small.setFromY(2);
                                    small.setToY(1);
                                    small.play();
                                    Hero_show.parry.setText(String.valueOf(hero.parry));

                                }
                                deck2.addCard(pp.id);
                                for (int i = 0; i < 4; i++) {
                                    chosen[i].setVisible(false);
                                }
                                //淡化效果
                                CardAnimation.cardDrop(pp);
                                Timeline timeline = new Timeline(
                                        new KeyFrame(Duration.ZERO, actionEvent -> {
                                            pp.setOpacity(1);
                                        }),
                                        new KeyFrame(Duration.seconds(0.05), actionEvent -> {
                                            pp.setOpacity(0.9);
                                        }),
                                        new KeyFrame(Duration.seconds(0.1), actionEvent -> {
                                            pp.setOpacity(0.8);
                                            line1.setVisible(true);
                                            line1.setOpacity(0.5);
                                        }),
                                        new KeyFrame(Duration.seconds(0.15), actionEvent -> {
                                            pp.setOpacity(0.7);
                                            line1.setOpacity(0.4);
                                        }),
                                        new KeyFrame(Duration.seconds(0.2), actionEvent -> {
                                            pp.setOpacity(0.6);
                                            line1.setOpacity(0.3);
                                        }),
                                        new KeyFrame(Duration.seconds(0.25), actionEvent -> {
                                            pp.setOpacity(0.5);
                                            line1.setOpacity(0.2);
                                        }),
                                        new KeyFrame(Duration.seconds(0.3), actionEvent -> {
                                            pp.setOpacity(0.4);
                                            line1.setOpacity(0.1);
                                        }),
                                        new KeyFrame(Duration.seconds(0.35), actionEvent -> {
                                            pp.setOpacity(0.3);
                                            line1.setVisible(false);
                                        }),
                                        new KeyFrame(Duration.seconds(0.4), actionEvent -> {
                                            pp.setOpacity(0.2);
                                        }),
                                        new KeyFrame(Duration.seconds(0.45), actionEvent -> {
                                            pp.setOpacity(0.1);
                                        }),
                                        new KeyFrame(Duration.seconds(0.5), actionEvent -> {
                                            if (Battle.energy <= 0) {
                                                Card.setDisable(true);
                                            }
                                            pp.setOpacity(0);
                                            pane.getChildren().removeAll(line, circle);
                                            Card.getChildren().remove(pp);
                                            CardPane[] cards;
                                            num_new = Card.getChildren().size();
                                            cards = new CardPane[num_new];
                                            for (int i = 0; i < num_new; i++) {
                                                cards[i] = (CardPane) (Card.getChildren().get(i));
                                            }
                                            Card.getChildren().clear();
                                            switch (num_new) {
                                                case 0, 1, 2, 3, 4, 5: {
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                                case 6, 7: {
                                                    Card.setSpacing(-28);
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                                case 8, 9: {
                                                    Card.setSpacing(-48);
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                                case 10: {
                                                    Card.setSpacing(-55);
                                                    for (int j = 0; j < num_new; j++) {
                                                        Card.getChildren().add(cards[j]);
                                                    }
                                                    break;
                                                }
                                            }

                                        })
                                );
                                timeline.setCycleCount(1);
                                timeline.play();
                                loge = 1;
                            } else {
                                pp.setScaleX(1);
                                pp.setScaleY(1);
                                if (pp.getLayoutY() >= 200) {
                                    pp.setLayoutX(old_x);
                                    pp.setLayoutY(old_y);
                                    pp.setScaleX(1);
                                    pp.setScaleY(1);
                                }

                            }
                        }
                    }
            );
        } else {
            pp.setOnMouseReleased((MouseEvent event) -> {
                for(int i=0;i<4;i++){
                    chosen[i].setVisible(false);
                }
                line.setVisible(false);
                circle.setVisible(false);
                pp.setScaleX(1);
                pp.setScaleY(1);
//                if (pp.getLayoutY() >= 200) {
                    pp.setLayoutX(old_x);
                    pp.setLayoutY(old_y);
                    pp.setScaleX(1);
                    pp.setScaleY(1);
             //   }
            });


        }
    }}

//        p.setOnMouseReleased((MouseEvent event) -> {
//                    line.setVisible(false);
//                    circle.setVisible(false);
//                    if(event.getSceneX()>enemy1.getLayoutX()&&
//                            event.getSceneX()<enemy1.getLayoutX()+enemy1.getWidth()&&
//                            event.getSceneY()>enemy1.getLayoutY()+100&&
//                            event.getSceneY()<enemy1.getLayoutY()+enemy1.getHeight()+100){
////                        Shake.shake(Card.getParent().battle333);
//                        for(int i=0;i<4;i++){
//                            chosen[i].setVisible(false);
//                        }
//                        //淡化效果
//                        Timeline timeline=new Timeline(
//                                new KeyFrame(Duration.ZERO , actionEvent -> {
//                                    p.setOpacity(1);
//
//
//                                    Hit hit = new Hit(pane,line1);
////                                    p.setLayoutX(425);
////                                    p.setLayoutY(100);
//                                }),
//                                new KeyFrame(Duration.seconds(0.05),actionEvent -> {
//                                    p.setOpacity(0.9);
//                                }),
//                                new KeyFrame(Duration.seconds(0.1),actionEvent -> {
//                                    p.setOpacity(0.8);
//                                    line1.setVisible(true);
//                                    line1.setOpacity(0.5);
//                                }),
//                                new KeyFrame(Duration.seconds(0.15),actionEvent -> {
//                                    p.setOpacity(0.7);
//                                    line1.setOpacity(0.4);
//                                }),
//                                new KeyFrame(Duration.seconds(0.2),actionEvent -> {
//                                    p.setOpacity(0.6);
//                                    line1.setOpacity(0.3);
//                                }),
//                                new KeyFrame(Duration.seconds(0.25),actionEvent -> {
//                                    p.setOpacity(0.5);
//                                    line1.setOpacity(0.2);
//                                }),
//                                new KeyFrame(Duration.seconds(0.3),actionEvent -> {
//                                    p.setOpacity(0.4);
//                                    line1.setOpacity(0.1);
//                                }),
//                                new KeyFrame(Duration.seconds(0.35),actionEvent -> {
//                                    p.setOpacity(0.3);
//                                    line1.setVisible(false);
//                                }),
//                                new KeyFrame(Duration.seconds(0.4),actionEvent -> {
//                                    p.setOpacity(0.2);
//                                }),
//                                new KeyFrame(Duration.seconds(0.45),actionEvent -> {
//                                    p.setOpacity(0.1);
//                                }),
//                                new KeyFrame(Duration.seconds(0.5),actionEvent -> {
//                                    p.setOpacity(0);
//
//                                    pane.getChildren().removeAll(line,circle);
//
//                                    Card.getChildren().remove(p);
//                                    CardPane[] cards = new CardPane[num_new -1];
//                                    Card.getChildren().toArray(cards);
//                                    num_new=Card.getChildren().size();
//                                    Card.getChildren().clear();
//                                    switch (num_new) {
//                                        case 0, 1, 2, 3, 4, 5: {
//                                            for (int j = 0; j < num_new; j++) {
//                                                Card.getChildren().add(cards[j]);
//                                            }
//                                            break;
//                                        }
//                                        case 6, 7: {
//                                            Card.setSpacing(-28);
//                                            for (int j = 0; j < num_new; j++) {
//                                                Card.getChildren().add(cards[j]);
//                                            }
//                                            break;
//                                        }
//                                        case 8, 9: {
//                                            Card.setSpacing(-48);
//                                            for (int j = 0; j < num_new; j++) {
//                                                Card.getChildren().add(cards[j]);
//                                            }
//                                            break;
//                                        }
//                                        case 10: {
//                                            Card.setSpacing(-55);
//                                            for (int j = 0; j < num_new; j++) {
//                                                Card.getChildren().add(cards[j]);
//                                            }
//                                            break;
//                                        }
//                                    }
//
//                                })
//                        );
//                        timeline.setCycleCount(1);
//                        timeline.play();
//                    }
//                    else{
//                        p.setScaleX(1);
//                        p.setScaleY(1);
//                        if (p.getLayoutY() >= 200) {
//                            p.setLayoutX(old_x);
//                            p.setLayoutY(old_y);
//                            p.setScaleX(1);
//                            p.setScaleY(1);
//                        }
//                    }
//                }
//        );
