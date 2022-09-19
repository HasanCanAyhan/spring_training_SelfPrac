package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    //     String because returns HTML
    @RequestMapping("/student")
    public String getStudentInfo(){
        return "student/welcome.html"; // inside static , we have another one folder which is student folder
    }

}
