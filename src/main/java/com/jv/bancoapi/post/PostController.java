package com.jv.bancoapi.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/post")
	public List<Post> getAllPosts() {
		List<Post> list = new ArrayList<>();
		for (Post post : postRepository.findAll()) list.add(post);
		java.util.Collections.reverse(list);
		return list;
	}
	
	@GetMapping("/user/{userId}/post")
	public List<Post> getUserPosts(@PathVariable String userId) {
		List<Post> list = postRepository.findByFkUserId(userId);
		java.util.Collections.reverse(list);
		return list;
	}
	
	@RequestMapping(value = {"/post", "/createPost"}, method = RequestMethod.POST)
	public void addUserPost(@RequestBody Post post) {
		postRepository.save(post);
	}
}
