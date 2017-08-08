/*
Functional Programs: Program 6

@author: Vaishali Gupta(QT8)
*/

import java.util.Scanner;
class PrimeFactorsOfN
{
	int c=0;
	public static void main(String args[])
	{
		System.out.println("Enter a number");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("Prime factors are: ");
		primeFactors(N);
	}
	static void primeFactors(int x)
	{		
		//for eliminating even numbers
		while(x%2==0)
		{				
			System.out.println(2);																												
			x=x/2;  
		}

		for(int i=3;i<=Math.sqrt(x);i++)//ask about it
		{
			while(x%i==0)
			{
				System.out.println(i);

			}
		}
		if(x>2)
			System.out.println(x);
	}
}