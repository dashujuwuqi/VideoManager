package com.zhiyou.backgroundservice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.backgroundservice.BackAdminService;
import com.zhiyou.dao.AdminMapper;
import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;
@Service
public class BackAdminServiceImpl implements BackAdminService{
	
	@Autowired
	AdminMapper am;
	@Override
	public long countByExample(AdminExample example) {
		// TODO Auto-generated method stub
		return am.countByExample(example);
	}

	@Override
	public int deleteByExample(AdminExample example) {
		// TODO Auto-generated method stub
		return am.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Integer adminId) {
		// TODO Auto-generated method stub
		return am.deleteByPrimaryKey(adminId);
	}

	@Override
	public int insert(Admin record) {
		// TODO Auto-generated method stub
		return am.insert(record);
	}

	@Override
	public int insertSelective(Admin record) {
		// TODO Auto-generated method stub
		return am.insertSelective(record);
	}

	@Override
	public List<Admin> selectByExample(AdminExample example) {
		// TODO Auto-generated method stub
		return am.selectByExample(example);
	}

	@Override
	public Admin selectByPrimaryKey(Integer adminId) {
		// TODO Auto-generated method stub
		return am.selectByPrimaryKey(adminId);
	}

	@Override
	public int updateByExampleSelective(Admin record, AdminExample example) {
		// TODO Auto-generated method stub
		return am.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(Admin record, AdminExample example) {
		// TODO Auto-generated method stub
		return am.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(Admin record) {
		// TODO Auto-generated method stub
		return am.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Admin record) {
		// TODO Auto-generated method stub
		return am.updateByPrimaryKey(record);
	}

}
