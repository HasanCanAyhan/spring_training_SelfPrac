package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor

@Component
public class Dimensions { // new Dimensions(int int int)

    private int width;
    private int height;
    private int depth;

    private void pressPowerButton(){
        System.out.println("Power button pressed");
    }

}
