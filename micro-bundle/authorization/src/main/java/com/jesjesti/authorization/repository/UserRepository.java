package com.jesjesti.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesjesti.authorization.entity.UserBean;

public interface UserRepository extends JpaRepository<UserBean, Integer> {

	UserBean findByUserName(String username);

}
