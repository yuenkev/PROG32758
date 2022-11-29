package com.sheridancollege.domain;

public class Message {
	
	private Integer id;
	private String title;
	private String text;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Message(Integer id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}
	
	

}
