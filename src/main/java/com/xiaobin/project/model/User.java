package com.xiaobin.project.model;

public class User {
    private int uid;
    private String account;
    private String pwd;
    private String nickname;
    private String regtime;
    private int state;
    private Order order;

    public User(int uid,String account, String pwd, String nickname, String regtime,int state,Order order) {
        this.uid = uid;
        this.account = account;
        this.pwd = pwd;
        this.nickname = nickname;
        this.regtime = regtime;
        this.state = state;
        this.order = order;
    }

    public User() {
    }

    public int getUid() {
        return uid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRegtime() {
        return regtime;
    }

    public void setRegtime(String regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "account='" + account + '\'' +
                ", pwd='" + pwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", regtime='" + regtime + '\'' +
                '}';
    }
}
