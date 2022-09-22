package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    @GetMapping("/register")
    public String resisterUser(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam(defaultValue = "off") String rememberMe,
            HttpServletResponse response) throws IOException {

        //Get Instance of PrintWriter
        PrintWriter out = response.getWriter();
        printHeader(out);

        return null;
    }

    private void printHeader(PrintWriter out) {

        out.print("<!DOCTYPE html>\n"
                + "<html>\n"
                + "<head>\n"
                + "<meta charset=\"UTF-8\">\n"
                + "<title>REgistration Status</title>\n"
                + "</head>\n"
                + "<body>\n"
                + "<h1>Registration Successful!</h1>\n");
    }


    @GetMapping("/register_page")
    public String goRegister() {
        return "register";
    }


}

