package com.sunzhouyu.jdbc;

import java.sql.*;

/**
 * @author sunyi
 */
public class Demo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Logstics", "root", "sunzhouyu");

            //设置为手动提交
            connection.setAutoCommit(false);
            long start = System.currentTimeMillis();
            statement = connection.createStatement();
            for(int i=0;i<20000;i++){
                statement.addBatch("INSERT  INTO  Address (Id,UserName,AddressInfo,Phone,userId) VALUES ("+(i+100)+",'sun"+i+"','aa',1,1)");
            }
            statement.executeBatch();
            connection.commit();//提交事务
            long end = System.currentTimeMillis();
            System.out.println(end-start);
//            statement.executeQuery("select * from ADDRESS");
//            PreparedStatement preparedStatement = connection.prepareStatement("select * from ADDRESS");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "--" +
//                        resultSet.getString(2) + "-----" + resultSet.getString(3) +
//                        "-----" + resultSet.getString(4) + "-----" + resultSet.getInt(5));
//            }
//
//            resultSet = preparedStatement.executeQuery();
//            System.out.println(1);
//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt(1) + "--" +
//                        resultSet.getString(2) + "-----" + resultSet.getString(3) +
//                        "-----" + resultSet.getString(4) + "-----" + resultSet.getInt(5));
//            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
