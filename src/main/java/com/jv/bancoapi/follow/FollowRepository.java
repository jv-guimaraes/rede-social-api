package com.jv.bancoapi.follow;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, Long> {
	public List<Follow> findByFollower(String follower);
	
	public List<Follow> findByFollowing(String following);
	
	public int countByFollower(String follower);
	
	public int countByFollowing(String following);
}
