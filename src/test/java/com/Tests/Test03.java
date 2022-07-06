package com.Tests;

import com.Config.DriverConfig;
import com.Model.Person;
import com.Pages.AccountServices;
import com.Pages.CustomerLoginServices;
import com.Pages.HomeServices;
import org.junit.jupiter.api.*;

public class Test03 {

    @BeforeAll
    public static void setupDriver(){
        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Vision general de la cuenta")
    public void test(){
        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.driver);
        Person person = new Person();
        AccountServices account = new AccountServices(DriverConfig.driver);
        HomeServices home = new HomeServices(DriverConfig.driver);


        login.writeUserName(person.getUserName());
        login.writeUserPassword(person.getUserPassword());
        login.clickLogin();

        account.clickAccountsOverview();

        Assertions.assertTrue(home.textRightPanel().contains("*Balance includes deposits that may be subject to holds"));

    }


    @AfterAll
    public static void end() {
        DriverConfig.quit();
    }
}
