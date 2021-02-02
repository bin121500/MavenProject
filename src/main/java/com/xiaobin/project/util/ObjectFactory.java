package com.xiaobin.project.util;

public class ObjectFactory {
    public static Object getObject(String className){
        Object object = null;
        try {
            Class aClass = Class.forName(className);
            object = aClass.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return object;
    }
}
