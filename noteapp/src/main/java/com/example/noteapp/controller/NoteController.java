package com.example.noteapp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.noteapp.model.ReminderNote;
import com.example.noteapp.service.IReminderNote;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class NoteController {
	
	@Autowired
	IReminderNote service;
	
	List<ReminderNote> li = new ArrayList<ReminderNote>();
	
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
}
