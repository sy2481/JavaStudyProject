package com.sunzhouyu.jdbc;

import java.sql.*;

/**
 * @author sunyi
 */
public class Demo1 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            long start = System.currentTimeMillis();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Logstics", "root", "sunzhouyu");
            System.out.println(connection);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
            statement = connection.createStatement();

            statement.executeQuery("select * from ADDRESS");
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ADDRESS");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "--" +
                        resultSet.getString(2) + "-----" + resultSet.getString(3) +
                        "-----" + resultSet.getString(4) + "-----" + resultSet.getInt(5));
            }

            resultSet = preparedStatement.executeQuery();
            System.out.println(1);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "--" +
                        resultSet.getString(2) + "-----" + resultSet.getString(3) +
                        "-----" + resultSet.getString(4) + "-----" + resultSet.getInt(5));
            }
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
