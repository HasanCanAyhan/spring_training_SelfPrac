package com.cydeo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WelcomeController.class)// i want to test this class
public class WelcomeControllerTest {

    // how to do unit test on Controller

    //@WebMvcTest


    @Autowired
    private MockMvc mvc;

    @Test
    void welcome_Test() throws Exception {

        //call first /welcome endpoint
        //verify response is "welcome"


        //nor preferred way
        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mvc.perform(request).andReturn();//andReturn() means the response

        assertEquals(200, result.getResponse().getStatus());
        assertEquals("welcome",result.getResponse().getContentAsString());

    }


    @Test
    void welcome_Test2() throws Exception {

        //2.way

        RequestBuilder request = MockMvcRequestBuilders.get("/welcome")
                .accept(MediaType.APPLICATION_JSON);

        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("welcome"))//content means : response body
                .andReturn();// to finish


    }




}
