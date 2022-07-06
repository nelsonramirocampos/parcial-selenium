package com.Tests;

import com.Config.DriverConfig;
import com.Model.Person;
import com.Pages.*;
import org.junit.jupiter.api.*;

public class Test05 {

    @BeforeAll
    public static void setupDriver(){
        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Actividad de la cuenta")
    public void test() throws InterruptedException {
        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.driver);
        Person person = new Person();
        AccountServices account = new AccountServices(DriverConfig.driver);
        AccountDetailsServices accountDetails = new AccountDetailsServices(DriverConfig.driver);
        HomeServices home = new HomeServices(DriverConfig.driver);
        AccountsOverviewServices accountsOverview = new AccountsOverviewServices(DriverConfig.driver);

        login.writeUserName(person.getUserName());
        login.writeUserPassword(person.getUserPassword());
        login.clickLogin();

        account.clickAccountsOverview();

        Assertions.assertTrue(home.textRightPanel().contains("*Balance includes deposits that may be subject to holds"));

        //Para que cargue los numeros de cuenta
        Thread.sleep(2000);

        //Al loguearse con un usuario al azar, no siempre se tiene el mismo numero de cuenta
        //por lo tanto se implementa el metodo clickRandomAccount() para que la seleccione al azar una cuenta
        //accountsOverview.clickAccount("21891");
        accountsOverview.clickRandomAccount();
        accountDetails.selectActivityPeriod("All");
        accountDetails.selectType("All");
        accountDetails.clickGo();
    }


    @AfterAll
    public static void end() {
        DriverConfig.quit();
    }
}
