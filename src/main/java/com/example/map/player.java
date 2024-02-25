package com.example.map;

public class player {
    private static String ID ;

    public static String getID() {
        return ID;
    }

    public static void setID(String ID) {
        player.ID = ID;
    }

    public static int getFile() {
        return File;
    }

    public static void setFile(int file) {
        File = file;
    }

    public static String getUserName() {
        return UserName;
    }

    public static void setUserName(String userName) {
        UserName = userName;
    }

    public static String getPassWord() {
        return PassWord;
    }

    public static void setPassWord(String passWord) {
        PassWord = passWord;
    }

    private static int File;

    private static String UserName;

    private static String PassWord;


}
