package com.example.map;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Vector;


public class Hero  {
    public static int Now_blood;
    AnchorPane root;
    int type;//人物代号，1，2，3，4分别代表对应人物
    public static int All_blood;
    int parry=0;
    int attack;
    int money;

    public static Hero_show show=null;
    Vector<Condition>conditions=new Vector<Condition>();

    public  Hero(int type,AnchorPane root){
        int now_blood=0;
        int all_blood=0;
        switch (type){
            case 1:{
                now_blood=80;
                all_blood=80;
                break;
            }
            case 2:{
                now_blood=75;
                all_blood=75;
                break;
            }
            case 3:{
                now_blood=70;
                all_blood=70;
                break;
            }
        }
        if((((int)GameScene.hp.charAt(1))-(int)'0')<=9&&(((int)GameScene.hp.charAt(1))-(int)'0')>=0){
        if(((int)GameScene.hp.charAt(0)-(int)'0')*10+((int)GameScene.hp.charAt(1)-(int)'0')<All_blood){
            now_blood=(((int)GameScene.hp.charAt(0)-(int)'0')*10+((int)GameScene.hp.charAt(1))-(int)'0');
        }}
        else{
            now_blood=(int)GameScene.hp.charAt(0)-(int)'0';
        }
        this.type=type;
        this.show=new Hero_show(type);
        this.root=root;
        All_blood=all_blood;
        Now_blood=now_blood;
    }
    public void parry_get(int n){
        show.parry.setText(String.valueOf(n));
        if(n!=0) {
            this.show.progressBar.setStyle("-fx-accent:rgb(102,204,255)");
        }
    }
    public void parry_used(int n){   //护盾生效特效,n为本次伤害数值
        if(n!=0) {
            if (parry == 0) {
                this.show.progressBar.setStyle("-fx-accent:rgb(204,12,12)");
            }
            else if(parry!=0){

            }
        }}

    public void Attack(){

       getAttackCondition();

    }
    public void Defend(Monster monster){

        int damage=monster.attack;
        getDefendCondition(monster);
                if(this.parry<monster.attack){

            this.Now_blood-=monster.attack-this.parry;
            this.parry=0;
            if(Now_blood<=0){

                //die();

            }

        }
        else {
            this.parry-=monster.attack;

        }}
            public void New_blood_change(int n){
                double currentProgress = this.show.progressBar.getProgress();
                double n1=n/All_blood;
                double newProgress = currentProgress - n1;
                newProgress = Math.min(1.0, newProgress);
                this.show.progressBar.setProgress(newProgress);
                if(Now_blood==0){
                    //调用死亡界面
                }
            }

public void setBlood(String blood){
        Hero_show.blood_value.setText(blood);
}



    public void getDefendCondition(Monster monster){
        for(int i=0;i<conditions.size();i++){
            if(conditions.get(i).type.equals("vulnerable")){
                monster.attack=(int)(monster.attack*1.5);
            }
            else if(conditions.get(i).type.equals("thorns")){
                if(monster.parry<conditions.get(i).n){
                    monster.blood-=conditions.get(i).n-monster.parry;

                }
                else{monster.parry-=conditions.get(i).n;}

            }


    }}

    public void getAttackCondition(){

        for (int i=0;i<conditions.size();i++){

            if(conditions.get(i).type.equals("strength")){

                this.attack+=conditions.get(i).n;
            }
            else if (conditions.get(i).type.equals("weak")) {
                this.attack=(int)(this.attack*0.75);
            }


        }


    }
    public void set_bar(){
        double newProgress =(Now_blood+0.0)/(All_blood+0.0);
        show.parry.setText(String.valueOf(this.parry));
        if(this.parry==0){
            show.progressBar.setStyle("-fx-accent:rgb(204,12,12)");
        }
        show.blood_value.setText(Now_blood+"/"+All_blood);
        newProgress = Math.min(1.0, newProgress);
        show.progressBar.setProgress(newProgress);
    }
    public void set_bar(int n){
        char[] a=GameScene.hp.toCharArray();
        int NOW=0;
        for(int i=0;(int)a[i]>=0&&(int)a[i]<10;i++){
            System.out.println("sasasasasasa"+a[i]);
            NOW=NOW*10+(int)a[i];
        }
        double newProgress =(NOW+0.0)/(All_blood+0.0);
        show.parry.setText(String.valueOf(this.parry));
        if(this.parry==0){
            show.progressBar.setStyle("-fx-accent:rgb(204,12,12)");
        }
        show.blood_value.setText(Now_blood+"/"+All_blood);
        newProgress = Math.min(1.0, newProgress);
        show.progressBar.setProgress(newProgress);
    }




}
