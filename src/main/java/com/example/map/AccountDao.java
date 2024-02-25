package com.example.map;





import java.sql.*;


public class AccountDao {
    static Connection cn=DBConnection.getConnection();



    //检查登录并且加载账号
        public static boolean CheckLogin(String username,String password){
            boolean i =false;


            try {
                Statement statement = cn.createStatement();

                String sqlCount= "select  count(*) as num from player where UserName = '%s' and Password = '%s'";
                String sql1 = String.format(sqlCount,username,password);
               ResultSet resultSet= statement.executeQuery(sql1);
               resultSet.next();
              if(resultSet.getInt("num")==1){
                  i=true;

                  resultSet.close();

                  String sql ="select * from player where UserName = '%s' and Password = '%s'";
                  String sql2 = String.format(sql,username,password);

                  ResultSet resultSet1 = statement.executeQuery(sql2);

                  resultSet1.next();

                  player.setFile(resultSet1.getInt("File"));
                  player.setID(resultSet1.getString("ID"));
                  file.setID(resultSet1.getInt("File"));
              }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return i;
        }

//读取存档
        public static void readArchived(int File){


            try {
                Statement statement = cn.createStatement();
                String sql = "select * from file where ID ='%s'";
                String sql1 = String.format(sql,File);
                ResultSet resultSet = statement.executeQuery(sql1);

                resultSet.next();
                file.setHealth(resultSet.getString("health"));
                file.setMoney(resultSet.getString("money"));
                file.setLayer1ID(resultSet.getInt("layer1ID"));

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }
//读取关卡
        public static void readLevel(int layer1ID){

            try {
                Statement statement = cn.createStatement();

                String sql = "select * from layer1 where layerID = '%s'";
                String sql1 = String.format(sql,layer1ID);

                System.out.println(sql1);

                ResultSet resultSet = statement.executeQuery(sql1);

                resultSet.next();

                for(int i = 1;i<15;i++){
                    String s = "L%s";
                    String s1 = String.format(s,i);
                    layer1.level[i] =  Integer.parseInt( resultSet.getString(s1));
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        //获取表的行数
        public static int getColum(String tableName) {
            int i = 0;



            try {
                Statement statement = cn.createStatement();

                String sql = "select count(*) as num from %s";
                String sql1 = String.format(sql, tableName);


                ResultSet resultSet = statement.executeQuery(sql1);

                resultSet.next();

                i = resultSet.getInt("num");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return i;
        }




        //重置存档
        public static boolean resetFile(String playerID){

            int colum=0;



            int num1 = getColum("file");
             int num2 = getColum("layer1");

            try {
                //更新player中的fileID值
                Statement statement = cn.createStatement();

                String sql = "update player set File = '%s' where ID = '%s'";
                String sql1 = String.format(sql,String.valueOf(num1+1),playerID);

                colum +=   statement.executeUpdate(sql1);

                //在file创建新的一行
                String sql2 = "insert into file (ID,layer1ID,money,health) values ('%s','%s',default,default)";
                String sqlFile = String.format(sql2,String.valueOf(num1+1),String.valueOf(num2+1));
               // System.out.println(sqlFile);
                colum +=  statement.executeUpdate(sqlFile);

                //在layer1中创建新的一行

                String sql3 = "insert into layer1 (layerID) values ('%s')";
                String sqlLayer1 = String.format(sql3,String.valueOf(num2+1));
              //  System.out.println(sqlLayer1);
                colum +=  statement.executeUpdate(sqlLayer1);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if (colum ==3)return true;
            else return false;
        }


        //改变player表中的ID，File，
        public static boolean changePlayerID(String newID)
        {

            boolean i = false;

            try {
                Statement statement = cn.createStatement();

                 String sql = ("update player set ID = '%s' where ID = '%s'");

                 String sql1 = String.format(sql,newID,player.getID());

                 if(statement.executeUpdate(sql1)>=1){
                     i = true;
                 };

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return i;
        }

        //用编号获取卡牌的信息
        public  static String getCardPower(int ID){


            String result ;

            try {
                Statement statement = cn.createStatement();

                String sql = "select * from card where ID2 = '%s'";
                String sql1 = String.format(sql,String.valueOf(ID));
                ResultSet resultSet = statement.executeQuery(sql1);

                resultSet.next();

                result=resultSet.getString("power");

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return result;
        }
    public  static String getCardType(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("type");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public  static String getCardName(int ID2){

        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID2));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("name");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardID2(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("ID2");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public  static String getCardOtherEffect(int ID2){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID2));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("effect");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public  static String getCardOtherEffectValue(int ID2){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID2));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("effectvalue");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    public  static String getCardID(int ID2){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID2));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("ID");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public  static String getCardDescribe(int ID){

        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("describe");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardMainValue(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("mainValue");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public  static String getCardLILIANG(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("力量");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public  static String getCardYISHANG(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("易伤");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardQIPAIDUI(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("弃牌堆");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardCHOUPAIDUI(int ID){

        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("抽牌堆");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardXURUO(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("虚弱");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardSHENGMING(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("生命");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardNENGLIANG(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("能量");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public  static String getCardSHOUPAI(int ID){

        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("手牌");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public  static String getCardDegree(int ID){


        String result ;

        try {
            Statement statement = cn.createStatement();

            String sql = "select * from card where ID2 = '%s'";
            String sql1 = String.format(sql,String.valueOf(ID));
            ResultSet resultSet = statement.executeQuery(sql1);

            resultSet.next();

            result=resultSet.getString("degree");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }


    public static boolean changePlayerFile( String newFile)
    {

        boolean i = false;

        try {
            Statement statement = cn.createStatement();

            String sql = "update player set File = '%s' where File = '%s'";

            String sql1 = String.format(sql,newFile,player.getFile());

            if(statement.executeUpdate(sql1)>=1){
                i = true;
            };

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return i;
    }













}
