package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginServices {
    private HomePage page;

    public CustomerLoginServices(WebDriver driver){
        this.page = PageFactory.initElements(driver, HomePage.class);
    }

    public void writeUserName(String userName){
        page.getTxt_userName().sendKeys(userName);
    }

    public void writeUserPassword(String userPassword){
        this.page.getTxt_password().sendKeys(userPassword);
    }

    public void clickLogin(){
        page.getBtn_logIn().click();
    }

    public void clickRegister(){
        page.getLbl_register().click();
    }
}
