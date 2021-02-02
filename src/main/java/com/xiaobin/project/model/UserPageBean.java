package com.xiaobin.project.model;

import java.util.List;

public class UserPageBean {

    /**
     * code : 0
     * msg :
     * count : 3000000
     * data : [{"account":"123456","nickname":"杜甫","pwd":"123456","regtime":"2021-01-25"}]
     */

    private int code;
    private String msg;
    private int count;
    private List<User> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

//    public static class DataBean {
//        /**
//         * account : 123456
//         * nickname : 杜甫
//         * pwd : 123456
//         * regtime : 2021-01-25
//         */
//
//        private String account;
//        private String pwd;
//        private String nickname;
//        private String regtime;
//
//        public String getAccount() {
//            return account;
//        }
//
//        public void setAccount(String account) {
//            this.account = account;
//        }
//
//        public String getNickname() {
//            return nickname;
//        }
//
//        public void setNickname(String nickname) {
//            this.nickname = nickname;
//        }
//
//        public String getPwd() {
//            return pwd;
//        }
//
//        public void setPwd(String pwd) {
//            this.pwd = pwd;
//        }
//
//        public String getRegtime() {
//            return regtime;
//        }
//
//        public void setRegtime(String regtime) {
//            this.regtime = regtime;
//        }
//    }
}
