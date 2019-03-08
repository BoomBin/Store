package com.itheima.dao;

import com.itheima.domain.User;

public interface UserDao {

	void add(User user) throws Exception;

	User getByUsernameAndPwd(String username, String password) throws Exception;

}
