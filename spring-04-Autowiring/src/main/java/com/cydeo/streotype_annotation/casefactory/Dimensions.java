package com.cydeo.streotype_annotation.casefactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
//@AllArgsConstructor : if you put that, then that means you trying to inject those fields(int ... ) to Dimension Object
                        // because AllArgsConst means Autowired and those fields will be injected to Dimension : dont do this
@Component
public class Dimensions { // new Dimensions(int int int)

    private int width;
    private int height;
    private int depth;

    public Dimensions() { // default Constructor, Dimension object is coming with those value
        this.width=10;
        this.height=30;
        this.depth=40;
    }

    private void pressPowerButton(){
        System.out.println("Power button pressed");
    }

}
