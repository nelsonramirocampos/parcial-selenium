package com.Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class TransferFoundsPage {

    @FindBy(xpath = "//input[@id='amount']")
    private WebElement txt_amount;

    @FindBy(xpath = "//select[@id='fromAccountId']")
    private WebElement dp_fromAccount;

    @FindBy(xpath = "//select[@id='toAccountId']")
    private WebElement dp_toAccount;

    @FindBy(xpath = "//input[@value='Transfer']")
    private WebElement btn_transfer;
}
