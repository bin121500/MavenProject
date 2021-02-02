package com.xiaobin.project.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class ConnectionPool {
    private static ConnectionPool connectionPool;
    private static ArrayList<Connection> cons = new ArrayList<>();

    public static ConnectionPool getConnectionPool() {
        if (null == connectionPool) {
            synchronized (ConnectionPool.class) {
                if (null == connectionPool) {
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }

    private ConnectionPool() {
    }

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("./config/config.txt"));
            String driver = properties.getProperty("driver");
//            String driver = "com.mysql.jdbc.Driver";
            String url = properties.getProperty("url");
            Class.forName(driver);
            for (int i = 0; i < 5; i++) {
                Connection con = DriverManager.getConnection(url);
                cons.add(con);
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        if (!cons.isEmpty()){
            Connection remove = cons.remove(0);
            return remove;
        }
        return null;
    }
    public static void putConnection(Connection con){
        if (cons.size()<5){
            cons.add(con);
        }
    }
    public static void closeConnections(PreparedStatement pre, ResultSet result, Connection con) {
        if (null != pre) {
            try {
                pre.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (null != result) {
            try {
                result.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (null != con) {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
