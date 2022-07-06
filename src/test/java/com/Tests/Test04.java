package com.Tests;

import com.Config.DriverConfig;
import com.Model.Person;
import com.Pages.*;
import org.junit.jupiter.api.*;

public class Test04 {

    @BeforeAll
    public static void setupDriver(){
        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("Transferencia de fondos")
    public void test() throws InterruptedException {
        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.driver);
        Person person = new Person();
        AccountServices account = new AccountServices(DriverConfig.driver);
        HomeServices home = new HomeServices(DriverConfig.driver);
        TransferFoundsServices transferFounds = new TransferFoundsServices(DriverConfig.driver);


        login.writeUserName(person.getUserName());
        login.writeUserPassword(person.getUserPassword());
        login.clickLogin();

        account.clickTransferFounds();

        Assertions.assertTrue(home.textRightPanel().contains("Transfer Funds"));

        //Para que termino de cargar los numeros de cuentas
        Thread.sleep(1000);

        transferFounds.writeAmount("100");
        transferFounds.selectRandomFromAccount();
        //transferFounds.selectFromAccount("21669");
        transferFounds.selectRandomToAccount();
        //transferFounds.selectToAccount("21891");
        transferFounds.clickTransfer();

        //Para que se visualice la transaccion completa
        Thread.sleep(1000);

        Assertions.assertTrue(home.textRightPanel().contains("Transfer Complete!"));
    }

    @AfterAll
    public static void end(){
        DriverConfig.quit();
    }
}
