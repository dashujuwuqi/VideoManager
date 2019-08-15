package com.zhiyou.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;
import com.zhiyou.model.UserExample.Criteria;
import com.zhiyou.serviceimpl.UserServiceImpl;

@Controller
public class LoginController {
	@Autowired
	UserServiceImpl userService;
	@RequestMapping("validateEmail.do")
	public void validateEmail(HttpServletRequest req,HttpServletResponse resp) {
		//System.out.println("1111111111111111111");
		String email = req.getParameter("email");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(email);
		List<User> list = userService.selectByExample(example);
		if(list.size() == 0) {
			try {
				resp.getWriter().write("success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("regUser.do")
	public void regUser(HttpServletRequest req,HttpServletResponse resp) {
		String regForm = req.getParameter("regForm");
		String[] split = regForm.split("&");
		String[] emails = split[0].split("=");
		String[] passwords = split[1].split("=");
		String email=emails[1];
		String password=passwords[1];
		try {
			email = URLDecoder.decode(email,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(regForm);
		User user = new User();
		user.setAccounts(email);
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		userService.insertSelective(user);
		req.setAttribute("user",user);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("validateLoginEmail.do")
	public void validateLoginEmail(HttpServletRequest req,HttpServletResponse resp) {
		String email = req.getParameter("email");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(email);
		List<User> list = userService.selectByExample(example);
		if(list.size() >0 ) {
			try {
				resp.getWriter().write("success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("userLogin.do")
	public void userLogin(String loginForm,HttpServletRequest req,HttpServletResponse resp) {
		//System.out.println(loginForm);
		String[] split = loginForm.split("&");
		String[] emails = split[0].split("=");
		String[] passwords = split[1].split("=");
		String email=emails[1];
		String password=passwords[1];
		try {
			email = URLDecoder.decode(email,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(email);
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		criteria.andPasswordEqualTo(password);
		List<User> list = userService.selectByExample(example);
		if(list.size() > 0) {
			req.getSession().setAttribute("user",list.get(0));
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@RequestMapping("loginOut.do")
	public String loginOut(HttpServletRequest req) {
		req.getSession().setAttribute("user",null);
		return "index";
	}
}
