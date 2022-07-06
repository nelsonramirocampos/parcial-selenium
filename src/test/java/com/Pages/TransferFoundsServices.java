package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class TransferFoundsServices {
    private TransferFoundsPage page;

    public TransferFoundsServices(WebDriver driver){
        this.page = PageFactory.initElements(driver, TransferFoundsPage.class);
    }

    public void writeAmount(String amount){
        this.page.getTxt_amount().sendKeys(amount);
    }

    public void selectFromAccount(String fromAccount){
        (new Select(this.page.getDp_fromAccount())).selectByVisibleText(fromAccount);
    }

    public void selectToAccount(String toAccount){
        (new Select(this.page.getDp_toAccount())).selectByVisibleText(toAccount);
    }

    public void clickTransfer(){
        this.page.getBtn_transfer().click();
    }

    public void selectRandomFromAccount() {
        Select select = new Select(this.page.getDp_fromAccount());

        //Genera un numero random para seleccionar una cuenta al azar
        Random r = new Random();
        int low = 0; //Elemento 0 de la lista
        int high = select.getOptions().size() - 1; //Último elemento. Se resta 1 ya que si da el tamaño de la lista, el puntero dara null
        int result = r.nextInt(high-low) + low;

        select.selectByIndex(result);
    }

    public void selectRandomToAccount() {
        Select select = new Select(this.page.getDp_toAccount());

        //Genera un numero random para seleccionar una cuenta al azar
        Random r = new Random();
        int low = 0; //Elemento 0 de la lista
        int high = select.getOptions().size() - 1; //Último elemento. Se resta 1 ya que si da el tamaño de la lista, el puntero dara null
        int result = r.nextInt(high-low) + low;

        select.selectByIndex(result);
    }
}
