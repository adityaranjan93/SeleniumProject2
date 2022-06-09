package problemsolving;
import java.lang.Math;
import java.util.Scanner;
import java.io.*;

public class ClosestPallendrome 
{ 
	static int rev=0;
	static int rem;
	public static boolean isPallen(int n)
	{
		int orig = n;
		while(n>0)
		{
			rem= n%10;
			rev = (rev*10)+rem;
			n=n/10;
		}
		if(orig==rev)
			return true;
		else 
			return false;
	}
	
	public static void closestPallen(int num)
	{
		int lhigh = num - 1;
		while(!(isPallen(lhigh)))
			lhigh--;
		
		int hLow = num+1;
		while(!(isPallen(hLow)))
			hLow++;
		
		if(Math.abs(num-lhigh) > Math.abs(num-hLow))
			System.out.println("Closest pallen : " + hLow);
		else if(Math.abs(num-lhigh) < Math.abs(num-hLow))
			System.out.println("Closest pallen : " + lhigh);
		else 
			System.out.println("number 1:"+lhigh +" "+"number 2:"+ hLow);
		
	}

	public static void main(String[] args) 
	{
		System.out.println("enter a valid pallendrome no");
		Scanner sob = new Scanner(System.in);
		int n = sob.nextInt();
		closestPallen(n);
		

	}

}
