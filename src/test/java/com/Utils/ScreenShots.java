package com.Utils;

import com.Config.Parametrs;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {

    public static String screenShot(WebDriver driver, String fileName) {
        String pathname = Parametrs.FOLDER_REPORTS.getParameter() + Parametrs.FOLDER_SCREENSHOTS.getParameter() + fileName;

        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot) driver);

        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination
        File DestFile=new File(pathname);

        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Parametrs.FOLDER_SCREENSHOTS.getParameter() + fileName;
    }
}
