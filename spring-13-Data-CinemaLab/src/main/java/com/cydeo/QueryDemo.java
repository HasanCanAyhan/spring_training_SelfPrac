package com.cydeo;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;

    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        /*

        System.out.println("----------------ACCOUNT---------------------");

        System.out.println("findByState :  " + accountRepository.findByState("Kentucky"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByAgeLessThanEqual :  " + accountRepository.findByAgeLessThanEqual(35));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByRole :  " + accountRepository.findByRole(UserRole.USER));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByAgeBetween :  " + accountRepository.findByAgeBetween(28,35));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByAddressContains :  " + accountRepository.findByAddressContains("A"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByAgeOrderByAge :  " + accountRepository.findAccountsByOrderByAgeDesc());
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAllAccounts :  " + accountRepository.retrieveAllAccounts());
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAccountsByAdmin :  " + accountRepository.retrieveAccountsByAdmin(UserRole.ADMIN));
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAccountsBySortingAge :  " + accountRepository.retrieveAccountsBySortingAge());
        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeLowerThan :  " + accountRepository.readAllAccountsWithAgeLowerThan(35));
        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeLowerThan2 :  " + accountRepository.readAllAccountsWithAgeLowerThan2(35));
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAccountsContainsNameAddressCountryStateCity :  "
                + accountRepository.retrieveAccountsContainsNameAddressCountryStateCity("Josie D Story","262  Lochmere Lane","United States","Kentucky"));

        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeHigherThan :  " + accountRepository.readAllAccountsWithAgeHigherThan(40));
        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeHigherThan2 :  " + accountRepository.readAllAccountsWithAgeHigherThan2(40));


        System.out.println("----------------CINEMA---------------------");
        System.out.println("findByName :  " + cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findTop3BySponsoredNameOrderByName :  " + cinemaRepository.findTop3BySponsoredNameOrderByName("PlayStation"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByLocation_Country :  " + cinemaRepository.findByLocation_Country("United States"));
        System.out.println("findByLocation_PostalCode :  " + cinemaRepository.findByLocation_PostalCode("10036"));
        System.out.println("------------------------------------------------------------------");
        //System.out.println("findByNameOrSponsoredName :  " + cinemaRepository.findByNameOrSponsoredName("Quick Silver"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveCinemaWithSpecificId :  " + cinemaRepository.retrieveCinemaWithSpecificId(1L));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findAllCinemasByLocationCountry :  " + cinemaRepository.findAllCinemasByLocationCountry("United States"));
        System.out.println("------------------------------------------------------------------");
        //System.out.println("findAllCinemasByNameOrSponsoredName :  " + cinemaRepository.findAllCinemasByNameOrSponsoredName("H","M"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findCinemasBySortingName :  " + cinemaRepository.findCinemasBySortingName());
        System.out.println("------------------------------------------------------------------");
        //Write a native query to distinct all cinemas by sponsored name
        System.out.println("------------------------------------------------------------------");


        System.out.println("----------------GENRE---------------------");

        System.out.println("retrieveGenres :  " + genreRepository.retrieveGenres());
        System.out.println("------------------------------------------------------------------");
        System.out.println("findGenresByContainingName :  " + genreRepository.findGenresByContainingName("C"));



        System.out.println("----------------MOVIE-CINEMA---------------------"); // nochmal widerholen

        System.out.println("findMovieCinemaByDateTimeGreaterThan :  " + movieCinemaRepository.findMovieCinemaByDateTimeGreaterThan(LocalDateTime.of(2020,5,12,5,12)));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findMovieCinemaByMovie_Name :  " + movieCinemaRepository.findMovieCinemaByMovie_Name("Tenet"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findMovieCinemaByCinema_Location :  " + movieCinemaRepository.findMovieCinemaByCinema_Location_Name( "AMC Empire 25"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findMovieCinemasWithHigherThanSpecificDate :  " + movieCinemaRepository.findMovieCinemasWithHigherThanSpecificDate(LocalDateTime.of(2020,5,12,5,12)));
        System.out.println("------------------------------------------------------------------");
        System.out.println("getCountMovieCinemasByCinemaId :  " + movieCinemaRepository.getCountMovieCinemasByCinemaId(2L));
        System.out.println("------------------------------------------------------------------");
        System.out.println("getMovieCinemasByLocationName :  " + movieCinemaRepository.getMovieCinemasByLocationName("AMC Empire 25"));

         */

        System.out.println("----------------MOVIE---------------------");
        System.out.println("readByName :  " + movieRepository.findMovieByName("The Gentleman"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByPriceBetween :  " + movieRepository.findByPriceBetween(BigDecimal.TEN, BigDecimal.valueOf(20)));
        System.out.println("-----------------------------------------------------------------");
        List<Integer> durations = Arrays.asList(113,135);
        for (Integer duration : durations) {
            System.out.println("findByDuration :  " + movieRepository.findByDuration(duration));
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("findMovieByReleaseDateGreaterThan :  " + movieRepository.findMovieByReleaseDateGreaterThan(LocalDate.of(2020,11,19)));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("findByStateAndType :  " + movieRepository.findByStateAndType(MovieState.ACTIVE, MovieType.REGULAR));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("getAllMoviesBetweenRangeOfPrices :  " + movieRepository.getAllMoviesBetweenRangeOfPrices(BigDecimal.valueOf(15),BigDecimal.valueOf(20)));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("getAllMoviesNames :  " + movieRepository.getAllMoviesNames());





    }
}
