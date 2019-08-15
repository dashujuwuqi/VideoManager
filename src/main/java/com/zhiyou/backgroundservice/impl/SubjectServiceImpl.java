package com.zhiyou.backgroundservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.backgroundservice.SubjectService;
import com.zhiyou.dao.SubjectMapper;
import com.zhiyou.model.Subject;
import com.zhiyou.model.SubjectExample;
@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectMapper sm;
	@Override
	public long countByExample(SubjectExample example) {
		// TODO Auto-generated method stub
		return sm.countByExample(example);
	}

	@Override
	public int deleteByExample(SubjectExample example) {
		// TODO Auto-generated method stub
		return sm.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer subjectId) {
		// TODO Auto-generated method stub
		return sm.deleteByPrimaryKey(subjectId);
	}

	@Override
	public int insert(Subject record) {
		// TODO Auto-generated method stub
		return sm.insert(record);
	}

	@Override
	public int insertSelective(Subject record) {
		// TODO Auto-generated method stub
		return sm.insertSelective(record);
	}

	@Override
	public List<Subject> selectByExample(SubjectExample example) {
		// TODO Auto-generated method stub
		return sm.selectByExample(example);
	}

	@Override
	public Subject selectByPrimaryKey(Integer subjectId) {
		// TODO Auto-generated method stub
		return sm.selectByPrimaryKey(subjectId);
	}

	@Override
	public int updateByExampleSelective(Subject record, SubjectExample example) {
		// TODO Auto-generated method stub
		return sm.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Subject record, SubjectExample example) {
		// TODO Auto-generated method stub
		return sm.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Subject record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Subject record) {
		// TODO Auto-generated method stub
		return sm.updateByPrimaryKey(record);
	}

}
