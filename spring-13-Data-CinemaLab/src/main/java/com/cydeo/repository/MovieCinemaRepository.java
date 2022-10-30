package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id

    MovieCinema findMovieCinemaByMovieAndCinema(Movie movie, Cinema cinema);

    //Write a derived query to count all movie cinemas with a specific cinema id

    List<MovieCinema> findMovieCinemasByCinema(Cinema cinema);


    //Write a derived query to count all movie cinemas with a specific movie id

    List<MovieCinema> findMovieCinemasByMovie(Movie movie);


    //Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema> findMovieCinemaByDateTimeGreaterThan(LocalDateTime dateTime);


    //Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findTop3ByMovie(Movie movie);


    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findMovieCinemaByMovie_Name(String name);

    //Write a derived query to list all movie cinemas in a specific location name

    List<MovieCinema> findMovieCinemaByCinema_Location_Name(String locationName);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> findMovieCinemasWithHigherThanSpecificDate(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(value = "\n" +
            "select count(movie_cinema) from movie_cinema join cinema c on c.id = movie_cinema.cinema_id\n" +
            "where cinema_id = ?1", nativeQuery = true)
    Long getCountMovieCinemasByCinemaId(Long id);

    //Write a native query that returns all movie cinemas by location name

    @Query(value = "select * from movie_cinema " +
            "join cinema c on c.id = movie_cinema.cinema_id " +
            "join location l on l.id = c.location_id\n" +
            "where l.name = ?1", nativeQuery = true)
    List<MovieCinema> getMovieCinemasByLocationName(String locationName);




}
