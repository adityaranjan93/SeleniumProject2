package testngproject;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class FacebookLogin 
{
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void launchChrome(String browser)
	{
		if(browser.equals("chrome"))
		{
			System.out.println("Before:: Set property and launch set up");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			//driver.get("https://www.google.com");
		}
		else
			System.out.println("Invalid browser");
	}
	
	@Test(groups="FacebookLogin")
	@Parameters({"url","username","password"})
	public void facebookLogin(String url, String username, String password) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(5000);
		//Assert.assertEquals(driver.getTitle(), "Facebook");
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(2000);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("loginbutton")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//textarea[contains(@title,'Write something here...')]")).sendKeys("<parameter name:url value:testScript/>PostRequest--AutoXMLParsing");
		Thread.sleep(9000);
		//driver.finElement(By.xpath("//textarea[contains(@title,'Write something here...')]")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}
