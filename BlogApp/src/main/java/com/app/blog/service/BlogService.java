package com.app.blog.service;

import java.util.List;

import com.app.blog.model.BlogComment;
import com.app.blog.model.BlogPost;

public interface BlogService {

	void saveBlog(BlogPost blog);
	
	public List<BlogPost> getBlogByAuthorId(long authorId);

	void saveComment(BlogComment comment);

}
