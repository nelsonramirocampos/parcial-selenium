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

public class Test05 {

    @BeforeAll
    public static void setupDriver(){
        ReportsHelper.crear(Test05.class.getName());

        DriverConfig.setup("chrome");
        DriverConfig.goHome();
    }

    @Test
    @Tag("Smoke")
    @Tag("Integration")
    @DisplayName("TC - Actividad de la cuenta")
    public void test() throws InterruptedException {
        ExtentTest test = ReportsHelper.extent.createTest("TC - Actividad de la cuenta");
        test.info("Inicio de test");

        CustomerLoginServices login = new CustomerLoginServices(DriverConfig.getDriver());
        AccountServices account = new AccountServices(DriverConfig.getDriver());
        AccountDetailsServices accountDetails = new AccountDetailsServices(DriverConfig.getDriver());
        HomeServices home = new HomeServices(DriverConfig.getDriver());
        AccountsOverviewServices accountsOverview = new AccountsOverviewServices(DriverConfig.getDriver());

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

        //Agregar validación que se visualice que se inicio sesión, sino, muestré que falló.
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

        Thread.sleep(2000);

        if(accountDetails.isVisibleTransactionsTable()){
            test.pass("Se visualiza la tabla con las transacciones");
        }
        else{
            test.fail("Error al visualizar la tabla de transacciones");
        }

        test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(
                ScreenShots.screenShot(DriverConfig.getDriver(),"capture.png")
        ).build());

        Assertions.assertTrue(accountDetails.isVisibleTransactionsTable());
    }


    @AfterAll
    public static void end() {
        DriverConfig.quit();
        ReportsHelper.extent.flush();
    }
}
