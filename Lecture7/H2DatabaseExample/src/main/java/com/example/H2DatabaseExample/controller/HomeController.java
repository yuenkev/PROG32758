package com.example.H2DatabaseExample.controller;

import com.example.H2DatabaseExample.beans.Avenger;
import com.example.H2DatabaseExample.database.DatabaseAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController
{
    private DatabaseAccess database;

    /**
     * Our one arg constructor for dependency injection
     * @param database will be injected by Spring at runtime
     */

    public HomeController(DatabaseAccess database){
        this.database=database;
    }
    @GetMapping("/")
    public String goHome(Model model){
        List<Avenger> avengers = database.getAvengers();
        model.addAttribute("avengerList",avengers);
        return "index";
    }

    @GetMapping("/addPage")
    public String goToAdd(Model model){
        //Recall from binding...
        model.addAttribute("avenger",new Avenger());
        return "add_avenger";
    }
    /**
     * @param avenger is a ModelAttribute. A special instance that
     *        was populated with values the user entered on the form
     * @return "redirect:/" Redirects the request to the '/' resource
     */
    @PostMapping("/addAvenger")
    public String addAvenger(@ModelAttribute Avenger avenger){
        //call the addAvenger method of the Database Access class
        int returnValue = database.addAvenger(avenger);
        //we're not doing anything with this now, but we could
        //send a message back through the model, use Elvis...
        System.out.println("return value is: " + returnValue);
        //redirect to '/' so we don't have to add to the model...
        return "redirect:/";
    }

    @GetMapping("/deleteAvenger/{id}")
    public String deleteAvenger(@PathVariable Long id){
        int returnValue = database.deleteAvenger(id);
        System.out.println("return value is: " + returnValue);
        return "redirect:/";
    }

    @GetMapping("/editAvenger/{id}")
    public String editAvenger(@PathVariable Long id, Model model){

        Avenger avenger = database.getAvenger(id);

        if (avenger == null){
            System.out.println("No result for id=" + id);
            return "redirect:/";
        }

        model.addAttribute("avenger", avenger);

        return "edit_avenger";
    }

    @PostMapping("/updateAvenger")
    public String updateAvenger(@ModelAttribute Avenger avenger){

        int returnValue = database.updateAvenger(avenger);

        System.out.println("return value is: " + returnValue);

        return "redirect:/";
    }

}
