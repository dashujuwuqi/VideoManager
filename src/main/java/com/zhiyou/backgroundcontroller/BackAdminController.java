package com.zhiyou.backgroundcontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.zhiyou.backgroundservice.BackAdminService;
import com.zhiyou.backgroundutil.VideoResult;
import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;

@Controller
public class BackAdminController {
	@Autowired
	BackAdminService adminService;
	
	@RequestMapping("Back-Admin-Show")
	public String adminShow(HttpServletRequest req) {
		AdminExample example=new AdminExample();
		int count = adminService.selectByExample(example).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Admin> list = adminService.selectByExample(example);
		VideoResult result=new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundAdminShow";
	}
	
	@RequestMapping("AdminShowAgain")
	public String adminShowAgain(HttpServletRequest req) {
		AdminExample example=new AdminExample();
		int count = adminService.selectByExample(example).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Admin> list = adminService.selectByExample(example);
		VideoResult result=new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundAdminShow";
	}
	
	@RequestMapping("AdminAddShow.do")
	public String adminAddShow() {
		return "background/BackgroundAdminAdd";
	}
	
	@RequestMapping("adminAdd.do")
	public String adminAddSuccess(Admin admin) {
		adminService.insert(admin);
		return "forward:AdminShowAgain";
		
	}
}
