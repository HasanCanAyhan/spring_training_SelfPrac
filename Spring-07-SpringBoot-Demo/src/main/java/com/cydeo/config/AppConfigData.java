package com.cydeo.config;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


//@Component
@Data
@Configuration // you can use this : it has inside @component but if it is @Value
public class AppConfigData {

    @Value("${username}")
    private String abc;
    @Value("${password}")
    private String password;
    @Value("${url}")
    private String url;

}
