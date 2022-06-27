package com.example.noteapp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;


public class ReminderNote {
	
	private int id = 0;
	private String title;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date reminder;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date create;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		id = id + 1;
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getReminder() {
		return reminder;
	}
	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ReminderNote [id=" + id + ", title=" + title + ", reminder=" + reminder + ", create=" + create
				+ ", description=" + description + "]";
	}

}
