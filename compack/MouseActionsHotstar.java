package compack;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActionsHotstar {

	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.hotstar.com");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("Movies"))).build().perform();//build().perform() helps action object to perform the task
		Thread.sleep(5000);
		driver.findElement(By.linkText("Telugu")).click();
		
		driver.quit();
		

	}

}
