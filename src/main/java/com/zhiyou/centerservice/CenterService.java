package com.zhiyou.centerservice;

import com.zhiyou.model.User;

public interface CenterService {
	void update(User user);
	User selectById(int userId);
}
