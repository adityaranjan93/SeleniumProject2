package compack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		//driver.switchTo().frame(0);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		//Thread.sleep(4000);
		WebElement draggable_ob = driver.findElement(By.id("draggable"));
		WebElement droppable_ob = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		System.out.println("Enters into frame");
		/*
		 * action.moveToElement(draggable_ob).build().perform(); Thread.sleep(2000);
		 * action.dragAndDrop(draggable_ob,
		 * driver.findElement(By.id("droppable"))).build().perform(); alternate wayusing
		 * click and hold
		 * 
		 * action.clickAndHold(draggable_ob).build().perform(); Thread.sleep(2000);
		 * action.moveToElement(driver.findElement(By.id("droppable"))).build().perform(
		 * ); OR all in one
		 */
		action.clickAndHold(draggable_ob).moveToElement(droppable_ob).release().build().perform();
		

	  Thread.sleep(4000);
		driver.switchTo().parentFrame();
		//WebElement searchbar = driver.findElement(By.xpath("//input[contains(@name, 's')]"));
		WebElement searchbar = driver.findElement(By.xpath("//input[starts-with(@name, 's')]"));//can use ends-with also

		searchbar.sendKeys("Java");
		Thread.sleep(2000);
		searchbar.sendKeys(Keys.ENTER);
		
		Thread.sleep(5000);
		System.out.println("Task completed");
	
		/*
		 * Thread.sleep(2000); driver.findElement(By.linkText("Demos")).click();
		 */
		driver.quit();

	}

}
