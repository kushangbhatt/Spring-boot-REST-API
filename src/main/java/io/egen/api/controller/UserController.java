package io.egen.api.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.api.entity.User;
import io.egen.api.service.UserService;

//@Controller
@RestController
public class UserController {
	
	private UserService service;
	
	public UserController(UserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}

	//@ResponseBody //Whatever we get from this method tied back to the response body.
	@RequestMapping(method = RequestMethod.GET, value = "/users", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll(){
		return service.findAll();
	}
	
	//@ResponseBody
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}", produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}
	
	//@ResponseBody
	@RequestMapping(method = RequestMethod.POST, value = "/users", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE )
	public User create(@RequestBody User user) {
		return service.create(user);
	}
	
	//@ResponseBody
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE )
	public User update(@PathVariable("id") String id, @RequestBody User user) {
		return service.update(id, user);
	}
	
	//@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces= MediaType.APPLICATION_JSON_UTF8_VALUE )
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
}
