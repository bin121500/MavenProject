package com.xiaobin.project.dao.impl;

import com.xiaobin.project.dao.UserDao;
import com.xiaobin.project.model.User;
import com.xiaobin.project.model.UserPageBean;
import com.xiaobin.project.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl  {
//    @Override
//    public List<UserPageBean.DataBean> getUserPage(int curPage, int pageSize) {
//        List<UserPageBean.DataBean> userList = new ArrayList<>();
//        Connection connection = null;
//        try {
//            connection = DBUtil.getInstance().getConnection();
//            String sql = "select *from users limit "+((curPage - 1) * pageSize)+","+pageSize;
//            PreparedStatement pre = connection.prepareStatement(sql);
//            ResultSet resultSet = pre.executeQuery();
//            while (resultSet.next()) {
//                UserPageBean.DataBean dataBean = new UserPageBean.DataBean();
//                dataBean.setAccount(resultSet.getString(1));
//                dataBean.setPwd(resultSet.getString(2));
//                dataBean.setNickname(resultSet.getString(3));
//                dataBean.setRegtime(resultSet.getString(4));
//                userList.add(dataBean);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        } finally {
//            DBUtil.closeConnection(connection);
//        }
//        return userList;
//    }

//    @Override
    public Integer getUserCount() {
        Connection connection = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "select count(*) from users";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return 0;
    }

//    @Override
    public boolean delUser(String account) {
        Connection connection = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "delete from users where account='"+account+"'";
            PreparedStatement pre = connection.prepareStatement(sql);
            int resultSet = pre.executeUpdate();
            if (resultSet==1) {
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return false;
    }

//    @Override
    public User login(String account) {
        User user = new User();
        Connection connection = null;
        try {
            connection = DBUtil.getInstance().getConnection();
            String sql = "";
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()) {
                user.setAccount(resultSet.getString(1));
                user.setPwd(resultSet.getString(2));
                user.setNickname(resultSet.getString(3));
                user.setRegtime(resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(connection);
        }
        return null;
    }

//    @Override
    public List<User> selectlist() {
        return null;
    }
}
