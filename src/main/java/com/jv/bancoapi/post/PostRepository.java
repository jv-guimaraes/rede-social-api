package com.jv.bancoapi.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long>{
	public List<Post> findByFkUserId(String userId);
}
