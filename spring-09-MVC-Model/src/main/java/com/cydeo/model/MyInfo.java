package com.cydeo.model;

import com.cydeo.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class MyInfo {

    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
    private String favoriteTeam;
    private String language;

}
