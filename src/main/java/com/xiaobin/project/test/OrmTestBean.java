package com.xiaobin.project.test;

public class OrmTestBean {
    private String id;
    private String name="李四";

    public OrmTestBean(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public OrmTestBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "OrmTestBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
    public void add(String id) {
        System.out.println(id);
    }
}
