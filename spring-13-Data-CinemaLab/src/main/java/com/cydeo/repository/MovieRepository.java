package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name

   Optional<Movie> findMovieByName(String name);


    //Write a derived query to list all movies between a range of prices

    List<Movie> findByPriceBetween(BigDecimal price1, BigDecimal price2);


    //Write a derived query to list all movies where duration exists in the specific list of duration

    List<Movie> findByDurationIn(List<Integer> durations);

    //Write a derived query to list all movies with higher than a specific release date

    List<Movie> findMovieByReleaseDateAfter(LocalDate date);

    //Write a derived query to list all movies with a specific state and type

    List<Movie> findByStateAndType(MovieState movieState, MovieType movieType);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices

    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> getAllMoviesBetweenRangeOfPrices(BigDecimal price1, BigDecimal price2);


    //Write a JPQL query that returns all movie names

    @Query("select distinct m.name from Movie m")
    List<String> getAllMoviesNames();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name

    @Query(value = "select * from movie\n" +
            "where name = ?1", nativeQuery = true)
    Optional<Movie> getMovieByName(@Param("name") String name);


    //Write a native query that return the list of movies in a specific range of prices

    @Query(value = "select * from movie\n" +
            "where price between ?1 and ?2", nativeQuery = true)
    List<Movie> getMoviesInSpecificRangeOfPrice(BigDecimal price1, BigDecimal price2);


    //Write a native query to return all movies where duration exists in the range of duration

    @Query(value = "select * from movie\n" +
            "where duration between ?1 and ?2", nativeQuery = true) // also: in()
    List<Movie> getMoviesInRangeOfDuration(Integer duration1, Integer duration2);

 @Query(value = "select * from movie\n" +
         "where duration IN ?1", nativeQuery = true) // also: in()
 List<Movie> getMoviesInRangeOfDuration2(List<Integer> durations); // ?1 : List<Integer>


    //Write a native query to list the top 5 most expensive movies

    @Query(value = "select * from movie\n" +
            "order by price desc\n" +
            "limit 5", nativeQuery = true)
    List<Movie> getTop5MostExpensiveMovies();

}
