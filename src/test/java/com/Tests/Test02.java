package com.Tests;

import com.Config.DriverConfig;
import com.Model.Person;
import com.Pages.AccountServices;
import com.Pages.CustomerLoginServices;
import com.Pages.HomeServices;
import org.junit.jupiter.api.*;

import java.util.TreeMap;

public class Test02 {

    @BeforeAll
    public static void setupDriver(){
        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Apertura de una nueva cuenta")
    public void test() throws InterruptedException {
        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.driver);
        Person person = new Person();
        AccountServices account = new AccountServices(DriverConfig.driver);
        HomeServices home = new HomeServices(DriverConfig.driver);


        login.writeUserName(person.getUserName());
        login.writeUserPassword(person.getUserPassword());
        login.clickLogin();


        account.clickOpenNewAccount();
        account.selectTypeAccount("SAVINGS");

        //Para que pueda hacer click en New Account
        Thread.sleep(1000);
        account.clickNewAccount();

        //Para que termine de abrir la cuenta
        Thread.sleep(1000);
        Assertions.assertTrue(home.textRightPanel().contains("Congratulations, your account is now open."));
    }


    @AfterAll
    public static void end(){
        DriverConfig.quit();
    }
}
