package com.app.blog.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.blog.model.User;

@Transactional
@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	
	private static final int FIRST_ELEMENT = 0;
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void saveUser(User user){
		
		sessionFactory.getCurrentSession().save(user);
	}


	@SuppressWarnings("unchecked")
	@Override
	public User findUserByEmailId(String email) {
		
		List<User> userList = sessionFactory.getCurrentSession().createQuery("From User where email ='" + email + "'").list();
		
		if(userList!=null && !userList.isEmpty()){
			
			return userList.get(FIRST_ELEMENT);
			
		}
		
		return null;
		
	}
}
