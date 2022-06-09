package compack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicXpath {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://in.ebay.com/");
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//a[contains(text(),'Daily Deals')]")).click();//for link
		Thread.sleep(4000);
		WebElement search_holder = driver.findElement(By.xpath("//input[contains(@placeholder,'Search for anything')]"));
		search_holder.sendKeys("Clothes");
		Thread.sleep(1000);
		//search_holder.sendKeys(Keys.ENTER);Thread.sleep(10000);
		driver.findElement(By.xpath("//input[contains(@id,'-btn')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'My eBay')]")).click();
		Thread.sleep(4000);
		if(driver.getTitle().equalsIgnoreCase("Sign in or Register | eBay"))
		  System.out.println("Pass");
		else System.out.println("Fail");
		
		System.out.println("SimplyPrinting");
		
		driver.quit();
		

	}

}
