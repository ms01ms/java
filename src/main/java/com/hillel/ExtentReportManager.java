package com.hillel;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.hillel.project_config.ConfigReader;
import com.hillel.utils.DateUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest extentTest;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            String timestamp = DateUtils.getCurrentDate("yyyyMMdd_HHmmss");
            String reportPath = ConfigReader.getProperty("report.path") + " " + timestamp;
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extentReports.attachReporter(sparkReporter);

            sparkReporter.config().setReportName("Test Report");
            sparkReporter.config().setDocumentTitle("Test Results");
        }
        return extentReports;
    }

    public static ExtentTest createTest(String testName) {
        extentTest = extentReports.createTest(testName);
        return extentTest;
    }

    public static ExtentTest getTest() {
        return extentTest;
    }

    public static void finishTest() {
        extentReports.flush();
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = DateUtils.getCurrentDate("yyyyMMdd_HHmmss");
        String screenshotDir = ConfigReader.getProperty("screenshot.path");
        File destinationFile = new File(screenshotDir + screenshotName + "_" + timestamp +  ".png");

        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
            extentTest.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath("screenshots/" + screenshotName + "_" + timestamp +  ".png").build());
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

