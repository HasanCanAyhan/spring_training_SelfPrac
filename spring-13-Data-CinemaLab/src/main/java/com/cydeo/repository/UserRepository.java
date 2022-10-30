package com.cydeo.repository;

import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?

    User findByEmail(String email);

    //Write a derived query to read a user with a username?

    User findByUsername(String username);


    //Write a derived query to list all users that contain a specific name?

    List<User> findUserByUsernameContains(String pattern);


    //Write a derived query to list all users that contain a specific name in the ignore case mode?

    List<User> findUserByUsernameContainsIgnoreCase(String pattern);

    //Write a derived query to list all users with an age greater than a specified age?

   //??????????????????????????????????????????????????????????????????


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?

    @Query("select u from User  u where u.email = ?1")
    User retrieveUserByEmail(String email);


    //Write a JPQL query that returns a user read by username?

    @Query("select u from User  u where u.username = ?1")
    User retrieveUserByUsername(String username);


    //Write a JPQL query that returns all users?

    @Query("select u from User  u ")
    List<User> retrieveUsers( );


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?

    @Query(value = "select * from user_account\n" +
            "where username like %?1%",nativeQuery = true)
    List<User> retrieveUsersContainASpecificName(String pattern);

    //Write a native query that returns all users?

    @Query(value = "select * from user_account",nativeQuery = true)
    List<User> retrieveAllUsers();


    //Write a native query that returns all users in the range of ages?

    @Query(value = "select * from user_account join account_details ad on ad.id = user_account.account_details_id\n" +
            "where ad.age between ?1 and ?2",nativeQuery = true)
    List<User> retrieveUsersByAgeBetween(Integer age1, Integer age2);


    //Write a native query to read a user by email?

    @Query(value = "select * from user_account where email = ?1",nativeQuery = true)
    User retrieveSpecificUserByEmail(String email);




}
