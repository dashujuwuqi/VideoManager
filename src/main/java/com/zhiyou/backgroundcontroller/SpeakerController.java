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
import com.zhiyou.backgroundservice.SpeakerService;
import com.zhiyou.backgroundutil.VideoResult;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.SpeakerExample;

@Controller
public class SpeakerController {

	@Autowired
	SpeakerService speakerService;

	@RequestMapping("Back-Speaker-Show")
	public String speakerShow(HttpServletRequest req) {
		SpeakerExample example = new SpeakerExample();
		int count = speakerService.selectByExample(example).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Speaker> list = speakerService.selectByExample(example);
		VideoResult result = new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundSpeakerShow";

	}

	@RequestMapping("SpeakerShowAgain.do")
	public String speakerShowAgain(HttpServletRequest req) {
		SpeakerExample example = new SpeakerExample();
		int count = speakerService.selectByExample(example).size();
		req.setAttribute("count", count);
		String pages = req.getParameter("page");
		int page = pages == null || pages.equals("") ? 1 : Integer.valueOf(pages);
		req.setAttribute("page", page);
		PageHelper.startPage(page, 5);
		List<Speaker> list = speakerService.selectByExample(example);
		VideoResult result = new VideoResult();
		result.setData(list);
		req.setAttribute("result", result);
		return "background/BackgroundSpeakerShow";

	}

	@RequestMapping("BackgroundSpeakerAddShow.do")
	public String speakerAddShow() {
		return "background/BackgroundSpeakerAdd";
	}

	@RequestMapping("speakerAdd.do")
	public String speakerAddSuccess(Speaker speaker) {
		speakerService.insert(speaker);
		return "forward:SpeakerShowAgain.do";
	}
	
	@RequestMapping("speakerDelete.do")
	public void speakerDeleteOne(int id,HttpServletResponse resp) {
		speakerService.deleteByPrimaryKey(id);
		try {
			resp.getWriter().write("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("speakerUpdateShow.do")
	public String speakerUpdateShow(int id ,HttpServletRequest req) {
		Speaker speaker = speakerService.selectByPrimaryKey(id);
		VideoResult result =new VideoResult();
		result.setData(speaker);
		req.setAttribute("result", result);
		return "background/BackgroundSpeakerUpdate";
	}
	
	@RequestMapping("speakerUpdate.do")
	public String speakerUpdateSuccess(Speaker speaker) {
		speakerService.updateByPrimaryKey(speaker);
		return "forward:SpeakerShowAgain.do";
	}
	
	@RequestMapping("speakerDeleteAll.do")
	public String speakerDeleteMany(String ids) {
		List<Integer> list = JSON.parseArray(ids,Integer.class);
		for (Integer id : list) {
			speakerService.deleteByPrimaryKey(id);
		}
		return "forward:SpeakerShowAgain.do";
	}
}
