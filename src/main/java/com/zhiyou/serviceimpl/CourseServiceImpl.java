package com.zhiyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.CourseExtensionMapper;
import com.zhiyou.model.CourseExtension;
import com.zhiyou.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService{
	@Autowired
	private CourseExtensionMapper courseExtension;
	@Cacheable("COURSE_EXTENSION_LIST")
	@Override
	public List<CourseExtension> selectBySubjectid(int id) {
		// TODO Auto-generated method stub
		return courseExtension.selectBySubjectid(id);
	}


}
