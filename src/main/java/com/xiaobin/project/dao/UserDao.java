package com.xiaobin.project.dao;

import com.xiaobin.project.model.Order;
import com.xiaobin.project.model.User;
import com.xiaobin.project.model.UserInfo;
import com.xiaobin.project.model.UserPageBean;
import org.apache.ibatis.session.RowBounds;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserDao {
//    public List<UserPageBean.DataBean> getUserPage(int curPage, int pageSize);
//    public Integer getUserCount();
//    public boolean delUser(String account);
//    public User login(String account);

    /**
     * 注意：1.方法名需要和xml文件里面的id一致
     * 2.查询结果是多条的话，必须用list接收
     * @return
     */
    List<User> selectlist(User user,RowBounds rowBounds);

    HashMap<Object,Object> selectlistmap();
    /**
     * 对象的属性需要和xml文件里面的参数一一对应，能多不能少
     * 如果直接传参，参数一个都不能少，而且参数名要一一对应
     */
    boolean addUser(User user);

    User getOneUserInf(String account);

    void deleteone(String account);

    Integer getUserCount(User user);

    List<User> getUserPage(User user,RowBounds rowBounds);

    boolean changeUserInf(User user);

    UserInfo selectuser(int id);
    List<Order> selectorder(int id);
}
