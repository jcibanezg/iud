package com.aka.crud.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aka.crud.exception.InvalidUserRequestException;
import com.aka.crud.exception.UserNotFoundException;
import com.aka.crud.model.User;
import com.aka.crud.service.UserService;

/**
 * @author jibanezg
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * GetAll users. Returns HTTP 204 if users not found
	 * @return
	 */
	@RequestMapping(path = { "getall" }, method = { RequestMethod.GET })
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAll();
		if (users.isEmpty()) {
			logger.debug("Users does not exists");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + users.size() + " Users");
		logger.debug(Arrays.toString(users.toArray()));
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	/**
	 * Get user using id. Returns HTTP 404 if user not found
	 * 
	 * @param id
	 * @return retrieved user
	 */
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long userId) {
		/* validate user Id parameter */
		if (null==userId) {
			throw new InvalidUserRequestException();
		}
		
		User user = userService.get(userId);
		
		if(null==user){
			throw new UserNotFoundException();
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(path = { "create" }, method = { RequestMethod.POST })
	public ResponseEntity<User> createUser(@RequestBody User user) {

		User createUser = null;
		createUser = userService.create(user);
		return new ResponseEntity<User>(createUser, HttpStatus.CREATED);
	}
	
	@RequestMapping(path = { "update" },method = RequestMethod.PUT)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User existingUser = userService.get(user.getId());
		if (existingUser == null) {
			logger.debug("User with id " + user.getId() + " does not exists");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			userService.update(user);
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		User user = userService.get(id);
		if (user == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.remove(id);
			logger.debug("User with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
