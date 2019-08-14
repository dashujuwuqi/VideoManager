package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.CourseExtension;

public interface CourseService {
	//根据subjectid查询课程
	List<CourseExtension> selectBySubjectid(int id);
}
