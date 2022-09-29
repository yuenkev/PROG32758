package ca.example.pracex2.controllers;

import ca.example.pracex2.beans.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controller {

    @GetMapping("/")
    public String goDefault(Model model){
        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/submitLogin")
    public String goSubmitLogin(@ModelAttribute Login login, Model model){
        model.addAttribute("login", login);
        return "success";
    }

    @GetMapping("/nextPage")
    public String goNext(){
        return "redirect";
    }

    @GetMapping("/goHome")
    public String goHome(Model model){
        model.addAttribute("login", new Login());
        return "index";
    }



}
