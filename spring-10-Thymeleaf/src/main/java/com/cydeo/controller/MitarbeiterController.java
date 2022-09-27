package com.cydeo.controller;

import com.cydeo.model.Mitarbeiter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

    @GetMapping("/register") // mitarbeiter/register
    public String getMitarbeiter(Model model){

        List<String> stateList = Arrays.asList("Alaska","LA","NW");
        model.addAttribute("stateList",stateList);

        model.addAttribute("mitarbeiter", new Mitarbeiter());

        return "mitarbeiter/mitarbeiter-register";

    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute("mitarbeiter") Mitarbeiter mitarbeiter, Model model){

        model.addAttribute("mitarbeiter",mitarbeiter);

        return "mitarbeiter/show-table";
    }



}
