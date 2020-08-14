package com.jesjesti.user.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jesjesti.user.management.entity.UserDetailsBean;
import com.jesjesti.user.management.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserRest {

	@Autowired
	private UserService service;

	@RequestMapping(value = "ping/{message}", method = RequestMethod.GET)
	public ResponseEntity<Object> getByRefId(@PathVariable String message) {
		return new ResponseEntity(message, HttpStatus.OK);
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public ResponseEntity<Object> create(@RequestBody UserDetailsBean bean) {
		try {
			service.save(bean);
			return new ResponseEntity(bean, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Request Failed", HttpStatus.PRECONDITION_FAILED);
		}
	}

	@RequestMapping(value = "remove", method = RequestMethod.POST)
	public ResponseEntity<Object> remove(@RequestBody UserDetailsBean bean) {
		try {
			service.delete(bean);
			return new ResponseEntity(bean, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity("Request Failed", HttpStatus.PRECONDITION_FAILED);
		}
	}

	@RequestMapping(value = "find/all", method = RequestMethod.GET)
	public ResponseEntity<Object> findAllUsers() {
		List<UserDetailsBean> vendorlist = service.getRepository().findAll();
		return new ResponseEntity(vendorlist, HttpStatus.OK);
	}
}
