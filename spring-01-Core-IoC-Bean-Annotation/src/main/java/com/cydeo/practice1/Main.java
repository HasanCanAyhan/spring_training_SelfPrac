package com.cydeo.practice1;

import com.cydeo.practice1.config.CarConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {


        ApplicationContext container = new AnnotationConfigApplicationContext(CarConfig.class);
        // inside the container, we have 3 Car Object:BEANS



        //Car car = container.getBean(Car.class); exception


        /*
        Exception in thread "main"
        org.springframework.beans.factory.NoUniqueBeanDefinitionException:
        No qualifying bean of type 'com.cybertek.Car' available: expected
        single matching bean but found 3: car1,car2,car3
         */

        //                          First parameter is the name of the instance to which we refer.
        Car can = container.getBean("can", Car.class);
        System.out.println(can.getMake()); // Honda


        Car bmw = container.getBean("bmw", Car.class);
        System.out.println(bmw.getMake()); // BMW

    }

}
