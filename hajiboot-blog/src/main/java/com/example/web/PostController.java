package com.example.web;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.datetime.standard.DateTimeContext;
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

import com.example.domain.Category;
import com.example.domain.Post;
import com.example.repository.CategoryDao;
import com.example.repository.PostDao;


@Controller

public class PostController {

	@Autowired
	private PostDao postDao;
	
	@Autowired
	private CategoryDao categoryDao;
   
	@ModelAttribute
	Post setPost(){
		return new Post();
	}
	
	
	@RequestMapping(value="blog",method = RequestMethod.GET )
	public String list(Model model,@PageableDefault(sort={"id"},size=5) Pageable pageable) {
		
		model.addAttribute("categorylist",categoryDao.findAll());
		Page<Post> page=postDao.findAll(pageable);
	    model.addAttribute("postList", page);
		return "/blog";
	}
	
	
	@RequestMapping(value="write",method = RequestMethod.POST)
	public String write(Post post) {
		post.setReg(new Date());
		return "redirect:/artical/" + postDao.save(post).getId();
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String delete(@RequestParam Integer id){
		postDao.delete(id);
		return "redirect:/blog";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editor(Model model, @RequestParam int id) {
		List<Category> categoryList = categoryDao.findAll();
		model.addAttribute("categorylist",categoryList);
		
		Post post = postDao.findOne(id);
		model.addAttribute("post", post);
		
		return "editForm";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editor1(Model model, @RequestParam int id,@Validated Post post,BindingResult result) {
		
		if (result.hasErrors()) {
			return "editForm";
		}
		post.setReg(new Date());
		post.setId(id);
		
		return "redirect:../artical/"+postDao.save(post).getId();
	}
	
	

	@RequestMapping(value="post",method = RequestMethod.GET)
	public String view() {
		
		return "/post";
	}


	
	@RequestMapping(value="about",method = RequestMethod.GET)
	public String view1() {
		
		return "/about";
	}
	
	@RequestMapping(value="contact",method = RequestMethod.GET)
	public String view2() {
		
		return "/contact";
	}
	
	@RequestMapping(value="artical",method = RequestMethod.GET)
	public String view3(Model model,@RequestParam(value="id")int id,Post post) {
		post=postDao.findOne(id);
		model.addAttribute("post",post);
		return "/artical";
	}
	
	@RequestMapping(value="artical/{id}",method = RequestMethod.GET)
	public String view5(Model model,@PathVariable int id, Post post) {
		post=postDao.findOne(id);
		model.addAttribute("post",post);
		return "/artical";
	}
	
@RequestMapping(value ="form",method = RequestMethod.GET)
	
	public String  add (Model model){
		List<Category> categoryList = categoryDao.findAll();
		model.addAttribute("categorylist",categoryList);
		
		return "/form";
	}

@RequestMapping(value ="category",method = RequestMethod.GET)

  public String  addCategory (Model model,@RequestParam String name){
	
	model.addAttribute("categorylist",categoryDao.findAll());
	model.addAttribute("cate",categoryDao.findOne(name));
	
	
	return "/categoryBlog";
}



	
	
	
	
}