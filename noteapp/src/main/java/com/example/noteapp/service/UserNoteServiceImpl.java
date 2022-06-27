package com.example.noteapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.noteapp.model.UserNote;
import com.example.noteapp.repo.UserRepository;
import com.example.noteapp.validation.IUserValidation;

@Service
public class UserNoteServiceImpl implements IUserNote {
	
	@Autowired
	IUserValidation valid;
	
	List<UserNote> list = new ArrayList<UserNote>(); 
	
	@Autowired
	UserRepository repo;

	@Override
	public String registerUser(UserNote user) {
		// TODO Auto-generated method stub
		boolean isEmailValid = valid.validMail(user.getEmail());
		//boolean isPasswordValid = valid.validPassword(user.getPassword(), user.getConfirm());
		if(user!=null && (isEmailValid)) {
			user.setActive(true);
			//list.add(user);
			repo.save(user);
			return "success";
		}
		return "fail";
		
	}

	@Override
	public List<UserNote> getAllUser() {
		// TODO Auto-generated method stub
		list = repo.findAll();
		for (UserNote note:list) {
			System.out.println(note);
		}
		return list;
	}

}
