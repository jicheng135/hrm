package org.fkit.hrm.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.service.HrmService;
import org.fkit.hrm.util.common.HrmConstants;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理用户请求控制器
 * */
@Controller
public class UserController {

	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView mv){
		// 调用业务逻辑组件判断用户是否可以登录
		User user = hrmService.login(loginname,password);
		if(user!=null){
			// 将用户保存到HttpSession当中
			session.setAttribute(HrmConstants.USER_SESSION, user);
			// 客户端跳转到main页面
			mv.setViewName("redirect:/main");
		}else{
			mv.addObject("message", "登录名或密码错误!请重新输入!");
			mv.setViewName("forward:/loginForm");
		}
		return mv;
		
	}
	
}
