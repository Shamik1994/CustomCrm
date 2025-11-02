package com.example.Crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Crm.bean.UserDetail;
import com.example.Crm.repository.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	@Transactional
	public void createUser(UserDetail user)
	{
		userRepo.save(user);
	}
	public List<UserDetail> validateUser(String userName, String password)
	{
		return userRepo.validateUser(userName,password);
		
	}
}
