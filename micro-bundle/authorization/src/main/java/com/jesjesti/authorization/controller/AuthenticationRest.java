package com.jesjesti.authorization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jesjesti.authorization.entity.AuthenticationBean;
import com.jesjesti.authorization.utilities.JwtUtil;

@Controller
@RequestMapping("/auth/")
public class AuthenticationRest {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@RequestMapping(value = "authenticate", method = RequestMethod.POST)
	public ResponseEntity<Object> authenticate(@RequestBody AuthenticationBean bean) throws Exception {
		try {
			authenticationManager
			.authenticate(new UsernamePasswordAuthenticationToken(bean.getUserName(), bean.getPassword()));
		} catch (Exception e) {
			throw new Exception("Invalid User Name/Password");
		}
		
		return new ResponseEntity(jwtUtil.generateToken(bean.getUserName()), HttpStatus.OK);
	}

	@RequestMapping(value = "authenticated/request", method = RequestMethod.GET)
	public ResponseEntity<Object> checkAuthentication() {
		return new ResponseEntity("Sucessfull", HttpStatus.OK);
	}
}
