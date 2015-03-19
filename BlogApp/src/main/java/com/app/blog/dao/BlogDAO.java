package com.app.blog.dao;

import java.util.List;

import com.app.blog.model.BlogComment;
import com.app.blog.model.BlogPost;

public interface BlogDAO {

	void saveBlog(BlogPost blog);
	
	public List<BlogPost> getBlogByAuthorId(long authorId);

	void saveComment(BlogComment comment);
	
	public BlogPost getBlogById(long blogId);

}
