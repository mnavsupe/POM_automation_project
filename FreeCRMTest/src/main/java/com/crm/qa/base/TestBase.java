package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;
	public TestBase()
	{
		
		prop = new Properties();
//		File src = new File("./Configurations/config.properties");
		FileInputStream ip;
		try {
			//System.out.println(System.getProperty("user.dir"));
			ip = new FileInputStream("D:\\Study\\selenium\\udemy\\workspace\\NaveenFrameworkDemo\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(ip);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void initialization()
	{
		String browsername=prop.getProperty("browser");
		
		if (browsername.equals("chrome")) {
			System.out.println((System.getProperty("user.dir"))+"\\driver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir"))+"\\driver\\chromedriver.exe");
			driver= new ChromeDriver();
			wait= new WebDriverWait(driver, 30);
		}
		else if (browsername.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Installer\\selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.time_out, TimeUnit.SECONDS);
		
		//System.out.println(driver.capabilities['version']);
		driver.get(prop.getProperty("url"));
	}
	
}
