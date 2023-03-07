package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.utils.utilities;

public class registrationTest extends Base{
	public registrationTest() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeTest
	public void browsersetup() throws InterruptedException{
		    
		    driver=initializebrowserandvisitURL(prop.getProperty("Browser"));
			driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
			Thread.sleep(500);
			driver.findElement(By.linkText("Register")).click();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void registernewaccount() throws InterruptedException {
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstname"));
		Thread.sleep(500);
		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastname"));
		Thread.sleep(500);
		driver.findElement(By.id("input-email")).sendKeys(utilities.emailwithtimestamp());
		Thread.sleep(500);
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		Thread.sleep(500);
		driver.findElement(By.id("input-password")).sendKeys("12345");
		Thread.sleep(500);
		driver.findElement(By.id("input-confirm")).sendKeys("12345");
		Thread.sleep(500);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).isDisplayed());
	}
	
	
	@Test
	public void validatingerrormessage() {
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		//String actualprivacywarning = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).getText();
		//Assert.assertTrue(actualprivacywarning.contains("Warning: You must agree to the Privacy Policy!"), "msg is not displayed");
		
		String firstnamewarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).getText();
		Assert.assertEquals(firstnamewarning, "First Name must be between 1 and 32 characters!","Didnot show warning");
		

		String lastnamewarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[3]/div/div")).getText();
		Assert.assertEquals(lastnamewarning, "Last Name must be between 1 and 32 characters!","Didnot show warning");
		
		String Emailwarning = driver.findElement(By.xpath("//*[@id=\"account\"]/div[4]/div/div")).getText();
		Assert.assertEquals(Emailwarning, "E-Mail Address does not appear to be valid!","Didnot show warning");
		
	}
	
	

}
