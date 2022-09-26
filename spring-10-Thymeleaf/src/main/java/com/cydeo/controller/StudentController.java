package com.cydeo.controller;

import com.cydeo.bootstrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping(value = "/register",method = RequestMethod.GET) // localhost:8080/student/register
    @GetMapping("/register")
    public String register(Model model){

        //                               attribute name which is here holding data(s)
        model.addAttribute("students", DataGenerator.createStudent());

        return "student/register";
    }

    /*
    @RequestMapping("/drop") // localhost:8080/student/drop
    public String drop(){


        return "student/register";
    }

     */



   // @RequestMapping(value = "/welcome",method = RequestMethod.POST) // localhost:8080/student/welcome?name=Ozzy  comes from register html
    @PostMapping("/welcome")
    public String welcome(@RequestParam String name){ // @RequestParam String name

        System.out.println(name);// you can also send this paramater to DataBase

        return "student/welcome";
    }



}
