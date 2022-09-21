package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // to register to Handler Mapping
public class MentorController {

    @RequestMapping("/list")
    public String mentorPage(Model model){

        /*
        Mentor mentor1 = new Mentor("Mike","Smith",45, Gender.MALE);
        model.addAttribute("mentor1",mentor1);
        Mentor mentor2 = new Mentor("Tom","Hanks",65, Gender.MALE);
        model.addAttribute("mentor2",mentor2);
        Mentor mentor3 = new Mentor("Ammy","Bryan",25, Gender.FEMALE);
        model.addAttribute("mentor3",mentor3);


         */

        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("Tom","Hanks",65, Gender.MALE));
        mentorList.add(new Mentor("Ammy","Bryan",25, Gender.FEMALE));

        model.addAttribute("mentors",mentorList);


        return "mentor/mentor-list.html";

    }

}
