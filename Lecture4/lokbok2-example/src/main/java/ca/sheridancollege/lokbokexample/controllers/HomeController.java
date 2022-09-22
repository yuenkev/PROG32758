package ca.sheridancollege.lokbokexample.controllers;

import ca.sheridancollege.lokbokexample.beans.School;
import ca.sheridancollege.lokbokexample.database.DatabaseAccess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class HomeController {

    private DatabaseAccess da;

    public HomeController(DatabaseAccess da){
        this.da = da;
    }

    @GetMapping("/addSchoolForm")
    public String addSchoolForm(){
        return "addSchool";
    }

    @PostMapping("/add")
    public String AddSchool(
            @RequestParam String schoolName,
            @RequestParam String schoolAddress,
            @RequestParam int numStudents){

        School school = new School(schoolName, schoolAddress, numStudents);
        da.getSchoolList().add(school);

        return "index";
    }

    @GetMapping("removeAll")
    public String removeAndGoHome() {

        return "index";
    }

    @GetMapping("/viewSchools")
    public String viewSchools(Model model) {
        return "listing";
    }

}
