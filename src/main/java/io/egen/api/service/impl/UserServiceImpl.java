package io.egen.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.api.entity.User;
import io.egen.api.exception.BadRequestException;
import io.egen.api.exception.NotFoundException;
import io.egen.api.repository.UserRepository;
import io.egen.api.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository repository;
	
	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(String id) {
		return repository.findOne(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " does not exist"));
//		User existing = repository.findOne(id);
//		if(existing == null) {
//			//TODO
//			throw new NotFoundException("User with id " + id + " does not exist");
//			//Throw a runtime exceptions here which should return 404 to client
//		}
//		return existing;
	}

	@Override
	@Transactional
	public User create(User user) {
		
		Optional<User> exist = repository.findByEmail(user.getEmail());
		if(exist.isPresent()) {
			throw new BadRequestException("user with email "+ user.getEmail() + " already exist");
			//Throw a runtime exceptions here which should return 400 to client Bad request
		}
		return repository.save(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		repository.findOne(id)
			.orElseThrow(() -> new NotFoundException("User with id " + id + " does not exist"));
//		Optional<User> existing = repository.findOne(id);
//		if(existing == null) {
//			//TODO
//			throw new NotFoundException("User with id " + id + " does not exist");
//			//Throw a runtime exceptions here which should return 404 to client
//		}
		return repository.save(user);
	}

	@Override
	@Transactional
	public void delete(String id) {

		User existing = repository.findOne(id)
				.orElseThrow(() -> new NotFoundException("User with id " + id + " does not exist"));
//		if(existing == null) {
//			//TODO
//			throw new NotFoundException("User with id " + id + " does not exist");
//			//Throw a runtime exceptions here which should return 404 to client
//		}
		
		repository.delete(existing);
		
	}

}
