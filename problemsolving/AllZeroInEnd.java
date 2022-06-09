package problemsolving;

import java.util.Stack;

public class AllZeroInEnd {

	public static void main(String[] args) 
	{
		int ar[] = {1,9,8,4,0,0,2,7,0,6,0};
		
		for(int itr1 : ar)
			System.out.println("Input: ="+itr1);
		
		int ar_len = ar.length;
		Stack<Integer> obj = new Stack<Integer>();
		
		for(int i= ar_len - 1; i>=0; i--)
		{
			if(ar[i]!=0)
				obj.push(ar[i]);
		}
		int stack_size = obj.size();
		for(int j=0; j<stack_size; j++)
		{
			ar[j]=obj.pop();
		}
		for(int k=stack_size; k<ar_len; k++)
		{
			ar[k]=0;
		}
		
		for(int itr = 0; itr<ar_len; itr++)
			System.out.print(ar[itr]+",");

	}

}
