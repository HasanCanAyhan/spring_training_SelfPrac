package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name

    Movie findMovieByName(String name);


    //Write a derived query to list all movies between a range of prices

    List<Movie> findByPriceBetween(BigDecimal price1, BigDecimal price2);


    //Write a derived query to list all movies where duration exists in the specific list of duration

    //??????????yaptim ama bir dha bak
    List<Movie> findByDuration(Integer durations);

    //Write a derived query to list all movies with higher than a specific release date

    List<Movie> findMovieByReleaseDateGreaterThan(LocalDate date);

    //Write a derived query to list all movies with a specific state and type

    List<Movie> findByStateAndType(MovieState movieState, MovieType movieType);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices

    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> getAllMoviesBetweenRangeOfPrices(BigDecimal price1, BigDecimal price2);


    //Write a JPQL query that returns all movie names

    @Query("select m.name from Movie m")
    List<String> getAllMoviesNames();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name


    //Write a native query that return the list of movies in a specific range of prices


    //Write a native query to return all movies where duration exists in the range of duration


    //Write a native query to list the top 5 most expensive movies


}
