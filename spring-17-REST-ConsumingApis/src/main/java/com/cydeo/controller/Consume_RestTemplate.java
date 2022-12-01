package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    private final String URI = "https://jsonplaceholder.typicode.com/users"; // it is coming from third party (consuming api)
    private final RestTemplate restTemplate;// i will consume the api by using RestTemplate

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping //in the postman when you write and send http://localhost:8080/cydeo with Get, you can see data which is coming from consumed api
    public ResponseEntity<User[]> readAllUsers(){
        return restTemplate.getForEntity(URI, User[].class);//for consuming - mostly used
        //                               URI : consuming api , which dto you want to convert this Json data
        //                  getForEntity:You can customize the field, bcs we dto class, one field name ypu can put top oof it @JsonIgnore, if you dont want to see it in the json
    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable Integer id){
        String URL = URI + "/{id}"; // https://jsonplaceholder.typicode.com/users/id =>> hit the endpoint

        return restTemplate.getForObject(URL,Object.class, id);// here there is no our dto class
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){
        /*
        https://dummyapi.io/data/v1/user?limit=10 -->> it is secured api
        We should give key - value as password in the Headers, then you can reach the data from third part , like     headers.set("app-id", "6298ebfecd0551211fce37a6");
        Then you can send the request.
         */

        //we set headers

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id", "6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate
                .exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);
        //                                                                                 headers


    }




}
