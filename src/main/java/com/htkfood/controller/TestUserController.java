package com.htkfood.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htkfood.dao.Criteria;
import com.htkfood.entity.TestUser;
import com.htkfood.service.ITestUserService;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hzz
 * @since 2018-10-30
 */
@Controller
public class TestUserController {

	@Autowired
	private ITestUserService userService;

	@RequestMapping("user/add")
	@ResponseBody
	public Map<String, Object> add(String name, Integer age, Integer sex) {
		Map<String, Object> map = new HashMap<>();
		TestUser user = new TestUser();
		if (userService.insert(user)) {
			map.put("result", "success");
		} else {
			map.put("result", "failure");
		}
		return map;
	}

	@RequestMapping("/loginUser")
	public String loginUser(@RequestParam("username") String username,
			@RequestParam("password") String password, HttpSession session) {
		Map<String, Object> map = new HashMap<>();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			System.out.println("获取到信息，开始验证！！");
			subject.login(token);// 登陆成功的话，放到session中
			TestUser user = (TestUser) subject.getPrincipal();
			session.setAttribute("user", user);
			map.put("result", "success");
			return "example/index";
		} catch (Exception e) {
			map.put("result", "failure");
			return "example/login";
		}
	}

	@RequestMapping("user/get")
	@ResponseBody
	public Map<String, Object> get(String name) {
		Map<String, Object> map = new HashMap<>();
		Criteria criteria = new Criteria();
		criteria.put("userName", name);
		map.put("user", userService.getUserAndRole(criteria));
		return map;
	}

}
