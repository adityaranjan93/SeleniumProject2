package compack;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenImagesLinks2 {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium_Java\\\\chromedriver\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		allLinks.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total Links = "+allLinks.size());
		
		List<WebElement> activeLink = new ArrayList<WebElement>();
		for(int i=0; i<allLinks.size(); i++)
		{
			if(allLinks.get(i).getAttribute("href")!=null && !(allLinks.get(i).getAttribute("href").contains("javascript")))
					{
						activeLink.add(allLinks.get(i));
					}
		}
		System.out.println("Active Links ="+activeLink.size());
		
		for(int j=0; j<activeLink.size();j++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLink.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			System.out.println(activeLink.get(j)+"---->"+response);
			connection.disconnect();
		}
		
		
		

	}

}
