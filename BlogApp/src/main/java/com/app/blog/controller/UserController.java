package com.app.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.blog.model.User;
import com.app.blog.service.BlogService;
import com.app.blog.service.UserService;


@Controller
public class UserController {


	@Autowired
	private UserService userService;
	
	@Autowired
	private BlogService blogService;
	
	
	@RequestMapping("/registration")
	public String showRegistration(){
		
		return "registration";
	}

	@RequestMapping(value="userSignUp",method=RequestMethod.POST)
	public String userSignUp(@ModelAttribute("user") User user, HttpSession session) {
		
		userService.saveUser(user);
		
		session.setAttribute("user", user);
		
		return "userHome";
	}

	@RequestMapping(value="userLogin",method=RequestMethod.POST)
	public String userLogin(@ModelAttribute("user")User user, Model model, HttpSession session){
		
		User userObj = userService.findUserByLogin(user.getEmail(),user.getPassword());
		
		String viewPage = "userHome";
		
		if(userObj == null) {
			
			model.addAttribute("message","Wrong Credentials");
			
			viewPage ="home";
			
			return viewPage;
			
		} else {
			
			model.addAttribute("blogs", blogService.getBlogByAuthorId(userObj.getUserId()));
			
			session.setAttribute("user", userObj);
		}
		
		
		
		return viewPage;
	}
	
	@RequestMapping("/userLogin")
	public String authenticateUser(HttpSession session){
		
		String viewPage = "userHome";
		
		if(session.getAttribute("user") == null) {
			
			viewPage ="home";
			
			return viewPage;
		}
		
		return viewPage;
	}
	
	@RequestMapping("logout")
	public String userLogout(HttpServletRequest request){
		
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			
			session.removeAttribute("user");
			session.invalidate();
		}
		
		return "home";
	}
	
	
}
