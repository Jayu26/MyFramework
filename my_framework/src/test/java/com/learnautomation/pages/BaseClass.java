package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.externalconfig.model.Config;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(new File(System.getProperty("user.dir"))+"/Reports/"+Helper.getCurrentDateTime()+".html");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
	}

	@BeforeTest
	public void setup()
	{
		Reporter.log("Browser is going to up & app will be started", true);
		driver = BrowserFactory.startApplication(driver, config.getConfigData("Browser"), config.getConfigData("QaUrl"));
		System.out.println(driver.getTitle());
		Reporter.log("Browser is up & app has started", true);
	}
	
	@AfterTest
	public void tearDown()
	{
		Reporter.log("Browser is going to close", true);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("Browser has closed", true);
    }
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) 
	{
		Reporter.log("Going to capture & attach screenshot in report", true);
		if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Step Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Failed to capture screenshot");
			}		
		}
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				logger.pass("Test Step Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (IOException e) {
				System.out.println("Screenshot Captured");
			}
		}
		report.flush();
		Reporter.log("Screenshot is captured & attached", true);
	}
}
	
