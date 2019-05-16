package com.wusi.mybatis.mapper;

import java.util.List;
import com.wusi.mybatis.pojo.User;
/**
 * 
* @ClassName: UserMapper 
* @Description: 基于mapper代理的方法开发接口
* @author wuss
* @date 2019年5月16日 下午7:02:48 
*
 */
public interface UserMapper {
	
	public User findUserById(int id) throws Exception;
	
	public List<User> findUserByName(String name) throws Exception;
	
	public int insertUser(User user) throws Exception;
}
