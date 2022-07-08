package com.Pages;

import lombok.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage {

    @FindBy(xpath = "//input[@id='customer.firstName']")
    private WebElement txt_firstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    private WebElement txt_lastName;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    private WebElement txt_address;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    private WebElement txt_city;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    private WebElement txt_state;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    private WebElement txt_zipCode;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    private WebElement txt_phoneNumber;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    private WebElement txt_ssn;

    @FindBy(xpath = "//input[@id='customer.username']")
    private WebElement txt_userName;

    @FindBy(xpath = "//input[@id='customer.password']")
    private WebElement txt_password;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    private WebElement txt_repeatedPassword;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement btn_register;

    @FindBy(xpath = "//div[@id='rightPanel']")
    private WebElement div_rightPanel;
}
