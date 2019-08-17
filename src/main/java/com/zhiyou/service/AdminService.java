package com.zhiyou.service;

import java.util.List;

import com.zhiyou.model.Admin;
import com.zhiyou.model.AdminExample;

public interface AdminService {
	List<Admin> selectByExample(AdminExample example);
}
