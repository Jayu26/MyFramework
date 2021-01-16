package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory
{
	public static WebDriver startApplication(WebDriver driver, String browserName, String appURL)
	{
		if (browserName.equals("Chrome"))
		{
			/*System.setProperty("WebDriver.chrome.driver", "C:\\Automation\\chrome_driver\\chromedriver_win32\\chromedriver.exe");*/
			  System.setProperty("WebDriver.chrome.driver", "./Drivers/chromedriver.exe");// Driver moved to 'Drivers' folder in framework.
			  driver = new ChromeDriver();
		}
		else if (browserName.equals("Firefox"))
		{
			  System.setProperty("WebDriver.firefox.driver", "./firefoxdriver.exe");// this driver is not available
			  driver = new ChromeDriver();
		}
		else if (browserName.equals("IE"))
		{
			  System.setProperty("WebDriver.ie.driver", "./iedriver.exe");// this driver is not available
			  driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Sorry! We do not support this browser.");
		}
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver) 
	{
		driver.quit();
		
	}
}
