package com.jesjesti.authorization.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jesjesti.authorization.entity.UserBean;
import com.jesjesti.authorization.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository repository;

	public UserRepository getRepository() {
		return repository;
	}

	public UserBean save(UserBean bean) {
		UserBean savedBean = repository.save(bean);
		return savedBean;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserBean userBean = repository.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(userBean.getUserName(), userBean.getPassword(),
				new ArrayList<>());
	}

}
