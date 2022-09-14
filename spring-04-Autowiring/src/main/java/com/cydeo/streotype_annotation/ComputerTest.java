package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.PcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {

    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(PcConfig.class);

        PC myPc = container.getBean(PC.class);

        myPc.powerUp();

        System.out.println(myPc.getTheCase().getDimensions().getDepth());
        // Normally, it will be printed default int value 0 , but because we have default constructor in the Dimensions , then it returns int value : 40



    }


}
