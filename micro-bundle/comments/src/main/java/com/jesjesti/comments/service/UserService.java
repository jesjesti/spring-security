package com.jesjesti.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesjesti.comments.entity.UserBean;
import com.jesjesti.comments.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public UserBean save(UserBean bean) {
		UserBean savedBean = repository.save(bean);
		return savedBean;
	}

	public UserRepository getRepository() {
		return repository;
	}
}
