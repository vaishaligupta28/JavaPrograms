import java.util.Scanner;
class UseStopWatch
{
	static double startTime, stopTime;
	public static void main(String args[])
	{
		double elapsedTime;
		String toContinue= "";
		Scanner sc=new Scanner(System.in);
		
		do{
		System.out.println("Enter your choice:\n1)Press 1 to Start the stopwatch\n2)Press 2 Stop the stopwatch\n3)Press 3 to exit");
		int option= sc.nextInt();

		switch(option)
		{
			case 1:
			startTimer();
			System.out.println("Do you want to continue?(y/n)");
 	        toContinue = sc.next();
 	        break;
 	        
			case 2:
			elapsedTime= stopTimer();
			System.out.println("Total Elapsed Time:"+ elapsedTime);
			System.out.println("Do you want to continue?(y/n)");
 	        toContinue = sc.next();
			break;

			case 3:
			System.out.println("Invalid option");
			System.exit(0);
			break;
 	        
		}
	    }while(toContinue.equalsIgnoreCase("y"));

	}

	static void startTimer()
	{
		startTime = (System.currentTimeMillis())/1000;
		System.out.println("Stopwatch started: "+ startTime);
	}

	static double stopTimer()
	{
		stopTime= (System.currentTimeMillis())/1000;
		double elapsedTime= stopTime- startTime;
		return elapsedTime;
	}
}
