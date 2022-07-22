package com.jv.bancoapi.dislike;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jv.bancoapi.post.Post;
import com.jv.bancoapi.post.PostRepository;

@RestController
public class DislikeController {
	
	@Autowired
	private DislikeRepository dislikeRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/dislike")
	public List<Dislike> getAllLikes() {
		List<Dislike> list = new ArrayList<>();
		for ( Dislike dislike : dislikeRepository.findAll() ) list.add(dislike);
		return list;
	}
	
	@GetMapping("/post/{id}/dislike")
	public List<Dislike> getLikesByPostId(@PathVariable long id) {
		return dislikeRepository.findByPostId(id);
	}
	
	@GetMapping("/post/{id}/dislike/count")
	public int getCountByPostId(@PathVariable long id) {
		return dislikeRepository.countByPostId(id);
	}
	
	@PostMapping("/dislike")
	public void addLike(@RequestBody Dislike dislike) {
		Post post = postRepository.findById(dislike.getPostId()).orElse(null);
		post.setDislikesAmount(post.getDislikesAmount() + 1);
		postRepository.save(post);
		dislikeRepository.save(dislike);
	}
	
	@DeleteMapping("/dislike/{id}")
	public void deleteLike(@PathVariable long id) {
		Dislike dislike = dislikeRepository.findById(id).orElse(null);
		Post post = postRepository.findById(dislike.getPostId()).orElse(null);
		post.setDislikesAmount(post.getDislikesAmount() - 1);
		postRepository.save(post);
		dislikeRepository.deleteById(id);
	}
}
