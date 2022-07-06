package com.Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountPage {

    @FindBy(xpath = "//a[normalize-space()='Open New Account']")
    private WebElement lbl_openNewAccount;

    @FindBy(xpath = "//select[@id='type']")
    private WebElement dp_typeAccount;

    @FindBy(css = "input[value='Open New Account']")
    private WebElement lbl_newAccount;

    @FindBy(xpath = "//a[normalize-space()='Accounts Overview']")
    private WebElement lbl_accountsOverview;

    @FindBy(xpath = "//a[normalize-space()='Transfer Funds']")
    private WebElement lbl_transferFunds;



}
