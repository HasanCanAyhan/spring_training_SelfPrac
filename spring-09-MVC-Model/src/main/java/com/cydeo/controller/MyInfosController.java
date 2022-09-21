package com.cydeo.controller;


import com.cydeo.enums.Gender;
import com.cydeo.model.MyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyInfosController {

    @RequestMapping("/myInfo")
    public String myInfos(Model model){

        MyInfo my = new MyInfo("H.Can","Ayh",27, Gender.MALE,"GALATASARAY","English,German,Türkish");

        model.addAttribute("my",my);

        return "person/myInfo.html";
    }



}
