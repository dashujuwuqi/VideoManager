package com.zhiyou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.CourseExtension;
import com.zhiyou.serviceimpl.CourseServiceImpl;
import com.zhiyou.utils.VideoResult;

@Controller
public class CourseController {
	@Autowired
	private CourseServiceImpl course;
	@RequestMapping("courseWithVideoAndSubject.do")
	public String SelectBySubjectid(String subjectId,HttpServletRequest req) {
		List<CourseExtension> list = course.selectBySubjectid(Integer.valueOf(subjectId));
		VideoResult result = new VideoResult();
		Map<String, Object> map = new HashMap<String,Object>();
		if(list == null) {
			req.setAttribute("msg","没有课程");
			return "index";
		}
		map.put("list",list);
		map.put("subjectId",subjectId);
		result.setData(map);
		result.setMsg("成功了");
		result.setStatus(200);
		req.setAttribute("result",result);
		return "CourseShow";
	}
}
