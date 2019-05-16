package com.wusi.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.lang.reflect.Field;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.wusi.mybatis.pojo.User;
/**
 * 
* @ClassName: UserMapperTest 
* @Description: 基于mapper代理的方法开发测试
* @author wuss
* @date 2019年5月16日 下午7:52:45 
*
 */
public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;
	/**
	 * 
	* @Title: setUp 
	* @Description: 此方法在其他测试方法之前执行
	* @param @throws Exception 
	* @return void 
	* @throws
	 */
	@Before
	public void setUp() throws Exception{
		//获取配置文件
		InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
		//创建会话工厂,传入配置信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.findUserById(2);
		
		Field[] fields = user.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println(field.getName()+"："+field.get(user));
		}
	}

}
