package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.UserService;

@Controller

public class LoginController {
	 int count=1;
	@Autowired
	UserService userService;

	
    @RequestMapping("loginForm")
    String loginForm() {
        return "loginForm";
    }
    
    
    @RequestMapping(value="loginForm/abc",method=RequestMethod.GET)
    public @ResponseBody String dataChange1(){
	   
    	return String.valueOf(count=count+2);
    }
    
  
	 
	
  
    
    }
    
   