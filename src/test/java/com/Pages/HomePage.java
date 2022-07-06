package com.Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePage {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement txt_userName;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement txt_password;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement btn_logIn;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement lbl_register;

    @FindBy(xpath = "//div[@id='rightPanel']")
    private WebElement div_rightPanel;

}
