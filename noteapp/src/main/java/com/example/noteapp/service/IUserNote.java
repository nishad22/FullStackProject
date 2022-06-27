package com.example.noteapp.service;

import java.util.List;

import com.example.noteapp.model.UserNote;

public interface IUserNote {
	public String registerUser(UserNote user);
	//public UserNote getUserByEmail();
	public List<UserNote> getAllUser(); 

}
