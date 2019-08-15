package com.zhiyou.backgroundservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.backgroundservice.BackVideoService;
import com.zhiyou.dao.VideoMapper;
import com.zhiyou.model.Video;
import com.zhiyou.model.VideoExample;
@Service
public class BackVideoServiceImpl implements BackVideoService{
	
	@Autowired
	VideoMapper vm;
	
	@Override
	public long countByExample(VideoExample example) {
		// TODO Auto-generated method stub
		return vm.countByExample(example);
	}

	@Override
	public int deleteByExample(VideoExample example) {
		// TODO Auto-generated method stub
		return vm.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer videoId) {
		// TODO Auto-generated method stub
		return vm.deleteByPrimaryKey(videoId);
	}

	@Override
	public int insert(Video record) {
		// TODO Auto-generated method stub
		return vm.insert(record);
	}

	@Override
	public int insertSelective(Video record) {
		// TODO Auto-generated method stub
		return vm.insertSelective(record);
	}

	@Override
	public List<Video> selectByExample(VideoExample example) {
		// TODO Auto-generated method stub
		return vm.selectByExample(example);
	}

	@Override
	public Video selectByPrimaryKey(Integer videoId) {
		// TODO Auto-generated method stub
		return vm.selectByPrimaryKey(videoId);
	}

	@Override
	public int updateByExampleSelective(Video record, VideoExample example) {
		// TODO Auto-generated method stub
		return vm.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Video record, VideoExample example) {
		// TODO Auto-generated method stub
		return vm.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Video record) {
		// TODO Auto-generated method stub
		return vm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Video record) {
		// TODO Auto-generated method stub
		return vm.updateByPrimaryKey(record);
	}

	@Override
	public List<Video> select() {
		// TODO Auto-generated method stub
		return vm.select();
	}



}
