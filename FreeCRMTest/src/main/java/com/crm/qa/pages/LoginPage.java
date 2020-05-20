package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//PageFactory object repo OR
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	//Initialization of page objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLoginPageTitle()
	{
		
		return driver.getTitle();
	}
	
	public boolean validataCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pd)
	{
		username.sendKeys(un);
		password.sendKeys(pd);
		loginBtn.click();
		
		return new HomePage();
	}
}
