package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //display all employees with email address "" something
    List<Employee> findByEmail(String email);

    //display all employees with firstname "" and last name ""
    //also show all employees with an email address ""
    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //display all employees that firstName is not ""
    List<Employee> findByFirstNameIsNot(String firstName);

    //display all employees where lastname start with ""
    List<Employee> findByLastNameStartingWith(String pattern);

    //display all employees with salary higher than ""
    //display all employees with salary less than ""

    List<Employee> findBySalaryGreaterThan(Integer salary);
    List<Employee> findBySalaryLessThan(Integer salary);

    //display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findBySalaryGreaterThanEqualOrderBy(Integer salary);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees
    List<Employee> findByEmailIsNull();

}