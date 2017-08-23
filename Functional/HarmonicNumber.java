/*
Functional Programs: Program 5

@author: Vaishali Gupta(QT8)
*/

import java.util.Scanner;
public class HarmonicNumber
{
	public static void main(String args[])
	{
		float sum =0.0f;
		int N;
		do{
			System.out.println("Enter a harmonic value");
		    Scanner sc= new Scanner(System.in);
		    N= sc.nextInt();
		    if(N!=0)
		    {
		    	for(int i=1;i<=N;i++)
		    	{
		    		sum= sum+ (i/(float)N);
		    	}
		    	System.out.println("Sum of harmonic series: " + sum);
		    }
		    else
		    	System.out.println("Number entered should not be equal to zero.");
		}while(N==0);
	}
}
