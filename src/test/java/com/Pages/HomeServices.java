package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomeServices {
    private HomePage home;

    public HomeServices(WebDriver driver){
        this.home = PageFactory.initElements(driver, HomePage.class);
    }

    public String textRightPanel(){
        return home.getDiv_rightPanel().getText();
    }
}
