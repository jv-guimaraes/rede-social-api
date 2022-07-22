package com.jv.bancoapi.like;

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

import com.jv.bancoapi.dislike.Dislike;
import com.jv.bancoapi.post.Post;
import com.jv.bancoapi.post.PostRepository;

@RestController
public class LikeController {
	
	@Autowired
	private LikeRepository likeRepository;
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/like")
	public List<Like> getAllLikes() {
		List<Like> list = new ArrayList<>();
		for ( Like like : likeRepository.findAll() ) list.add(like);
		return list;
	}
	
	@GetMapping("/post/{id}/like")
	public List<Like> getLikesByPostId(@PathVariable long id) {
		return likeRepository.findByPostId(id);
	}
	
	@GetMapping("/post/{id}/like/count")
	public int getCountByPostId(@PathVariable long id) {
		return likeRepository.countByPostId(id);
	}
	
	@PostMapping("/like")
	public void addLike(@RequestBody Like like) {
		Post post = postRepository.findById(like.getPostId()).orElse(null);
		post.setLikesAmount(post.getLikesAmount() + 1);
		postRepository.save(post);
		likeRepository.save(like);
	}
	
	@DeleteMapping("/like/{id}")
	public void deleteLike(@PathVariable long id) {
		Like like = likeRepository.findById(id).orElse(null);
		Post post = postRepository.findById(like.getPostId()).orElse(null);
		post.setLikesAmount(post.getLikesAmount() - 1);
		postRepository.save(post);
		likeRepository.deleteById(id);
	}
}
