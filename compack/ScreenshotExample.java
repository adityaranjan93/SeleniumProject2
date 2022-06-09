package compack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotExample {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		Thread.sleep(5000);
		
		TakesScreenshot src = (TakesScreenshot)driver;
		File srcfile = src.getScreenshotAs(OutputType.FILE);
		File destfile = new File("D:\\Selenium_Workspace\\SeleniumProject2\\screen1.png");
		FileUtils.copyFile(srcfile, destfile);
		
		Thread.sleep(2000);
		driver.quit();

	}

}
