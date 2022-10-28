package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    List<Employee> findBySalaryGreaterThanEqualOrderBySalaryDesc(Integer salary);

    //display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //display all employees that do not have email
    List<Employee> findByEmailIsNull();


    //--------------------------------------
    //using JPQL

    //Employee here is Class name not table name !!!
    @Query("Select employee FROM Employee employee WHERE employee.email = 'amcnee1@google.es' ")
    Employee retrieveEmployeeDetail();

    @Query("Select e.salary FROM Employee e WHERE e.email = 'amcnee1@google.es' ")
    Integer retrieveEmployeeSalary();


    //Nothing new actually, just call service method from controller,
    // and call repository method from service.


}
