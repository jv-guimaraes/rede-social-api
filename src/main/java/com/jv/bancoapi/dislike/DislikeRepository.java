package com.jv.bancoapi.dislike;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DislikeRepository extends CrudRepository<Dislike, Long>{
	public List<Dislike> findByPostId(long id);
	
	public int countByPostId(long id);
}
