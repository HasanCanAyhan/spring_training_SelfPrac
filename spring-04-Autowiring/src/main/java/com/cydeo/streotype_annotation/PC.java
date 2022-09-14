package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class PC {
    // when ypu put @Component,  Spring do : new PC();
    //But here we have AllArgsConstructor that s why ==>> Spring do : new PC(case, monitor, motherboard)

    //@Autowired
    private Case theCase;

    //@Autowired
    private Monitor monitor;

    //@Autowired
    private Motherboard motherboard;


    // or : you can use also : constructor injection : mostly used
    //@Autowired

    // if you have one constructor , you do not need to put @Autowired
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
