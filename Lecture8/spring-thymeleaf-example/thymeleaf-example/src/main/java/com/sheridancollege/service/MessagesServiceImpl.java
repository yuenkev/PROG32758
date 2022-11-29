package com.sheridancollege.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sheridancollege.domain.Message;

@Service
public class MessagesServiceImpl{

	public List<Message> findAll() {
		
		List<Message> result = new ArrayList<Message>();
		result.add(new Message(1, "title 1", "text 1"));
		result.add(new Message(2, "title 2", "text 2"));
		result.add(new Message(3, "title 3", "text 3"));
		
		return result;
	}

}
