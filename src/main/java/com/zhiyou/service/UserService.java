package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;

public interface UserService {
	List<User> selectByExample(UserExample example);
	
	int insertSelective(User record);
	
	int updateByExampleSelective(User record,UserExample example);
}
