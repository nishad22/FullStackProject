package com.example.noteapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.example.noteapp.model.ReminderNote;

@Service
public class ReminderNoteServiceImpl implements IReminderNote{

	
	List<ReminderNote> list = new ArrayList<ReminderNote>();
	
	@Override
	public String postNote(ReminderNote note) {
		// TODO Auto-generated method stub
		//ReminderNote note = new ReminderNote();
		if(note!=null) {
			list.add(note);
			return "success";
		}
		
		return "fail";
	}
	@Override
	public List<ReminderNote> getAllNote() {
		// TODO Auto-generated method stub
		for(ReminderNote note : list) {
			System.out.println(note);
		}
		return list;
	}

}
