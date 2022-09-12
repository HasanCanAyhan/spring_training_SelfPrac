package com.cydeo.streotype_annotation.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cydeo.streotype_annotation") // check all the class with @Component  under this package
public class PcConfig {

    /*
    so basically we use @Bean with ready classes,
    and @Component with custom classes that we created ourselves
     */

}
