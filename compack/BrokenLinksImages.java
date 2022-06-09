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

public class BrokenLinksImages {

	public static void main(String[] args) throws MalformedURLException, IOException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Java\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://freecrm.com/");
		
		//1. Get list of all links and images in one list
		List<WebElement> allList = driver.findElements(By.tagName("a"));
		allList.addAll(driver.findElements(By.tagName("img")));
		System.out.println("All links");
		
		List<WebElement> activeList = new ArrayList<WebElement>();
		//2. find all active links in allList.
		for(int i=0;i<allList.size();i++)
		{
			System.out.println(allList.get(i));
			if(allList.get(i).getAttribute("href")!=null && (!(allList.get(i).getAttribute("href").contains("javascript"))))
					{
						activeList.add(allList.get(i));
					}
		}
		
		//3.CHeck with http url connection
		for(int j=0; j<activeList.size(); j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activeList.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println("Response for::"+j+activeList.get(j).getAttribute("href")+"-->"+response);
		}

	}

}
