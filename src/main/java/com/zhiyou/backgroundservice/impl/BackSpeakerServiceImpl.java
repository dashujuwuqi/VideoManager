package com.zhiyou.backgroundservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.backgroundservice.BackSpeakerService;
import com.zhiyou.dao.SpeakerMapper;
import com.zhiyou.model.Speaker;
import com.zhiyou.model.SpeakerExample;
@Service
public class BackSpeakerServiceImpl implements BackSpeakerService{
	@Autowired
	SpeakerMapper sm;
	@Override
	public long countByExample(SpeakerExample example) {
		// TODO Auto-generated method stub
		return sm.countByExample(example);
	}

	@Override
	public int deleteByExample(SpeakerExample example) {
		// TODO Auto-generated method stub
		return sm.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Speaker record) {
		// TODO Auto-generated method stub
		return sm.insert(record);
	}

	@Override
	public int insertSelective(Speaker record) {
		// TODO Auto-generated method stub
		return sm.insertSelective(record);
	}

	@Override
	public List<Speaker> selectByExample(SpeakerExample example) {
		// TODO Auto-generated method stub
		return sm.selectByExample(example);
	}

	@Override
	public Speaker selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Speaker record, SpeakerExample example) {
		// TODO Auto-generated method stub
		return sm.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Speaker record, SpeakerExample example) {
		// TODO Auto-generated method stub
		return sm.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Speaker record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Speaker record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKey(record);
	}

}
