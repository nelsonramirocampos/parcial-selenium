package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class AccountsOverviewServices {
    private AccountsOverviewPage page;

    public AccountsOverviewServices(WebDriver driver){
        this.page = PageFactory.initElements(driver, AccountsOverviewPage.class);
    }

    public void clickAccount(String account){
        for (WebElement element : this.page.getList_account()) {
            if (element.getText().equalsIgnoreCase(account)){
                element.click();
                break;
            }
        }
    }

    public void clickRandomAccount() {
        //Genera un numero random para seleccionar una cuenta al azar
        Random r = new Random();
        int low = 0; //Elemento 0 de la lista
        int high = this.page.getList_account().size() - 1; //Último elemento. Se resta 1 ya que si da el tamaño de la lista, el puntero dara null
        int result = r.nextInt(high-low) + low;

        this.page.getList_account().get(result).click();
    }
}
