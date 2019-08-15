package com.zhiyou.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.VideoMapper;
import com.zhiyou.service.VideoService;
@Service
public class VideoServiceImpl implements VideoService{
	@Autowired
	VideoMapper videoMapper;
}
