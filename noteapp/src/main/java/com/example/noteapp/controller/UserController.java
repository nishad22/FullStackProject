package com.example.noteapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteapp.model.UserNote;
import com.example.noteapp.service.IUserNote;

@RestController
public class UserController {
	
	@Autowired
	IUserNote service;
	
	List<UserNote> user = new ArrayList<UserNote>();
	
	@PostMapping(value="/register-user")
	@ResponseBody
	public String registerUser(@RequestBody UserNote note) {
		if(note!=null && service.registerUser(note) == "success") {
			return "User Added";
		}
		return "Fail";
	}
	
	@GetMapping(value="/get-all-user")
	public List<UserNote> getAllUser() {
		user = service.getAllUser();
		return user;
	}
	
	
	

}
