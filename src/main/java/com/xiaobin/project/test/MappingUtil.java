package com.xiaobin.project.test;

import com.xiaobin.project.model.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

public class MappingUtil {
    //解析xml文件  dom4j/SAX/jdom
    public static Element fetchXml(){
        File file = new File("src/TestTable.xml");
        SAXReader reader = new SAXReader();
        try {
            //xml解析器解析xml文件
            Document document = reader.read(file);
            //获取节点
            Element root = (Element)document.getRootElement();
            return root;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成插入语句 insert into 表明（字段名1，字段名2...） values（值1，值2...）
     * @param bean
     * @return
     */
    public static String genInsertSql(String bean){
        try {
            Class<?> clz = Class.forName(bean);
            //得到类名
            String clzName = clz.getName();
            //获取类名（表明）
            String beanName = clzName.substring(clzName.lastIndexOf(".") + 1).toLowerCase();
            //获取类的所有属性
            Field[] fields = clz.getDeclaredFields();
            //
            StringBuffer sb=null;

            String fileNames ="";
            //获取属性名(数据库中的字段名)
            for (Field field:fields){
                fileNames+=","+field.getName();
                if (sb==null){
                    sb=new StringBuffer();
                    sb.append("?");
                }else {
                    sb.append(",?");
                }
            }
            return "insert into "+beanName+"("+fileNames.substring(1)+") values ("+sb.toString()+")";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String genSelectSql(String bean){
        try {
            Class<?> clz = Class.forName(bean);
            //得到类名
            String clzName = clz.getName();
            //获取类名（表明）
            String beanName = clzName.substring(clzName.lastIndexOf(".") + 1).toLowerCase();
            //获取类的所有属性
            Field[] fields = clz.getDeclaredFields();
            //
            StringBuffer sb=null;

            String fileNames ="";
            //获取属性名(数据库中的字段名)
            for (Field field:fields){
                fileNames+=","+field.getName();
                if (sb==null){
                    sb=new StringBuffer();
                    sb.append("?");
                }else {
                    sb.append(",?");
                }
            }
            return "select "+fileNames.substring(1)+" from "+beanName;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        User user = new User();
        user.setNickname("ss");
        user.setPwd("123456");
        Element root = MappingUtil.fetchXml();
        Element foo;
        for (Iterator i = root.elementIterator("table");i.hasNext();){
            foo= (Element) i.next();
            String insertSql = MappingUtil.genInsertSql(foo.attributeValue("name"));
            String selectSql = MappingUtil.genSelectSql(foo.attributeValue("name"));
            System.out.println(insertSql);
            System.out.println(selectSql);
        }

    }
}
