package org.fkit.hrm.service;

import java.util.List;

import org.fkit.hrm.domain.User;
import org.fkit.hrm.util.tag.PageModel;

/**   
 * @Description: 人事管理服务层接口
 * <br>网站：<a href="http://www.fkit.org">疯狂Java</a> 
 * @author 肖文吉	36750064@qq.com   
 * @version V1.0   
 */
public interface HrmService {
	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	User login(String loginname, String password);
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<User> findUser(User user, PageModel pageModel);
	/**
	 * 添加用户
	 * @param User 用户对象
	 * */
	void addUser(User user);
	/**
	 * 根据id删除用户
	 * @param id
	 * */
	void removeUserById(int id);

}
