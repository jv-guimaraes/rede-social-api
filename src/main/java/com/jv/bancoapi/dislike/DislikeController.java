package com.jv.bancoapi.dislike;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DislikeController {
	
	@Autowired
	private DislikeRepository dislikeRepository;
	
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
	
	@PutMapping("/dislike")
	public void addLike(@RequestBody Dislike dislike) {
		dislikeRepository.save(dislike);
	}
	
	@DeleteMapping("/dislike/{id}")
	public void deleteLike(@PathVariable long id) {
		dislikeRepository.deleteById(id);
	}
}
