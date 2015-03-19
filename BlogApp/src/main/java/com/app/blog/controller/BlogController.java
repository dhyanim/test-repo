package com.app.blog.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.blog.model.BlogComment;
import com.app.blog.model.BlogPost;
import com.app.blog.model.User;
import com.app.blog.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	
	@RequestMapping("/newBlog")
	public String blogForm(){
		
		return "blogForm";
	}

	@RequestMapping(value="blogPost", method=RequestMethod.POST)
	public String saveBlog(@ModelAttribute("blog")BlogPost blog, HttpSession session, Model model) {
		
		User user = (User)session.getAttribute("user");
		
		setUserForBlog(blog,user);
		
		blogService.saveBlog(blog);
		
		model.addAttribute("blogs", blogService.getBlogByAuthorId(user.getUserId()));
		
		return "userHome";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="addblogComment", method=RequestMethod.POST)
	public void  addCommentForBlog(@ModelAttribute("comment")BlogComment comment,@RequestParam("blogId")long blogId, HttpServletResponse response) throws IOException{

		response.setContentType("application/json");
		
		setBlogIdForComment(comment,blogId);
		
		blogService.saveComment(comment);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("comment", comment.getCommentDesc());
		
		writeResponse(jsonObject.toString(),response);
	}

	private void setBlogIdForComment(BlogComment comment, long blogId) {
		
		BlogPost blog = new BlogPost();
		blog.setBlogId(blogId);
		comment.setBlogPost(blog);
	}

	private void writeResponse(String message, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		out.write(message);
		
		out.close();
		
		out.flush();
	
	}

	private void setUserForBlog(BlogPost blog, User user) {
		
		blog.setUser(user);
	}
}
