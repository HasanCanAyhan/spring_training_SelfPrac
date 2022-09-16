package com.cydeo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "db")  // ---->>> db comes from application.properties (db.)
@Data
public class DBConfigData {

    private String userName; // db.username
    private String password;
    private List<String> type;



}
