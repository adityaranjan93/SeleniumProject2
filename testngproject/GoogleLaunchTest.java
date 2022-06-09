package testngproject;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class GoogleLaunchTest 
{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.out.println("Before:: Set property and launch set up");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
	}
	
	@Test(priority=1, groups="HomePage")
	public void verifyTitle() throws InterruptedException
	{
		System.out.println("Test 1");
		if(driver.getTitle().equalsIgnoreCase("Google"))
			System.out.println("Pass");
	}
	@Test(priority=2, groups="HomePage")
	public void clickgmaillink() throws InterruptedException
	{
		System.out.println("Test 2");
		driver.findElement(By.linkText("Gmail")).click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=3, groups="Search Page")
	public void entertextinsearch() throws InterruptedException
	{
		System.out.println("Test 3");
		WebElement searchBar  = driver.findElement(By.xpath("//input[contains(@title, 'Search')]"));
		searchBar.sendKeys("wiki search");
		Thread.sleep(2000);
		searchBar.sendKeys(Keys.ENTER);
	}
	
	@Test(priority=4, groups="Search Page")
	public void verifyLogo() throws InterruptedException
	{
		System.out.println("Test 4");
		boolean result = driver.findElement(By.id("hplogo")).isDisplayed();
		if(result == true)
			System.out.println("Google logo is present");
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods="verifyLogo")//dependency of this test case on above test case - test 4
	public void printLogoName()
	{
		System.out.println("GOOGLE");
	}
	
	@AfterMethod
	public void closeBrowser() throws InterruptedException
	{
		System.out.println("After method");
		driver.quit();
	}
}
