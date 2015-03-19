package com.app.blog.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.blog.model.BlogComment;
import com.app.blog.model.BlogPost;

@Transactional
@Repository("blogDAO")
public class BlogDAOImpl implements BlogDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveBlog(BlogPost blog) {

		sessionFactory.getCurrentSession().save(blog);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<BlogPost> getBlogByAuthorId(long authorId) {
		
		return (List<BlogPost>) sessionFactory.getCurrentSession().createQuery("From BlogPost blog left outer join fetch blog.comment  join fetch blog.user where blog.user.userId =' " + authorId + "'  order by blog.createdDate desc").list();
	}


	@Override
	public void saveComment(BlogComment comment) {
		
		sessionFactory.getCurrentSession().save(comment);
		
	}


	@Override
	public BlogPost getBlogById(long blogId) {
		
		BlogPost blog = (BlogPost) sessionFactory.getCurrentSession().load(BlogPost.class, blogId);
		
		return blog;
	}
	

}
