package ca.sheridancollege.h2database.controller;

import ca.sheridancollege.h2database.beans.Avenger;
import ca.sheridancollege.h2database.database.DatabaseAccess;
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
    private DatabaseAccess database;

    public HomeController(DatabaseAccess database){
        this.database = database;
    }
    @GetMapping("/")
    public String goHome(Model model) {

        List<Avenger> avengers = database.getAvengers();

        model.addAttribute("avengerList", avengers);

        return "index";

    }
}
