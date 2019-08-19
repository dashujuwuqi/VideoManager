package com.zhiyou.centerservice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.centerservice.CenterService;
import com.zhiyou.dao.UserMapper;
import com.zhiyou.model.User;
@Service
public class CenterServiceImpl implements CenterService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public User selectById(int userId) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(userId);
	}

}
