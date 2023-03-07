package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	@FindBy(id="input-email")
	WebElement emailaddressfield;
	@FindBy(id="input-password")
	WebElement passwordfield;
	@FindBy(xpath="//*[@id=\\\"content\\\"]/div/div[2]/div/form/input")
	WebElement loginbutton;

	public loginpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enteremailaddress() {
		emailaddressfield.sendKeys();
	}
	
}
