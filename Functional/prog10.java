/*
Functional Programs: Program 10

@author: Vaishali Gupta(QT8)
*/

import java.util.*;  
class SumOfIntegersAdding2Zero
{
	public static void main(String args[])
	{		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the total integers: ");
		int N= sc.nextInt();
		int arr[]= new int[N];

		System.out.println("Enter elements:");
		for(int i=0;i<N;i++)
		{
			arr[i]=sc.nextInt();
		}						
		System.out.println("Total distinct elements whose sum is zero: "+ findDistinctTripletsToZero(arr, N));			
	}

	static boolean sumToZero(int a, int b, int c)
	{
		if((a+b+c)==0)
			return true;
		else
			return false;
	}
	
	static int findDistinctTripletsToZero(int arr[], int N)
	{
		int c=0, i=0, j=0, k=0;
		Arrays.sort(arr);//sorted the array
		for (i=0;i<N-2;i++)
	    { 
			if(i==0||arr[i]>arr[i-1])
			{
			j=i+1;
			k=N-1;
			while(j<k)
			{
				if(arr[i]+arr[j]+arr[k]==0)
				{
					System.out.println("The distinct elements are " + arr[i] +" " + arr[j] + " " + arr[k]);//print
					c++;
					j++;
					k--;
					while(j<k && arr[j]==arr[j-1])
					j++;
					while(j<k && arr[k]==arr[k+1])
					k--;
				}
				else if(arr[i]+arr[j]+arr[k]<0)
					j++;
				else if(arr[i]+arr[j]+arr[k]>0)
					k--;
			    }
		   }
	   }
	   return c;		
	}
}