package ca.sheridan.nov02.controllers;

import ca.sheridan.nov02.Database.DatabaseAccess;
import ca.sheridan.nov02.beans.Bob;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class HomeController {

    private DatabaseAccess da;

    @GetMapping("/")
    public String goHome(Model model){

        //returning the list of users
        List<Bob> userList = da.getUsers();
        model.addAttribute("userList", userList);

        //adding a new avenger
        model.addAttribute("user", new Bob());
        return "index";
    }

//    @PostMapping("/addUser")
//    public String addUser(@ModelAttribute Bob user){
//
//        //adding u ser to dbas
//        int returnValue = da.addUser(user);
//        return "redirect:/";
//    }
}
