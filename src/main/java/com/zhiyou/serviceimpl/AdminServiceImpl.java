package com.zhiyou.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.dao.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;
import com.zhiyou.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper adminMapper;
	@Override
	public List<Admin> selectByExample(AdminExample example) {
		// TODO Auto-generated method stub
		return adminMapper.selectByExample(example);
	}

}
