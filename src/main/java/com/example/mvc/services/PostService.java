package com.example.mvc.services;

import com.example.mvc.models.Post;
import com.example.mvc.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

	public Post getPostById(long id) {
		Optional<Post> optionalPost = repository.findById(id);
		return optionalPost.get();
	}

	public boolean existById(long id) {
		return repository.existsById(id);
	}

	public void deletePost(long id) {
		repository.deleteById(id);
	}
}
