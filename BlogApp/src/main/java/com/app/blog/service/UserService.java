package com.app.blog.service;

import com.app.blog.model.User;

public interface UserService {

	void saveUser(User user);

	User findUserByLogin(String email, String password);
	
}
