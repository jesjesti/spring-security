package com.jesjesti.comments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jesjesti.comments.entity.CommentBean;
import com.jesjesti.comments.service.CommentService;
@Controller
@RequestMapping("/comments/")
public class CommentsRest {

	@Autowired
	private CommentService service;

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Object> createComment(@RequestBody CommentBean bean) {
		try {
			bean = service.save(bean);
			return new ResponseEntity(bean, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity("Save Action failed", HttpStatus.PRECONDITION_FAILED);
		}
	}

	@GetMapping(path = "find/all")
	@ResponseBody
	public ResponseEntity<Object> allvendors() {
		List<CommentBean> users = service.getRepository().findAll();
		return new ResponseEntity(users, HttpStatus.OK);
	}
	
	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public ResponseEntity<Object> remove(@RequestBody CommentBean bean) {
		try {
			service.getRepository().delete(bean);
			return new ResponseEntity(bean, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Request Failed", HttpStatus.PRECONDITION_FAILED);
		}
	}
}
