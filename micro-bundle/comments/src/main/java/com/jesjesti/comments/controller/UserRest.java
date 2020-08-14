package com.jesjesti.comments.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jesjesti.comments.entity.UserBean;
import com.jesjesti.comments.service.UserService;

@Controller
@RequestMapping("/comments/user/")
public class UserRest {

	@Autowired
	UserService service;

	@RequestMapping(value = "ping/{message}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByRefId(@PathVariable String message) {
		System.out.println("Inside PING");
		return new ResponseEntity(message, HttpStatus.OK);
	}

	// CREATE
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Object> createUser(@RequestBody UserBean bean) {
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
		List<UserBean> users = service.getRepository().findAll();
		return new ResponseEntity(users, HttpStatus.OK);
	}

}
