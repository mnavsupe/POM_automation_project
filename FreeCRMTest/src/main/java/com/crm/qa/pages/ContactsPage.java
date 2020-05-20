package com.crm.qa.pages;

import org.apache.xmlbeans.impl.jam.xml.TunnelledException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtils;

public class ContactsPage extends TestBase{
	
	
	
	
	@FindBy(xpath="//tr//td[contains(text(),\"Company\") and @valign=\"middle\"]")
	WebElement comapnyLabel;
	
	@FindBy(xpath="//a[@title=\"Alerts\"]")
	WebElement alerts;
	
	@FindBy(xpath="//a[@title=\"Messages\"]")
	WebElement Messages;
	
	@FindBy(xpath="//a[@title=\"Products\"]")
	WebElement Products;
	
	
	
	
	////new contact page factory
	
	@FindBy(name="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	
	
	@FindBy(xpath="//form[@name=\"contactForm\"]//input[@type=\"submit\"and @value=\"Save\" and @class=\"button\"]")
	WebElement saveBtn;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void EnterCompany(String company)
	{
		comapnyLabel.clear();
		comapnyLabel.sendKeys(company);
	}
	
	public boolean VerifyComapanyPresent()
	{
		
		return comapnyLabel.isDisplayed();
	}

	public boolean VerifyAlertsPresent()
	{
		
		return alerts.isDisplayed();
	}

	public boolean VerifyMessagesPresent()
	{
		
		return Messages.isDisplayed();
	}
	
	public boolean VerifyProductsPresent()
	{
		
		return Products.isDisplayed();
	}

	
	public void createNewContact(String title,String fname,String lname,String cname)
	{
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//select[@name='title']")));
		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
		select.selectByVisibleText(title);
		
		first_name.sendKeys(fname);
	    surname.sendKeys(lname);
	    company.sendKeys(cname);
	   saveBtn.click();
	}
	
	
}
