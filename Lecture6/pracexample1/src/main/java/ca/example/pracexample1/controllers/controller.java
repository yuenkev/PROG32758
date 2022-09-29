package ca.example.pracexample1.controllers;

import ca.example.pracexample1.beans.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class controller {

    @GetMapping("/addForm")
        public String goHome(Model model){
            model.addAttribute("form", new Form());
            return "index";
        }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("form", new Form());
        return "index";
    }

        @PostMapping("/submitForm")
            public String goSubmitForm(@ModelAttribute Form form, Model model){
                 model.addAttribute("form", form);
                 return "addForm";

        }


}
