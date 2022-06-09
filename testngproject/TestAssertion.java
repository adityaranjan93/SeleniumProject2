package testngproject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAssertion 
{
	WebDriver driver;
	
	@BeforeMethod
	public void launchGoogleChrome()
	{
		System.out.println("Before:: Set property and launch set up");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test()
	public void validateTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Google");//asserts 2 strings
	}
	
	@Test()
	public void verifyLogo() throws InterruptedException
	{
		System.out.println("Test 4");
		boolean result = driver.findElement(By.id("hplogo")).isDisplayed();
		//Assert.assertFalse(result, "Failing intentionally");
		Assert.assertTrue(result);//assertTrue means expected value is true. assertFalse -> False
		
	}
	
	@AfterMethod
	public void closeDriver()
	{
		driver.quit();
	}
	
	
}
