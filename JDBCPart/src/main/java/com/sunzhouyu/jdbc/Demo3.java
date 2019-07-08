package com.sunzhouyu.jdbc;

import java.sql.*;

/**
 * @author sunyi
 */
public class Demo3 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection=JDBCUtil.getMysqlConnection();
            statement = connection.createStatement();
            statement.executeQuery("select * from ADDRESS");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ADDRESS");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "--" +
                        resultSet.getString(2) + "-----" + resultSet.getString(3) +
                        "-----" + resultSet.getString(4) + "-----" + resultSet.getInt(5));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
    }
}
