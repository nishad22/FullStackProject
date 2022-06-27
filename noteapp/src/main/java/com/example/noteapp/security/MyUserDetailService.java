package com.example.noteapp.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.noteapp.model.UserNote;
import com.example.noteapp.repo.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserNote> user = repo.findByEmail(email);
		user.orElseThrow(()->new UsernameNotFoundException("Not found: "+ email));
		return user.map(MyUserDetail::new).get();
	}

}
