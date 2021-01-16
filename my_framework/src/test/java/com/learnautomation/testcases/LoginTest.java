package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.learnautomation.pages.BaseClass;
import com.learnautomation.pages.LoginToApp;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ExcelDataProvider;

public class LoginTest extends BaseClass
{

	@Test
	public void startApp() 
	{	
		logger = report.createTest("Login to Facebook");// this creates object of Extent Test class
		
		LoginToApp login = new LoginToApp(driver);
		logger.info("Login to application");
		
		login.loginFB(excel.getStringData(0, 0, 0), excel.getStringData("Login", 0, 1)); // e.g of Abstraction i.e. code for login is hidden
		logger.pass("Login Successful"); 
		
		
		
		
		
	}
	
	
	
}
 