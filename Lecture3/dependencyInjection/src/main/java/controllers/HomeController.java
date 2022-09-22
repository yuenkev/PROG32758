package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private School school;

//    public HomeController(School school) {
//        this.school = school;
//    }

    @GetMapping("/")
    public String goHome() {
        System.out.println("--- From controller");
        System.out.println(school);
        return "index";
    }
}
