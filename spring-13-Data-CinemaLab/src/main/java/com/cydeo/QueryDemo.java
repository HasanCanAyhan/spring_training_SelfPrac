package com.cydeo;

import com.cydeo.entity.Movie;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;

    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
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
        System.out.println("findByAddressContains :  " + accountRepository.findAllByAddressStartingWith("A"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByAgeOrderByAge :  " + accountRepository.findAccountsByOrderByAgeDesc());
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAllAccounts :  " + accountRepository.retrieveAllAccounts());
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAccountsByAdmin :  " + accountRepository.retrieveAccountsByAdmin());
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveAccountsBySortingAge :  " + accountRepository.retrieveAccountsBySortingAge());
        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeLowerThan :  " + accountRepository.readAllAccountsWithAgeLowerThan(35));
        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeLowerThan2 :  " + accountRepository.readAllAccountsWithAgeLowerThan2(35));
        System.out.println("------------------------------------------------------------------");

       System.out.println("retrieveAccountsContainsNameAddressCountryStateCity :  "
         + accountRepository.retrieveAllAccountsContainNameAddressCountryStateCity("a"));

        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeHigherThan :  " + accountRepository.readAllAccountsWithAgeHigherThan(40));
        System.out.println("------------------------------------------------------------------");
        System.out.println("readAllAccountsWithAgeHigherThan2 :  " + accountRepository.readAllAccountsWithAgeHigherThan2(40));







        System.out.println("----------------CINEMA---------------------");
        System.out.println("findByName :  " + cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findTop3BySponsoredNameOrderByName :  "
                + cinemaRepository.findFirst3BySponsoredNameContainingOrderBySponsoredName("PlayStation"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByLocation_Country :  " + cinemaRepository.findByLocation_Country("United States"));
        System.out.println("findByLocation_PostalCode :  " + cinemaRepository.findByLocation_PostalCode("10036"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findByNameOrSponsoredName :  " + cinemaRepository.findAllByNameOrSponsoredName("Quick Silver","PlayStation"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("retrieveCinemaWithSpecificId :  " + cinemaRepository.retrieveCinemaWithSpecificId(1L));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findAllCinemasByLocationCountry :  " + cinemaRepository.findAllCinemasByLocationCountry("United States"));
        System.out.println("------------------------------------------------------------------");
        System.out.println("findAllCinemasByNameOrSponsoredName :  " + cinemaRepository.findAllCinemasByNameOrSponsoredName("H"));
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

        System.out.println("------------------------------------------------------------------");

        System.out.println("------------------------------------------------------------------");

        System.out.println("------------------------------------------------------------------");

        System.out.println("------------------------------------------------------------------");

        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("------------------------------------------------------------------");











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
        System.out.println("-----------------------------------------------------------------");
        System.out.println("getMovieByName :  " + movieRepository.getMovieByName("The Gentleman"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("getMoviesInSpecificRangeOfPrice :  " + movieRepository.getMoviesInSpecificRangeOfPrice(BigDecimal.valueOf(12),BigDecimal.valueOf(25)));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("getMoviesInRangeOfDuration :  " + movieRepository.getMoviesInRangeOfDuration(113, 135));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("getTop5MostExpensiveMovies :  " + movieRepository.getTop5MostExpensiveMovies());
        System.out.println("-----------------------------------------------------------------");



        System.out.println("----------------TICKET---------------------");

        System.out.println("countTicketByUserAccount :  " + ticketRepository.countTicketByUserAccount(userRepository.findById(1L).get()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("findByUserAccount_Email :  " + ticketRepository.findByUserAccount_Email("josie_story@email.com"));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("countTicketByMovieCinema_Movie :  " + ticketRepository.countTicketByMovieCinema_Movie(movieRepository.findById(3L).get()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("findTicketsByDateTimeBetween :  " + ticketRepository.findTicketsByDateTimeBetween(LocalDateTime.of(2000,1,1,8,15),LocalDateTime.of(2025,1,1,8,30) ));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("findTicketsBoughtFromASpecificUser :  " + ticketRepository.findTicketsBoughtFromASpecificUser(userRepository.findById(2L).get()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("findTicketsBetweenDates :  " + ticketRepository.findTicketsBetweenDates(LocalDateTime.of(2000,1,1,8,15),LocalDateTime.of(2025,1,1,8,30) ));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("countTicketWhichUserBought :  " + ticketRepository.countTicketWhichAUserBought(userRepository.findById(1L).get()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("countTicketsOfAUserBoughtWhichDateTimeBetween :  " + ticketRepository.countTicketsOfAUserBoughtWhichDateTimeBetween(
                userRepository.findById(1L).get(), LocalDateTime.of(2000,1,1,8,15),LocalDateTime.of(2025,1,1,8,30) ));
        System.out.println("-----------------------------------------------------------------");
        //?????????????????
        //System.out.println("distinctAllTicketsByMovieName :  " + ticketRepository.distinctAllTicketsByMovieName());
        System.out.println("-----------------------------------------------------------------");

        System.out.println("getAllTicketsByUserEmail :  " + ticketRepository.getAllTicketsByUserEmail(userRepository.findById(1L).get().getEmail()));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("retrieveAllTickets :  " + ticketRepository.retrieveAllTickets());


        System.out.println("-----------------------------------------------------------------");
        //??????????????????????????
        //System.out.println("retrieveTicketsWhereSpecificValueContainableInUsernameOrAccountNameOrMovieName :  "
          //      + ticketRepository.retrieveTicketsWhereSpecificValueContainableInUsernameOrAccountNameOrMovieName());






        System.out.println("----------------USER---------------------");


        System.out.println("findByEmail :  " + userRepository.findByEmail("josie_story@email.com"));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("findByUsername :  " + userRepository.findByUsername("josieStory"));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("findUserBy :  " + userRepository.findUserByUsernameContains("j"));
        System.out.println("-----------------------------------------------------------------");

        System.out.println("findUserByUsernameContainsIgnoreCase :  " + userRepository.findUserByUsernameContainsIgnoreCase("J"));
        System.out.println("-----------------------------------------------------------------");

        //Write a derived query to list all users with an age greater than a specified age?
        //???????????????????????????????????????????????????????????????
        System.out.println("-----------------------------------------------------------------");

        System.out.println("retrieveUserByEmail :  " + userRepository.retrieveUserByEmail("josie_story@email.com"));

        System.out.println("-----------------------------------------------------------------");

        System.out.println("retrieveUserByUsername :  " + userRepository.retrieveUserByUsername("josieStory"));


        System.out.println("-----------------------------------------------------------------");
        System.out.println("retrieveUsers :  " + userRepository.retrieveUsers());

        System.out.println("-----------------------------------------------------------------");
        System.out.println("retrieveUsersContainASpecificName :  " + userRepository.retrieveUsersContainASpecificName("a"));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("retrieveAllUsers :  " + userRepository.retrieveAllUsers());

        System.out.println("-----------------------------------------------------------------");
        System.out.println("retrieveUsersByAgeBetween :  " + userRepository.retrieveUsersByAgeBetween(10,35));

        System.out.println("-----------------------------------------------------------------");
        System.out.println("retrieveSpecificUserByEmail :  " + userRepository.retrieveSpecificUserByEmail("josie_story@email.com"));






         */


        /* I should first change method name's
        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(accountRepository.fetchAdminUsers());
        System.out.println(cinemaRepository.distinctBySponsoredName());
        System.out.println(movieRepository.fetchAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.fetchAllTicketsByUserAccount(4L));
        System.out.println(ticketRepository.fetchAllTicketsWithRangeOfDates(LocalDateTime.now().minusDays(21), LocalDateTime.now()));
        System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
        System.out.println(genreRepository.fetchAll());


         */


        System.out.println("1 : " + userRepository.findUserByUsernameContains("josieStory"));

        System.out.println("--------------------");

        System.out.println("2 : " + userRepository.findAllByAccountNameContaining("Josie D Story"));


    }
}
