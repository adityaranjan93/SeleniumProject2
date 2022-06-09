package testngproject;

import org.testng.annotations.Test;

public class ExpectedExceptionTest 
{
	/*
	 * here we know that exception will occur but yet we want our test to pass.
	 * Thus we use expectedExceptions keyword and tell test ng that this is the
	 * exception that we are expecting. TestNG will pass this test case. This is
	 * how we handle exception without try catch.
	 * If we don't provide this test case will fail
	 */	
	@Test(expectedExceptions = ArithmeticException.class)
	public void invalidTest()
	{
		int a=5;
		System.out.println(a/0);
	}
}
