package com.Tests;


import com.Config.DriverConfig;
import com.Model.Person;
import com.Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;

class Test01 {
	static ExtentSparkReporter spark;
	static ExtentReports extent;

	@BeforeAll
	public static void setupDriver(){
		spark = new ExtentSparkReporter("target/Spark.html");
		extent = new ExtentReports();

		extent.attachReporter(spark);



		DriverConfig.setup("chrome");
		DriverConfig.goHome();
	}


	@Test
	@Tag("Smoke")
	@DisplayName("Proceso de registro")
	public void test() throws InterruptedException {
		CustomerLoginServices login = new CustomerLoginServices(DriverConfig.driver);
		RegisterServices register = new RegisterServices(DriverConfig.driver);
		HomeServices home = new HomeServices(DriverConfig.driver);

		Person person = new Person();

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
		Assertions.assertTrue(home.textRightPanel().contains("Your account was created successfully. You are now"));

		extent.createTest("Nombre test").log(Status.PASS, "Correcto");
		extent.flush();
	}

	@AfterAll
	public static void end(){
		DriverConfig.quit();
	}

}
