package com.app.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.dao.UserDAO;
import com.app.blog.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Override
	public void saveUser(User user) {
		
		userDAO.saveUser(user);
	}

	@Override
	public User findUserByLogin(String email, String password) {

		User user = userDAO.findUserByEmailId(email);
		
		if(user!=null && passwordMatch(password, user.getPassword()))  {
			
			return user;
		}
		
		return  null;
	}

	private boolean passwordMatch(String password, String dbPassword) {
		
		return dbPassword.equals(password);
	}

}
