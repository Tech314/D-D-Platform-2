package com.tech314.DDDataService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech314.DDDataService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUserId(Long userId);
	User findByUserName(String userName);
	User findByEmail(String email);

}
