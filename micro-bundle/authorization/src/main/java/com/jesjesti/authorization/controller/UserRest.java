package com.jesjesti.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jesjesti.authorization.entity.UserBean;
import com.jesjesti.authorization.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserRest {

	@Autowired
	private UserService service;

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody UserBean bean) {
		try {
			service.save(bean);
			return new ResponseEntity(bean, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
		}
	}
	
	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public ResponseEntity<Object> pingMe() {
		return new ResponseEntity("Sucessfull", HttpStatus.OK);
	}
}
