package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "departments")
public class Department {


    @Id
    private String department;//according to data.sql , primary key is department

    private String division;


}
