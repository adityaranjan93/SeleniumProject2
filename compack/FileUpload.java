package compack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload 
{
	public static void main(String[] args) throws Exception 
	{
		
		System.out.println("Hello World Adi");	
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/test/upload/");
		//D:\Selenium_Java
		driver.findElement(By.id("uploadfile_0")).sendKeys("D:\\Selenium_Java\\TestFileUpload.txt");
		WebElement chckbox = driver.findElement(By.id("terms"));
		if(chckbox.isEnabled())
			chckbox.click();
		Thread.sleep(5000);
		driver.findElement(By.id("submitbutton")).click();
		Thread.sleep(4000);
		
		driver.quit();
		
		
	}
		
}
