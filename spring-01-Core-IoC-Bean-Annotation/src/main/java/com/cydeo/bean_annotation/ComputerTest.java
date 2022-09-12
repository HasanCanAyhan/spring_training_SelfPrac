package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class ComputerTest {

    public static void main(String[] args) {

        //Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        //Creating container by using BeanFactory
        //BeanFactory context = new AnnotationConfigApplicationContext();


        Monitor theMonitor = container.getBean(Monitor.class); // error : 2 monitor we have Sony and Acer

        //Monitor theMonitor = container.getBean(SonyMonitor.class);
        //Monitor monitorAcer = container.getBean(AcerMonitor.class);

        //we can write also :
        //SonyMonitor theMonitor = container.getBean(SonyMonitor.class);

        Case theCase = container.getBean(Case.class);
        Motherboard theMotherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(theCase,theMonitor,theMotherboard);

        myPc.powerUp();

    }

}
