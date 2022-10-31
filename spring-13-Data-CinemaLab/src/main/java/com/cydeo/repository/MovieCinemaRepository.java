package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id

    Optional<MovieCinema> findById(Long Id); // from JPA REPOSITORY

    //Write a derived query to count all movie cinemas with a specific cinema id

    Integer countAllByCinemaId(Long id);


    //Write a derived query to count all movie cinemas with a specific movie id

    Integer countAllByMovieId(Long id);


    //Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema> findMovieCinemaByDateTimeAfter(LocalDateTime dateTime);


    //Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findFirst3ByOrderByMoviePriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findAllByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name

    List<MovieCinema> findMovieCinemaByCinema_Location_Name(String locationName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> findMovieCinemasWithHigherThanSpecificDate(@Param("dateTime") LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(value = "\n" +
            "select count(movie_cinema) from movie_cinema where cinema_id = ?1", nativeQuery = true)
    Long getCountMovieCinemasByCinemaId(Long id);
    //Write a native query that returns all movie cinemas by location name

    @Query(value = "select * from movie_cinema " +
            "join cinema c on c.id = movie_cinema.cinema_id " +
            "join location l on l.id = c.location_id\n" +
            "where l.name = ?1", nativeQuery = true)
    List<MovieCinema> getMovieCinemasByLocationName(String locationName);

    //SELECT * FROM movie_cinema
    // where cinema_id IN
    // (SELECT id FROM cinema WHERE location_id = (SELECT id FROM location WHERE name = ?1))




}
