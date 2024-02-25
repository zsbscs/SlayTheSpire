package com.example.map;

import javafx.geometry.Pos;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Deck extends VBox {
    public  int energy;
    public Hero hero;
    public HBox[] cardList;
    public int toNextLine=0;
    public int useLine=0;
    public int[] numberList;
    public int cardNumber=0;
    public int useNumber=0;



    Deck(Hero hero)
    {
        super();
        this.hero=hero;
        setPrefSize(1000,2000);
        setSpacing(10);
        setLayoutY(100);
        setAlignment(Pos.TOP_CENTER);
        //默认最大卡牌行数为8
        cardList=new HBox[8];
        numberList=new int[40];
        for (int i=0;i<8;i++)
        {
            cardList[i]=new HBox();
            cardList[i].setAlignment(Pos.CENTER);
            cardList[i].setSpacing(10);
            getChildren().add(cardList[i]);
        }
        setOnScroll(scrollEvent -> {
            if(scrollEvent.isControlDown()){
                setLayoutY(getLayoutY()-30);}
            else
            {
                setLayoutY(getLayoutY()+30);
            }
        });
    }
    void resetDeck()
    {
        setPrefSize(1000,2000);
        setSpacing(10);
        setAlignment(Pos.TOP_CENTER);
        cardNumber=0;
        useNumber=0;
        toNextLine=0;
        useLine=0;
        for (int i=0;i<8;i++)
        {
            cardList[i].getChildren().clear();
        }
        numberList=new int[40];
    }
    void addCard(int number)
    {
        if (toNextLine==5)
        {
            useLine++;
            toNextLine=0;
        }
        CardPane card=new CardPane(number);
        cardList[useLine].getChildren().add(card);
        toNextLine++;
        numberList[cardNumber]=number;
        cardNumber++;
    }

    void addCard(String number)
    {
        if (toNextLine==5)
        {
            useLine++;
            toNextLine=0;
        }
        CardPane card=new CardPane(Integer.parseInt(number));
        cardList[useLine].getChildren().add(card);
        toNextLine=toNextLine+1;
        numberList[cardNumber]=Integer.parseInt(number);
        cardNumber++;
    }

    //用于显示当前卡牌数量
    int getLeaveNumber()
    {
        return cardNumber;
    }

    //抽number张牌,deck为抽牌堆,hands为手牌区域,deck2为弃牌堆
    void getCard(int number, Pane hands, Deck deck2, AnchorPane animationPane,Monster enemy1)
    {
        if (getLeaveNumber()>=number)
        {
            for (int i=0;i<number;i++)
            {
                //获取卡牌编号
                int cardNumber=numberList[0];
                CardPane card=new CardPane(cardNumber);
                useCard useCard= new useCard(
                        card,
                        (HBox) hands,
                        animationPane,enemy1
                        ,hero);
                card.setOnMouseDragged(event-> {
                    useCard.setDragged();
                });
                card.setOnMouseReleased(event-> {
                    useCard.setRelease(deck2);
                });
                if(card.energy!=0){
                    this.energy=card.energy;
                }
                //手牌布局添加上面的卡牌

                deleteCard(cardNumber);
                hands.getChildren().add(card);
            }
        }
        //没抽够则需要洗牌再抽
        else
        {
            int getNumber=0;
            for (int i=0;i<cardNumber;getNumber++)
            {
                int cardNumber=numberList[0];
                CardPane card=new CardPane(cardNumber);
                useCard useCard= new useCard(
                        card,
                        (HBox) hands,
                        animationPane,enemy1
                        ,hero);
                card.setOnMouseDragged(event-> {
                    useCard.setDragged();
                });
                card.setOnMouseReleased(event-> {
                    useCard.setRelease(deck2);
                });
                if(card.energy!=0){
                    this.energy=useCard.energy;
                }
                deleteCard(cardNumber);
                hands.getChildren().add(card);
            }
            //弃牌堆洗牌进入抽牌堆
            wash(this,deck2);
            Battle.baseNumberLabel2.setText("0");
            upsetNumberList();
            getCard(number-getNumber,hands,deck2,animationPane,enemy1);
        }
    }
    void deleteCard(int number)
    {
        Deck deck=new Deck(hero);
        deck.initFrom(this);
        resetDeck();
        boolean notDelete=true;
        for (int i=0;i<deck.cardNumber;i++)
        {
            if (notDelete&&deck.numberList[i]==number)
            {
                notDelete=false;
            }
            else
            {
                addCard(deck.numberList[i]);
            }
        }
    }

    //洗牌,deck为抽牌堆,deck2为弃牌堆
    static void wash(Deck deck,Deck deck2)
    {
        deck.initFrom(deck2);
        deck.upsetNumberList();
        deck2.resetDeck();
    }
    //战斗开始初始化抽牌堆
    void initFrom(Deck deck)
    {
        for (int i=0;i<deck.cardNumber;i++)
        {
            addCard(deck.numberList[i]);
        }
    }

    //打乱牌库
    void upsetNumberList()
    {
        for(int i = 0;i<cardNumber;i++)
        {
            int randomNumber = cardNumber-1-(int)(Math.random()*(cardNumber));
            int tem = numberList[i];
            numberList[i] = numberList[randomNumber];
            numberList[randomNumber] = tem;
        }
    }
}