package com.example.mvc.controllers;

import com.example.mvc.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final PostService service;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("title", "Главная страница");
		model.addAttribute("posts", service.getAllPosts());
		return "home";
	}

	@GetMapping("/about")
	public String about(Model model) {
		model.addAttribute("title", "O нас");
		return "about";
	}
}
