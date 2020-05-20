package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;

public class HomePageTest extends TestBase{

	LoginPage lptest;
	HomePage homepage;
	TestUtils testutil;
	ContactsPage ContactsPage;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		testutil= new TestUtils();
		lptest = new LoginPage();
		ContactsPage=new ContactsPage();
		homepage=lptest.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitle()
	{
		String title=homepage.verifyHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CRMPRO","Title is not correct");
	}

	
	@Test(priority=2)
	public void verifyHomePageUserNameTest()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.VerifyUserName());
		
	}

	
	@Test(priority=3)
	public void verifyContactsLinkTest()
	{
		//testutil.switchToFrame();
		ContactsPage=homepage.clickOnContactsLink();
		
	}

	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
