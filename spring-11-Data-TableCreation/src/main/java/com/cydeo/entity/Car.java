package com.cydeo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
//@AllArgsConstructor :  you should not put it, bcs you have to assign id, but id is coming from postgres automatically
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;


    //create without id
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }


}
