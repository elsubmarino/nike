package com.nike.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nike.dao.UserDAO;
import com.nike.dto.User;

@RestController
@RequestMapping("/login/")
public class LoginRestController {
	@Autowired
	UserDAO userDAO;
	
	public ResponseEntity<String> login(@RequestBody String username,HttpSession sess) {
		User user=userDAO.getOne(username);
		if(user!=null) {
			sess.setAttribute("user", user);
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		
	}
}
