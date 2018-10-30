package com.htkfood.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
public class PageController {



	@RequestMapping("index")
	public String index() {
		return "example/index";
	}
	
	@RequestMapping("user_add")
	@RequiresPermissions("user_add")//权限管理;
	public String userAdd() {
		return "example/user_add";
	}
	
	@RequestMapping("user_delete")
	@RequiresPermissions("user_delete")//权限管理;
	public String user_delete() {
		return "example/user_delete";
	}
	
	@RequestMapping("user_list")
	@RequiresPermissions("user_list")//权限管理;
	public String user_list(){
		return "example/user_list";
	}
	
	@RequestMapping("login")
	public String login() {
		return "example/login";
	}
	@RequestMapping("unauthorized")
	public String unauthorized() {
		return "example/unauthorized";
	}
	
	
	


}
