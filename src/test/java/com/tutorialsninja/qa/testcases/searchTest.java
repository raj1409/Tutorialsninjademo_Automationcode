package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;

public class searchTest extends Base {
	public searchTest() {
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver=initializebrowserandvisitURL(prop.getProperty("Browser"));
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	
	@Test
	public void searchwithvalidproduct() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("validproduct"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed(),"not displayed anything");
	}
	
	@Test
	public void searchwithinvalidproduct() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.name("search")).sendKeys(dataProp.getProperty("invalidproduct"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		String actualsearchmessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualsearchmessage,"There is no product that matches the search criteria.","No product displayed" );
		
	}
	
	@Test
	public void searchwithoutproduct() throws InterruptedException {
		
		driver.findElement(By.name("search")).sendKeys("");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		String actualsearchmessage = driver.findElement(By.xpath("//*[@id=\"content\"]/p[2]")).getText();
		Assert.assertEquals(actualsearchmessage,"There is no product that matches the search criteria.","No product displayed" );
		
	}

}
