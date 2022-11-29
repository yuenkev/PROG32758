package com.sheridancollege.controller;

import com.sheridancollege.service.MessagesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExampleController {

	@Autowired
	MessagesServiceImpl messagesService;
	
    @RequestMapping("/")
    String index(){
        return "index";
    }
    
    @GetMapping("/list")
    String list(){
    	return "list";
    }

}
