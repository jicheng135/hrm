package org.fkit.hrm.service;

import org.fkit.hrm.domain.User;

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

}
