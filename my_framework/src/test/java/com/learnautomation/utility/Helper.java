package com.learnautomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper 
{
	public static String captureScreenshot(WebDriver driver)
	{
		String screenshotPath = System.getProperty("user.dir")+"/Screenshots/FB "+getCurrentDateTime()+".png";
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHelper.copyFile(src, new File(screenshotPath));
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime() 
	{
		DateFormat customFormat = new SimpleDateFormat("MM_DD_YYYY_HH_MM_SS");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
}
