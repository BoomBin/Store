package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.MailUtils;

public class UserServiceImpl implements UserService{

	/**
	 * 用户注册
	 */
	@Override
	public void regist(User user)  throws Exception{
		UserDao dao=new UserDaoImpl();
		dao.add(user);
		//发送邮件
		
		//email:收件人地址
		//emailMsg:邮件的内容
//		String emailMsg="欢迎您注册成我们的一员,<a href='http://localhost/store/user?method=active&code="+user.getCode()+"'>点此激活</a>";
//		MailUtils.sendMail(user.getEmail(), emailMsg);
	}
	/**
	 * 用户登录
	 */
	@Override
	public User login(String username, String password) throws Exception {
		// TODO 用户登录
		UserDao dao = new UserDaoImpl();
		return dao.getByUsernameAndPwd(username,password);
		
	}
}
