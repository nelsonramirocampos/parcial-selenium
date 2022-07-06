package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegisterServices {

    private RegisterPage register;

    public RegisterServices(WebDriver driver) {
        register = PageFactory.initElements(driver, RegisterPage.class);
    }

    public void writeFirtsName(String firtsName){
        register.getTxt_firstName().sendKeys(firtsName);
    }

    public void writeLastName(String lastName){
        register.getTxt_lastName().sendKeys(lastName);
    }

    public void writeAddress(String address){
        register.getTxt_address().sendKeys(address);
    }

    public void writeCity(String city){
        register.getTxt_city().sendKeys(city);
    }

    public void writeState(String state){
        register.getTxt_state().sendKeys(state);
    }

    public void writeZipCode(String zipCode){
        register.getTxt_zipCode().sendKeys(zipCode);
    }

    public void writePhoneNumber(String phoneNumber){
        register.getTxt_phoneNumber().sendKeys(phoneNumber);
    }

    public void writeSsn(String ssn){
        register.getTxt_ssn().sendKeys(ssn);
    }

    public void writeUserName(String userName){
        register.getTxt_userName().sendKeys(userName);
    }

    public void writePassword(String password){
        register.getTxt_password().sendKeys(password);
    }

    public void writeRepeatedPassword(String password){
        register.getTxt_repeatedPassword().sendKeys(password);
    }

    public void clickRegister(){
        register.getBtn_register().click();
    }
}
