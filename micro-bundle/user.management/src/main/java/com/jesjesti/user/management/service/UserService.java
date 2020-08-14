package com.jesjesti.user.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesjesti.user.management.entity.UserDetailsBean;
import com.jesjesti.user.management.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;

	public UserDetailsBean save(UserDetailsBean bean) {
		repository.save(bean);
		return bean;
	}

	public void delete(UserDetailsBean bean) {
		repository.delete(bean);
	}

	public UserRepository getRepository() {
		return repository;
	}

}
