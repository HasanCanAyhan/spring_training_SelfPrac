package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Using derived queries

    //display all departments in the furniture department
    List<Department> findByDepartment(String department);

    //display all departments in the Health Division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    List<Department> findDepartmentsByDivision(String division);

    //display all departments with division name ends with 'ics'

    List<Department> findByDivisionEndsWith(String pattern);

    //display top 3 departments with division name includes 'Hea' without duplicates

    List<Department> findDistinctTop3ByDivisionContaining(String pattern);



}
