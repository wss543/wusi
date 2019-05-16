package com.wusi.mybatis.dao;

import java.util.List;
import com.wusi.mybatis.pojo.User;
/**
 * 
* @ClassName: UserDao 
* @Description: 原始dao开发方法
* @author wuss
* @date 2019年5月16日 下午7:02:48 
*
 */
public interface UserDao {
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public int insertUser(User user) throws Exception;
}
