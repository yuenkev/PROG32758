package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {

    //Sept 9th Exercise (GET)
//
//        @GetMapping("/register")
//        public String registerUserGet(
//                @RequestParam String firstName,
//                @RequestParam String lastName,
//                        //the default value is always the same if u check the box (on = always on, off = always off)
//                        @RequestParam(defaultValue="on") String rememberMe) {
//                System.out.println(firstName + " " + lastName + " " + rememberMe);
//                return "success";
//        }
//
//        //Sept 14th - Exercise (POST)
//
//        @PostMapping(value = "/register2")
//        public String registerUserPost(
//                @RequestParam String firstName,
//                @RequestParam String lastName,
//                //the default value is always the same if u check the box (on = always on, off = always off)
//                @RequestParam(defaultValue="on") String rememberMe){
//                System.out.println(firstName + " " + lastName + " " + rememberMe);
//                return "success";
//        }

    //http servet

    @GetMapping("/register_page")
    public String goRegister(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam(defaultValue = "off") String rememberMe, Model model){

            model.addAttribute("firstName", firstName);

            model.addAttribute("lastName", lastName);
            model.addAttribute("rememberMe", rememberMe);

            return "success";
    }


    @GetMapping("/getListings")
    public String getListing(Model model)
    {
        List<String> members = new ArrayList<>();

        members.add("Iron Man");
        members.add("Gamora");
        members.add("Thor");
        members.add("Nebula");


        model.addAttribute("members", members);

        return "listing";
    }


}

