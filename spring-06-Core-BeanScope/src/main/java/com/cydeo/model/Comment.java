package com.cydeo.model;


import lombok.Data;

@Data
public class Comment {

    //Inside the Model we  should not put @component
    //1.There is no Has A relationship
    //2. This class is any classes's has a relationship : no -->> needs to be injected somewhere else : no

    private String author;
    private String text;

}
