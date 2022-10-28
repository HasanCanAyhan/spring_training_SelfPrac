package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "COURSES")
public class Course {


    /*
    Because other entities ids are created from data.sql
    and that's why we didn't put @GeneratedValue(strategy = GenerationType.IDENTITY) in BaseEntity class.
    But the id of Course is not created in data.sql
    so that's why we need to use @GeneratedValue(strategy = GenerationType.IDENTITY) in Course class.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DESCRIPTION")
    private String description;


}
