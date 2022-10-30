package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import com.cydeo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought

    Integer countTicketByUserAccount(User user);

    //Write a derived query to list all tickets by specific email

    List<Ticket> findByUserAccount_Email(String email);


    //Write a derived query to count how many tickets are sold for a specific movie

    Integer countTicketByMovieCinema_Movie(Movie movie);


    //Write a derived query to list all tickets between a range of dates

    List<Ticket> findTicketsByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user

    @Query("select t from Ticket t where t.userAccount = ?1")
    List<Ticket> findTicketsBoughtFromASpecificUser(User user);


    //Write a JPQL query that returns all tickets between a range of dates

    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> findTicketsBetweenDates(LocalDateTime dateTime1, LocalDateTime dateTime2);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value = "select count(ticket) from ticket\n" +
            "where ticket.user_account_id = ?1 ",nativeQuery = true)
    Integer countTicketWhichAUserBought(User user);


    //Write a native query to count the number of tickets a user bought in a specific range of dates

    @Query(value = "select count(ticket) from ticket\n" +
            "where user_account_id = ?1  and  date_time between ?2 and ?3",nativeQuery = true)
    Integer countTicketsOfAUserBoughtWhichDateTimeBetween(User user, LocalDateTime dateTime1,LocalDateTime dateTime2);



    //Write a native query to distinct all tickets by movie name
    //?????????????????????????????????????

    //List<Ticket> distinctAllTicketsByMovieName();

    /*
    select distinct(ticket) from ticket
    join movie_cinema mc on mc.id = ticket.movie_cinema_id
    join movie m on m.id = mc.movie_id
    where m.name = 'The Nights Before Christmas';
     */



    //Write a native query to find all tickets by user email


    @Query(value = "select * from ticket\n" +
            "join user_account ua on ua.id = ticket.user_account_id\n" +
            "where ua.email = ?1 ;",nativeQuery = true)
    List<Ticket> getAllTicketsByUserEmail(String userEmail);


    //Write a native query that returns all tickets

    @Query(value = "select * from ticket",nativeQuery = true)
    List<Ticket> retrieveAllTickets();


    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name

    //???????????????????????????????????????????????
   // List<Ticket> retrieveTicketsWhereSpecificValueContainableInUsernameOrAccountNameOrMovieName();
    /*
    select * from ticket
    join user_account ua on ua.id = ticket.user_account_id
             join account_details ad on ad.id = ua.account_details_id
             join movie_cinema mc on mc.id = ticket.movie_cinema_id
             join movie m on m.id = mc.movie_id
    where ua.username = 'j%' or
          ad.name = 'J%'or
          m.name = 'T%';

     */

}
