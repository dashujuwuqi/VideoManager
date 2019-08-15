package com.zhiyou.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.VideoExtensionMapper;
import com.zhiyou.dao.VideoMapper;
import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;
import com.zhiyou.model.VideoExtension;
import com.zhiyou.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	VideoExtensionMapper videoMapper;
	@Autowired
	VideoMapper videoMapper1;

	@Override
	public VideoExtension videoPlay(int videoId) {
		// TODO Auto-generated method stub
		return videoMapper.videoPlay(videoId);
	}

	@Override
	public void updatePlayNum(Video video, VideoExample example) {
		// TODO Auto-generated method stub
		videoMapper1.updateByExampleSelective(video, example);
	}
}
