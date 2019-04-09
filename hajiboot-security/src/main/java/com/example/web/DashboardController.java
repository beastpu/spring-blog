package com.example.web;




import org.springframework.stereotype.Controller;




import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("dashboard")


public class DashboardController {
	
	int count=17;
	
	 @RequestMapping(method = RequestMethod.GET)
	String index(){
		return "dashboard/index";
	} 
	 
	 @RequestMapping(value="ab",method=RequestMethod.GET)
	    public @ResponseBody String dataChange(){
		   System.out.println(count);
	    	return String.valueOf(count++);
	    }
	 
	 
	 @RequestMapping(value="abc",method=RequestMethod.GET)
	    public @ResponseBody String dataChange1(){
		   
	    	return String.valueOf(count=count+2);
	    }
	 
	
	    
}
