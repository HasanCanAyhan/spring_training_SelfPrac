package com.cydeo.bean_annotation.config;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ComputerConfig {

    @Bean(name = "sony") // is going to save as sony in the container
    public Monitor monitorSony(){ // return object instance
        return new SonyMonitor("25 inc Beast", "Sony",25); // Monitor abc = new SonyMonitor();

    }

    @Bean(name="sony2")
    public Monitor monitorSony2(){

        return new SonyMonitor("40 inc Beast","Sony",40);
    }

    @Bean
    @Primary // this one is default one : higher preference
    public Monitor monitorAcer(){
        return new AcerMonitor("23 inc Beast", "Acer",23); // Monitor abc = new SonyMonitor();

    }

    @Bean
    public Case caseDell(){
        return new DellCase("220B","Dell","240");
    }

    @Bean
    public Motherboard motherboardAsus(){
        return new AsusMotherboard("BJ-200","Asus",4,6,"v2.44");
    }



}
