package com.wusi.mybatis.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.wusi.mybatis.pojo.User;

/**
 * 
* @ClassName: UserDaoImpl 
* @Description: UserDao的实现类
* @author wuss
* @date 2019年5月16日 下午7:29:06 
*
 */
public class UserDaoImpl implements UserDao{

	private SqlSessionFactory sqlSessionFactory;
	
	
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("UserMapper.findUserById",id);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> findUserByName(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> users = sqlSession.selectList("UserMapper.findUserByName",name);
		sqlSession.close();
		return users;
	}

	@Override
	public int insertUser(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("UserMapper.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
		return user.getId();
	}
		
}
