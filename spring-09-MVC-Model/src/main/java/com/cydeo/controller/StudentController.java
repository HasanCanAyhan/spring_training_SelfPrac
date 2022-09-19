package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homePage(Model model){

        //pass some Data to the view/html
        //Model , we are using carry Data to view

        //String name = "Ozzy";
        model.addAttribute("name","Cydeo");
        model.addAttribute("course","MVC");
        return "student/welcome";

    }

}
