package com.example.H2DatabaseExample.controller;


import com.example.H2DatabaseExample.beans.Avenger;
import com.example.H2DatabaseExample.database.AvengerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    private AvengerRepository avengerRepository;

    public HomeController(AvengerRepository avengerRepository) {
        this.avengerRepository = avengerRepository;
    }

    @GetMapping("/")
    public String goHome(Model model){
        List<Avenger> avengers = avengerRepository.findAll();
        model.addAttribute("avengerList", avengers);
        return "index";
    }

    @GetMapping("/addPage")
    public String goToAdd(Model model){
        model.addAttribute("avenger", new Avenger());
        return "add_avenger";
    }

    @GetMapping("/deleteAvenger/{id}")
    public String deleteAvenger(@PathVariable Long id){
        avengerRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/addAvenger")
    public String addAvenger(@ModelAttribute Avenger avenger){

        avengerRepository.save(avenger);
        return "redirect:/";
    }
}
