package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //city, state , account so field
    private String password; // password should not be passed to UI Part through api
    private String username;
    private UserRole role;

    @JsonManagedReference // show accountDto inside userDto  //This field is  going to be serialized
    private AccountDTO account;

}
