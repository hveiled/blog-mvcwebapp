package com.example.mvc.controllers;

import com.example.mvc.models.Post;
import com.example.mvc.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

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

	@GetMapping("/blog/{id}")
	public String details(@PathVariable(value = "id") long id, Model model) {
		if (!service.existById(id)) {
			return "redirect:/blog";
		}
		Post post = service.getPostById(id);
		int limit = 20;
		String fullTitle = post.getTitle();
		String subStr = fullTitle.length() > limit ? fullTitle.substring(0, limit) : fullTitle;
//		model.addAttribute("views", )
		model.addAttribute("title", subStr);
		model.addAttribute("post", post);
		return "post-details";
	}

	@GetMapping("/blog/{id}/edit")
	public String postEdit(@PathVariable(value = "id") long id, Model model) {
		if (!service.existById(id)) {
			return "redirect:/blog";
		}
		Post post = service.getPostById(id);
//		model.addAttribute("views", )
		model.addAttribute("title", post.getTitle());
		model.addAttribute("post", post);
		return "post-edit";
	}

	@PostMapping("/blog/{id}/edit")
	public String updatePost(@PathVariable(value = "id") long id,
	                         Post post) {
		post.setId(id);
		service.savePost(post);
		return "redirect:/blog";
	}

	@PostMapping("/blog/{id}/remove")
	public String removePost(@PathVariable(value = "id") long id) {
		if (!service.existById(id)) {
			return "redirect:/blog";
		}
		service.deletePost(id);
		return "redirect:/blog";
	}
}
