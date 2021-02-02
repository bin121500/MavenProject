package com.xiaobin.project.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	//MyBatis配置文件名以及路径
	private static final String CONFIG_PATH = "mybatis-config.xml";
	//sqlSession的工厂对象
	private SqlSessionFactory sessionFaction = null;
	private SqlSession session = null;////不能将SqlSession实例引用放在静态字段中
	//单例引用模式
	private static MyBatisUtils instance = null;
	private MyBatisUtils(){
		Reader reader = null;
		try {
			//将配置文件读取到IO流中
			reader = Resources.getResourceAsReader(CONFIG_PATH);
			//SqlSessionFactoryBuilder解析配置文件，并新建sessionFaction工厂
			sessionFaction = new SqlSessionFactoryBuilder().build(reader);
			session = sessionFaction.openSession(false);//打开事务，取消自动提交
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//获取MyBatisUtil单例(最佳的单例模式，线程安全，效率高)
	public static synchronized MyBatisUtils getInstance(){
		if(null == instance){
			synchronized (MyBatisUtils.class) {
				instance = new MyBatisUtils();
			}
		}
		return instance;
	}	
	//获取连接
	public synchronized SqlSession getSqlSession(){
		session = sessionFaction.openSession();
		return session;	
	}
}
