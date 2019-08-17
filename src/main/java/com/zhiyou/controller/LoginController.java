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

import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;
import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;
import com.zhiyou.model.UserExample.Criteria;
import com.zhiyou.serviceimpl.AdminServiceImpl;
import com.zhiyou.serviceimpl.UserServiceImpl;
import com.zhiyou.utils.MailUtil;

@Controller
public class LoginController {
	@Autowired
	UserServiceImpl userService;
	@Autowired
	AdminServiceImpl adminService;

	@RequestMapping("validateEmail.do")
	public void validateEmail(HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println("1111111111111111111");
		String email = req.getParameter("email");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(email);
		List<User> list = userService.selectByExample(example);
		if (list.size() == 0) {
			try {
				resp.getWriter().write("success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("MailCheck.do")
	public void MailCheck(HttpServletRequest req, HttpServletResponse resp) {
		int a = (int) (Math.random() * 9000) + 1000;
		// System.out.println(a);
		String email = req.getParameter("mail");
		// System.out.println(email);
		MailUtil.setMain(email, String.valueOf(a));
		String Yzm = String.valueOf(a);
		try {
			resp.getWriter().write(Yzm);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("findPassword.do")
	public String findPassword(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email2");
		String password = req.getParameter("password2");
		System.out.println(email);
		System.out.println(password);
		password = DigestUtils.md5DigestAsHex(password.getBytes());
		User user = new User();
		user.setAccounts(email);
		user.setPassword(password);
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(email);
		userService.updateByExampleSelective(user, example);
		return "index";
	}

	@RequestMapping("regUser.do")
	public void regUser(HttpServletRequest req, HttpServletResponse resp) {
		String regForm = req.getParameter("regForm");
		String[] split = regForm.split("&");
		String[] emails = split[0].split("=");
		String[] passwords = split[1].split("=");
		String email = emails[1];
		String password = passwords[1];
		try {
			email = URLDecoder.decode(email, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(regForm);
		User user = new User();
		user.setAccounts(email);
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		userService.insertSelective(user);
		req.setAttribute("user", user);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("validateLoginEmail.do")
	public void validateLoginEmail(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(email);
		List<User> list = userService.selectByExample(example);
		if (list.size() > 0) {
			try {
				resp.getWriter().write("success");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("userLogin.do")
	public void userLogin(String loginForm, HttpServletRequest req, HttpServletResponse resp) {
		// System.out.println(loginForm);
		String[] split = loginForm.split("&");
		String[] emails = split[0].split("=");
		String[] passwords = split[1].split("=");
		String email = emails[1];
		String password = passwords[1];
		try {
			email = URLDecoder.decode(email, "UTF-8");
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
		if (list.size() > 0) {
			req.getSession().setAttribute("user", list.get(0));
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("validateAdminEmail.do")
	public void validateAdminEmail(HttpServletRequest req, HttpServletResponse resp) {
		String account = req.getParameter("email");
		// System.out.println(account);
		AdminExample example = new AdminExample();
		com.zhiyou.model.AdminExample.Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(account);
		List<Admin> list = adminService.selectByExample(example);
		if (list.size() > 0) {
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("adminLogin.do")
	public void adminLogin(String loginForm, HttpServletRequest req, HttpServletResponse resp) {
		String[] split = loginForm.split("&");
		String[] emails = split[0].split("=");
		String[] passwords = split[1].split("=");
		String account = emails[1];
		String password = passwords[1];
		try {
			account = URLDecoder.decode(account, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminExample example = new AdminExample();
		com.zhiyou.model.AdminExample.Criteria criteria = example.createCriteria();
		criteria.andAccountsEqualTo(account);
		List<Admin> list = adminService.selectByExample(example);
		if (list.get(0).getPassword().equals(password)) {
			try {
				req.getSession().setAttribute("admin", list.get(0));
				resp.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping("AdminShow.do")
	public String AdminShow(HttpServletRequest req) {
		System.out.println("111111111111111");
		return "/background/BackgroundCourseAdd";
	}

	@RequestMapping("loginOut.do")
	public String loginOut(HttpServletRequest req) {
		req.getSession().removeAttribute("user");
		return "index";
	}
}
