/*
Functional Programs: Program 2

@author: Vaishali Gupta(QT8)
*/


import java.util.Scanner;
class FlipCoin
{
	public static void main(String args[])
	{
		double rand;
		int tails=0, heads=0, num;
		
	try{
		do{
			System.out.println("Enter the number of times to flip a coin: ");
		    Scanner sc= new Scanner(System.in);
		    num= sc.nextInt();
			if(num>=0)
			{
				for(int i=1;i<=num;i++)
				{
					rand= Math.random();
					if(rand<0.5)
					{
						tails++;
					}
					else
						heads++;
				}
			}
			else
				System.out.println("Entered number not positive!!");
		}while(num<0);
		double percentage=  (double)((heads *100.0)/tails);
		System.out.println("Percentage of heads v/s tails : "+ percentage);
	}
	catch(ArithmeticException e)
	{
		System.out.println("Either heads or tails or both are zero");
	}
	}
}