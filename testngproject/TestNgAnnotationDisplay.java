package testngproject;

/*import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;*/

import org.testng.annotations.*;

public class TestNgAnnotationDisplay 
{
	@BeforeSuite
	public void setup()
	{
		System.out.println("SetUp - 1");
	}
	
	@BeforeTest
	public void launch_browser()
	{
		System.out.println("order - 2");
	}
	@BeforeClass
	public void get_url()
	{
		System.out.println("order - 3");
	}
	
	@BeforeMethod
	public void launchapp()
	{
		System.out.println("order - 4");
	}
	
	@Test
	public void display_title()
	{
		System.out.println("Test one");
	}
	
	@Test
	public void display_links()
	{
		System.out.println("Test two");
	}
	
	@Test
	public void display_images()
	{
		System.out.println("Test three");
	}
	
	@Test
	public void display_buttons()
	{
		System.out.println("Test four");
	}
	
	
	
	@AfterMethod
	public void closeapp()
	{
		System.out.println("order- 5");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("order- 6");
	}
	@AfterTest
	public void deleteCookies()
	{
		System.out.println("order- 7");
	}
	

}
