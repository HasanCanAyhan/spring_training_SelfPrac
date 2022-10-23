package com.cydeo.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // table is created
public class Employee {
    // in the database, employee-table
    //column : field of the class
    //row : object of class

    @Id // to make primary key
    private int id;
    private String name;










}
