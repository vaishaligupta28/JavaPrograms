/*
Algorithm Programs: Program 5

@author : Vaishali Gupta(QT8)
*/
import java.util.Scanner;
class GuessNumber
{
	static int count = 0;


	public static void main(String args[])throws InterruptedException
	{
		int n = Integer.parseInt(args[0]);
		int low = 0;
		int high = (int)((Math.pow(2, n)) - 1);
		Scanner sc = new Scanner(System.in);
		System.out.println("Think the number you want to be searched\n\n");
		Thread.sleep(5000);

		boolean flag = true;
		if(sc.nextBoolean())
		{
			System.out.println("Does number lie b/w ["+ low + "-" + high +"] ?" );
			int number = search(low, high);
			if(number == -1)
				System.out.println("Sorry!!!Number not present.");
			if(count==n)
				{System.out.println("Number found is "+ number+ " after "+ count + " chances!!!!!");}
	    	}
	    else
	    	System.out.println("Sorry!!!Number not present.");
		


	}
	static int search(int first, int last)
	{	
		Scanner sc = new Scanner(System.in);
		int mid = first + (last - first)/2;
		if(first < last)
		{
		   	  //if(first == mid)
		   	       //{return first;}
		     // if(last == mid)
		           //{return last;}
		    System.out.println("Does number lie b/w ["+ first + "-" + mid +"] ?" );
		    if(sc.nextBoolean()){count++; return search(first, mid);}
	        else{
	               System.out.println("Does number lie b/w ["+ (mid + 1) + "-" + last +"] ?" );
	               if(sc.nextBoolean()){count++;return search(mid+1, last);}
	               else{ return -1;}
	              }
	    }
	    else if(first == last)
	    return first;

	   return -1;
	} 
}
