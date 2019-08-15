package com.zhiyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.model.UserExample;
import com.zhiyou.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	public List<User> selectByExample(UserExample example) {
		// TODO Auto-generated method stub
		return userMapper.selectByExample(example);
	}
	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return userMapper.insertSelective(record);
	}

}
