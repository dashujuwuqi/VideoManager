package com.zhiyou.dao;

import java.util.List;

import com.zhiyou.model.CourseExtension;

public interface CourseExtensionMapper {
	List<CourseExtension> selectBySubjectid(Integer id);
}
