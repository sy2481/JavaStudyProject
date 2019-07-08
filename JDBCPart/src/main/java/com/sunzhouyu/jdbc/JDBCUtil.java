package com.sunzhouyu.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author sunyi
 */
public class JDBCUtil {

    static Properties properties = null;

    static {
        properties=new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMysqlConnection() {
        try {
            Class.forName(properties.getProperty("mysqlDriver"));
            return DriverManager.getConnection(properties.getProperty("mysqlUrl"), properties.getProperty("mysqlUser"), properties.getProperty("mysqlPassword"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
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

    public static void close(Statement statement, Connection connection) {
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

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
