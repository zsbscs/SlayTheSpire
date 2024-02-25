package com.example.map;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.util.Vector;

public class Map extends AnchorPane {
    public static int floor=1;
    static int row1_amount=(int)(Math.random()*2.1+2);
    static int row2_amount=(int)(Math.random()*2.1+2);
    static int row3_amount=(int)(Math.random()*1.1+4);
   static int row4_amount=(int)(Math.random()*1.1+4);
   static int row5_amount=(int)(Math.random()*1.1+4);
    static int row7_amount=(int)(Math.random()*1.1+4);
   static int row8_amount=(int)(Math.random()*1.1+4);
    static int row10_amount=(int)(Math.random()*1.1+4);
    static int row11_amount=(int)(Math.random()*1.1+4);
   static int row12_amount=(int)(Math.random()*1.1+4);
    static int row13_amount=(int)(Math.random()*1.1+4);
   static int row14_amount=(int)(Math.random()*1.1+4);
    static Gamebutton[]button_row1=new Gamebutton[5];
    static Gamebutton[]button_row2=new Gamebutton[5];
    static Gamebutton[]button_row3=new Gamebutton[5];
    static Gamebutton[]button_row4=new Gamebutton[5];
    static Gamebutton[]button_row5=new Gamebutton[5];
    static Gamebutton[]button_row6=new Gamebutton[5];
    static Gamebutton[]button_row7=new Gamebutton[5];
    static Gamebutton[]button_row8=new Gamebutton[5];
   static Gamebutton[]button_row9=new Gamebutton[5];
    static Gamebutton[]button_row10=new Gamebutton[5];
   static Gamebutton[]button_row11=new Gamebutton[5];
   static Gamebutton[]button_row12=new Gamebutton[5];
    static Gamebutton[]button_row13=new Gamebutton[5];
    static Gamebutton[]button_row14=new Gamebutton[5];
   static Gamebutton[]button_row15=new Gamebutton[5];
    Map()
    {
        super();
        setPrefSize(1000,600);
        String mapPath=Map.class.getResource("image/map/map.png").toExternalForm();
        String tipPath=Map.class.getResource("image/map/tip.png").toExternalForm();

        AnchorPane mapPane=new AnchorPane();
        mapPane.setPrefSize(1000,1600);
        mapPane.setLayoutY(200);
        mapPane.setStyle("-fx-background-image: url('"+mapPath+"');-fx-background-size: 1000px 1600px");
        TranslateTransition transition=new TranslateTransition(Duration.seconds(2),mapPane);
        transition.setToY(-1200);
        transition.setDelay(Duration.seconds(2));
        transition.play();
        mapPane.setOnScroll(scrollEvent -> {
            if(scrollEvent.isControlDown()){
                mapPane.setLayoutY(mapPane.getLayoutY()-30);}
            else
            {
                mapPane.setLayoutY(mapPane.getLayoutY()+30);
            }
        });
        AnchorPane tipPane=new AnchorPane();
        tipPane.setPrefSize(250,300);
        tipPane.setLayoutX(750);
        tipPane.setLayoutY(150);
        tipPane.setStyle("-fx-background-image: url('"+tipPath+"');-fx-background-size: 250px 300px");

        AnchorPane floorPane=new AnchorPane();
        floorPane.setPrefSize(1000,300);
        Label floorLabel=new Label();
        floorLabel.setPrefSize(1000,100);
        floorLabel.setLayoutY(50);
        Font floorFont= Font.loadFont(MainApplication.fontPath,30);
        floorLabel.setFont(floorFont);
        floorLabel.setAlignment(Pos.CENTER);
        floorLabel.setStyle("-fx-text-fill: rgb(135,206,235);-fx-background-color: transparent");
        Label floorName=new Label();
        floorName.setPrefSize(1000,150);
        floorName.setLayoutY(80);
        Font nameFont=Font.loadFont(MainApplication.fontPath,60);
        floorName.setFont(nameFont);
        floorName.setAlignment(Pos.CENTER);
        floorName.setStyle("-fx-text-fill: rgb(239,200,81);-fx-background-color: transparent");
        if (floor==1)
        {
            floorLabel.setText("第一阶段");
            floorName.setText("塔底");
        }
        else if (floor==2)
        {
            floorLabel.setText("第二阶段");
            floorName.setText("忘了");
        }
        else if (floor==3)
        {
            floorLabel.setText("第三阶段");
            floorName.setText("忘了");
        }
        else
        {
            floorLabel.setText("忘了");
            floorName.setText("忘了");
        }
        floorPane.getChildren().addAll(floorLabel,floorName);
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),floorPane);
        fadeTransition.setToValue(0);
        fadeTransition.statusProperty().addListener((observableValue, oldstatus, newstatus) -> {
            if (newstatus== Animation.Status.STOPPED)
            {
                floorPane.setVisible(false);
            }
        });
        fadeTransition.setDelay(Duration.seconds(5));
        fadeTransition.play();

        getChildren().addAll(mapPane,floorPane,tipPane);
        creat_map(mapPane);
    }
    public void creat_map(AnchorPane anchorPane){
        //row1





        for(int i=0;i<row1_amount;i++){
            button_row1[i]=new Gamebutton("monster");
            double y=1450+Math.random()*30;
            button_row1[i].setY(y);
            button_row1[i].setLayoutY(y);
            button_row1[i].setDisable(false);
            double x=150+(400/row1_amount)*(i+1)+50*(Math.random()-0.5);
            button_row1[i].setX(x);
            button_row1[i].setLayoutX(x);
            anchorPane.getChildren().add(button_row1[i]);

        }


        for(int i=0;i<row2_amount;i++){
            int type_change=(int)(Math.random()*11);
            if(type_change<=2) {
                button_row2[i] =new Gamebutton("event");

            }
            else {
                button_row2[i]=new Gamebutton("monster");
            }
            double x=150+(500/row2_amount)*(i+1)+50*(Math.random()-0.5);
            double y=1370+Math.random()*30;
            button_row2[i].setLayoutY(y);
            button_row2[i].setY(y);
            button_row2[i].setLayoutX(x);
            button_row2[i].setX(x);

            anchorPane.getChildren().add(button_row2[i]);
        }


        for(int i=0;i<row3_amount;i++){
            double x=150+(500/row3_amount)*(i+1)+50*(Math.random()-0.5);
            double y=1290+Math.random()*30;

            int type_change=(int)(Math.random()*11);
            if(type_change<=4) {
                button_row3[i] =new Gamebutton("event");

            }
            else if(type_change>4&&type_change<=7) {
                button_row3[i]=new Gamebutton("monster");
            }
            else{button_row3[i]=new Gamebutton("rest");}
            button_row3[i].setX(x);
            button_row3[i].setY(y);
            button_row3[i].setLayoutY(y);
            button_row3[i].setLayoutX(x);
            anchorPane.getChildren().add(button_row3[i]);
        }



        for(int i=0;i<row4_amount;i++){
            double x=150+(500/row4_amount)*(i+1)+50*(Math.random()-0.5);
            double y=1210+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3&&type_change>1) {
                button_row4[i] =new Gamebutton("event");

            }
            else if (type_change<=1){
                button_row4[i]=new Gamebutton("chest");
            }
            else {
                button_row4[i]=new Gamebutton("monster");
            }
            button_row4[i].setLayoutY(y);
            button_row4[i].setLayoutX(x);
            button_row4[i].setX(x);
            button_row4[i].setY(y);
            anchorPane.getChildren().add(button_row4[i]);
        }


        for(int i=0;i<row5_amount;i++){
            double x=150+(500/row5_amount)*(i+1)+50*(Math.random()-0.5);
            double y=1130+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row5[i] =new Gamebutton("event");

            }
            else if(type_change>3&&type_change<=5){
                button_row5[i]=new Gamebutton("chest");
            }
            else {
                button_row5[i]=new Gamebutton("monster");
            }
            button_row5[i].setLayoutY(y);
            button_row5[i].setLayoutX(x);
            button_row5[i].setY(y);
            button_row5[i].setX(x);
            anchorPane.getChildren().add(button_row5[i]);
        }


        for(int i=0;i<5;i++){
            double x=150+(500/5)*(i+1)+50*(Math.random()-0.5);
            double y=1050+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row6[i] =new Gamebutton("rest");

            }
            else if(type_change>3&&type_change<=5){
                button_row6[i]=new Gamebutton("monster");
            }
            else {
                button_row6[i]=new Gamebutton("elite");
            }
            button_row6[i].setLayoutY(y);
            button_row6[i].setLayoutX(x);
            button_row6[i].setY(y);
            button_row6[i].setX(x);
            anchorPane.getChildren().add(button_row6[i]);
        }

        for(int i=0;i<row7_amount;i++){
            double x=150+(500/row7_amount)*(i+1)+50*(Math.random()-0.5);
            double y=970+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=2) {
                button_row7[i] =new Gamebutton("chest");

            }
            else if(type_change>2&&type_change<=5){
                button_row7[i]=new Gamebutton("monster");
            }
            else if (type_change>5&&type_change<8){
                button_row7[i]=new Gamebutton("shop");
            }
            else {
                button_row7[i]=new Gamebutton("elite");
            }
            button_row7[i].setLayoutY(y);
            button_row7[i].setLayoutX(x);
            button_row7[i].setY(y);
            button_row7[i].setX(x);
            anchorPane.getChildren().add(button_row7[i]);
        }

        for(int i=0;i<row8_amount;i++){
            double x=150+(400/row7_amount)*(i+1)+50*(Math.random()-0.5);
            double y=890+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=2) {
                button_row8[i] =new Gamebutton("event");

            }
            else if(type_change>2&&type_change<=5){
                button_row8[i]=new Gamebutton("monster");
            }
            else if (type_change>5&&type_change<8){
                button_row8[i]=new Gamebutton("shop");
            }
            else {
                button_row8[i]=new Gamebutton("rest");
            }
            button_row8[i].setLayoutY(y);
            button_row8[i].setLayoutX(x);
            button_row8[i].setY(y);
            button_row8[i].setX(x);
            anchorPane.getChildren().add(button_row8[i]);
        }

        for(int i=0;i<5;i++){
            double x=150+(500/5)*(i+1)+50*(Math.random()-0.5);
            double y=800+Math.random()*30;
            button_row9[i]=new Gamebutton("chest");
            button_row9[i].setLayoutY(y);
            button_row9[i].setLayoutX(x);
            button_row9[i].setY(y);
            button_row9[i].setX(x);
            anchorPane.getChildren().add(button_row9[i]);

        }

        for(int i=0;i<row10_amount;i++){
            double x=150+(500/row10_amount)*(i+1)+50*(Math.random()-0.5);
            double y=720+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row10[i] =new Gamebutton("event");

            }
            else if(type_change>3&&type_change<=4){
                button_row10[i]=new Gamebutton("elite");
            }
            else if (type_change>4&&type_change<8){
                button_row10[i]=new Gamebutton("monster");
            }
            else {
                button_row10[i]=new Gamebutton("rest");
            }
            button_row10[i].setLayoutY(y);
            button_row10[i].setLayoutX(x);
            button_row10[i].setY(y);
            button_row10[i].setX(x);
            anchorPane.getChildren().add(button_row10[i]);
        }

        for(int i=0;i<row11_amount;i++){
            double x=150+(500/row11_amount)*(i+1)+50*(Math.random()-0.5);
            double y=640+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row11[i] =new Gamebutton("event");

            }
            else if(type_change>3&&type_change<=4){
                button_row11[i]=new Gamebutton("rest");
            }
            else if (type_change>4&&type_change<8){
                button_row11[i]=new Gamebutton("monster");
            }
            else {
                button_row11[i]=new Gamebutton("shop");
            }
            button_row11[i].setLayoutY(y);
            button_row11[i].setLayoutX(x);
            button_row11[i].setY(y);
            button_row11[i].setX(x);
            anchorPane.getChildren().add(button_row11[i]);
        }

        for(int i=0;i<row12_amount;i++){
            double x=150+(500/row12_amount)*(i+1)+50*(Math.random()-0.5);
            double y=560+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row12[i] =new Gamebutton("event");

            }
            else if(type_change>3&&type_change<=4){
                button_row12[i]=new Gamebutton("chest");
            }
            else if (type_change>4&&type_change<=8){
                button_row12[i]=new Gamebutton("monster");
            }
            else {
                button_row12[i]=new Gamebutton("shop");
            }
            button_row12[i].setLayoutY(y);
            button_row12[i].setLayoutX(x);
            button_row12[i].setY(y);
            button_row12[i].setX(x);
            anchorPane.getChildren().add(button_row12[i]);
        }

        for(int i=0;i<row13_amount;i++){
            double x=150+(500/row13_amount)*(i+1)+50*(Math.random()-0.5);
            double y=430+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row13[i] =new Gamebutton("event");

            }
            else if(type_change>3&&type_change<=4){
                button_row13[i]=new Gamebutton("rest");
            }
            else if (type_change>4&&type_change<=9){
                button_row13[i]=new Gamebutton("monster");
            }
            else {
                button_row13[i]=new Gamebutton("elite");
            }
            button_row13[i].setLayoutY(y);
            button_row13[i].setLayoutX(x);
            button_row13[i].setY(y);
            button_row13[i].setX(x);
            anchorPane.getChildren().add(button_row13[i]);
        }

        for(int i=0;i<row14_amount;i++){
            double x=150+(400/row13_amount)*(i+1)+50*(Math.random()-0.5);
            double y=350+Math.random()*30;
            int type_change=(int)(Math.random()*11);
            if(type_change<=3) {
                button_row14[i] =new Gamebutton("event");

            }
            else if(type_change>3&&type_change<=4){
                button_row14[i]=new Gamebutton("shop");
            }
            else if (type_change>4&&type_change<=9){
                button_row14[i]=new Gamebutton("monster");
            }
            else {
                button_row14[i]=new Gamebutton("elite");
            }
            button_row14[i].setLayoutY(y);
            button_row14[i].setLayoutX(x);
            button_row14[i].setY(y);
            button_row14[i].setX(x);
            anchorPane.getChildren().add(button_row14[i]);
        }
        Gamebutton boss=new Gamebutton("boss");



        for(int i=0;i<5;i++){
            double x=150+(400/row13_amount)*(i+1)+50*(Math.random()-0.5);
            double y=250+Math.random()*30;
            button_row15[i]=new Gamebutton("rest");
            button_row15[i].setLayoutY(y);
            button_row15[i].setLayoutX(x);
            button_row15[i].setY(y);
            button_row15[i].setX(x);
            anchorPane.getChildren().add(button_row15[i]);

        }

        boss.setLayoutX(350);
        boss.setLayoutY(50);
        anchorPane.getChildren().add(boss);

        anchorPane.getChildren().add(connect(button_row1[0],button_row2[0]));
        anchorPane.getChildren().add(connect(button_row2[0],button_row3[0]));
        anchorPane.getChildren().add(connect(button_row3[0],button_row4[0]));
        anchorPane.getChildren().add(connect(button_row4[0],button_row5[0]));
        anchorPane.getChildren().add(connect(button_row5[0],button_row6[0]));
        anchorPane.getChildren().add(connect(button_row6[0],button_row7[0]));
        anchorPane.getChildren().add(connect(button_row7[0],button_row8[0]));
        anchorPane.getChildren().add(connect(button_row8[0],button_row9[0]));
        anchorPane.getChildren().add(connect(button_row9[0],button_row10[0]));
        anchorPane.getChildren().add(connect(button_row10[0],button_row11[0]));
        anchorPane.getChildren().add(connect(button_row11[0],button_row12[0]));
        anchorPane.getChildren().add(connect(button_row12[0],button_row13[0]));
        anchorPane.getChildren().add(connect(button_row13[0],button_row14[0]));
        anchorPane.getChildren().add(connect(button_row14[0],button_row15[0]));

        anchorPane.getChildren().add(connect(button_row1[row1_amount-1],button_row2[row2_amount-1]));
        anchorPane.getChildren().add(connect(button_row2[row2_amount-1],button_row3[row3_amount-1]));
        anchorPane.getChildren().add(connect(button_row3[row3_amount-1],button_row4[row4_amount-1]));
        anchorPane.getChildren().add(connect(button_row4[row4_amount-1],button_row5[row5_amount-1]));
        anchorPane.getChildren().add(connect(button_row5[row5_amount-1],button_row6[4]));
        anchorPane.getChildren().add(connect(button_row6[4],button_row7[row7_amount-1]));
        anchorPane.getChildren().add(connect(button_row7[row7_amount-1],button_row8[row8_amount-1]));
        anchorPane.getChildren().add(connect(button_row8[row8_amount-1],button_row9[4]));
        anchorPane.getChildren().add(connect(button_row9[4],button_row10[row10_amount-1]));
        anchorPane.getChildren().add(connect(button_row10[row10_amount-1],button_row11[row11_amount-1]));
        anchorPane.getChildren().add(connect(button_row11[row11_amount-1],button_row12[row12_amount-1]));
        anchorPane.getChildren().add(connect(button_row12[row12_amount-1],button_row13[row13_amount-1]));
        anchorPane.getChildren().add(connect(button_row13[row13_amount-1],button_row14[row14_amount-1]));
        anchorPane.getChildren().add(connect(button_row14[row14_amount-1],button_row15[4]));

        for(int i=0;i<row1_amount;i++){
            for(int x=0;x<row2_amount;x++){
                if(button_row1[i].connect_parent==0&&button_row2[x].connect_child==0){
                    anchorPane.getChildren().add(connect(button_row1[i],button_row2[x]));
                }}}

        for (int i=0;i<row1_amount;i++){
            if(button_row1[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row1[i],Gamebutton.choose(button_row2,button_row1[i],row2_amount)));
            }

        }
        for (int i=0;i<row2_amount;i++){
            if(button_row2[i].connect_child==0){
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row1,button_row2[i],row1_amount),button_row2[i]));
            }

        }

        for (int i=0;i<row3_amount;i++){
            if(button_row3[i].connect_child==0){
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row2,button_row3[i],row2_amount),button_row3[i]));
            }

        }
        for (int i=0;i<row2_amount;i++){
            if(button_row2[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row2[i],Gamebutton.choose(button_row3,button_row2[i],row3_amount)));
            }

        }

        for (int i=0;i<row4_amount;i++) {
            if (button_row4[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row3, button_row4[i], row3_amount), button_row4[i]));
            }
        }
        for (int i=0;i<row3_amount;i++){
            if(button_row3[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row3[i],Gamebutton.choose(button_row4,button_row3[i],row4_amount)));
            }

        }
        for (int i=0;i<row5_amount;i++) {
            if (button_row5[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row4, button_row5[i], row4_amount), button_row5[i]));
            }
        }
        for (int i=0;i<row4_amount;i++){
            if(button_row4[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row4[i],Gamebutton.choose(button_row5,button_row4[i],row5_amount)));
            }

        }
        for (int i=0;i<5;i++) {
            if (button_row6[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row5, button_row6[i], row5_amount), button_row6[i]));
            }
        }
        for (int i=0;i<row5_amount;i++){
            if(button_row5[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row5[i],Gamebutton.choose(button_row6,button_row5[i],5)));
            }

        }
        for (int i=0;i<row7_amount;i++) {
            if (button_row7[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row6, button_row7[i], 5), button_row7[i]));
            }
        }
        for (int i=0;i<5;i++){
            if(button_row6[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row6[i],Gamebutton.choose(button_row7,button_row6[i],row7_amount)));
            }

        }
        for (int i=0;i<row8_amount;i++) {
            if (button_row8[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row7, button_row8[i], row7_amount), button_row8[i]));
            }
        }
        for (int i=0;i<row7_amount;i++){
            if(button_row7[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row7[i],Gamebutton.choose(button_row8,button_row7[i],row8_amount)));
            }

        }
        for (int i=0;i<5;i++) {
            if (button_row9[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row8, button_row9[i], row8_amount), button_row9[i]));
            }
        }
        for (int i=0;i<row8_amount;i++){
            if(button_row8[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row8[i],Gamebutton.choose(button_row9,button_row8[i],5)));
            }

        }
        for (int i=0;i<row10_amount;i++) {
            if (button_row10[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row9, button_row10[i], 5), button_row10[i]));
            }
        }
        for (int i=0;i<5;i++){
            if(button_row9[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row9[i],Gamebutton.choose(button_row10,button_row9[i],row10_amount)));
            }

        }
        for (int i=0;i<row11_amount;i++) {
            if (button_row11[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row10, button_row11[i], row10_amount), button_row11[i]));
            }
        }
        for (int i=0;i<row10_amount;i++){
            if(button_row10[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row10[i],Gamebutton.choose(button_row11,button_row10[i],row11_amount)));
            }

        }
        for (int i=0;i<row12_amount;i++) {
            if (button_row12[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row11, button_row12[i], row11_amount), button_row12[i]));
            }
        }
        for (int i=0;i<row11_amount;i++){
            if(button_row11[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row11[i],Gamebutton.choose(button_row12,button_row11[i],row12_amount)));
            }

        }
        for (int i=0;i<row13_amount;i++) {
            if (button_row13[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row12, button_row13[i], row12_amount), button_row13[i]));
            }
        }
        for (int i=0;i<row12_amount;i++){
            if(button_row12[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row12[i],Gamebutton.choose(button_row13,button_row12[i],row13_amount)));
            }

        }
        for (int i=0;i<row14_amount;i++) {
            if (button_row14[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row13, button_row14[i], row13_amount), button_row14[i]));
            }
        }
        for (int i=0;i<row13_amount;i++){
            if(button_row13[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row13[i],Gamebutton.choose(button_row14,button_row13[i],row14_amount)));
            }

        }
        for (int i=0;i<5;i++) {
            if (button_row15[i].connect_child == 0) {
                anchorPane.getChildren().add(connect(Gamebutton.choose(button_row14, button_row15[i], row14_amount), button_row15[i]));
            }
        }
        for (int i=0;i<row14_amount;i++){
            if(button_row14[i].connect_parent==0){
                anchorPane.getChildren().add(connect(button_row14[i],Gamebutton.choose(button_row15,button_row14[i],5)));
            }
        }
    }
    public Line connect(Gamebutton btn1, Gamebutton btn2){
        Line line=new Line();

        line.setStartX(btn1.getX()+35);
        line.setStartY(btn1.getY()+35);
        line.setEndX(btn2.getX()+35);
        line.setEndY(btn2.getY()+35);

        btn1.connect_parent++;
        btn1.setParent(btn2);
        btn2.connect_child++;

        return line;
    }
    public static void setDisableMap(){
        for (int i=0;i<row1_amount;i++){
            button_row1[i].setDisable(true);
        }
        for (int i=0;i<row2_amount;i++){
            button_row2[i].setDisable(true);
        }
        for (int i=0;i<row3_amount;i++){
            button_row3[i].setDisable(true);
        }
        for (int i=0;i<row4_amount;i++){
            button_row4[i].setDisable(true);
        }
        for (int i=0;i<row5_amount;i++){
            button_row5[i].setDisable(true);
        }
        for (int i=0;i<5;i++){
            button_row6[i].setDisable(true);
        }
        for (int i=0;i<row7_amount;i++){
            button_row7[i].setDisable(true);
        }
        for (int i=0;i<row8_amount;i++){
            button_row8[i].setDisable(true);
        }
        for (int i=0;i<5;i++){
            button_row9[i].setDisable(true);
        }
        for (int i=0;i<row10_amount;i++){
            button_row10[i].setDisable(true);
        }
        for (int i=0;i<row11_amount;i++){
            button_row11[i].setDisable(true);
        }
        for (int i=0;i<row12_amount;i++){
            button_row12[i].setDisable(true);
        }
        for (int i=0;i<row13_amount;i++){
            button_row13[i].setDisable(true);
        }
        for (int i=0;i<row14_amount;i++){
            button_row14[i].setDisable(true);
        }
        for (int i=0;i<5;i++){
            button_row15[i].setDisable(true);
        }
    }

}
