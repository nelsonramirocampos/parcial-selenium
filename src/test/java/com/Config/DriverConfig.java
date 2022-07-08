package com.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class DriverConfig {
    private static WebDriver driver;

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

    public static WebDriver getDriver(){
        return driver;
    }

    public static void goHome() {
        driver.get("https://parabank.dedosmedia.com/parabank/index.htm");
    }

    public static void quit() {
        driver.quit();
    }
}
