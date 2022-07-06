package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountDetailsServices {
    private AccountDetailsPage page;

    public AccountDetailsServices(WebDriver driver){
        this.page = PageFactory.initElements(driver, AccountDetailsPage.class);
    }

    public void selectActivityPeriod(String activityPeriod){
        (new Select(this.page.getDp_activityPeriod())).selectByVisibleText(activityPeriod);
    }

    public void selectType(String type){
        (new Select(this.page.getDp_type())).selectByVisibleText(type);
    }

    public void clickGo(){
        this.page.getBtn_go().click();
    }
}
