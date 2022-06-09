package compack;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumPractice 
{
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello World Adi");
		
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * "D:\\Selenium_Java\\geckodriver\\geckodriver.exe"); WebDriver driver = new
		 * FirefoxDriver(); driver.manage().window().maximize();
		 */		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
	    driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	    WebElement username =  driver.findElement(By.id("login1"));
	    username.sendKeys("adi");
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		String alert_text = alert.getText();
		System.out.println(alert_text);
		if(alert_text.equalsIgnoreCase("Please enter your password"))
			alert.accept();
		else 
			System.out.println("Look somewhere else");
		
		
		driver.quit();

	}
}
