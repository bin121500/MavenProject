package com.xiaobin.project.servlet;


import com.google.gson.Gson;
import com.xiaobin.project.dao.UserDao;
import com.xiaobin.project.dao.impl.UserDaoImpl;
import com.xiaobin.project.model.User;
import com.xiaobin.project.model.UserPageBean;
import com.xiaobin.project.util.MyBatisUtils;
import com.xiaobin.project.util.ObjectFactory;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@WebServlet("/DataServlet")
public class DataServlet extends BaseServlet {
//    UserDaoImpl userDao = (UserDaoImpl) ObjectFactory.getObject("com.xiaobin.project.dao.impl.UserDaoImpl");

    public void testData(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        int page = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("limit"));
        RowBounds rowBounds = new RowBounds((page - 1) * pageSize, pageSize);
        SqlSession sqlSession = MyBatisUtils.getInstance().getSqlSession();
        //获取接口
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
//        System.out.println(request.getParameter("account")+"--"+request.getParameter("nickName"));
        if (null != request.getParameter("account")) {
            user.setAccount("%" + request.getParameter("account") + "%");
        }
        if (null != request.getParameter("nickName")) {
            user.setNickname("%" + request.getParameter("nickName") + "%");
        }
        List<User> userPage = userDao.getUserPage(user, rowBounds);
        Integer userCount = userDao.getUserCount(user);
//        sqlSession.close();
        UserPageBean userPageBean = new UserPageBean();
        userPageBean.setCode(0);
        userPageBean.setMsg("");
        userPageBean.setCount(userCount);
        userPageBean.setData(userPage);
        try {
            response.getWriter().write(new Gson().toJson(userPageBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String logins(HttpServletRequest request, HttpServletResponse response) {
        String account = request.getParameter("account");
        String pwd = request.getParameter("pwd");
        return "html/admin.html";
    }
    //用户禁用启用
    public void changeUserState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String account = request.getParameter("userAccount");
        String tmpstate = request.getParameter("state");
        int state = 1;
        if (tmpstate.equals("true")) {
            state = 1;
        }
        if (tmpstate.equals("false")) {
            state = 0;
        }
        SqlSession sqlSession = MyBatisUtils.getInstance().getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setAccount(account);
        user.setState(state);
        boolean b = userDao.changeUserInf(user);
        if (b) {
            sqlSession.commit();
//        sqlSession.close();
            response.getWriter().write("修改成功");
        }else {
            sqlSession.rollback();
//            sqlSession.close();
            response.getWriter().write("修改失败");
        }
    }
    //修改用户昵称
    public void changeUserNickName(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SqlSession sqlSession = MyBatisUtils.getInstance().getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        String account = request.getParameter("userAccount");
        String nickname = request.getParameter("nickname");
        User user = new User();
        user.setAccount(account);
        user.setNickname(nickname);
        user.setState(99);
        boolean b = userDao.changeUserInf(user);
        if (b) {
            sqlSession.commit();
//            sqlSession.close();
            response.getWriter().write("修改成功");
        }else {
            sqlSession.rollback();
//            sqlSession.close();
            response.getWriter().write("修改失败");
        }
    }
}
