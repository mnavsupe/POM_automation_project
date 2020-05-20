package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtils extends TestBase{

	public static long time_out=60;
	
	
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
		
	}
}
