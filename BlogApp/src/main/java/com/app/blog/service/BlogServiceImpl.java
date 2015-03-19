package com.app.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.dao.BlogDAO;
import com.app.blog.model.BlogComment;
import com.app.blog.model.BlogPost;

@Service("blogService")
public class BlogServiceImpl implements BlogService{

	@Autowired
	private BlogDAO blogDAO;
	
	
	@Override
	public void saveBlog(BlogPost blog) {
		
		blogDAO.saveBlog(blog);
		
	}

	@Override
	public List<BlogPost> getBlogByAuthorId(long authorId) {
		
		return blogDAO.getBlogByAuthorId(authorId);
	}

	@Override
	public void saveComment(BlogComment comment) {
		
		blogDAO.saveComment(comment);
		
	}

}
