	package com.example.noteapp.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class UserValidationImpl implements IUserValidation{

	@Override
	public boolean validMail(String mail) {
		// TODO Auto-generated method stub
		String regex = "^[A-Za-z0-9+-_.]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher match = pattern.matcher(mail);
		return match.matches();
	
	}

	@Override
	public boolean validPassword(String password,String confirmPassword) {
		// TODO Auto-generated method stub
		return password.equals(confirmPassword);
	}

}
