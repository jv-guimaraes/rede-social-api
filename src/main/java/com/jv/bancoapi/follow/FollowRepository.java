package com.jv.bancoapi.follow;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, Long> {
	public List<Follow> findByToId(String to);
	
	public List<Follow> findByFromId(String from);
	
	public int countByFromId(String from);
	
	public int countByToId(String to);
}
