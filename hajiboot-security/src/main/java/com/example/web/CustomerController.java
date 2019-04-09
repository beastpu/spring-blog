package com.example.web;

import com.example.domain.Customer;
import com.example.domain.student;
import com.example.service.CustomerService;
import com.example.service.LoginUserDetails;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("customers")
public class CustomerController {
	int count = 0;
    @Autowired
    CustomerService customerService;

    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm();
    }
    
    
	@RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("fuck", new Date().getMonth());
        
        return "customers/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated CustomerForm form, BindingResult result, Model model,
                  @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return list(model);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customerService.create(customer, userDetails.getUser());
        return "redirect:/customers";
    }

    @RequestMapping(value = "edit", params = "form", method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, form);
        return "customers/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated CustomerForm form, BindingResult result,
                @AuthenticationPrincipal LoginUserDetails userDetails) {
        if (result.hasErrors()) {
            return editForm(id, form);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customer.setId(id);
        customerService.update(customer, userDetails.getUser());
        return "redirect:/customers";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop() {
        return "redirect:/customers";
        
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    String delete(@RequestParam Integer id) {
        customerService.delete(id);
        return "redirect:/customers";
    }
    
    
    @RequestMapping(value="getRandom",method=RequestMethod.GET)
      public @ResponseBody String getRandom(){
    	Random r=new Random();
    	String values="<br/> Radom Value:"+r.nextFloat()*100+"is generated on"+new Date().toString();
           return values;
    	}
    
   
    
    @RequestMapping(value="ajax/{id}",method=RequestMethod.GET)
    public @ResponseBody Customer ajax(@PathVariable(value="id") Integer id,Customer customer){
       customer=customerService.findOne(1);
    	return customer;
    }
    
    
    @RequestMapping(value="json",method=RequestMethod.GET)
    @ResponseBody
  
    public List<Customer> json(){
    	List<Customer> a=customerService.findAll();
    	
    	return  a;
    	}
    
    @RequestMapping(value="add",method=RequestMethod.GET)
    public @ResponseBody String dataChange(){
    	return String.valueOf(count++);
    }
    
    
    @RequestMapping(value="abc",method=RequestMethod.GET)
    public @ResponseBody String dataChange1(){
	   
    	return String.valueOf(count=count+2);
    }
    @RequestMapping(value="kan",method=RequestMethod.GET)
    @ResponseBody
    public List<Customer> c(){
    	return customerService.findAll();
    }
    
    
    
  }


    
