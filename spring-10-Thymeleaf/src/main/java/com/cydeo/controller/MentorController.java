package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

    @GetMapping("/register") //localhost:8080/mentor/register
    public String register(Model model){

        List<String> batchList = Arrays.asList("JD1","JD2","JD3");
        model.addAttribute("batchList",batchList);

        model.addAttribute("mentor",new Mentor()); // empty object

        return "mentor/mentor-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor){
        //PathVariable is the part you capturing from URL itself.
        //@ModelAttribute is the object you saved from the form in the view.
        // how can I access to "mentor" attribute in this method




        //return "mentor/mentor-confirmation"; 1

        //model.addAttribute("mentor",new Mentor()); // empty object

        //return "mentor/mentor-register";

        return "redirect:/mentor/register"; // to return again register page with the empty form-empty object
    }


    /*
    @GetMapping("/confirm")
    public String submitForm2(){
        return "mentor/mentor-confirmation";
    }

     */



}
