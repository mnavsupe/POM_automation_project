package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase{
	
	LoginPage lp;
	HomePage hp;
	TestUtils tu;
	ContactsPage cp;
	
	public ContactsPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		lp= new LoginPage();
		hp = new HomePage();
		cp=new ContactsPage();
		tu = new TestUtils();
		hp=lp.login(prop.getProperty("username"),prop.getProperty("password"));
	
		cp=hp.clickOnContactsLink();
	}
	
	
	

	@Test(priority=2)
	public void verifyAlertsPage()
	{
		
		Assert.assertEquals(true, cp.VerifyAlertsPresent());
	}

	@Test(priority=3)
	public void verifyMessagePage()
	{
		
		Assert.assertEquals(true, cp.VerifyMessagesPresent());
	}

	@Test(priority=1)
	public void verifyProductsPage()
	{
		
		Assert.assertEquals(true, cp.VerifyProductsPresent());
	}
	
	@Test(priority=4)
	public void validateCreateNewContacts()
	{
		
		hp.clickOnNewContacts();
		cp.createNewContact("Mr.", "mayur", "test", "google");
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
