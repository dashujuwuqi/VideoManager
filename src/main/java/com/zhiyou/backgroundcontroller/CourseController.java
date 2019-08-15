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
import com.zhiyou.backgroundservice.CourseService;
import com.zhiyou.backgroundservice.SubjectService;
import com.zhiyou.backgroundutil.VideoResult;
import com.zhiyou.model.Course;
import com.zhiyou.model.CourseExample;
import com.zhiyou.model.CourseExample.Criteria;
import com.zhiyou.model.Subject;
import com.zhiyou.model.SubjectExample;

@Controller
public class CourseController {
	@Autowired
	CourseService courseService;
	@Autowired
	SubjectService subjectService;

	@RequestMapping("Back-Course-Show")
	public String courseShow(HttpServletRequest req) {

		CourseExample example = new CourseExample();
		int count = courseService.selectByExample(example).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Course> list = courseService.selectByExample(example);
		VideoResult result = new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundCourseShow";
	}

	@RequestMapping("CourseShowAgain.do")
	public String courseShowAgain(HttpServletRequest req) {

		CourseExample example = new CourseExample();
		int count = courseService.selectByExample(example).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Course> list = courseService.selectByExample(example);
		VideoResult result = new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundCourseShow";
	}

	@RequestMapping("courseAddShow.do")
	public String courseAddShow(HttpServletRequest req) {
		SubjectExample example = new SubjectExample();
		List<Subject> list = subjectService.selectByExample(example);
		VideoResult result = new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundCourseAdd";
	}

	@RequestMapping("courseAdd.do")
	public String courseAddSuccess(Course course, HttpServletRequest req) {
		courseService.insert(course);
		return "forward:/CourseShowAgain.do";
	}

	@RequestMapping("courseDelete.do")
	public void courseDeleteOne(HttpServletRequest req, HttpServletResponse resp, int id) {
		courseService.deleteByPrimaryKey(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			e.printStackTrace();

		}
		
	}

	@RequestMapping("courseUpdateShow.do")
	public String courseUpdateJsp(int id, HttpServletRequest req) {
		Course course = courseService.selectByPrimaryKey(id);
		VideoResult result = new VideoResult();
		result.setData(course);
		req.setAttribute("result", result);
		return "background/BackgroundCourseUpdate";
	}

	@RequestMapping("courseUpdate.do")
	public String courseUpdateSuccess(Course course) {
		courseService.updateByPrimaryKeySelective(course);
		return "forward:/CourseShowAgain.do";
	}

	@RequestMapping("courseDeleteAll.do")
	public String courseDeleteMany(HttpServletRequest req, HttpServletResponse resp, String ids) {
		List<Integer> list = JSON.parseArray(ids, Integer.class);
		for (Integer id : list) {
			courseService.deleteByPrimaryKey(id);
		}
		return "forward:/CourseShowAgain.do";
	}

}
