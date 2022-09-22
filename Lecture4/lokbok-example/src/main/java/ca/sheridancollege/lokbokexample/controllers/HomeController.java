package ca.sheridancollege.lokbokexample.controllers;

import ca.sheridancollege.lokbokexample.beans.School;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    private School school;

    @Autowired
    public HomeController(School school){
        this.school = school;
    }

    @GetMapping("/")
    public String goHome(){

        System.out.println("---- From controller");
        System.out.println(school);
        return "index";
    }
}
