package com.example.web;

import com.example.domain.User;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.service.UserService;

@Controller
@RequestMapping("/sign")
public class SignController {

	@Autowired
	UserService userService;
	
	
	@ModelAttribute
    User setUpForm() {
        return new User();
    }
    
    
	
	@RequestMapping(method=RequestMethod.GET)
	String sign(Model model1){
		
		return "/sign";
	}
	@RequestMapping(method=RequestMethod.POST)
	String create(@ModelAttribute User user,BindingResult result,Model model1){
		model1.addAttribute("user",new User());
		 model1.addAttribute("user", user);
		userService.create(user);
		return "/sign";
	}
	
	}


