package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountServices {
    private AccountPage page;

    public AccountServices(WebDriver driver){
        this.page = PageFactory.initElements(driver, AccountPage.class);
    }

    public void clickOpenNewAccount(){
        this.page.getLbl_openNewAccount().click();
    }

    public void selectTypeAccount(String typeAccount){
        (new Select(this.page.getDp_typeAccount())).selectByVisibleText(typeAccount.toUpperCase());
    }

    public void clickNewAccount(){
        this.page.getLbl_newAccount().click();
    }

    public void clickAccountsOverview(){
        this.page.getLbl_accountsOverview().click();
    }

    public void clickTransferFounds(){
        this.page.getLbl_transferFunds().click();
    }

}
