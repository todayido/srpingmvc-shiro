package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.user.service.UserService;
import com.user.vo.User;

import utils.StringsUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "info")
	public ModelAndView getUserByUsername(@RequestParam String username){
		
		ModelAndView mav = new ModelAndView("user/userInfo");
		
		User user = userService.getUserByUsername(username);
		mav.addObject("user", user);
		
		return mav;
	}

	@RequestMapping(value = "list")
	//@RequiresRoles("admin")
	public String getUserList(HttpServletRequest request,Model model){

		/**
		 * 根据用户的角色查询用户对于某张表具有的查询条件
		 * 普通用户:username=#{username}
		 * 部门经理：user_dept_id=#{dept_id}
		 * 超级管理员：1=1
		 */
		String username = (String) request.getSession().getAttribute("username");
		Set set = userService.getUserRolesSet(username);
		String roles = StringsUtils.convertSet2String(set);
		String conditions = userService.getQueryConditions(roles, "t_user");
		
		Map paramsMap = new HashMap();
		paramsMap.put("conditions", conditions);
		paramsMap.put("username", "test");
		
		List userList = userService.getUserList(paramsMap);
		model.addAttribute("userList", userList);

		return "/user/list";
	}

	@RequestMapping(value = "add")
	public String add(){
		return "user/add";
	}

	@RequestMapping(value = "delete")
	public String delete(){
		return "user/delete";
	}

	@RequestMapping(value = "update")
	public String update(){
		return "user/update";
	}

	@RequestMapping(value = "get")
	public String get(){
		return "user/get";
	}
}
