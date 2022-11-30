package com.cydeo.dto;

import com.cydeo.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)//if you dont want to see NULL FIELDS in your JsonResponses, we will use it.
//That means, dont put null fileds to Json response while giving response
public class AddressDTO {

    @JsonIgnore
    private Long id;

    private String street;
    private String country;
    private String state;
    private String city;
    private String postalCode;


    private AddressType addressType;

    @JsonBackReference(value = "student-address-reference") // we are hiding it  // defaultReference
    private StudentDTO student;

    @JsonBackReference(value = "parent-address-reference") // defaultReference
    private ParentDTO parent;

    @JsonBackReference (value = "teacher-address-reference")// defaultReference
    private TeacherDTO teacher;

    //this is null for now
    private Integer currentTemperature; //weather information, which we will later get it from 3rd party API -consuming

}