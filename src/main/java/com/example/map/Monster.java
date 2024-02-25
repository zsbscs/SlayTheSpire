package com.example.map;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Vector;

public class Monster extends Label {
       int All_blood=0;
       static int blood=0;
       static int attack = 0;
       static int nextAttack=0;
       public int parry = 0;
       public int nextParry=0;
       static String type;
       int i;
       static int movement=0;
       String node_movement;
       static Monster_show show=null;

       Vector<Condition> conditions = new Vector<Condition>();


       Monster(String type) {




              this.type=type;
              this.show=new Monster_show(getID(type),movement);
              if (type.equals("daechong")) {

                     this.blood = 40;
                     All_blood=this.blood;

              }
              else if (type.equals("Cultist")){

                     this.blood= 48;
                     All_blood=this.blood;
              } else if (type.equals("spikeslime")) {
                     this.blood= 64;
                     All_blood=this.blood;

              } else if (type.equals("red_worm")) {
                     this.blood=10;
                     All_blood=this.blood;
                     NodeFloat.nodeFloat("蜷缩",show);
                     this.conditions.add(new Condition("curl", 6));
              } else if (type.equals("looter")) {
                     this.blood=44;
                     All_blood=this.blood;
              }
              else if (type.equals("acidslime")){
                     this.blood=24;
                     All_blood=this.blood;
              }
              else if (type.equals("mashroom")){
                     this.blood=65;
                     All_blood=this.blood;
              }
              else if (type.equals("Gremlin_Nob")) {
                     this.blood=82;
                     All_blood=this.blood;
              }
              else if (type.equals("Lagavulin")){
                     this.blood=109;
                     Lagavulin_movement(0);
                     All_blood=this.blood;
              }
              else if(type.equals("sentry")){
                     this.blood=38;
                     sentry_movement(0);
                     All_blood=this.blood;
              }


       }
       public int getID(String type){

              if (type.equals("daechong")) {
                    return 1;

              }
              else if (type.equals("Cultist")){

                     return 2;
              } else if (type.equals("spikeslime")) {
                    return 3;

              } else if (type.equals("red_worm"))
              {
                     return 4;
              } else if (type.equals("looter")) {
                     return 5;
              }
              else if (type.equals("mashroom")){
                     return 7;
              }

              else if (type.equals("Gremlin_Nob")) {
                    return 8;
              }
              else if (type.equals("Lagavulin")){
                    return 9;
              }
              else if(type.equals("sentry")){
                     return 10;
              }
              else return 0;


       }

       public static String GetImages(int n,int m) {
              m=movement;
              switch (n) {
                     case 1: {
                            return "image/monster/daechong.png";
                     }
                     case 2: {
                            return "image/monster/Cultist.png";
                     }
                     case 3: {
                            return "image/monster/spikeslime.png";
                     }
                     case 4: {
                            return "image/monster/worm_red.png";
                     }
                     case 5: {
                            return "image/monster/looter.png";
                     }
                     case 6:{
                            return "image/monster/acidslime.png";
                     }
                     case 7: {
                            return "image/monster/mashroom.png";
                     }
                     case 8: {
                            return "image/elite/Gremlin_Nob.png";
                     }
                     case 9:{
                            if(m==1){
                            return "image/elite/Lagavulin_sleep.png" ;
                            }
                            if (m==2){
                                   return "image/elite/Lagavulin_awake.png";
                            }
                     }
                     case 10:{
                            return "image/elite/Sentry.png";
                     }
                     default:
                            return "error!";

              }


       }
       public void attackPrepare(Hero hero,int id ,int m)
       {
              switch (id) {
                     case 1:
                     {
                            dae_movement(m);
                            break;
                     }
                     case 2: {
                            cultust_movement(m);
                            break;
                     }
                     case 3: {
                            spikeslime_movement(m);
                            break;
                     }
                     case 4: {
                            red_louse_movement(m);
                            break;
                     }
                     case 5: {
                            looter_movement(m);
                            break;
                     }
                     case 6:{
                            }
                     case 7:{
                            mashroom_movement(m);
                            break;}
                     case 8:{
                            Gremlin_Nob_movement(m);
                            break;
                     }
                     case 9:{
                            Lagavulin_movement(m);
                            break;
                     }
                     case 10:{
                            sentry_movement(m);
                     }
              }
       }

       public void Attack(Hero hero, int id, int m) {

              attack=nextAttack;
              parry=nextParry;

              switch (id) {
                     case 1:
                     {
                            dae_movement(m);
                            getAttackCondition();
                            break;
                     }
                     case 2: {
                            cultust_movement(m);
                            getAttackCondition();
                            break;
                     }
                     case 3: {
                            spikeslime_movement(m);
                            getAttackCondition();
                            if (m == 1) {
                                   boolean ishave=false;
                                   int x=0;
                                   for(int i=0;i<hero.conditions.size();i++){
                                          if(hero.conditions.get(i).type.equals("weak")){
                                                 ishave=true;
                                                 x=i;

                                          }

                                   }
                                   if(ishave){
                                          hero.conditions.get(x).n+=1;
                                   }
                                   else {
                                          hero.conditions.add(new Condition("weak", 1));
                                   }
                                  node_movement="虚弱";
                                  i=0;
                            }
                            break;
                     }
                     case 4: {
                            red_louse_movement(m);
                            getAttackCondition();
                            if (m == 2) {
                                   boolean ishave=false;
                                   int x=0;
                                   for(int i=0;i<hero.conditions.size();i++){
                                          if(hero.conditions.get(i).type.equals("weak")){
                                                 ishave=true;
                                                 x=i;

                                          }

                                   }
                                   if(ishave){
                                          hero.conditions.get(x).n+=1;
                                   }
                                   else {
                                          hero.conditions.add(new Condition("weak", 1));
                                   }
                                   node_movement="虚弱";
                                   i=0;
                                   break;
                            }

                     }
                     case 5: {
                            looter_movement(m);
                            getAttackCondition();
                            if (GameScene.money>=15)
                            {
                                   GameScene.money -= 15;
                            }
                            else {
                                   GameScene.money=0;
                            }
                            GameScene.moneyLabel.setText(String.valueOf(GameScene.money));
                            Shake.shake(GameScene.moneyLabel);
                            i=0;
                            node_movement="窃取";
                            break;
                     }
                     case 6:{
                     }
                     case 7:{
                            mashroom_movement(m);
                            getAttackCondition();
                            break;}
                     case 8:{
                            Gremlin_Nob_movement(m);
                            getAttackCondition();
                            if(m==1){
                                   boolean ishave=false;
                                   int x=0;
                                   for(int i=0;i<hero.conditions.size();i++){
                                          if(hero.conditions.get(i).type.equals("vulnerable")){
                                                 ishave=true;
                                                 x=i;

                                          }

                                   }
                                   if(ishave){
                                          hero.conditions.get(x).n+=1;
                                   }
                                   else {
                                          hero.conditions.add(new Condition("vulnerable", 1));
                                   }
                                   i=0;
                                   node_movement="易伤";
                            }
                            break;
                     }
                     case 9:{
                            Lagavulin_movement(m);
                            getAttackCondition();
                            if(m==2){

                                   i=0;
                                   node_movement="力量减弱";
                            }
                            break;

                     }
                     case 10:{
                            sentry_movement(m);
                            getAttackCondition();
                            if(m==2){



                            }
                     }
              }
       }


       public void Defend(Hero hero){

              getDefendCondition(hero);
              if(this.parry<hero.attack)
              {
                     show.enemy1_block.setText(String.valueOf(0));
                     Monster_show.enemy1_Bar.setStyle("-fx-accent:red");
                     this.blood-=hero.attack-this.parry;
                     NodeFloat.nodeFloat(String.valueOf(hero.attack-parry),Battle.monsterPane);
                     double newProgress = (this.blood+0.0)/(All_blood+0.0);
                     Monster_show.enemy1_Bar.setProgress(newProgress);
                     Monster_show.enemy1_blood_value.setText(blood+"/"+All_blood);
                     parry=0;
              }
              else {
                     parry-=attack;
                     show.enemy1_block.setText(String.valueOf(parry));
                     NodeFloat.nodeFloat("格挡",Battle.monsterPane);
              }
       }

       public void  getAttackCondition()
       {
              for (int i=0;i<conditions.size();i++)
              {
                     if(conditions.get(i).type.equals("strength"))
                     {
                            this.attack+=conditions.get(i).n;
                     }
                     else if (conditions.get(i).type.equals("weak")) {
                            this.attack=(int)(this.attack*0.75);
                     }


              }

       }



       public void getDefendCondition(Hero hero){
              for(int i=0;i<conditions.size();i++){
                     if(conditions.get(i).type.equals("vulnerable")){
                            hero.attack=(int)(hero.attack*1.5);
                     }
                     else if(conditions.get(i).type.equals("thorns")){
                            if(hero.parry<conditions.get(i).n){
                                   hero.Now_blood-=conditions.get(i).n-hero.parry;

                            }
                            else{hero.parry-=conditions.get(i).n;}

                     }
                     else if (conditions.get(i).type.equals("curl")){
                            this.parry+=conditions.get(i).n;
                            conditions.remove(i);

                     }


              }


       }





//大鳄虫 id 1

       public void dae_movement(int n) {
              switch (n) {
                     case 0: {
                            nextParry=0;
                            nextAttack = 11;
                            node_movement=null;
                            break;

                     }
                     case 1: {
                            this.nextAttack = 7;
                            this.nextParry = 5;
                            i=1;
                            node_movement="格挡";
//
                            break;
                     }
                     case 2: {
                            this.nextParry = 6;
                            show.enemy1_block.setText(String.valueOf(this.parry));
                            Monster_show.enemy1_Bar.setStyle("-fx-accent:rgb(102,204,255)");
                            conditions.add(new Condition("strength", 3));
                            node_movement="力量";
                            i=1;
                            break;
                     }

              }


       }

       //邪教徒 id 2
       public void cultust_movement(int n) {
              switch (n) {
                     case 0: {
                            this.nextAttack = 6;
                            node_movement=null;
                            break;
                     }
                     case 1: {
                            this.nextAttack=0;
                            boolean ishave=false;
                            int x=0;
                            for(int i=0;i<this.conditions.size();i++){
                                   if(this.conditions.get(i).type.equals("ritual")){
                                          ishave=true;
                                          x=i;

                                   }

                            }
                            if(ishave){
                                   this.conditions.get(x).n+=1;
                            }
                            else {
                                   this.conditions.add(new Condition("ritual", 1));
                            }
                            i=1;
                            node_movement="仪式";
                     }
              }

       }


       //尖刺史莱姆 id 3
       public void spikeslime_movement(int n) {
              switch (n) {
                     case 0:
                            this.nextAttack = 16;
                            node_movement=null;
                            break;
                     case 1: {
                            //舔舔
                            Monster.nextAttack=0;
                            break;
                     }


              }
       }

       //虱虫 id 4
       public void red_louse_movement(int n) {
              switch (n) {
                     case 0: {
                            Monster.nextAttack = 7;
                            node_movement=null;

                            break;

                     }
                     case 1: {
                            Monster.nextAttack=0;
                            this.conditions.add(new Condition("strength", 3));
                            i=1;
                            node_movement="力量";
                            break;
                     }
                     case 2: {
                            //吐网
                            break;
                     }


              }

       }

//抢劫的(偷钱) id 5

       public void looter_movement(int n) {
              switch (n) {
                     case 0: {
                            this.nextAttack = 10;
                            node_movement=null;
                            break;

                     }
                     case 1: {
                            this.nextAttack = 12;
                            break;
                     }
                     case 2: {
                            this.nextParry = 6;
                            node_movement="格挡";
                            show.enemy1_block.setText(String.valueOf(this.parry));
                            i=1;
                            Monster_show.enemy1_Bar.setStyle("-fx-accent:rgb(102,204,255)");
                            break;
                     }


              }
       }

       //蘑菇怪 id 7
       public void mashroom_movement(int n) {
              switch (n) {
                     case 0:{
                            this.nextAttack = 6;
                            node_movement=null;
                            break;}
                     case 1:{
                            boolean ishave=false;
                            int x=0;
                            for(int i=0;i<this.conditions.size();i++){
                                   if(this.conditions.get(i).type.equals("strength")){
                                          ishave=true;
                                          x=i;

                                   }

                            }
                            if(ishave){
                                   this.conditions.get(x).n+=3;
                            }
                            else {
                                   this.conditions.add(new Condition("strength", 3));
                            }
                            i=1;
                            node_movement="力量";
                            break;
                     }
              }

       }


//精英怪

       //地精大块头 id 8
       public void Gremlin_Nob_movement(int n){
              switch (n){
                     case 0:
                     { boolean ishave=false;
                            int x=0;
                            for(int i=0;i<this.conditions.size();i++){
                                   if(this.conditions.get(i).type.equals("enrage")){
                                          ishave=true;
                                          x=i;

                                   }

                            }
                            if(ishave){
                                   this.conditions.get(x).n+=2;
                            }
                            else {
                                   this.conditions.add(new Condition("enrage", 2));
                            }
                            i=1;
                            node_movement="易怒";
                       break;}
                     case 1:
                     {
                            this.nextAttack=16;
                            node_movement=null;



                            break;}

                     case 2:
                     { this.nextAttack=14;
                     break;}


              }

       }


       //乐加韦林 id 9
       public void Lagavulin_movement(int n){
              switch (n){
                     case 0:{
                            //沉睡
                     this.nextParry=8;
                     this.conditions.add(new Condition("metallicize",8));
                            i=1;
                            NodeFloat.nodeFloat("金属化",Monster.show);
                     break;

                     }

                     case 1:{
                     this.nextAttack=18;
                            node_movement=null;
                     break;
                     }
                     case 2:{
                            //添加效果
                            break;
                     }

              }


       }
   //哨位 id 10
       public void  sentry_movement(int n){
              switch (n){
                     case 0:{
                            this.conditions.add(new Condition("artifact",1));

                            NodeFloat.nodeFloat("人工制品",Monster.show);
                            break;
                     }
                     case 1:{
                            this.nextAttack=9;
                            break;
                     }
                     case 2:{

                     //丢混乱牌
                            break;
                     }

              }

       }











}















