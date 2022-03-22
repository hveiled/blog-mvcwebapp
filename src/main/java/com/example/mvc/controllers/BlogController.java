package com.example.mvc.controllers;

import com.example.mvc.models.Post;
import com.example.mvc.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BlogController {

	private final PostService service;

	@GetMapping("/blog")
	public String blog(Model model) {
		model.addAttribute("posts", service.getAllPosts());
		return "blog-main";
	}

	@GetMapping("/blog/add")
	public String addPost(Model model) {
		return "post-add";
	}

	@PostMapping("/blog/add")
	public String submitNewPost(Post post) {
		service.savePost(post);
		return "redirect:/blog";
	}

//	@GetMapping("/blog/{id}")
//	public String details(@PathVariable(name = "id") long id) {
//		return "post-add";
//	}
}
