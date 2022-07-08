package com.Tests;

import com.Config.DriverConfig;
import com.Helpers.ReportsHelper;
import com.Utils.ScreenShots;
import com.Model.User;
import com.Pages.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.*;

public class Test04 {

    @BeforeAll
    public static void setupDriver(){
        ReportsHelper.crear(Test04.class.getName());

        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Integration")
    @DisplayName("TC - Transferencia de fondos")
    public void test() throws InterruptedException {
        ExtentTest test = ReportsHelper.extent.createTest("TC - Transferencia de fondos");
        test.info("Inicio de test");

        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.getDriver());
        AccountServices account = new AccountServices(DriverConfig.getDriver());
        HomeServices home = new HomeServices(DriverConfig.getDriver());
        TransferFoundsServices transferFounds = new TransferFoundsServices(DriverConfig.getDriver());

        test.log(Status.INFO, String.format("Username: %s - Userpassword: %s", User.USUARIO.getUserName(), User.USUARIO.getUserPassword()) );

        //Person person = new Person();
        //login.writeUserName(person.getUserName());
        //login.writeUserPassword(person.getUserPassword());

        login.writeUserName(User.USUARIO.getUserName());
        login.writeUserPassword(User.USUARIO.getUserPassword());
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

        Boolean result = home.textRightPanel().contains("Transfer Complete!");

        if (result) {
            test.pass("Contiene el texto");
        } else {
            test.fail("NO contiene el texto");
        }

        test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(
                ScreenShots.screenShot(DriverConfig.getDriver(),Test04.class.getName() + "capture.png")
        ).build());


        Assertions.assertTrue(result);
    }

    @AfterAll
    public static void end(){
        DriverConfig.quit();

        ReportsHelper.extent.flush();
    }
}
