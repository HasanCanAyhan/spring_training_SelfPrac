package com.cydeo;

import com.cydeo.enums.UserRole;
import com.cydeo.repository.AccountRepository;
import com.cydeo.repository.CinemaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
    }


    @Override
    public void run(String... args) throws Exception {

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






    }
}
