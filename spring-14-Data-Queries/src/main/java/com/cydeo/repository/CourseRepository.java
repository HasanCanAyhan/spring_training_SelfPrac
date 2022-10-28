package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    //Ex:
    // @Query("Select employee FROM Employee employee WHERE employee.email = 'amcnee1@google.es' ")
    // Employee retrieveEmployeeDetail();

    //Derived query
    //find all courses by category -->> select * from course where category = '';
    List<Course> findByCategory(String category); // find-read-get means select

    //find all courses by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    //Checks if a course with the supplied name exist. Return true if it exist.
    boolean existsByName(String name);

    //returns the count of courses for the given category
    Integer countByCategory(String category);

    //find all courses that start with the given course name ''
    List<Course> findByNameStartsWith(String name);

    //find all courses by category and returns a stream
    Stream<Course> streamAllByCategory(String category);


}
