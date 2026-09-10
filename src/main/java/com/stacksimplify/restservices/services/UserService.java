package com.stacksimplify.restservices.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserExistException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//getUser method
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//createUser method
	public User createUser(User user) throws UserExistException{
		//if user exist using username throw error
		User existingUser = userRepository.findUserByUsername(user.getUsername());
		if(existingUser != null) {
			throw new UserExistException("User already exist in the repository");
		}
		return userRepository.save(user);
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException{
		Optional<User> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not found in the repository");
		}
		return user;
	}
	
	//updateUserById method
	
	public User updateUserById(Long id, User user) throws UserNotFoundException{
		Optional<User> OptionalUser = userRepository.findById(id);
		if(!OptionalUser.isPresent()) {
			throw new UserNotFoundException("User Not found in the repository, provide a correct user id");
		}
		user.setId(id);
		return userRepository.save(user);
	}
	
	//deleteUserById method
	public void deleteUserById(Long id) {
		Optional<User> OptionalUser = userRepository.findById(id);
		if(!OptionalUser.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User Not found in the repository, provide a correct user id");
		}
	}
	
	//getUserByUsername method
	public User getUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

}
