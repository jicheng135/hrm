package org.fkit.hrm.service.impl;

import org.fkit.hrm.dao.DeptDao;
import org.fkit.hrm.dao.DocumentDao;
import org.fkit.hrm.dao.EmployeeDao;
import org.fkit.hrm.dao.JobDao;
import org.fkit.hrm.dao.NoticeDao;
import org.fkit.hrm.dao.UserDao;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService{
	
	/**
	 * 自动注入持久层Dao对象
	 * */
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private DeptDao deptDao;
	
	@Autowired
	private JobDao jobDao;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private NoticeDao noticeDao;
	
	@Autowired
	private DocumentDao documentDao;

	/*****************用户服务接口实现*************************************/
	/**
	 * HrmServiceImpl接口login方法实现
	 *  @see { HrmService }
	 * */
	@Transactional(readOnly=true)
	@Override
	public User login(String loginname, String password) {
		User user = userDao.selectByLoginnameAndPassword(loginname, password);
		return user;
	}
	
	
}
