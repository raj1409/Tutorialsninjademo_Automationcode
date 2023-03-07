package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	//objects
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[1]") 
    private WebElement myaccountdropmenu;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	public Homepage(WebDriver driver) {
		this.driver=driver; 
		PageFactory.initElements(driver,this);
	}
	
	//actions
	public void clickonmyaccount() {
		myaccountdropmenu.click();
	}
	public void selectloginoption() {
		loginoption.click();
	}
}
