package com.hillel.hw23;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
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
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-report.html");
            extentReports.attachReporter(sparkReporter);

            sparkReporter.config().setReportName("UI Automation Test Report");
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

        File destinationFile = new File("screenshots/" + screenshotName + ".png");

        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
            extentTest.pass("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(destinationFile.getAbsolutePath()).build());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

