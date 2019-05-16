package com.wusi.mybatis.test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.wusi.mybatis.pojo.User;


public class MybatisFirstTest {

	@Test	
	public void findUserById()  {
		SqlSession sqlSession = null;
		try {
			//获取配置文件
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//创建会话工厂,传入配置信息
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂得到SqlSession
			sqlSession = sessionFactory.openSession();
			
			//通过SqlSsession操作数据库
			//第一个参数：映射文件中statement的id，等于namespace+"."+statement的id
			User user = sqlSession.selectOne("UserMapper.findUserById",3);
			
			Field[] fields = user.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				System.out.println("属性："+field.getName()+"，值："+field.get(user));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != sqlSession) 
				//释放资源
				sqlSession.close();
		}
	}
	
	@Test	
	public void findUserByName()  {
		SqlSession sqlSession = null;
		try {
			//获取配置文件
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//创建会话工厂,传入配置信息
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂得到SqlSession
			sqlSession = sessionFactory.openSession();
			
			//通过SqlSsession操作数据库
			//第一个参数：映射文件中statement的id，等于namespace+"."+statement的id
			List<User> users= sqlSession.selectList("UserMapper.findUserByName","小");
			for (User user : users) {
				Field[] fields = user.getClass().getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
					System.out.println("属性："+field.getName()+"，值："+field.get(user));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != sqlSession) 
				//释放资源
				sqlSession.close();
		}
	}
	
	@Test	
	public void insertUser()  {
		SqlSession sqlSession = null;
		try {
			//获取配置文件
			InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
			//创建会话工厂,传入配置信息
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			//通过工厂得到SqlSession
			sqlSession = sessionFactory.openSession();
			
			//通过SqlSsession操作数据库
			User user = new User("灰灰", "1", "福建福州");
			sqlSession.insert("UserMapper.insertUser", user);
			System.out.println(user.getId());
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != sqlSession) 
				//释放资源
				sqlSession.close();
		}
	}
}
