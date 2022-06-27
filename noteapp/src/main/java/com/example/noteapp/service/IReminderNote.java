package com.example.noteapp.service;

import java.util.Date;
import java.util.List;

import com.example.noteapp.model.ReminderNote;

public interface IReminderNote{
	public String postNote(ReminderNote note);
	//public String postNote(int id,String title, Date reminder, Date creation, String description);
	public List<ReminderNote> getAllNote();
	//public ReminderNote getAllNote();
}
