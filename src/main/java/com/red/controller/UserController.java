package com.red.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.red.model.User;
import com.red.repo.UserRepository;

@Controller
public class UserController 
{
	@Autowired
	UserRepository urepo;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/login")
	public String getLogin()
	{
		return "login";
	}
	
	
	  @PostMapping("/addUser") public ModelAndView
	  addUser(@RequestParam("user_email") String user_email, User user) {
	  ModelAndView mv=new ModelAndView("success"); List<User>
	  list=urepo.findByEMAIL(user_email);
	  
	  if(list.size()!=0) { mv.addObject("message",
	  "Oops!  There is already a user registered with the email provided.");
	  
	  } else { urepo.save(user); mv.addObject("message","Logged In"); }
	  
	  return mv; }
	 
	
	
	
}
