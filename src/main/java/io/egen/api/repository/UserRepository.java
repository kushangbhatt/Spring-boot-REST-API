package io.egen.api.repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import io.egen.api.entity.User;

public interface UserRepository extends Repository<User, String>{

	public List<User> findAll();
	
	//public Page<User> findAll(Pageable pageable); 
	
	public Optional<User> findOne(String id);
	
	public Optional<User> findByEmail(String email);
	
	public User save(User user);
	
	public void delete(User user);
}
