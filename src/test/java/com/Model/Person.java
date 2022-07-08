package com.Model;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {

    private String firtsName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String ssn;
    private String userName;
    private String userPassword;

    public Person(){
        create();
    }

    private void create(){
        this.firtsName = Faker.instance().name().firstName();
        this.lastName = Faker.instance().name().lastName();
        this.address = Faker.instance().address().streetAddress();
        this.city = Faker.instance().address().city();
        this.state = Faker.instance().address().state();
        this.zipCode = Faker.instance().address().zipCode();
        this.phoneNumber = Faker.instance().phoneNumber().phoneNumber();
        this.ssn = Faker.instance().idNumber().ssnValid();
        this.userName = Faker.instance().name().username();
        this.userPassword = Faker.instance().internet().password();
    }
}
