package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider
{
	Properties prop;
	public ConfigDataProvider()
	{
		File src = new File("./Config/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			
			prop = new Properties();
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Not able to load config file" + e.getMessage());
		} 
	}
	public String getConfigData(String key)
	{
		return prop.getProperty(key);
	}
}
