package compack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecHandler {

	public static void main(String[] args)throws Exception 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("https://google.com/");
		driver.get("https://www.guru99.com/execute-javascript-selenium-webdriver.html");
		
		
		/*
		 * WebElement loginbutton =
		 * driver.findElement(By.xpath("//span[contains(text(),'Log In')]")); WebElement
		 * gmailLink = driver.findElement(By.linkText("Gmail")); WebElement ImageLink =
		 * driver.findElement(By.linkText("Images")); String color =
		 * loginbutton.getCssValue("Color"); String colorcode="rgb(0,200,0)";
		 *
		 */
	//	WebElement view = driver.findElement(By.xpath("//strong[contains(@text,'Report a Bug')]"));
		JavascriptExecutor jsob = (JavascriptExecutor)driver;
		jsob.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		jsob.executeScript("history.go(0)");
		//.sleep(4000);
		//jsob.executeScript("arguments[0].scrollIntoView(true);", view);
		jsob.executeScript("history.go(0)");
		Thread.sleep(4000);
		jsob.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		/*
		 * jsob.executeScript("arguments[0].style.backgroundColor='"+colorcode+"'",
		 * gmailLink); jsob.executeScript("alert('Hello ADI')"); Alert alert =
		 * driver.switchTo().alert(); alert.accept(); Thread.sleep(3000);
		 * jsob.executeScript("arguments[0].style.border= '5px solid red'", ImageLink);
		 * 
		 * 
		 * 
		 * System.out.println(driver.getCurrentUrl()); Thread.sleep(4000);
		 * jsob.executeScript("history.go(0)");//refresh browser using javascript :
		 * another way was using navigate().refresh Thread.sleep(2000); String title =
		 * jsob.executeScript("return document.title").toString();//get title by js
		 * System.out.println(title); String innerText =
		 * jsob.executeScript("return document.documentElement.innerText;").toString();/
		 * /similar to getPageSource System.out.println(innerText);
		 */
		driver.quit();

	}

}
