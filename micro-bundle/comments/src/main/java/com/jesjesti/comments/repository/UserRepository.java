package com.jesjesti.comments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jesjesti.comments.entity.UserBean;

@Repository
public interface UserRepository extends MongoRepository<UserBean, String> {

}
