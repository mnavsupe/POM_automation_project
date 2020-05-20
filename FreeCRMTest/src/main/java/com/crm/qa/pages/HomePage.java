package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtils;

public class HomePage extends TestBase{
	
	TestUtils ts= new TestUtils();
	
	@FindBy(xpath="//table//tr//td[contains(text(),\"User: Demo User\")]")
	WebElement userNameLabel;
	
	
	@FindBy(xpath="//ul//a[@title=\"Contacts\"]")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//a[@title=\"Deals\"]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[@title=\"Tasks\"]")
	WebElement TaskLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newcontacts;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();

	}
	
	
	public boolean VerifyUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink()
	{
		
		ts.switchToFrame();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		TaskLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContacts()
	{
		Actions action = new Actions(driver);
		//ts.switchToFrame();
		action.moveToElement(contactsLink).build().perform();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='New Contact']")));
		newcontacts.click();
	}

}
