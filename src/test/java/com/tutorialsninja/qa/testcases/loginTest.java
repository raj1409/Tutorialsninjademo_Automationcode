package com.tutorialsninja.qa.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.utils.utilities;

public class loginTest extends Base {
	public loginTest() {
		super();
	}
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		
		driver=initializebrowserandvisitURL(prop.getProperty("Browser"));  
		Homepage homepage= new Homepage(driver);
		homepage.clickonmyaccount();
		homepage.selectloginoption();
	}
	
	@DataProvider
	public Object[][] supplytestdata() {
		Object [][] data= utilities.gettestdatafromexel("login sheet");
		return data;
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@Test(dataProvider="supplytestdata")
	public void testloginwithvalidcredential(String email, String password) throws InterruptedException {
		
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}
	
	@Test
	public void testloginwithinvalidcredentials() throws InterruptedException {
		
		Thread.sleep(500);
	
		driver.findElement(By.id("input-email")).sendKeys(utilities.emailwithtimestamp());
		Thread.sleep(500);
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidpassword"));
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div[1]")).isDisplayed());
		
	}
	
	@Test
	public void testwithoutaanycredential() throws InterruptedException {
		driver.findElement(By.name("email")).sendKeys("");
		Thread.sleep(500);
		driver.findElement(By.name("password")).sendKeys("");
		Thread.sleep(500);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).isDisplayed(), "didnt show");
		
	}
	
	

	
	

}
