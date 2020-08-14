package com.jesjesti.comments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jesjesti.comments.entity.CommentBean;

@Repository
public interface CommentRepository extends MongoRepository<CommentBean, String> {

}
