/*
Functional Programs: Program 7

@author: Vaishali Gupta(QT8)
*/

import java.util.Scanner;
class GamblerGame
{
	public static void main(String args[])
	{
		int wins=0, loss=0, bets=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the inital cash:");
		int cash= sc.nextInt();
		System.out.println("Enter the amount to stake:");
		int stake= sc.nextInt();
		System.out.println("Enter the amount to goal:");
		int goal= sc.nextInt();
		System.out.println("Enter the number of times he can play: ");
		int numOfTimes= sc.nextInt();

		for(int i=1;i<=numOfTimes;i++)
		{
			while(cash>=stake && cash<goal)
			{
				bets++;
			    double rand= Math.random();
			    if(rand<0.5)
			    {
				   cash+=stake;
				   wins++;
			    }
			    else
			    {
				   cash-=stake;
				   loss++;
			    }
		    }
		    if(cash==goal || cash==0)
		    	break;
        }
        System.out.println("Total bets: "+ bets);
        System.out.println("Total wins: "+ wins);
        System.out.println("Total losses: "+ loss);
	}
}