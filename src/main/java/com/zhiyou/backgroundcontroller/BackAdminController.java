package com.zhiyou.backgroundcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
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
	public String adminAddShow(HttpServletRequest req,HttpServletResponse resp) {
		return "background/BackgroundAdminAdd";
	}
	
	@RequestMapping("adminAdd.do")
	public String adminAddSuccess(Admin admin,HttpServletRequest req) {
		adminService.insert(admin);
		return "redirect:AdminShowAgain";
		
	}
	
	@RequestMapping("adminDelete.do")
	public void adminDeleteOne(int id,HttpServletResponse resp,HttpServletRequest req) {
		System.out.println(id);
		if (id==1) {
		}else {
			adminService.deleteByPrimaryKey(id);
			try {
				resp.getWriter().write("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@RequestMapping("adminDeleteAll.do")
	public String adminDeleteMany(String ids) {
		List<Integer> list = JSON.parseArray(ids, Integer.class);
		if (list.get(0)==1) {
			list.remove(0);
		}
		for (Integer id : list) {
			adminService.deleteByPrimaryKey(id);
		}
		return "redirect:AdminShowAgain";
	}
}
