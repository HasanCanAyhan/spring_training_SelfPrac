package com.cydeo.practice1.config;

import com.cydeo.practice1.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarConfig {

    @Bean(name = "can")
    Car car1(){
        Car c = new Car();
        c.setMake("Honda");
        return c;
    }

    @Bean(name = "bmw")
    Car car2(){

        Car c1 = new Car();
        c1.setMake("BMW");
        return c1;

    }

    @Bean
    Car car3(){

        Car c1 = new Car();
        c1.setMake("Nissan");
        return c1;

    }


}
