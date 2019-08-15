package com.zhiyou.service.center.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.UserMapper;
import com.zhiyou.model.User;
import com.zhiyou.service.center.CenterService;
@Service
public class CenterServiceImpl implements CenterService{
	@Autowired
	private UserMapper userMapper;
	@Override
	public void update(User user) {
		userMapper.updateByPrimaryKey(user)	;
	}

}
