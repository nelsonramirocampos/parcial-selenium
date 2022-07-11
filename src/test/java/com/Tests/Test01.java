package com.Tests;


import com.Config.DriverConfig;
import com.Helpers.ReportsHelper;
import com.Utils.ScreenShots;
import com.Model.Person;
import com.Pages.*;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.*;

class Test01 {

	@BeforeAll
	public static void setupDriver(){
		ReportsHelper.crear(Test01.class.getName());

		DriverConfig.setup("chrome");
		DriverConfig.goHome();
	}


	@Test
	@Tag("Smoke")
	@DisplayName("TC - Proceso de registro")
	public void test() throws InterruptedException {
		ExtentTest test = ReportsHelper.extent.createTest("TC - Proceso de registro");
		test.info("Inicio de test");

		CustomerLoginServices login = new CustomerLoginServices(DriverConfig.getDriver());
		RegisterServices register = new RegisterServices(DriverConfig.getDriver());
		HomeServices home = new HomeServices(DriverConfig.getDriver());

		Person person = new Person();

		test.log(Status.INFO, "Datos del usuario a registrar: " + person);


		RegisterPage registerPage = new RegisterPage();

		login.clickRegister();

		register.writeFirtsName(person.getFirtsName());
		register.writeLastName(person.getLastName());
		register.writeAddress(person.getAddress());
		register.writeCity(person.getCity());
		register.writeState(person.getState());
		register.writeZipCode(person.getZipCode());
		register.writePhoneNumber(person.getPhoneNumber());
		register.writeSsn(person.getSsn());

		register.writeUserName(person.getUserName());
		register.writePassword(person.getUserPassword());
		register.writeRepeatedPassword(person.getUserPassword());

		register.clickRegister();

		Thread.sleep(1000);

		Boolean result_register = home.textRightPanel().contains("This username already exists.");
		if(!result_register){
			test.pass("Se registro correctamente");
		}
		else{
			test.fail("Error al registrarse");
		}

		test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(
				ScreenShots.screenShot(DriverConfig.getDriver(), "capture.png")
		).build());

		Assertions.assertTrue(!result_register);


		Boolean result =
				home.textRightPanel().contains("Your account was created successfully. You are now");

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
	public static void end(){
		DriverConfig.quit();

		ReportsHelper.extent.flush();
	}

}
