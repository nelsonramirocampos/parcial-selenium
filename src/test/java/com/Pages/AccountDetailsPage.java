package com.Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountDetailsPage {

    @FindBy(xpath = "//select[@id='month']")
    private WebElement dp_activityPeriod;

    @FindBy(xpath = "//select[@id='transactionType']")
    private WebElement dp_type;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement btn_go;

    @FindBy(xpath = "//table[@id='transactionTable']")
    private WebElement tbl_transactions;

}
