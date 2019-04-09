package com.example.service;

import com.example.domain.User;

import com.example.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class UserService {
	 @Autowired 
	 UserRepository userRepository;
	 
  public User create(User user){
	  return userRepository.save(user);
  }
  
}

