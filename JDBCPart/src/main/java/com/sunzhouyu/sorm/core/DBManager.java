package com.sunzhouyu.sorm.core;

import com.sunzhouyu.sorm.bean.Configuration;

import java.sql.*;
import java.util.Properties;

/**
 * 根据配置信息，维持连接对象的管理(增加连接池功能)
 *
 * @author sunyi
 */
public class DBManager {
    private static Configuration configuration;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("mysql.properties"));
        } catch (Exception e) {
        }
        configuration = new Configuration();
        configuration.setDriver(properties.getProperty("driver"));
        configuration.setUrl(properties.getProperty("url"));
        configuration.setUser(properties.getProperty("user"));
        configuration.setPwd(properties.getProperty("password"));
        configuration.setSrcPath(properties.getProperty("srcPath"));
        configuration.setUsingDB(properties.getProperty("usingDB"));
        configuration.setPoPackage(properties.getProperty("poPackage"));

        configuration.setPoolMaxSize(Integer.parseInt(properties.getProperty("poolMaxSize")));
        configuration.setPoolMinSize(Integer.parseInt(properties.getProperty("poolMinSize")));
    }

    public static Connection getConnection() {
        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(), configuration.getUser(), configuration.getPwd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 创建新的Connection对象
     * @return
     */
    public static Connection createConn(){
        try {
            Class.forName(configuration.getDriver());
            return DriverManager.getConnection(configuration.getUrl(),
                    configuration.getUser(),configuration.getPwd());     //直接建立连接，后期增加连接池处理，提高效率！！！
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

    public static Configuration getConf() {
        return configuration;
    }
}
