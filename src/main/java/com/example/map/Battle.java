package com.example.map;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Battle extends AnchorPane {
    public static AnchorPane blackPane=null;
    public static Deck deck1=null;
    public static Deck deck2=null;
    public static AnchorPane battlePane=null;
    public static  int energy=3;
    public final int all_energy=3;
    public static Label energyNumberLabel;
    public static TranslateTransition translateTransition=null;
    public static FadeTransition fadeTransition=null;
    public static String backImage= Battle.class.getResource("image/battle/scene.jpg").toExternalForm();

    static int num=5;
    static int[]  id_nowHave=new int[num];
    AnchorPane animationPane;
    public static Label baseNumberLabel2=null;
    public static AnchorPane monsterPane=null;

    Battle(String type)
    {
        super();
        setPrefSize(1000,600);
        setStyle("-fx-background-image: url('"+backImage+"');-fx-background-size: 1000px 600px");
        energy=3;
        battlePane=this;
        if (deck1!=null)
        {
            deck1.resetDeck();
        }
        if (deck2!=null)
        {
            deck2.resetDeck();
        }
        if (blackPane==null)
        {
            blackPane=new AnchorPane();
            blackPane.setPrefSize(1000,600);
            blackPane.setStyle("-fx-background-color: rgb(0,0,0,0.8)");
            blackPane.setVisible(false);
        }


        Font battleFont= Font.loadFont(MainApplication.fontPath,20);

        //用于演示战斗的动画布局

        animationPane=new AnchorPane();
        animationPane.setPrefSize(1000,350);
        animationPane.setLayoutY(100);
        //animationPane.setStyle("-fx-background-color: grey");
        Label battleStartLabel=new Label();
        battleStartLabel.setPrefSize(2000,100);
        battleStartLabel.setLayoutX(-2000);
        battleStartLabel.setLayoutY(150);
        Font tipFont=Font.loadFont(MainApplication.fontPath,30);
        battleStartLabel.setText("战斗开始");
        battleStartLabel.setAlignment(Pos.CENTER);
        battleStartLabel.setFont(tipFont);
        String battlePath=Battle.class.getResource("image/game_pics/battlestart.png").toExternalForm();
        battleStartLabel.setStyle("-fx-background-image: url('"+battlePath+"');-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226);-fx-background-size: 2000px 100px");
        battleStartLabel.setOpacity(0.8);
        TranslateTransition quickTransition=new TranslateTransition(Duration.seconds(0.3),battleStartLabel);
        quickTransition.setByX(1450);
        TranslateTransition quickTransition2=new TranslateTransition(Duration.seconds(0.3),battleStartLabel);
        quickTransition2.setByX(1450);
        TranslateTransition slowTransition=new TranslateTransition(Duration.seconds(0.6),battleStartLabel);
        slowTransition.setByX(100);
        quickTransition.statusProperty().addListener((observableValue, status, t1) -> {
            if (t1== Animation.Status.STOPPED)
            {
                slowTransition.statusProperty().addListener((observableValue1, status1, t11) -> {
                    if (t11== Animation.Status.STOPPED)
                    {
                        quickTransition2.play();
                    }
                });
                slowTransition.play();
            }
        });
        quickTransition.setDelay(Duration.seconds(2.5));
        quickTransition.play();

        AnchorPane heroPane=new AnchorPane();
        heroPane.setPrefSize(120,120);
        heroPane.setLayoutX(120);
        heroPane.setLayoutY(180);
        heroPane.setStyle("-fx-background-color: transparent");

        monsterPane=new AnchorPane();
        monsterPane.setPrefSize(120,120);
        monsterPane.setLayoutX(750);
        monsterPane.setLayoutY(180);
        monsterPane.setStyle("-fx-background-color: transparent");
        //判定框


        //伤害显示
//        VBox labesasasa = new VBox();
//        labesasasa.setLayoutX(202);
//        labesasasa.setLayoutY(477);
//        labesasasa.setPrefWidth(13);
//        labesasasa.setPrefHeight(23);
//        Hurt hurt = new Hurt(10, labesasasa, animationPane);
//        Button showPower = new Button("显示伤害");
//        showPower.setLayoutY(90);
//        showPower.setLayoutX(400);
//        showPower.setOnMouseClicked((MouseEvent event) -> {
//            hurt.Hurt_show();
//        });
   //     animationPane.getChildren().add(showPower);

        //怪
        Monster enemy1=new Monster(type);
        System.out.println(type);
        //角色
        Hero hero = new Hero(1, animationPane);
        hero.setBlood(GameScene.hp);
        hero.set_bar();
        //hero.show.progressBar.setProgress(((int)GameScene.hp.charAt(0)*10+(int) GameScene.hp.charAt(1)+0.0)/(Hero.Now_blood+0.0));
        //hero.show.progressBar.setProgress((Hero.Now_blood+0.0)/(Hero.All_blood+0.0));
        //System.out.println("bar"+(Hero.Now_blood+0.0)/(Hero.All_blood+0.0));

        animationPane.getChildren().addAll(enemy1.show,hero.show,battleStartLabel,heroPane,monsterPane);



        //可操作部分的布局
        deck1=new Deck(hero);
        deck1.initFrom(GameScene.deck);
        deck1.setVisible(false);
        deck2=new Deck(hero);
        deck2.setVisible(false);

        //卡牌区
//        HBox card_chosen =new HBox();
//        card_chosen.setPrefSize(1000,200);
//        card_chosen.setLayoutY(450);

        HBox Card = new HBox(-3);
        //Card.setStyle("-fx-background-color: grey");
        Card.setPrefSize(1000,200);
        Card.setAlignment(Pos.CENTER);

        TranslateTransition getTransparent=new TranslateTransition(Duration.seconds(0.5),Card);
        TranslateTransition dropTransparent=new TranslateTransition(Duration.seconds(0.5),Card);
        FadeTransition getFade=new FadeTransition(Duration.seconds(0.5),Card);
        FadeTransition dropFade=new FadeTransition(Duration.seconds(0.5),Card);
        getTransparent.setFromX(-100);
        getTransparent.setToX(0);
        dropTransparent.setToX(100);
        getFade.setFromValue(0);
        getFade.setToValue(1);
        dropFade.setToValue(0);


        int n =0;//抽牌数
        int num_old=Card.getChildren().size();
        int num_new=0;
        if(num_old==10){}
        else if((n+num_old)>10){
            num_new=10;
        }
        else if((n+num_old)<=10){
            num_new=n+num_old;
        }
        CardPane[] card_get = new CardPane[n];
        Card.setAlignment(Pos.CENTER);
        for (int i = 0; i < n; i++) {
            card_get[i] = new CardPane(11101);
            Card.getChildren().addAll(card_get[i]);
        }
        CardPane[] cards = new CardPane[num_new];
        Card.getChildren().toArray(cards);
        Card.getChildren().clear();
        num_new=cards.length;
        switch (num_new) {
            case 0, 1, 2, 3, 4, 5: {
                for (int i = 0; i < num_new; i++) {
                    Card.getChildren().add(cards[i]);
                }
                break;
            }
            case 6, 7: {
                Card.setSpacing(-28);
                for (int i = 0; i < num_new; i++) {
                    Card.getChildren().add(cards[i]);
                }
                break;
            }
            case 8, 9: {
                Card.setSpacing(-48);
                for (int i = 0; i < num_new; i++) {
                    Card.getChildren().add(cards[i]);
                }
                break;
            }
            case 10: {
                Card.setSpacing(-55);
                for (int i = 0; i < num_new; i++) {
                    Card.getChildren().add(cards[i]);
                }
                break;
            }
        }
        useCard[] useCard=new useCard[num_new];
        for (int i = 0; i < num_new; i++) {
            useCard[i] = new useCard(
                    (CardPane) Card.getChildren().get(i),
                    Card,
                    animationPane,enemy1,hero);
            useCard[i].setDragged();
            //useCard[i].setRelease();
            for(int j=0;j<i;j++) {
                if (useCard[j].loge == 1) {
                    Shake.shake(this);
                }
            }
            Card.getChildren().get(i).setOpacity(0.9);
            if (Card.getChildren().get(i).getOpacity() == 0) {
                Card.getChildren().remove(i);
                CardPane[] cards1 = new CardPane[num_new];
                Card.getChildren().toArray(cards);
                Card.getChildren().clear();
                num_new=cards.length;
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
                        for (int j = 0; i < num_new; j++) {
                            Card.getChildren().add(cards[j]);
                        }
                        break;
                    }
                }
            }
        }

        AnchorPane accessiblePane=new AnchorPane();
        accessiblePane.setPrefSize(1000,200);
        accessiblePane.setLayoutY(450);
        accessiblePane.getChildren().addAll(Card);
       // accessiblePane.setDisable();
        //accessiblePane.setStyle("-fx-background-color: red");
        //抽牌堆
        AnchorPane basePane=new AnchorPane();
        basePane.setPrefSize(70,70);
        basePane.setLayoutY(80);
        String baseImage=Battle.class.getResource("image/battle/base.png").toExternalForm();
        basePane.setStyle("-fx-background-image: url('"+baseImage+"');-fx-background-size: 70px 70px");
        Label baseNumberLabel=new Label("10");
        baseNumberLabel.setPrefSize(30,30);
        baseNumberLabel.setLayoutX(50);
        baseNumberLabel.setLayoutY(40);
        baseNumberLabel.setFont(battleFont);
        baseNumberLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
        basePane.setOnMouseEntered(event -> {
            basePane.setStyle("-fx-background-image: url('"+baseImage+"');-fx-background-size: 70px 70px;-fx-scale-x: 1.1;-fx-scale-y: 1.1");
        });
        basePane.setOnMouseExited(event -> {
            basePane.setStyle("-fx-background-image: url('"+baseImage+"');-fx-background-size: 70px 70px");
        });
        basePane.getChildren().add(baseNumberLabel);
        //能量
        AnchorPane energyPane=new AnchorPane();
        energyPane.setPrefSize(70,70);
        energyPane.setLayoutX(50);
        String energyImage=Battle.class.getResource("image/battle/iron_power.png").toExternalForm();
        energyPane.setStyle("-fx-background-image: url('"+energyImage+"');-fx-background-size: 70px 70px");
        energyNumberLabel=new Label("3/3");
//        if(deck1.energy!=0) {
//            String energy = deck1.energy + "/3";
//            energyNumberLabel.setText(energy);
//        }
        energyNumberLabel.setPrefSize(50,50);
        energyNumberLabel.setLayoutX(10);
        energyNumberLabel.setLayoutY(10);
        energyNumberLabel.setAlignment(Pos.CENTER);
        energyNumberLabel.setFont(battleFont);
        energyPane.getChildren().add(energyNumberLabel);
        //手牌
        //按钮

        Button btnEnd=new Button("结束回合");
        btnEnd.setPrefSize(120,50);
        btnEnd.setLayoutX(880);
        btnEnd.setAlignment(Pos.CENTER);
        Font endFont=Font.loadFont(MainApplication.fontPath,15);
        btnEnd.setFont(endFont);
        String endImage=Battle.class.getResource("image/battle/end.png").toExternalForm();
        String endImageX=Battle.class.getResource("image/battle/endX.png").toExternalForm();
        String endingImage=Battle.class.getResource("image/battle/ending.png").toExternalForm();
        btnEnd.setStyle("-fx-background-image: url('"+endImage+"');-fx-background-size: 120px 50px;-fx-text-fill: rgb(255,246,226);-fx-background-color: transparent");
        btnEnd.setOnMouseEntered(event -> {
            btnEnd.setStyle("-fx-background-image: url('"+endImageX+"');-fx-background-size: 120px 50px;-fx-text-fill: rgb(255,101,99);-fx-effect: dropshadow(gaussian,rgb(255,246,226),20,0,0,2);-fx-background-color: transparent");
        });
        btnEnd.setOnMouseExited(event -> {
            String text=btnEnd.getText();
            if (text=="结束回合")
            {
                btnEnd.setStyle("-fx-background-image: url('"+endImage+"');-fx-background-size: 120px 50px;-fx-text-fill: rgb(255,246,226);-fx-background-color: transparent");
            }
            else
            {
                btnEnd.setStyle("-fx-background-image: url('"+endingImage+"');-fx-background-size: 120px 50px;-fx-text-fill: rgb(255,246,226);-fx-background-color: transparent");
            }
        });

        //弃牌堆
        AnchorPane basePane2=new AnchorPane();
        basePane2.setPrefSize(70,70);
        basePane2.setLayoutX(930);
        basePane2.setLayoutY(80);
        String baseImage2=Battle.class.getResource("image/battle/base2.png").toExternalForm();
        basePane2.setStyle("-fx-background-image: url('"+baseImage2+"');-fx-background-size: 70px 70px");
        baseNumberLabel2=new Label("0");
        baseNumberLabel2.setPrefSize(30,30);
        baseNumberLabel2.setLayoutY(40);
        baseNumberLabel2.setFont(battleFont);
        baseNumberLabel2.setStyle("-fx-text-fill: rgb(255,246,226)");
        basePane2.setOnMouseEntered(event -> {
            basePane2.setStyle("-fx-background-image: url('"+baseImage2+"');-fx-background-size: 70px 70px;-fx-scale-x: 1.1;-fx-scale-y: 1.1");
        });
        basePane2.setOnMouseExited(event -> {
            basePane2.setStyle("-fx-background-image: url('"+baseImage2+"');-fx-background-size: 70px 70px");
        });
        basePane2.getChildren().add(baseNumberLabel2);
        accessiblePane.getChildren().addAll(energyPane,basePane,basePane2,btnEnd);

        getChildren().addAll(animationPane,accessiblePane,blackPane,deck1,deck2);


        translateTransition=new TranslateTransition(Duration.seconds(0.2),accessiblePane);
        translateTransition.setFromY(0);
        translateTransition.setToY(200);

        fadeTransition=new FadeTransition(Duration.seconds(0.5),enemy1.show);
        fadeTransition.setToValue(0);

        deck1.upsetNumberList();

        //事件
        btnEnd.setOnMouseClicked(event -> {
            System.out.println("当前攻击"+hero.attack);
            System.out.println("当前格挡"+hero.parry);

            Card.setDisable(false);
            for(int i=0;i<Card.getChildren().size();i++){
                deck2.addCard(((CardPane)(Card.getChildren().get(i))).id);
            }
            baseNumberLabel2.setText(String.valueOf(deck2.cardNumber));
            btnEnd.setText("敌方回合");
            btnEnd.setStyle("-fx-background-image: url('"+endingImage+"');-fx-background-size: 120px 50px;-fx-text-fill: rgb(255,246,226);-fx-background-color: transparent");
            btnEnd.setDisable(true);
            Timeline timeline=new Timeline(
                    new KeyFrame(Duration.ZERO,actionEvent->{
                        dropTransparent.play();
                        dropFade.play();
                    }),
                    //怪物回合开始动画
                    new KeyFrame(Duration.seconds(1),actionEvent->{
                            AttackAnimation.attack(Monster.show.enemy1_character,false);
                    }),
                    //怪物行动生效
                    new KeyFrame(Duration.seconds(1.15),actionEvent->{
                        //怪物行动
                        if (Monster.attack!=0)
                        {
                            AttackAnimation.beAttacked(Hero.show.character1,true);
                        }


                        enemy1.Attack(hero,enemy1.getID(enemy1.type),Monster.movement);
                        Fight.getHRoundCondition(hero);
                        Fight.getMRoundCondition(enemy1);

                        System.out.println("当前攻击"+hero.attack);
                        System.out.println("当前格挡"+hero.parry);

                        if(enemy1.parry>0)
                        {
                            enemy1.show.enemy1_block.setVisible(true);
                            ScaleTransition small=new ScaleTransition(Duration.seconds(0.3),enemy1.show.enemy1_block);
                            small.setFromX(2);
                            small.setToX(1);
                            small.setFromY(2);
                            small.setToY(1);
                            small.play();
                            enemy1.show.enemy1_block.setText(String.valueOf(enemy1.parry));
                            Monster_show.enemy1_Bar.setStyle("-fx-accent:rgb(102,204,255)");
                        }
                        //攻击意图
                        if (Monster.attack!=0)
                        {
                            //怪物造成伤害
                            if (enemy1.attack-hero.parry>0)
                            {
                                NodeFloat.nodeFloat(String.valueOf((enemy1.attack-hero.parry)),heroPane);
                                AnchorPane redPane=new AnchorPane();
                                redPane.setPrefSize(1000,600);
                                redPane.setStyle("-fx-background-color: red");
                                FadeTransition redIn=new FadeTransition(Duration.seconds(0.1),redPane);
                                redIn.setFromValue(0);
                                redIn.setToValue(0.2);
                                FadeTransition redOut=new FadeTransition(Duration.seconds(0.1),redPane);
                                redOut.setToValue(0);
                                redIn.statusProperty().addListener((observableValue, status, t1) -> {
                                    if (t1== Animation.Status.STOPPED)
                                    {
                                        redOut.play();
                                        redPane.setDisable(true);
                                    }
                                });
                                redIn.play();
                                getChildren().add(redPane);
                            }
                            else
                            {
                                NodeFloat.nodeFloat("格挡",heroPane);
                            }

                            hero.Defend(enemy1);

                            Shake.shake(GameScene.gamePane);
                            Shake.shake(GameScene.hpLabel);
                            String s1=String.valueOf(Hero.Now_blood);
                            String s2=String.valueOf(Hero.All_blood);
                            GameScene.hp=s1+"/"+s2;
                            GameScene.hpLabel.setText(GameScene.hp);

                            hero.set_bar();
                            if (hero.parry<=0)
                            {
                                Hero_show.parry.setVisible(false);
                            }
                            //死亡
                            if (Hero.Now_blood<=0)
                            {
                                Timeline timeline1=new Timeline(
                                        new KeyFrame(Duration.ZERO,event1 -> {
                                            translateTransition.play();
//换贴图，放大
                                            FadeTransition fadeTransition1=new FadeTransition(Duration.seconds(0.5),hero.show);
                                            fadeTransition1.setToValue(0);
                                            fadeTransition1.play();


                                        }),
                                        new KeyFrame(Duration.seconds(2),event1 -> {
                                            MenuScene newMenu=new MenuScene(false);
                                            SceneChange.blackTo1To0(GameScene.gamePane,MenuScene.menuPane);
                                        })

                                );
                                timeline1.setCycleCount(1);
                                timeline1.play();
                            }
                        }
                        else
                        {



                        }
                    }),

                    new KeyFrame(Duration.seconds(1.3),actionEvent->{
                        FadeTransition fadeOut=new FadeTransition(Duration.seconds(0.5),enemy1.show.intentionPane);
                        fadeOut.setToValue(0);
                        fadeOut.play();
                    }),

                    new KeyFrame(Duration.seconds(1.45),actionEvent->{
                        String node=enemy1.node_movement;
                            if(enemy1.i==0) {
                                NodeFloat.nodeFloat(node,heroPane);
                            }
                            if(enemy1.i==1){
                                NodeFloat.nodeFloat(node,monsterPane);
                            }
                    }),
                    //下一个英雄回合开始
                    new KeyFrame(Duration.seconds(2),actionEvent->{
                        Fight.getHRoundCondition(hero);
                        Fight.getMRoundCondition(enemy1);
                        System.out.println("怪物下次攻击"+Monster.nextAttack);
                        System.out.println("怪物当前攻击"+Monster.attack);
                        System.out.println("怪物下次格挡"+enemy1.nextParry);
                        System.out.println("怪物当前格挡"+enemy1.parry);

                        int random=(int)(Math.random()*10.1);
                        if (random>=0&&random<=7){
                            Monster.movement=0;
                        }
                        else {
                            Monster.movement=1;
                        }
                        enemy1.attackPrepare(hero,enemy1.getID(enemy1.type),Monster.movement);
                        enemy1.show.resetImage();

                        energy=3;
                        setEnergy(-3);
                        btnEnd.setDisable(false);
                        btnEnd.setText("结束回合");
                        btnEnd.setStyle("-fx-background-image: url('"+endImage+"');-fx-background-size: 120px 50px;-fx-text-fill: rgb(255,246,226);-fx-background-color: transparent");
                        Card.getChildren().clear();
                        deck1.getCard(num,Card,deck2,animationPane,enemy1);
                        getTransparent.play();
                        getFade.play();
                        baseNumberLabel.setText(String.valueOf(deck1.cardNumber));
                        int n1=Card.getChildren().size();
                        place(n1,Card);

                        //useCard[] useCard11=new useCard[n1];



                        for (int i = 0; i < n1; i++) {
//                            useCard11[i] = new useCard(
//                                    (CardPane)Card.getChildren().get(i),
//                                    Card,
//                                    animationPane,enemy1.show);
//                            useCard11[i].setDragged();
//                            useCard11[i].setRelease();

                            Card.getChildren().get(i).setOpacity(0.9);
                            if (Card.getChildren().get(i).getOpacity() == 0) {
                                Card.getChildren().remove(i);
                                place(n1,Card);
                            }
                        }
                    })
            );

            timeline.setCycleCount(1);
            timeline.play();
        });

        basePane.setOnMouseClicked(event->{
            deck1.setVisible(true);
            deck1.setLayoutY(100);
            blackPane.setVisible(true);
            GameScene.returnTransition.setToX(140);
            GameScene.returnTransition.play();
        });

        basePane2.setOnMouseClicked(event->{
            deck2.setVisible(true);
            deck2.setLayoutY(100);
            blackPane.setVisible(true);
            GameScene.returnTransition.setToX(140);
            GameScene.returnTransition.play();
        });


        TranslateTransition t=new TranslateTransition(Duration.seconds(2),accessiblePane);
        t.statusProperty().addListener((observableValue, status, t1) -> {
            if (t1== Animation.Status.STOPPED)
            {

                deck1.getCard(num,Card,deck2,animationPane,enemy1);
                getTransparent.play();
                getFade.play();
                baseNumberLabel.setText(String.valueOf(deck1.cardNumber));
                int random=(int)(Math.random()*10.1);
                if (random>=0&&random<=5){
                    Monster.movement=0;
                }
                else {
                    Monster.movement=1;
                }
                enemy1.attackPrepare(hero,enemy1.getID(enemy1.type),Monster.movement);
                enemy1.show.resetImage();
            }
        });
        t.play();

    }
    public static void setEnergy(int energy1){

        if(energy1<0){
        energyNumberLabel.setText("3"+"/3");
    }
    else {
        energy-=energy1;
        energyNumberLabel.setText(energy+"/3");

    }}
    void place(int num,HBox Card){
        CardPane[] cards=new CardPane[num];
        for(int i=0;i<num;i++){
            cards[i]=(CardPane) Card.getChildren().get(i);
        }
        Card.getChildren().clear();
        switch (num) {
            case 0, 1, 2, 3, 4, 5 -> {
                for (int j = 0; j < num; j++) {
                    Card.getChildren().add(cards[j]);
                }
            }
            case 6, 7 -> {
                Card.setSpacing(-28);
                for (int j = 0; j < num; j++) {
                    Card.getChildren().add(cards[j]);
                }
            }
            case 8, 9 -> {
                Card.setSpacing(-48);
                for (int j = 0; j < num; j++) {
                    Card.getChildren().add(cards[j]);
                }
            }
            case 10 -> {
                Card.setSpacing(-55);
                for (int j = 0; j < num; j++) {
                    Card.getChildren().add(cards[j]);
                }
            }
        }

    }


}
