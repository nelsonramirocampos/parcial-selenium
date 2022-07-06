package com.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class DriverConfig {

    public static WebDriver driver;

    public static void setup(String browser){
        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("start-maximized");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
                break;
        }
    }

    public static void goHome() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public static void quit() {
        driver.quit();
    }
}
