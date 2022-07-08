package com.Tests;

import com.Config.DriverConfig;
import com.Helpers.ReportsHelper;
import com.Utils.ScreenShots;
import com.Model.User;
import com.Pages.AccountServices;
import com.Pages.CustomerLoginServices;
import com.Pages.HomeServices;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.*;

public class Test02 {
    @BeforeAll
    public static void setupDriver(){
        ReportsHelper.crear(Test02.class.getName());

        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @Tag("Integration")
    @DisplayName("TC - Apertura de una nueva cuenta")
    public void test() throws InterruptedException {
        ExtentTest test = ReportsHelper.extent.createTest("TC - Apertura de una nueva cuenta");
        test.info("Inicio de test");

        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.getDriver());
        AccountServices account = new AccountServices(DriverConfig.getDriver());
        HomeServices home = new HomeServices(DriverConfig.getDriver());

        test.log(Status.INFO, String.format("Username: %s - Userpassword: %s", User.USUARIO.getUserName(), User.USUARIO.getUserPassword()) );

        //Person person = new Person();
        //login.writeUserName(person.getUserName());
        //login.writeUserPassword(person.getUserPassword());

        login.writeUserName(User.USUARIO.getUserName());
        login.writeUserPassword(User.USUARIO.getUserPassword());
        login.clickLogin();


        account.clickOpenNewAccount();
        account.selectTypeAccount("SAVINGS");

        //Para que pueda hacer click en New Account
        Thread.sleep(1000);
        account.clickNewAccount();

        //Para que termine de abrir la cuenta
        Thread.sleep(1000);

        Boolean result = home.textRightPanel().contains("Congratulations, your account is now open.");

        if (result) {
            test.pass("Contiene el texto");
        } else {
            test.fail("NO contiene el texto");
        }

        test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(
                ScreenShots.screenShot(DriverConfig.getDriver(),Test02.class.getName() + "capture.png")
        ).build());

        Assertions.assertTrue(result);
    }


    @AfterAll
    public static void end(){
        DriverConfig.quit();

        ReportsHelper.extent.flush();
    }
}
