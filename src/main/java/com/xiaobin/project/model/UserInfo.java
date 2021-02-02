package com.xiaobin.project.model;

import java.util.List;

public class UserInfo {
    private String userid;
    private String useraccount;
    private String userpwd;
    private String usernickname;
    private String userregtime;
    private int userstate;
    private List<Order> order;

    public UserInfo(String userid,String useraccount, String userpwd, String usernickname, String userregtime,int userstate,List<Order> order) {
        this.userid = userid;
        this.useraccount = useraccount;
        this.userpwd = userpwd;
        this.usernickname = usernickname;
        this.userregtime = userregtime;
        this.userstate = userstate;
        this.order = order;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userid='" + userid + '\'' +
                ", useraccount='" + useraccount + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", usernickname='" + usernickname + '\'' +
                ", userregtime='" + userregtime + '\'' +
                ", userstate=" + userstate +
                ", order=" + order +
                '}';
    }

    public UserInfo() {
    }

    public String getUseraccount() {
        return useraccount;
    }

    public int getUserstate() {
        return userstate;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

    public void setUserstate(int userstate) {
        this.userstate = userstate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getUsernickname() {
        return usernickname;
    }

    public void setUsernickname(String usernickname) {
        this.usernickname = usernickname;
    }

    public String getUserregtime() {
        return userregtime;
    }

    public void setUserregtime(String userregtime) {
        this.userregtime = userregtime;
    }
}
