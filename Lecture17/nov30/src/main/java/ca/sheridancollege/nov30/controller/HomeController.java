package ca.sheridancollege.nov30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {


    //When page is loaded up, it'll have a href that redirect to seclogin
    @GetMapping("/seclogin")
    public String goLogin(){
        return "seclogin";
    }

    //is user enters in correct creds
    @PostMapping("/seclogin")
    public String goHome(){
        //redirect allows u to send it to another mapping
        return "redirect:/success";
    }

    //uses this mapping if the login is sucessful
    @GetMapping("/success")
    public String goSuccess(){
        return "success";
    }

    //error mapping if it fails
    @GetMapping("/error")
    public String goError() {return "error";}

    //going to the logout page
    @GetMapping("/seclogout")
    public String goToLogoutPage() {
        return "seclogout";
    }

    //sucess for logout
    @GetMapping("/gologout")
    public String goLogout(){
        return "/seclogin";
    }
}
