package compack;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandlerConcept {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Good PopUp #2")).click();
		driver.findElement(By.linkText("Good PopUp #1")).click();
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String parent_window = (String) itr.next();
		while(itr.hasNext())
		{
			String childwindow = itr.next();
			if(!parent_window.equals(childwindow))
			{
				driver.switchTo().window(childwindow);
				System.out.println(driver.getCurrentUrl());
				driver.close();
			}
			else System.out.println("No windows exist");
			
			
		}
		driver.switchTo().window(parent_window);
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(2000);
		driver.quit();
		
		
		

	}

}
