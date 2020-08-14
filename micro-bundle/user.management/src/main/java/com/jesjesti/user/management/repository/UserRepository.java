package com.jesjesti.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesjesti.user.management.entity.UserDetailsBean;

public interface UserRepository extends JpaRepository<UserDetailsBean,Integer>{

}
