package com.xiaobin.project.test;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class CopyObject {
    /**
     * 拷贝对象
     * @param source 源对象
     * @return
     */
    public static Object copy(Object source) {
        //1.创建一个空对象（新的）
        Object target = null;
        try {
//        2.获取源对象的class对象
            Class<?> aClass = source.getClass();
            //源对象中，必须要有无参构造
            target = aClass.newInstance();
            //获取到类中的所有属性
            Field[] fields = aClass.getDeclaredFields();
            for (Field field:fields){
                //获取属性名
                String fieldName = field.getName();
                //根据属性获取对用的get、set的方法名
                String get="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                String set="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
                //根据方法名去获取方法对象
                Method method_set = aClass.getMethod(set, field.getType());
                Method method_get = aClass.getMethod(get);
                //执行源对象的get获取返回值
                Object returnValue = method_get.invoke(source);
                //执行目标对象的set方法，将源对象的返回值作为参数设置给目标对象
                method_set.invoke(target, returnValue);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return target;
    }

    public static void main(String[] args) {
        OrmTestBean ormTestBean = new OrmTestBean();
        ormTestBean.setId("110");
        ormTestBean.setName("警察");
        OrmTestBean copy = (OrmTestBean) CopyObject.copy(ormTestBean);
        System.out.println(copy.getName()+"--"+copy.getId());
    }
}
