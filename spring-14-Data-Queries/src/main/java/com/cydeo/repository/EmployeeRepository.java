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

    //Generell Info-Flow
    //Nothing new actually, just call service method from controller,
    // and call repository method from service.

    //Employee here is Class name not table name !!!
    @Query("Select employee FROM Employee employee WHERE employee.email = 'amcnee1@google.es' ")
    Employee retrieveEmployeeDetail();

    @Query("Select e.salary FROM Employee e WHERE e.email = 'amcnee1@google.es' ")
    Integer retrieveEmployeeSalary();

    //Nor equal
    @Query(" SELECT e FROM Employee e WHERE e.salary <> ?1    ")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    // like  / Contains / StartsWith / EndsWith
    @Query(" SELECT e FROM Employee e WHERE e.firstName like ?1 ")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less Than - Greater Than

    @Query("select e from Employee  e  where e.salary < ?1 ")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    @Query("select e.firstName from Employee  e  where e.salary > ?1 ")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //Between
    @Query("select e.salary from Employee  e  where e.salary between ?1 and ?2 ")
    List<Integer> retrieveSalaryBetween(int salary1, int salary2);

    @Query("select e from Employee  e  where e.salary between ?1 and ?2 ")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //Before
    @Query("select e from Employee  e  where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //Null

    @Query("select e from Employee  e  where e.email is NULL ")
    List<Employee> retrieveEmployeeEmailIsNull();

    //Not Null
    @Query("select e from Employee  e  where e.email is not NULL ")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //Sorting in asc order - desc order
    @Query("select e from Employee  e   order by e.salary  ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    @Query("select e from Employee  e   order by e.salary desc  ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();


}
