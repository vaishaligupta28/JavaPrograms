/*
Algorithm Programs: Program 10

@author: Vaishali Gupta(QT8)
*/
import java.util.Scanner;
class prog10
{
	public static void main(String args[])
	{
		int noOfNotes, noOfCoins, coinsLeft;
		System.out.println("Enter the amount you want to enchash!!!!");
		Scanner sc = new Scanner(System.in);
		int cash = sc.nextInt();

		System.out.println("The notes enchashed are: ");
		while(cash > 0)
		{
			if(cash >= 1000)
			{
				noOfNotes = cash / 1000;
				cash = cash % 1000;
				System.out.println("1000 Rs notes: " + noOfNotes);
			}
			else if(cash >= 500 && cash < 1000)
			{
				noOfNotes = cash / 500;
				cash = cash % 500;
				System.out.println("500 Rs notes: "+ noOfNotes);
			}
			else if(cash >=100 && cash <500)
			{
				noOfNotes = cash / 100;
				cash = cash % 100;
				System.out.println("100 Rs notes: "+ noOfNotes);
			}
			else if(cash >=50 && cash < 100)
			{
				noOfNotes = cash / 50;
				cash = cash % 50;
				System.out.println("50 Rs notes: "+ noOfNotes);
			}
			else if(cash >=10 && cash < 50)
			{
				noOfNotes = cash / 10;
				cash = cash % 10;
				System.out.println("10 Rs notes: "+ noOfNotes);
			}
			else if(cash >=2 && cash < 10)
			{
				noOfCoins = cash / 2;
				cash = cash % 2;
				System.out.println("2 Rs Coins: "+ noOfCoins);
			}
			else
			{
				cash = 0;
				System.out.println("1 Rs Coins: "+ 1);
			}
		}
	}
}
