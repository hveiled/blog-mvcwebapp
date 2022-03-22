package com.example.mvc.services;

import com.example.mvc.models.Post;
import com.example.mvc.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

	private final PostRepository repository;

	public List<Post> getAllPosts() {
		return repository.findAll();
	}

	public void savePost(Post post) {
		repository.save(post);
	}
}
