package com.xiaobin.project.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    private static DBUtil dbUtil;
    private Properties properties;
    private Connection connection;
    private ComboPooledDataSource dataSource;

    private DBUtil() {
//        try {
//            properties = new Properties();
//            properties.load(this.getClass().getClassLoader().getResourceAsStream("db.properties"));//需要通过Tomcat去获取文件流然后读取文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        dataSource = new ComboPooledDataSource("mysql");
    }

    public synchronized static DBUtil getInstance() {
        if (dbUtil == null) {
            dbUtil = new DBUtil();
        }
        return dbUtil;
    }

    public Connection getConnection() {
//        String driverClass = properties.getProperty("driverClass");
//        String url = properties.getProperty("url");
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        try {
//            Class.forName(driverClass);
//            connection= DriverManager.getConnection(url,user,password);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public DataSource getDataSource(){
        return dataSource;
    }
}
