package com.zhiyou.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.model.CourseExtension;
import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;
import com.zhiyou.model.VideoExample.Criteria;
import com.zhiyou.model.VideoExtension;
import com.zhiyou.serviceimpl.CourseServiceImpl;
import com.zhiyou.serviceimpl.VideoServiceImpl;
import com.zhiyou.utils.VideoResult;


@Controller
public class VideoController {
	@Autowired
	VideoServiceImpl videoService;
	@Autowired
	CourseServiceImpl courseService;
	@SuppressWarnings("unused")
	@RequestMapping("videoPlay.do")
	public String videoPlay(String videoId,String subjectId,HttpServletRequest req) {
		//System.out.println(subjectId);
		VideoResult result = new VideoResult();
		Map<String, Object> map = new HashMap<String,Object>();
		VideoExtension videoPlay = videoService.videoPlay(Integer.valueOf(videoId));
		int playNum = videoPlay.getPlayNum()+1;
		Video video = new Video();
		video.setPlayNum(playNum);
		video.setVideoId(Integer.valueOf(videoId));
		VideoExample example = new VideoExample();
		Criteria criteria = example.createCriteria();
		criteria.andVideoIdEqualTo(Integer.valueOf(videoId));
		videoService.updatePlayNum(video, example);
		List<CourseExtension> list = courseService.selectBySubjectid(Integer.valueOf(subjectId));
		if(videoPlay == null) {
			req.setAttribute("msg","没有视频");
			return "foreground/CourseShow";
		}
		map.put("list",list);
		map.put("videoPlay",videoPlay);
		map.put("subjectId",subjectId);
		result.setData(map);
		result.setMsg("成功了");
		result.setStatus(200);
		req.setAttribute("result",result);
		return "foreground/VideoPlay";
	}
}
