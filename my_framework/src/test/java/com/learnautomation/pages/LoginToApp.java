package com.learnautomation.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginToApp 
{
WebDriver driver;

public LoginToApp(WebDriver ldriver)
  {
	this.driver=ldriver;
  }

public void loginFB(String username, String password)
  {
	WebElement emailID=driver.findElement(By.name("email"));
	emailID.sendKeys(username);
	
	WebElement lpassword=driver.findElement(By.name("pass"));
	lpassword.sendKeys(password);
	
	driver.findElement(By.name("login")).click();
	try {
		Thread.sleep(10000);
	} 
	catch (InterruptedException e)
	{
		e.printStackTrace();
	}
  }
}
