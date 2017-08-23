/*
Functional Programs: Program 8

@author: Vaishali Gupta(QT8)
*/

import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
public class DistinctCouponNumbers
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the range in which coupon numbers are required\n");
		System.out.print("a:");
		int min=sc.nextInt();
		System.out.print("b:");
		int max=sc.nextInt();
		System.out.println("Enter the size of array of distinct coupons");
		int size= sc.nextInt();
		int distinctCoupons[]= new int[size];
		System.out.println("Total random numbers generates: "+ checkDistinct(distinctCoupons, size, min, max));
		System.out.println("The distinct coupons are: ");
		for(int i=0;i<distinctCoupons.length;i++)
			{System.out.println(distinctCoupons[i]);}
	}
	
	static int getRandom(int min, int max){
	int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
	return randomNum;
	}

	static int checkDistinct(int arr[], int size, int min, int max)
	{
		int i=0,c=0;
		do
		{
		    int rand = getRandom(min, max);
		    c++;
			for(int j=0;j<i;j++)
			{
				if(rand==arr[j])
				{
					rand= getRandom(min, max);
					c++;
				}
				else
				{
					arr[i]= rand;
				}
			}
			arr[i]=rand;
			i++;
		}while(i<size);
		return c;
	}
}
