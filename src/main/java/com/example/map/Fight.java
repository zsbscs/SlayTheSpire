package com.example.map;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Fight {
    int round;

    public static void getMRoundCondition(Monster monster){
        boolean ishave=false;
        int count=0;
        for (int i=0;i<monster.conditions.size();i++){

                if(monster.conditions.get(i).type.equals("metallicize")){
                monster.parry+=monster.conditions.get(i).n;

            }
                else if(monster.conditions.get(i).type.equals("ritual")){
                    for (int x=0;x<monster.conditions.size();x++){
                        if(monster.conditions.get(x).type.equals("strength")){
                           ishave=true;
                           count=x;

                        }
                        else {ishave=false;}

                    }
                    if(ishave){
                        monster.conditions.get(count).n+=monster.conditions.get(i).n;}

                    else
                    {
                        monster.conditions.add(new Condition("strength",monster.conditions.get(i).n));}

                }
                for(int c=0;c<monster.conditions.size();c++){
                    if(monster.conditions.get(c).n<0){
                        monster.conditions.get(c).n++;

                    }
                    else if(monster.conditions.get(c).n>0){
                        monster.conditions.get(c).n--;

                    }
                    else if(monster.conditions.get(c).n==0){
                        monster.conditions.remove(c);


                    }


                }



        }




    }
    public static void getHRoundCondition(Hero hero){
        for(int i=0;i<hero.conditions.size();i++){
            if(hero.conditions.get(i).type.equals("metallicize")){
                hero.parry+=hero.conditions.get(i).n;

            }
            else if(hero.conditions.get(i).type.equals("Demon_Form")){
               for (int x=0;x<hero.conditions.size();x++){
                   if(hero.conditions.get(x).type.equals("strength")){
                       hero.conditions.get(x).n+=hero.conditions.get(i).n;

                   }

               }
                hero.conditions.add(new Condition("strength",hero.conditions.get(i).n));
            }


        }
        for(int c=0;c<hero.conditions.size();c++){
            if(hero.conditions.get(c).n<0){
                hero.conditions.get(c).n++;

            }
            else if(hero.conditions.get(c).n>0){
                hero.conditions.get(c).n--;

            }
            else if(hero.conditions.get(c).n==0){
                hero.conditions.remove(c);


            }



    }}

    public static void useCard(Hero hero,Monster monster,CardPane card){

            switch (card.getType()){

                case 1:{
                        boolean bool=false;
                        int num=0;
                        hero.attack+=card.getMainEffectValue();
                    if(card.otherEffectType!=null)
                    {
                        if(card.otherEffectType.equals("weak"))
                        {
                            monster.conditions.add(new Condition("weak",card.otherEffectValue));
                        }
                        else if (card.otherEffectType.equals("vulnerable"))
                        {
                            monster.conditions.add(new Condition("vulnerable", -(card.otherEffectValue)));
                        }
                        else if(card.otherEffectType.equals("blood"))
                        {
                            Hero.Now_blood-=card.otherEffectValue;
                            int now_blood=(GameScene.hp.charAt(0)-48)*10+(GameScene.hp.charAt(1)-48);
                            int all_blood=(GameScene.hp.charAt(3)-48)*10+(GameScene.hp.charAt(4)-48);
                            now_blood-=card.otherEffectValue;
                            String s1=String.valueOf(now_blood);
                            String s2=String.valueOf(all_blood);
                            GameScene.hp=s1+"/"+s2;
                            GameScene.hpLabel.setText(GameScene.hp);
                            Shake.shake(GameScene.hpLabel);
                            hero.show.progressBar.setProgress((now_blood+0.0)/(all_blood+0.0));
                            Hero_show.blood_value.setText(now_blood+"/"+all_blood);

                        }
                        else if (card.otherEffectType.equals("parry"))
                        {
                            hero.parry+=card.otherEffectValue;
                        }
                        else if (card.otherEffectType.equals("strength"))
                        {
                            for (int i=0;i<monster.conditions.size();i++)
                            {
                                if(monster.conditions.get(i).type.equals("strength"))
                                {
                                    bool=true;
                                    num=i;
                                }
                            }
                            if(bool)
                                {
                                    monster.conditions.get(num).n-=card.otherEffectValue;
                                }
                                else
                                {
                                    monster.conditions.add(new Condition("strength",0-(card.otherEffectValue)));
                                }
                        }
                    }


                    hero.Attack();
                    monster.Defend(hero);

                    break;

                }
                case 2:{
                    boolean bool=false;
                    int num=0;
                    hero.parry+=card.getMainEffectValue();
                    if(card.otherEffectType!=null){
                        if(card.otherEffectType.equals("weak")){
                            monster.conditions.add(new Condition("weak",card.otherEffectValue));


                        }

                        else if (card.otherEffectType.equals("vulnerable")) {
                            monster.conditions.add(new Condition("vulnerable", card.otherEffectValue));
                        }
                        else if(card.otherEffectType.equals("blood")){
                            Hero.Now_blood-=card.otherEffectValue;

                        } else if (card.otherEffectType.equals("parry")) {
                            hero.parry+=card.otherEffectValue;


                        }
                        else if (card.otherEffectType.equals("strength")){
                            for (int i=0;i<monster.conditions.size();i++){
                                if(monster.conditions.get(i).type.equals("strength")){
                                    bool=true;
                                    num=i;

                                }


                            }
                            if(bool){
                                monster.conditions.get(num).n-=card.otherEffectValue;

                            }
                            else {
                                monster.conditions.add(new Condition("strength",0-(card.otherEffectValue)));
                            }

                        }}
                        break;

                }
                case 3:{

                    break;

                }


            }







    }
    public Fight(){


    }





}
