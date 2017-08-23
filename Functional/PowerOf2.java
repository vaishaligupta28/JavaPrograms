/*
Functional Programs: Program 4

@author: Vaishali Gupta(QT8)
*/

public class PowerOf2
{
	public static void main(String args[])
	{
		int N = Integer.parseInt(args[0]);
		int i=0;
		if(N>=1 && N<31)
		{
			int limit=(int)Math.pow(2,N);
			while(Math.pow(2,i)<=limit)
			{
				System.out.println("2 ^ "+i+ " = "+ (int)Math.pow(2,i++));
			}
		}
	    else
	    	System.out.println("Wrong input");
	}
}
