package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // inside this , it has @Component
//to register those views  inside the Handler Mapping  with @Controller
public class HomeController {

    @RequestMapping("/home") // RequestMapping is for endpoint  "/home" is the endpoint
    public String getHomePage(){  // which end point? www.amazon.com/login or register
        return "home.html"; // returns view
    }

    @RequestMapping("/ozzy")
    public String getHomePage2(){
        return "home.html"; // returns view
    }
    @RequestMapping // nothing and / : default
    public String getHomePage3(){
        return "home.html"; // returns view
    }

    @RequestMapping({ "/apple","/orange" })
    public String getHomePage4(){
        return "home.html"; // returns view
    }

}
