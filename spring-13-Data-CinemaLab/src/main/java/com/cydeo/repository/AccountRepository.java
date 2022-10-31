package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to list all accounts with a specific country or state
    List<Account> findByCountry(String country);
    List<Account> findByState(String state);


    //BY CNDLLH
    //List<Account> findAllByCountryOrState(String country, String state);



    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(int age);


    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);

    //Write a derived query to list all accounts between a range of ages
    List<Account> findByAgeBetween(int age1,int age2 );

    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account>  findAllByAddressStartingWith(String keyword);


    //Write a derived query to sort the list of accounts with age
    List<Account> findAccountsByOrderByAgeDesc();
    //List<Account> findAccountsByOrderByAge();


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts

    @Query(" SELECT a from Account a ")
    List<Account> retrieveAllAccounts();


    //Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role = 'ADMIN'")
    List<Account> retrieveAccountsByAdmin();

    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age")
    List<Account> retrieveAccountsBySortingAge();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "SELECT * FROM account_details where age  < ?1",nativeQuery = true)
    List<Account> readAllAccountsWithAgeLowerThan(int age); // native , can be used with @Param("age") too

    @Query("SELECT a FROM Account a where a.age  < :age")
    List<Account> readAllAccountsWithAgeLowerThan2(@Param("age") int age); // named parameter

    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city


    @Query(value = "select * from account_details ad where name ilike concat('%',?1,'%')" +
            "or address ilike concat('%',?1,'%') " +
            "or country ilike concat('%',?1,'%')" + // we can  do '%' || ?1 || '%' ?
            "or ad.state ilike concat('%',?1,'%')" +
            "or city ilike concat('%',?1,'%')", nativeQuery = true)
    List<Account> retrieveAllAccountsContainNameAddressCountryStateCity(@Param("pattern") String pattern);




    //Write a native query to read all accounts with an age higher than a specific value

    @Query(value = "SELECT * FROM account_details where age > ?1", nativeQuery = true)
    List<Account> readAllAccountsWithAgeHigherThan(int age );

    @Query("SELECT a from Account a where a.age > :age")
    List<Account> readAllAccountsWithAgeHigherThan2(@Param("age") int age );


}
