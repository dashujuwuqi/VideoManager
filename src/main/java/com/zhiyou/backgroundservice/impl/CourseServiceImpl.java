package com.zhiyou.backgroundservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.backgroundservice.CourseService;
import com.zhiyou.dao.CourseMapper;
import com.zhiyou.model.Course;
import com.zhiyou.model.CourseExample;
@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseMapper cm;
	@Override
	public long countByExample(CourseExample example) {
		// TODO Auto-generated method stub
		return cm.countByExample(example);
	}

	@Override
	public int deleteByExample(CourseExample example) {
		// TODO Auto-generated method stub
		return cm.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cm.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Course record) {
		// TODO Auto-generated method stub
		return cm.insert(record);
	}

	@Override
	public int insertSelective(Course record) {
		// TODO Auto-generated method stub
		return cm.insertSelective(record);
	}

	@Override
	public List<Course> selectByExample(CourseExample example) {
		// TODO Auto-generated method stub
		return cm.selectByExample(example);
	}

	@Override
	public Course selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(Course record, CourseExample example) {
		// TODO Auto-generated method stub
		return cm.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Course record, CourseExample example) {
		// TODO Auto-generated method stub
		return cm.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Course record) {
		// TODO Auto-generated method stub
		return cm.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Course record) {
		// TODO Auto-generated method stub
		return cm.updateByPrimaryKey(record);
	}

}
