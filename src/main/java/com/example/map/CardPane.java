package com.example.map;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class CardPane extends AnchorPane {
    public int id;
    public int energy;
    private Label cardType;
    private String cardTypePath;
    private Label nameLabel;
    private Label typeLabel;
    private Label detailLabel;
    private Label consumeLabel;
    private Label imageLabel;
    private int type;

    private int mainEffectValue;
    public String otherEffectType=null;
    public int otherEffectValue;
    //创建空卡，输入职业（卡牌颜色），卡牌稀有度
    CardPane(int career,int rare)
    {
        super();
        setPrefSize(120,160);
        Font mainFont=Font.loadFont(MainApplication.fontPath,10);
        Font typeFont=Font.loadFont(MainApplication.fontPath,6);

        cardType=new Label();
        cardType.setPrefSize(120,160);
        if (career==1)
        {
            if (rare==1)
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/iron_card1.png").toExternalForm();
            }
            else if (rare==2)
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/iron_card2.png").toExternalForm();
            }
            else
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/iron_card3.png").toExternalForm();
            }
        }
        else if (career==2)
        {
            if (rare==1)
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/silent_card1.png").toExternalForm();
            }
            else if (rare==2)
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/silent_card2.png").toExternalForm();
            }
            else
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/silent_card3.png").toExternalForm();
            }
        }
        else
        {
            if (rare==1)
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/defect_card1.png.png").toExternalForm();
            }
            else if (rare==2)
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/defect_card2.png.png").toExternalForm();
            }
            else
            {
                cardTypePath=CardPane.class.getResource("image/game_pics/defect_card3.png.png").toExternalForm();
            }
        }
        cardType.setStyle("-fx-background-image: url('"+cardTypePath+"');-fx-background-size: 120px 160px");

        nameLabel=new Label();
        nameLabel.setPrefSize(120,30);
        nameLabel.setLayoutY(5);
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setFont(mainFont);
        nameLabel.setStyle("-fx-text-fill: rgb(255,246,226)");

        typeLabel=new Label();
        typeLabel.setPrefSize(120,10);
        typeLabel.setLayoutY(84);
        typeLabel.setAlignment(Pos.CENTER);
        typeLabel.setFont(typeFont);

        detailLabel=new Label();
        detailLabel.setPrefSize(80,40);
        detailLabel.setLayoutX(20);
        detailLabel.setLayoutY(100);
        detailLabel.setAlignment(Pos.CENTER);
        detailLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
        detailLabel.setWrapText(true);
        detailLabel.setFont(mainFont);

        consumeLabel=new Label();
        consumeLabel.setPrefSize(20,20);
        consumeLabel.setLayoutX(3);
        consumeLabel.setLayoutY(3);
        consumeLabel.setAlignment(Pos.CENTER);
        consumeLabel.setFont(mainFont);
        consumeLabel.setStyle("-fx-text-fill: rgb(255,246,226);-fx-font-weight: bold");

        imageLabel=new Label();
        imageLabel.setPrefSize(100,80);
        imageLabel.setLayoutX(10);
        imageLabel.setLayoutY(20);

        getChildren().addAll(imageLabel,cardType,nameLabel,typeLabel,detailLabel,consumeLabel);
        setStyle("-fx-background-color: transparent");
        addListener();
    }
    //编号顺序为职业(1)、稀有度(1)、类型(1)、卡面(2)，如11102表示战士、普通卡、攻击卡、02号卡
    CardPane(int number)
    {
        super();
        id=number;
        String name=AccountDao.getCardName(number);
        String detail=AccountDao.getCardDescribe(number);

        setPrefSize(120,160);
        Font mainFont=Font.loadFont(MainApplication.fontPath,10);
        Font typeFont=Font.loadFont(MainApplication.fontPath,6);


        cardType=new Label();
        cardType.setPrefSize(120,160);
        if (number/1000==11)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/iron_card1.png").toExternalForm();
        }
        else if (number/1000==12)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/iron_card2.png").toExternalForm();
        }
        else if (number/1000==13)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/iron_card3.png").toExternalForm();
        }
        else if (number/1000==21)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/silent_card1.png").toExternalForm();
        }
        else if (number/1000==22)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/silent_card2.png").toExternalForm();
        }
        else if (number/1000==23)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/silent_card3.png").toExternalForm();
        }
        else if (number/1000==31)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/defect_card1.png").toExternalForm();
        }
        else if (number/1000==32)
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/defect_card2.png").toExternalForm();
        }
        else
        {
            cardTypePath=CardPane.class.getResource("image/game_pics/defect_card3.png").toExternalForm();
        }
        cardType.setStyle("-fx-background-image: url('"+cardTypePath+"');-fx-background-size: 120px 160px");

        typeLabel=new Label();
        typeLabel.setPrefSize(120,10);
        typeLabel.setLayoutY(84);
        typeLabel.setAlignment(Pos.CENTER);
        typeLabel.setFont(typeFont);
        int i=number/1000-number/10000*10;
        if (i==1)
        {
            typeLabel.setText("攻击");
        }
        else if (i==2)
        {
            typeLabel.setText("技能");
        }
        else if (i==3)
        {
            typeLabel.setText("能力");
        }
        else {
            typeLabel.setText("未知");
        }

        //数据库取数据





        //能量消耗
        consumeLabel=new Label();
        consumeLabel.setPrefSize(20,20);
        consumeLabel.setLayoutX(3);
        consumeLabel.setLayoutY(3);
        consumeLabel.setAlignment(Pos.CENTER);
        consumeLabel.setFont(mainFont);
        consumeLabel.setText(String.valueOf(AccountDao.getCardPower(number)));

        //卡名
        nameLabel=new Label();
        nameLabel.setPrefSize(120,30);
        nameLabel.setLayoutY(5);
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setFont(mainFont);
        nameLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
        nameLabel.setText(AccountDao.getCardName(number));
        detailLabel=new Label();
        detailLabel.setPrefSize(80,40);
        detailLabel.setLayoutX(20);
        detailLabel.setLayoutY(100);
        detailLabel.setAlignment(Pos.CENTER);
        detailLabel.setStyle("-fx-text-fill: rgb(255,246,226)");
        detailLabel.setWrapText(true);
        detailLabel.setFont(mainFont);
        detailLabel.setText(AccountDao.getCardDescribe(number));
        imageLabel=new Label();
        imageLabel.setPrefSize(100,80);
        imageLabel.setLayoutX(10);
        imageLabel.setLayoutY(20);
        String s=CardPane.class.getResource("image/game_pics/iron/cardimage/"+AccountDao.getCardID(number)+".png").toExternalForm();
        imageLabel.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("image/game_pics/iron/cardimage/"+AccountDao.getCardID(number)+".png").toExternalForm()), BackgroundRepeat.NO_REPEAT
                ,BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,null)));
        imageLabel.setStyle("-fx-background-image:url('"+s+"');-fx-background-size: 100px 80px");


        type=Integer.parseInt(AccountDao.getCardType(number));
        energy=Integer.parseInt(AccountDao.getCardPower(number));
        mainEffectValue=Integer.parseInt(AccountDao.getCardMainValue(number));

        otherEffectType=AccountDao.getCardOtherEffect(number);

        if(AccountDao.getCardOtherEffectValue(number)!=null){
            otherEffectValue=Integer.parseInt(AccountDao.getCardOtherEffectValue(number));


        };

        getChildren().addAll(imageLabel,cardType,nameLabel,typeLabel,detailLabel,consumeLabel);
        setStyle("-fx-background-color: transparent");
     //   setCard();
        addListener();
    }


    void addListener()
    {
        setOnMouseEntered(event -> {
            setStyle("-fx-scale-x: 1.3;-fx-scale-y: 1.3;-fx-background-color: transparent");
        });
        setOnMouseExited(event -> {
            setStyle("-fx-background-color: transparent");
        });
    }
    //升级卡，配套setEffect函数使用
    void levelUp()
    {
        String oldText=nameLabel.getText();
        nameLabel.setText(oldText+"+");
        nameLabel.setStyle("-fx-text-fill: rgb(112,224,0)");
        consumeLabel.setStyle("-fx-text-fill: rgb(112,224,0)");
    }
    //设置卡牌名称，卡牌介绍，卡牌类型，费用，卡牌图片
    void setCard(String name,String detail,String imageurl)
    {
        nameLabel.setText(name);
        detailLabel.setText(detail);
        imageLabel.setStyle("-fx-background-image: url('"+imageurl+"');-fx-background-size: 100px 80px");
    }
    int getMainEffectValue()
    {
        return mainEffectValue;
    }
    String getOtherEffectType()
    {
        return otherEffectType;
    }
    int getOtherEffectValue()
    {
        return otherEffectValue;
    }
    public int getType(){
        return this.type;
    }





}
