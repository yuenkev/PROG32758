package com.example.assign2.controller;

import com.example.assign2.beans.Student;
import com.example.assign2.database.DatabaseAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {

    private DatabaseAccess database;

    public HomeController(DatabaseAccess database){
        this.database=database;
    }

    //when it loads up it'll go to the home page
    @GetMapping("/")
    public String goHome(){
        return "index";
    }

    //hyper link to the add page, createa new object
    @GetMapping("/addPage")
    public String goToAdd(Model model){
        model.addAttribute("student", new Student());
        return "add_student";
    }

    //submiting a form, redirecting to the list page
    @PostMapping("/addStudent")
    public String goAddStudent(@ModelAttribute Student student, Model model){

        model.addAttribute("student", student);
        int returnValue = database.addStudent(student);
        System.out.println("return value is: " + returnValue);
        return "redirect:/listStudents";
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        int returnValue = database.deleteStudent(id);
        System.out.println("return value is: " + returnValue);
        return "redirect:/listStudents";
    }

    @GetMapping("/editStudent/{id}")
    public String editStudent(@PathVariable Long id, Model model){

        Student student = database.getStudents(id);

        if(student == null){
            System.out.println("No result for id=" + id);
            return "redirect:/listStudents";
        }

        model.addAttribute("student", student);

        return "edit_student";

    }

    @GetMapping("/showDetails/{id}")
    public String showDetailsStudent(@PathVariable Long id, Model model){

        Student student = database.getStudents(id);

        if(student == null){
            System.out.println("No result for id=" + id);
            return "redirect:/listStudents";
        }

        model.addAttribute("student", student);

        return "details";
    }

    //update
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student student){

        int returnValue = database.updateStudent(student);

        System.out.println("return value is: " + returnValue);

        return "redirect:/listStudents";
    }


    //mapping to the list page
    @GetMapping("/listStudents")
    public String goToList(Model model){
        //get list of students in the database + add it to the model
        List<Student> students = database.getStudents();
        //since its added to the model we can now access it on the UI
        model.addAttribute("studentList", students);
        return "list_students";
    }

    @GetMapping("/deleteAll")
    public String deleteAll(){
        int returnValue = database.deleteAll();
        System.out.println("return value is: " + returnValue);
        return "redirect:/listStudents";
    }
}
