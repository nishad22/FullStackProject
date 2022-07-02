package com.example.noteapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteapp.jwt.JwTUtil;
import com.example.noteapp.model.AuthenticationRequest;
import com.example.noteapp.model.AuthenticationResponse;
import com.example.noteapp.model.ReminderNote;
import com.example.noteapp.service.IReminderNote;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoteController {
	
	@Autowired
	IReminderNote service;
	
	List<ReminderNote> li = new ArrayList<ReminderNote>();
	
	@Autowired
	private AuthenticationManager authenticationManager;	
	
	@Autowired
	private UserDetailsService userDetailService;
	
	@Autowired
	private JwTUtil jwtUtil;
	
	@PostMapping(value="/postnote")
	@ResponseBody
	public String postNote(@RequestBody ReminderNote note) {
		if(note!=null && service.postNote(note) == "success") {
			return "success";
		}
		return "Failure";
	}
	/*public String postNote(@RequestParam(value = "id", required = true) int id,@RequestParam String title, @RequestParam Date reminder,
			@RequestParam Date create, @RequestParam String description ) {
		if(service.postNote(id,title,reminder,create,description) == "success") {
			return "success";
		}
		return "Failure";	
	}*/

	@GetMapping(value="/getnote")
	public List<ReminderNote> getNote() {
		li = service.getAllNote();
		return li;
	}
	
	@GetMapping(value="/")
	public String home() {
		return("<h1>Welcome</h1>");
	}
	
	@GetMapping(value="/user")
	public String user() {
		return("<h1>Welcome user</h1>");
	}
	@GetMapping(value="/admin")
	public String admin() {
		return("<h1>Welcome admin</h1>");
	}
	
	@RequestMapping(value="/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e){
			throw new Exception("Incorrect usrename or password",e);
		}
		
		final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails);
				
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
