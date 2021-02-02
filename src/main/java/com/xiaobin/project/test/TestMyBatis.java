package com.xiaobin.project.test;

import com.xiaobin.project.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestMyBatis {
    public static void main(String[] args) throws IOException {
        //1.通过Resources对象获取mybatis的全局配置文件
        String url= "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(url);
        //创建SqlSessionFactoryBuilder实例
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();
        //根据build方法获取SqlSessionFactory对象
        SqlSessionFactory sessionFactory = factoryBuilder.build(inputStream);
        //获取SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
        System.out.println(sqlSession);
        //1.实现一个selectlist（）

//        User user = new User();
//        user.setAccount("120");
//        user.setNickname("阿炳");
//        user.setPwd("120");
//        user.setRegtime("2021-01-25");
//        sqlSession.insert("addUser",user);
//        sqlSession.commit();
////
//        List<User> selectlist = sqlSession.selectList("selectlist");
//        System.out.println(new Gson().toJson(selectlist));
//        User selectone = sqlSession.selectOne("selectone", "120");
//        System.out.println(selectone);

        //删除单条
//        int delete = sqlSession.delete("deleteone", "120");
//        sqlSession.commit();
//        System.out.println(delete);

        //RowBounds--分页    offset:偏移量, limit：限制条数
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUsernickname("阿炳");
//        RowBounds rowBounds = new RowBounds(0,2);
//        User user = new User();
//        user.setNickname("阿炳");
//        List<User> selectlist = sqlSession.selectList("selectlist",user);
//        System.out.println(new Gson().toJson(selectlist));

        //查询要返回map
//        Map<Object, Object> objectObjectMap = sqlSession.selectMap("selectlistmap", "account");
//        System.out.println(sqlSession.selectMap("selectlistmap", "account"));

//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<User> selectlist = userDao.selectlist(user,rowBounds);
//        System.out.println(new Gson().toJson(selectlist));

        //添加自增
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        User user = new User();
//        user.setNickname("11111");user.setState(1);user.setUid(25);user.setAccount("11111");user.setPwd("11111");
//        boolean b = userDao.addUser(user);
//        sqlSession.commit();
//        System.out.println(b);
        //实体类返回map集合
//        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        HashMap selectlistmap = userDao.selectlistmap();
//        System.out.println(selectlistmap.size());

        UserDao userDao = sqlSession.getMapper(UserDao.class);
        System.out.println(userDao.selectuser(12));
    }
}
