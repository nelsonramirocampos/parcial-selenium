package com.Helpers;

import com.Config.Parametrs;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportsHelper {
    private static ExtentSparkReporter spark;
    public static ExtentReports extent;

    public static void crear(String nameReport) {
        spark = new ExtentSparkReporter(Parametrs.FOLDER_REPORTS.getParameter() + nameReport + ".html");
        extent = new ExtentReports();

        extent.attachReporter(spark);
    }
}
