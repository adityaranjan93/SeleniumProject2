package problemsolving;
import java.util.*;

public class FirstRepeatingElement {

	public static void main(String[] args) 
	{
		//print first repeating element and the index
		int ar[]= {10,8,9,5,8,9,7,4,3,2,1};
		int min=0;
		HashSet<Integer> ob = new HashSet<>();
		for(int i=ar.length-1;i>=0;i--)
		{
			
			if(ob.contains(ar[i]))
				min=i;
			else
				ob.add(ar[i]);
				
		}
		System.out.println("First repeating number is:"+ar[min]+""+"at index"+""+min);
		

	}

}
