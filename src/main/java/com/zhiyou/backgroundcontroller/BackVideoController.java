package com.zhiyou.backgroundcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.zhiyou.backgroundservice.BackCourseService;
import com.zhiyou.backgroundservice.BackSpeakerService;
import com.zhiyou.backgroundservice.BackVideoService;
import com.zhiyou.backgroundutil.VideoResult;
import com.zhiyou.model.Course;
import com.zhiyou.model.CourseExample;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.SpeakerExample;
import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;

@Controller
public class BackVideoController {
	@Autowired
	BackVideoService videoService;
	@Autowired
	BackSpeakerService speakerService;
	@Autowired
	BackCourseService courseService;
	@RequestMapping("Back-Video-Show")
	public String videoShow(HttpServletRequest req) {
		VideoExample videoExample=new VideoExample();
		SpeakerExample speakerExample=new SpeakerExample();
		CourseExample courseExample=new CourseExample();
		int count = videoService.selectByExample(videoExample).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Video> videos = videoService.select();
		List<Course> courses = courseService.selectByExample(courseExample);
		List<Speaker> speakers = speakerService.selectByExample(speakerExample);
		VideoResult result=new VideoResult();
		VideoResult result2=new VideoResult();
		VideoResult result3=new VideoResult();
		result.setData(videos);
		result2.setData(courses);
		result3.setData(speakers);
		req.setAttribute("result", result);
		req.setAttribute("result2", result2);
		req.setAttribute("result3", result3);
		return "background/BackgroundVideoShow";
	}
	
	@RequestMapping("VideoShowAgain")
	public String videoShowAgain(HttpServletRequest req) {
		VideoExample videoExample=new VideoExample();
		SpeakerExample speakerExample=new SpeakerExample();
		CourseExample courseExample=new CourseExample();
		int count = videoService.selectByExample(videoExample).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Video> videos = videoService.select();
		List<Course> courses = courseService.selectByExample(courseExample);
		List<Speaker> speakers = speakerService.selectByExample(speakerExample);
		VideoResult result=new VideoResult();
		VideoResult result2=new VideoResult();
		VideoResult result3=new VideoResult();
		result.setData(videos);
		result2.setData(courses);
		result3.setData(speakers);
		req.setAttribute("result", result);
		req.setAttribute("result2", result2);
		req.setAttribute("result3", result3);
		return "background/BackgroundVideoShow";
	}
	
	@RequestMapping("videoUpdateShow.do")
	public String videoUpdateShow(HttpServletRequest req,int id) {
		SpeakerExample speakerExample=new SpeakerExample();
		CourseExample courseExample=new CourseExample();
		Video videos = videoService.selectByPrimaryKey(id);
		List<Course> courses = courseService.selectByExample(courseExample);
		List<Speaker> speakers = speakerService.selectByExample(speakerExample);
		Map map=new HashMap();
		map.put("video", videos);
		map.put("course", courses);
		map.put("speaker", speakers);
		System.out.println(map);
		VideoResult result=new VideoResult();
		result.setData(map);
		req.setAttribute("result", result);
		return "background/BackgroundVideoUpdate";
	}
	
	@RequestMapping("videoUpdate.do")
	public String videoUpdateSuccess(Video video) {
		videoService.updateByPrimaryKeySelective(video);
		return "forward:VideoShowAgain";
	}
	
	@RequestMapping("videoAddShow.do")
	public String videoAddJsp(HttpServletRequest req) {
		SpeakerExample speakerExample=new SpeakerExample();
		CourseExample courseExample=new CourseExample();
		List<Course> courses = courseService.selectByExample(courseExample);
		List<Speaker> speakers = speakerService.selectByExample(speakerExample);
		VideoResult result=new VideoResult();
		VideoResult result1=new VideoResult();
		result.setData(courses);
		result1.setData(speakers);
		req.setAttribute("result", result);
		req.setAttribute("result1", result1);
		return "background/BackgroundVideoAdd";
	}
	@RequestMapping("videoAdd.do")
	public String videoAddSuccess(Video video) {
		 videoService.insert(video);
		 return "forward:VideoShowAgain";
	}
	
	@RequestMapping("videoDelete.do")
	public void videoDeleteOne(int id,HttpServletResponse resp) {
		videoService.deleteByPrimaryKey(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@RequestMapping("videoDeleteAll.do")
	public String videoDeleteMany(String ids) {
		 List<Integer> list = JSON.parseArray(ids,Integer.class);
		 for (Integer id : list) {
			videoService.deleteByPrimaryKey(id);
		}
		 return "forward:VideoShowAgain";
	}
}
