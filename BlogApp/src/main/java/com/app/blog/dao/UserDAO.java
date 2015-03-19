package com.app.blog.dao;

import com.app.blog.model.User;

public interface UserDAO {

	public void saveUser(User user);

	public User findUserByEmailId(String email);
	
}
