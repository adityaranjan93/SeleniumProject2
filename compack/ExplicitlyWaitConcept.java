package compack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class ExplicitlyWaitConcept {

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[contains(text(), 'Log In')]")).click();
		
		WebElement loginele = driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
		//clickon(driver, loginele, 20);
		impFluentwait(driver, 10, 4,loginele);
		Thread.sleep(3000);
		driver.quit();
		
	}
	public static void clickon(WebDriver driver, WebElement locator, int timeout)
	{
		System.out.println("Enter this method");
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}
	public static void impFluentwait(WebDriver driver, int timeout, int polling, WebElement locator)
	{
		 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS).pollingEvery(4, TimeUnit.SECONDS).ignoring(ElementNotFoundException.class);
		 wait.until(ExpectedConditions.elementToBeClickable(locator));
		 
	}

}
