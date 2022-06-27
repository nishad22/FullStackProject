package com.example.noteapp.validation;

public interface IUserValidation {
	
	public boolean validMail(String mail);
	public boolean validPassword(String password,String confirmPassword);

}
