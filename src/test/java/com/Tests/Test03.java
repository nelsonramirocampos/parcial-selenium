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

public class Test03 {
    @BeforeAll
    public static void setupDriver(){
        ReportsHelper.crear(Test03.class.getName());

        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @DisplayName("TC - Vision general de la cuenta")
    public void test(){
        ExtentTest test = ReportsHelper.extent.createTest("TC - Vision general de la cuenta");
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

        Boolean result_login = home.textRightPanel().contains("The username and password could not be verified.");
        if(!result_login){
            test.pass("Se inicio correctamente la sesión");
        }
        else{
            test.fail("Error al iniciar sesión");
        }

        test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(
                ScreenShots.screenShot(DriverConfig.getDriver(), "capture.png")
        ).build());

        Assertions.assertTrue(!result_login);


        account.clickAccountsOverview();


        Boolean result = home.textRightPanel().contains("*Balance includes deposits that may be subject to holds");

        if (result) {
            test.pass("Contiene el texto");
        } else {
            test.fail("NO contiene el texto");
        }

        test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(
                ScreenShots.screenShot(DriverConfig.getDriver(), "capture.png")
        ).build());


        Assertions.assertTrue(result);
    }


    @AfterAll
    public static void end() {
        DriverConfig.quit();

        ReportsHelper.extent.flush();
    }
}
