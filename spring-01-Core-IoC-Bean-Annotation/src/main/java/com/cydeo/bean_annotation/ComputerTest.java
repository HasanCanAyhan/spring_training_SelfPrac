package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class ComputerTest {

    public static void main(String[] args) {

        System.out.println("Creating Container");

        //Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        //Creating container by using BeanFactory
        //BeanFactory context = new AnnotationConfigApplicationContext();


        /*
        Monitor theMonitor = container.getBean(Monitor.class); // error : 2 monitor we have Sony and Acer

        //Monitor theMonitor = container.getBean(SonyMonitor.class);
        //Monitor monitorAcer = container.getBean(AcerMonitor.class);

        //we can write also :
        //SonyMonitor theMonitor = container.getBean(SonyMonitor.class);


        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);


         */

        System.out.println("****************Retrieving the beans******************");

        SonyMonitor sony = container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);

        PC myPc = new PC(dell,sony,asus);

        myPc.powerUp();

        dell.pressPowerButton();

        System.out.println("------------------------------------------");

        //Monitor theMonitor = container.getBean(Monitor.class);
       // Case theCase = container.getBean(Case.class);
        //Motherboard theMotherboard = container.getBean(Motherboard.class);

        //PC myPc2 = new PC(theCase,theMonitor,theMotherboard);


        System.out.println("-------------MULTIPLE OBJECTS---------------------------");

        //3 ways

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class); // default bean name so method name in the config class
        Monitor theMonitor3 = container.getBean("sony", Monitor.class); // custom bean name
        Monitor theMonitor4 = container.getBean(Monitor.class); // @Primary





    }

}
