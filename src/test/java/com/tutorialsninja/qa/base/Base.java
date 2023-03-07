package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public Properties prop;
	public Properties dataProp;
	WebDriver driver;
	
	public Base() {
		prop=new Properties();
		File propFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		dataProp = new Properties();
		File dataPropFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis=new FileInputStream(dataPropFile);
		dataProp.load(datafis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		try {
		FileInputStream fis=new FileInputStream(propFile);
		prop.load(fis);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
	public WebDriver initializebrowserandvisitURL(String Browser) {
		
		if(Browser.equals("Chrome"))
		{
		driver=new ChromeDriver();
		} 
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		return driver;
	}

}
