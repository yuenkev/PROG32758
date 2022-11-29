package ca.sheridancollege.fragments.example.controllers;

import ca.sheridancollege.fragments.example.beans.Student;
import ca.sheridancollege.fragments.example.database.DatabaseAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {


    private DatabaseAccess database;

    public StudentController(DatabaseAccess database){
        this.database = database;
    }

    @GetMapping("/")
    public String goHome(Model model){

        model.addAttribute("student", new Student());
        model.addAttribute("students", database.getStudents());
        return "index";
    }


    @PostMapping("/addStudent")
    public String insertStudent(@ModelAttribute Student student){

        database.addStudent(student);

        return "redirect:/";
    }
}
