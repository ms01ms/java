package com.hillel;

import com.aventstack.extentreports.ExtentReports;
import com.hillel.project_config.ConfigReader;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    private ExtentReports extentReport;

    @BeforeClass
    public void setUp() {
        BrowserFactory.createDriver(ConfigReader.getProperty("browser.name"));
        extentReport = ExtentReportManager.getInstance();
    }

    @AfterClass
    public void tearDown() {
        BrowserFactory.quitDriver();
        ExtentReportManager.finishTest();
    }
}
