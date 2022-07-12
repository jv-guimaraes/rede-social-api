package com.jv.bancoapi.like;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LikeRepository extends CrudRepository<Like, Long>{
	public List<Like> findByPostId(long id);
	
	public int countByPostId(long id);
}
