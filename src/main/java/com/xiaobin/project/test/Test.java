package com.xiaobin.project.test;

import com.xiaobin.project.util.DBUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    /**
     * 常用获取class对象的三种方法
     * 1.Class类的静态方法：class。forname（）
     * 2.使用类的.class语法，例如string.class
     * 3.使用对象的getclass（）
     */
//    public static void main(String[] args) {
////        1.class。forname（）
//        try {
//            Class<?> aClass = Class.forName("com.xiaobin.project.test.OrmTestBean");
//
//            System.out.println(aClass.getName());
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
////        2.string.class
//        Class<OrmTestBean> ormTestBeanClass = OrmTestBean.class;
//        System.out.println(ormTestBeanClass.getName());
////        3.getclass（）
//        OrmTestBean ormTestBean = new OrmTestBean();
//        Class<?> aClass = ormTestBean.getClass();
//        System.out.println(aClass.getName());
//    }
//    public static void main(String[] args) {
////        1.使用newinstance创建对象
//        Class<OrmTestBean> ormTestBeanClass = OrmTestBean.class;
//        try {
//            OrmTestBean ormTestBean = ormTestBeanClass.newInstance();
//            System.out.println(ormTestBean.getName());
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
////        2.通过constructor对象获取一个无参构造方法
//        try {
//            Constructor<OrmTestBean> constructor = ormTestBeanClass.getConstructor();
//            OrmTestBean ormTestBean = constructor.newInstance(new Object[]{});
//            System.out.println(ormTestBean.getName());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
////        3.利用有参构造方法来生成对象
//        try {
//            //有参构造有几个参数，就传几个--传参数类型
//            Constructor<OrmTestBean> constructor = ormTestBeanClass.getConstructor(String.class,String.class);
//            //有参构造有几个参数，就传几个--传具体的值
//            OrmTestBean ormTestBean = constructor.newInstance("10086","张三");
//            System.out.println(ormTestBean.toString());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {//使用反射获取/调用方法
//        Class<OrmTestBean> ormTestBeanClass = OrmTestBean.class;
//        try {
////            Constructor<OrmTestBean> constructor = ormTestBeanClass.getConstructor();
//            OrmTestBean ormTestBean = ormTestBeanClass.newInstance();
////            Method[] methods = ormTestBeanClass.getMethods();
////            for (Method method:methods){
////                System.out.println(method.getName());
////            }
//            Method add = ormTestBeanClass.getMethod("add", String.class);
//            add.invoke(ormTestBean,"111");
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
        System.out.println("新改动");
    }
}
