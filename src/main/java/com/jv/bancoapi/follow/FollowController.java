package com.jv.bancoapi.follow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FollowController {
	
	@Autowired
	private FollowRepository followRepository;
	
	@GetMapping("/follow")
	public List<Follow> getAllFollow() {
		List<Follow> list = new ArrayList<>();
		followRepository.findAll().forEach(list::add);
		return list;
	}
	
	@PostMapping("/user/{userId}/follow/{followId}")
	public void addFollow(@PathVariable String userId, @PathVariable String followId) {
		followRepository.save(new Follow(userId, followId));
	}
	
	@GetMapping("/user/{userId}/following")
	public List<String> getFollowing(@PathVariable String userId) {
		List<String> list = new ArrayList<>();
		for (Follow f : followRepository.findByFromId(userId)) list.add(f.getToId());
		return list;
	}
	
	@GetMapping("/user/{userId}/followers")
	public List<String> getFollowers(@PathVariable String userId) {
		List<String> list = new ArrayList<>();
		for (Follow f : followRepository.findByToId(userId)) list.add(f.getFromId());
		return list;
	}
	
	@GetMapping("user/{id}/following/count")
	public int getFollowingCount(@PathVariable String id) {
		return followRepository.countByFromId(id);
	}
	
	@GetMapping("user/{id}/followers/count")
	public int getFollowerCount(@PathVariable String id) {
		return followRepository.countByToId(id);
	}
	
}
