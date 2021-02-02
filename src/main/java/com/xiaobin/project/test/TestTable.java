package com.xiaobin.project.test;

public class TestTable {
    private String name;
    private String pwd;

    public TestTable(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public TestTable() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
