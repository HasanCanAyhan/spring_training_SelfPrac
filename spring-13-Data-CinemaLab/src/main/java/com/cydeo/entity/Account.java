package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
//@Data
@Getter
@Setter
@Table(name = "account_details")
public class Account extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(mappedBy = "account")
    private User user;

    /*
   The reason is, when you have bidirectional mapping, if you use @ToString coming from Lombok, it will be an issue.
And @Data is also creating an issue because it is coming with @ToString in it already.
It is happening liken this.
Let's say you add @ToString in Account class. It will print all the fields inside the Account class. It will also print user field inside the Account class.
But what happens if User also has @ToString? User has account field inside of it. So @ToString will print the same Account object again, but again Account has User, so print the User again, and Account again, and User again and again and again.
Because of the bidirectional mapping, toString methods will get into infinite loop. So either you can break the bidirectional mapping or you can break the two sided toString structure, like I sent above.
I just created my own custom toString methods, and I removed User from Account's toString method.
So when you print User, it will print Account but while printing the Account, it won't be printing User inside the Account again.
     */


    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", postalCode='" + postalCode + '\'' +
                ", role=" + role +
                '}';
    }



}
