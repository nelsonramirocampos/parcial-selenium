package com.Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class AccountsOverviewPage {
    @FindBy(xpath = "//a[@class='ng-binding']")
    private List<WebElement> list_account;

}
