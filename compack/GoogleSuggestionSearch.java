package compack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSuggestionSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//input[contains(@title,'Search')]")).sendKeys("testin");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("testin");
		
		List<WebElement> element = driver.findElements(By.xpath("//ul[@role='listbox')]//li/descendant::div[@class='sbl1']"));
		System.out.println("Number of suggestions="+element.size());
		for(int i=0; i<element.size(); i++)
		{
			System.out.println(element.get(i));
		}
		Thread.sleep(10000);
		driver.quit();

	}

}
