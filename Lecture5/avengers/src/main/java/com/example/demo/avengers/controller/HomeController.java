package com.example.demo.avengers.controller;

import com.example.demo.avengers.beans.Avenger;
import org.apache.logging.log4j.spi.CopyOnWrite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class HomeController
{
    private CopyOnWriteArrayList<Avenger> avengerList = new CopyOnWriteArrayList<>();

    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute("avengerList", avengerList);
        return "index";
    }

    @GetMapping("/addPage")
    public String goToAdd(Model model){

        model.addAttribute("avenger", new Avenger());
        return "add_avenger";
    }

    @PostMapping ("/addAvenger")
    public String addAvenger(Model model, @ModelAttribute Avenger avenger){
        avengerList.add(avenger);
        model.addAttribute("avengerList", avengerList);
        return "redirect:/";
    }

}
