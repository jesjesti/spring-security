package com.jesjesti.comments.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesjesti.comments.entity.CommentBean;
import com.jesjesti.comments.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private CommentRepository repository;

	public CommentBean save(CommentBean bean) {
		CommentBean savedBean = repository.save(bean);
		return savedBean;
	}

	public CommentRepository getRepository() {
		return repository;
	}

}
