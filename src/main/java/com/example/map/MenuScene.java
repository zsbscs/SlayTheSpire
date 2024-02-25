package com.example.map;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class MenuScene extends Scene {
    public static int choose=0;
    public static GameScene gameScene=null;
    public static String cursorPath=MenuScene.class.getResource("image/menu_pics/cursor.png").toExternalForm();
    public static AnchorPane menuPane=null;
    MenuScene(boolean ifAlive)
    {
        super(new AnchorPane(),1000,600);
        setCursor(new ImageCursor(new Image(cursorPath)));
        AnchorPane mainPane=(AnchorPane) getRoot();
        menuPane=mainPane;
        String coverPath=MenuScene.class.getResource("image/menu_pics/动画.gif").toExternalForm();
        AnchorPane usePane=new AnchorPane();
        usePane.setPrefSize(1000,600);
        usePane.setStyle("-fx-background-image: url('"+coverPath+"');-fx-background-size: 1000px 600px");

        //基本布局

        AnchorPane blackPane=new AnchorPane();
        blackPane.setPrefSize(1000,600);
        blackPane.setStyle("-fx-background-color: rgba(0,0,0,0.8)");
        blackPane.setVisible(false);
        Label titleLabel=new Label();
        titleLabel.setPrefSize(400,300);
        titleLabel.setLayoutX(300);
        titleLabel.setLayoutY(130);
        String titlePath=MenuScene.class.getResource("image/menu_pics/title.png").toExternalForm();
        titleLabel.setStyle("-fx-background-image: url('"+titlePath+"');-fx-background-size: 400px 300px");
        AnchorPane nameSettingCover=new AnchorPane();
        nameSettingCover.setPrefSize(1000,480);
        nameSettingCover.setLayoutY(120);
        Button btnName=new Button("YourName");
        btnName.setPrefSize(120,60);
        btnName.setLayoutX(20);
        btnName.setLayoutY(10);
        Font nameFont=Font.loadFont(MainApplication.fontPath,15);
        btnName.setFont(nameFont);
        btnName.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226)");
        btnName.setOnMouseEntered(event -> {
            btnName.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(112,224,0)");
        });
        btnName.setOnMouseExited(event -> {
            btnName.setStyle("-fx-background-color: transparent;-fx-text-fill: rgb(255,246,226)");
        });
        AnchorPane nameSettingPane=new AnchorPane();
        nameSettingPane.setPrefSize(300,400);
        nameSettingPane.setLayoutX(350);
        String namePicPath=MenuScene.class.getResource("image/menu_pics/settingBack.png").toExternalForm();
        nameSettingPane.setStyle("-fx-background-image: url('"+namePicPath+"');-fx-background-size: 300px 400px;-fx-background-color: transparent");
        Font messageFont=Font.loadFont(MainApplication.fontPath,20);
        Label tipLabel=new Label("输入你的名字");
        tipLabel.setPrefSize(200,50);
        tipLabel.setLayoutX(50);
        tipLabel.setLayoutY(80);
        tipLabel.setAlignment(Pos.CENTER);
        tipLabel.setFont(messageFont);
        tipLabel.setStyle("-fx-text-fill: rgb(239,200,81)");
        TextField nameField=new TextField();
        nameField.setPrefSize(200,50);
        nameField.setLayoutX(50);
        nameField.setLayoutY(150);
        nameField.setFont(messageFont);
        nameSettingPane.getChildren().addAll(tipLabel,nameField);
        Button cancelButton=new Button("取消");
        cancelButton.setPrefSize(250,50);
        cancelButton.setLayoutX(408);
        cancelButton.setLayoutY(-10);
        cancelButton.setAlignment(Pos.CENTER);
        Font cancelFont=Font.loadFont(MainApplication.fontPath,18);
        cancelButton.setFont(cancelFont);
        String abandonPath=GameScene.class.getResource("image/game_pics/abandon.png").toExternalForm();
        cancelButton.setStyle("-fx-background-image: url('"+abandonPath+"');-fx-background-size: 250px 50px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        cancelButton.setOnMouseEntered(event -> {
            String abandonPathX=GameScene.class.getResource("image/game_pics/abandonX.png").toExternalForm();
            cancelButton.setStyle("-fx-background-image: url('"+abandonPathX+"');-fx-background-size: 250px 50px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        cancelButton.setOnMouseExited(event -> {
            cancelButton.setStyle("-fx-background-image: url('"+abandonPath+"');-fx-background-size: 250px 50px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        cancelButton.setOnAction(event -> {
            blackPane.setVisible(false);
            nameSettingCover.setVisible(false);
        });
        Button enterButton=new Button("确认");
        enterButton.setPrefSize(320,200);
        enterButton.setLayoutX(440);
        enterButton.setLayoutY(190);
        enterButton.setAlignment(Pos.BOTTOM_CENTER);
        Font enterFont=Font.loadFont(MainApplication.fontPath,20);
        enterButton.setFont(enterFont);
        String quitPath=GameScene.class.getResource("image/game_pics/quitButton.png").toExternalForm();
        enterButton.setStyle("-fx-background-image: url('"+quitPath+"');-fx-background-size:320px 200px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        enterButton.setOnMouseEntered(event -> {
            String quitPathX=GameScene.class.getResource("image/game_pics/quitButtonX.png").toExternalForm();
            enterButton.setStyle("-fx-background-image: url('"+quitPathX+"');-fx-background-size:320px 200px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        enterButton.setOnMouseExited(event -> {
            enterButton.setStyle("-fx-background-image: url('"+quitPath+"');-fx-background-size:320px 200px;-fx-background-color: transparent;-fx-text-fill: rgb(239,200,81)");
        });
        enterButton.setOnAction(event -> {
            blackPane.setVisible(false);
            nameSettingCover.setVisible(false);
            String newName=nameField.getText();
            nameField.clear();
            btnName.setText(newName);
        });
        nameSettingCover.getChildren().addAll(nameSettingPane,cancelButton,enterButton);
        nameSettingCover.setVisible(false);
        btnName.setOnAction(event -> {
            blackPane.setVisible(true);
            nameSettingCover.setVisible(true);
        });
        AnchorPane changePane=new AnchorPane();
        changePane.setPrefSize(1000,600);
        changePane.setStyle("-fx-background-color: black");
        FadeTransition fadeTransition=new FadeTransition(Duration.seconds(1),usePane);
        fadeTransition.setToValue(0);

        //选择界面

        AnchorPane choosePane=new AnchorPane();
        AnchorPane choosePane2=new AnchorPane();
        AnchorPane choosePane3=new AnchorPane();
        choosePane.setPrefSize(1000,600);
        choosePane2.setPrefSize(1000,600);
        choosePane3.setPrefSize(1000,600);
        String singlePath=MenuScene.class.getResource("image/menu_pics/standard.jpg").toExternalForm();
        ChoosePane single=new ChoosePane(0,singlePath,"标准模式","启程去屠戮这座高塔。");
        single.setLayoutX(250);
        single.setLayoutY(175);
        String multiPath=MenuScene.class.getResource("image/menu_pics/multi.jpg").toExternalForm();
        ChoosePane multi=new ChoosePane(1,multiPath,"多人模式","尚未开放。");
        multi.setLayoutX(550);
        multi.setLayoutY(175);
        multi.setDisable(true);
        String cardPath=MenuScene.class.getResource("image/menu_pics/card.jpg").toExternalForm();
        ChoosePane card=new ChoosePane(0,cardPath,"卡牌总览","查看你在高塔中遇见过的所有卡牌。");
        card.setLayoutX(150);
        card.setLayoutY(175);
        String remainsPath=MenuScene.class.getResource("image/menu_pics/relics.jpg").toExternalForm();
        ChoosePane remains=new ChoosePane(1,remainsPath,"遗物收集","检阅你的游戏中获取过的各种遗物与物件。");
        remains.setLayoutX(400);
        remains.setLayoutY(175);
        String potionPath=MenuScene.class.getResource("image/menu_pics/potion.jpg").toExternalForm();
        ChoosePane potion=new ChoosePane(2,potionPath,"药水研究所","查看你在高塔中找到过的各种药水。");
        potion.setLayoutX(650);
        potion.setLayoutY(175);
        String settingPath=MenuScene.class.getResource("image/menu_pics/input_settings.jpg").toExternalForm();
        ChoosePane setting=new ChoosePane(0,settingPath,"游戏设置","改变游戏的分辨率和其他各种设定。");
        setting.setLayoutX(250);
        setting.setLayoutY(175);
        String makerPath=MenuScene.class.getResource("image/menu_pics/credits.jpg").toExternalForm();
        ChoosePane maker=new ChoosePane(1,makerPath,"制作人员","来看一看所有为游戏作出贡献的人们！");
        maker.setLayoutX(550);
        maker.setLayoutY(175);
        choosePane.getChildren().addAll(single,multi);
        choosePane2.getChildren().addAll(card,remains,potion);
        choosePane3.getChildren().addAll(setting,maker);
        choosePane.setVisible(false);
        choosePane2.setVisible(false);
        choosePane3.setVisible(false);
        Button btnReturn=new Button("返回");
        btnReturn.setPrefSize(160,50);
        btnReturn.setLayoutX(-160);
        btnReturn.setLayoutY(450);
        Font menuFont=Font.loadFont(MainApplication.fontPath,18);
        btnReturn.setFont(menuFont);
        String imagePath=MenuScene.class.getResource("image/menu_pics/cancelButton.png").toExternalForm();
        btnReturn.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        btnReturn.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            String imagePathX=MenuScene.class.getResource("image/menu_pics/cancelButtonX.png").toExternalForm();
            btnReturn.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePathX+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        });
        btnReturn.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnReturn.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        });
        Button btnGO=new Button("启程");
        btnGO.setPrefSize(160,50);
        btnGO.setLayoutX(1000);
        btnGO.setLayoutY(450);
        btnGO.setFont(menuFont);
        String imagePath2=MenuScene.class.getResource("image/menu_pics/confirmButton.png").toExternalForm();
        btnGO.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath2+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        btnGO.addEventHandler(MouseEvent.MOUSE_ENTERED,event -> {
            String imagePath2X=MenuScene.class.getResource("image/menu_pics/confirmButtonX.png").toExternalForm();
            btnGO.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath2X+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        });
        btnGO.addEventHandler(MouseEvent.MOUSE_EXITED,event -> {
            btnGO.setStyle("-fx-background-color: transparent;-fx-background-image: url('"+imagePath2+"');-fx-background-size: 160px 50px;-fx-text-fill: rgb(239,200,81)");
        });
        TranslateTransition returnTransition=new TranslateTransition(Duration.seconds(0.2),btnReturn);
        TranslateTransition goTransition=new TranslateTransition(Duration.seconds(0.2),btnGO);
        //选项界面
        AnchorPane menuPane=new AnchorPane();
        menuPane.setPrefSize(250,160);
        menuPane.setLayoutX(-200);
        menuPane.setLayoutY(360);
        TranslateTransition transition=new TranslateTransition(Duration.seconds(0.5),menuPane);
        transition.setToX(250);
        transition.play();
        TranslateTransition up=new TranslateTransition(Duration.seconds(0.2));
        TranslateTransition up2=new TranslateTransition(Duration.seconds(0.2));
        TranslateTransition up3=new TranslateTransition(Duration.seconds(0.2));
        up.setToY(-50);
        up2.setToY(-50);
        up3.setToY(-50);
        TranslateTransition down=new TranslateTransition(Duration.seconds(0.01));
        TranslateTransition down2=new TranslateTransition(Duration.seconds(0.01));
        TranslateTransition down3=new TranslateTransition(Duration.seconds(0.01));
        down.setToY(0);
        down2.setToY(0);
        down3.setToY(0);
        MenuButtonPane btnStart;
        if (ifAlive)
        {
            btnStart=new MenuButtonPane("继续游戏");
            btnStart.setLayoutX(0);
            btnStart.setLayoutY(0);
        }
        else
        {
            btnStart=new MenuButtonPane("开始");
            btnStart.setLayoutX(0);
            btnStart.setLayoutY(0);
            btnStart.button.setOnAction(event -> {
                returnTransition.setToX(140);
                returnTransition.play();
                TranslateTransition transition2=new TranslateTransition(Duration.seconds(0.5),menuPane);
                transition2.setToX(0);
                transition2.play();
                blackPane.setVisible(true);
                choosePane.setVisible(true);
                up.setNode(single);
                up2.setNode(multi);
                up.play();
                up2.play();
            });
        }
        MenuButtonPane btnLibrary=new MenuButtonPane("百科大全");
        btnLibrary.setLayoutX(0);
        btnLibrary.setLayoutY(40);
        btnLibrary.button.setOnAction(event -> {
            returnTransition.setToX(140);
            returnTransition.play();
            TranslateTransition transition2=new TranslateTransition(Duration.seconds(0.5),menuPane);
            transition2.setToX(0);
            transition2.play();
            blackPane.setVisible(true);
            choosePane2.setVisible(true);
            up.setNode(card);
            up2.setNode(remains);
            up3.setNode(potion);
            up.play();
            up2.play();
            up3.play();
        });
        MenuButtonPane btnSetting=new MenuButtonPane("设定");
        btnSetting.setLayoutX(0);
        btnSetting.setLayoutY(80);
        btnSetting.button.setOnAction(event -> {
            returnTransition.setToX(140);
            returnTransition.play();
            TranslateTransition transition2=new TranslateTransition(Duration.seconds(0.5),menuPane);
            transition2.setToX(0);
            transition2.play();
            blackPane.setVisible(true);
            choosePane3.setVisible(true);
            up.setNode(setting);
            up2.setNode(maker);
            up.play();
            up2.play();
        });
        MenuButtonPane btnExit=new MenuButtonPane("退出");
        btnExit.setLayoutX(0);
        btnExit.setLayoutY(120);
        btnExit.button.setOnAction(event -> {
            System.exit(0);
        });
        menuPane.getChildren().addAll(btnStart,btnLibrary,btnSetting,btnExit);

        //主要按钮功能实现

        //选角按钮
        HBox characterButton=new HBox();
        characterButton.setPrefSize(1000,100);
        characterButton.setSpacing(40);
        characterButton.setAlignment(Pos.CENTER);
        characterButton.setLayoutY(420);
        characterButton.setVisible(false);
        String ironBack=MenuScene.class.getResource("image/menu_pics/ironcladPortrait.jpg").toExternalForm();
        String silentBack=MenuScene.class.getResource("image/menu_pics/silentPortrait.jpg").toExternalForm();
        String defectBack=MenuScene.class.getResource("image/menu_pics/defectPortrait.jpg").toExternalForm();
        String ironPath=MenuScene.class.getResource("image/menu_pics/ironcladButton.png").toExternalForm();
        String silentPath=MenuScene.class.getResource("image/menu_pics/silentButton.png").toExternalForm();
        String defectPath=MenuScene.class.getResource("image/menu_pics/defectButton.png").toExternalForm();
        String ironPath2=MenuScene.class.getResource("image/menu_pics/ironcladButtonX.png").toExternalForm();
        String silentPath2=MenuScene.class.getResource("image/menu_pics/silentButtonX.png").toExternalForm();
        String defectPath2=MenuScene.class.getResource("image/menu_pics/defectButtonX.png").toExternalForm();
        CharacterChooseButton ironButton=new CharacterChooseButton(ironPath,ironPath2);
        CharacterChooseButton silentButton=new CharacterChooseButton(silentPath,silentPath2);
        CharacterChooseButton defectButton=new CharacterChooseButton(defectPath,defectPath2);
        characterButton.getChildren().addAll(ironButton,silentButton,defectButton);
        single.setOnMouseClicked(event -> {
            choosePane.setVisible(false);
            characterButton.setVisible(true);
            TranslateTransition move=new TranslateTransition(Duration.seconds(0.2),ironButton);
            TranslateTransition move2=new TranslateTransition(Duration.seconds(0.2),silentButton);
            TranslateTransition move3=new TranslateTransition(Duration.seconds(0.2),defectButton);
            move.setFromY(30);
            move.setToY(0);
            move2.setFromY(30);
            move2.setToY(0);
            move3.setFromY(30);
            move3.setToY(0);
            move.play();
            move2.play();
            move3.play();
            ironButton.setOnAction(event2 -> {
                CharacterPane iron=new CharacterPane("铁甲战士",80,99,"铁甲军团残留下的士兵。他出卖自己的灵魂，获得了恶魔的力量。",ironPath,"燃烧之血","在战斗结束时，回复6点生命。",ironBack);
                blackPane.getChildren().add(iron);
                Shake.shake(usePane);
                goTransition.setToX(-140);
                goTransition.play();
                choose=1;
            });
            silentButton.setOnAction(event3 -> {
                CharacterPane silent=new CharacterPane("静默猎手",70,99,"来自雾霾之地的致命女猎手。使用匕首和下毒来消灭对手。",silentPath,"蛇之戒指","在每场战斗开始时，额外抽2张牌。",silentBack);
                blackPane.getChildren().add(silent);
                Shake.shake(usePane);
                goTransition.setToX(-140);
                goTransition.play();
                choose=2;
            });
            defectButton.setOnAction(event4 -> {
                CharacterPane defect=new CharacterPane("故障机器人",75,99,"一具产生了自我意识的战斗型机器人。它装载的远古科技让它可以操控充能球。",defectPath,"破损核心","在每场战斗开始时，生成1个闪电充能球。",defectBack);
                blackPane.getChildren().add(defect);
                Shake.shake(usePane);
                goTransition.setToX(-140);
                goTransition.play();
                choose=3;
            });

        });
        //返回
        btnReturn.setOnAction(event -> {
            returnTransition.setToX(0);
            returnTransition.play();
            goTransition.setToX(0);
            goTransition.play();
            transition.setToX(250);
            transition.play();
            blackPane.setVisible(false);
            if (choosePane.isVisible())
            {
                choosePane.setVisible(false);
                down.setNode(single);
                down2.setNode(multi);
                down.play();
                down2.play();
            }
            else if (choosePane2.isVisible())
            {
                choosePane2.setVisible(false);
                down.setNode(card);
                down2.setNode(remains);
                down3.setNode(potion);
                down.play();
                down2.play();
                down3.play();
            }
            else if (choosePane3.isVisible())
            {
                choosePane3.setVisible(false);
                down.setNode(setting);
                down2.setNode(maker);
                down.play();
                down2.play();
            }
            if (characterButton.isVisible())
            {
                characterButton.setVisible(false);
                blackPane.getChildren().clear();
            }
        });
        //启程
        btnGO.setOnAction(event -> {
            AnchorPane gameScenePane=new AnchorPane();
            gameScenePane.setPrefSize(1000,600);
            gameScenePane.setStyle("-fx-background-color: black");
            gameScene=new GameScene(gameScenePane,btnName.getText(),choose);
            SceneChange.blackTo1To0(mainPane,gameScenePane);
        });
        if (ifAlive)
        {
            btnStart.button.setOnAction(event -> {
                if (gameScene!=null)
                {
                    AnchorPane gameScenePane=new AnchorPane();
                    gameScenePane.setPrefSize(1000,600);
                    gameScenePane.setStyle("-fx-background-color: black");
                    SceneChange.blackTo1To0(mainPane,GameScene.gamePane);
                }
            });
        }
        usePane.getChildren().addAll(btnName,titleLabel,menuPane,blackPane,nameSettingCover,choosePane,choosePane2,choosePane3,characterButton,btnReturn,btnGO);
        mainPane.getChildren().addAll(changePane,usePane);
    }
    public static void backToMenuScene(boolean ifAlive)
    {
        MenuScene newMenu=new MenuScene(ifAlive);
        MainApplication.stage.setScene(newMenu);
    }
}
