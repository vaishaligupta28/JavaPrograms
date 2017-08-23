/*
Functional Programs: Program 13

@author: Vaishali Gupta(QT8)
*/

import java.util.Scanner;
public class UseStopWatch
{
	static double startTime, stopTime, pauseTime;
	static boolean isTimerStarted = false;
	static boolean isTimerPaused = false;
	public static void main(String args[])throws InterruptedException
	{
		double elapsedTime = 0.0;
		String toContinue= "";
		Scanner sc=new Scanner(System.in);
		
		do{
		System.out.println("Enter your choice:\n1)Press 1 to Start the stopwatch\n2)Press 2 Stop the stopwatch\n3)Press 3 to pause the stopwatch\n4)Press 4 to exit");
		int option= sc.nextInt();

		switch(option)
		{
			case 1:
			if(!isTimerStarted){System.out.println("Starting the timer....."); Thread.sleep(1000); startTimer();//if stopwatch not started, then start the timer;
			    isTimerStarted = true; isTimerPaused= false;} // timer started
			else
				System.out.println("Stopwatch already started.Perform something else!!");
			System.out.println("Do you want to continue?(y/n)");
 	        toContinue = sc.next();
 	        break;
 	        
			case 2:
			if(isTimerStarted){
			   System.out.println("Stopping the timer....."); Thread.sleep(1000); 
			   elapsedTime= elapsedTime + stopTimer();
			   isTimerStarted = false;
			   System.out.println("Total Elapsed Time:"+ elapsedTime);
			}
			else
			{
			   if(elapsedTime>0){
			   	  System.out.println("Stopping the timer....."); Thread.sleep(1000);
			      System.out.println("Total Elapsed Time:"+ elapsedTime);}
			   else
			   	System.out.println("Timer cannot be stopped.First start the timer!!");
			}

			System.out.println("Do you want to continue?(y/n)");
 	        toContinue = sc.next();
			break;

			case 3:
			if(isTimerStarted)
				{
					if(!isTimerPaused){System.out.println("Pausing the timer....."); Thread.sleep(1000);isTimerPaused = true; elapsedTime = elapsedTime + pauseTimer();System.out.println("Stopwatch paused.\nTime elapsed :"+ elapsedTime); isTimerStarted= false;}
					else System.out.println("Timer is already in pause");
				}
			else 
				{System.out.println("First start the stopwatch");}
			System.out.println("Do you want to continue?(y/n)");
 	        toContinue = sc.next();
			break;

			case 4:
			System.out.println("Invalid option");
			System.exit(0);
			break;
 	        
		}
	    }while(toContinue.equalsIgnoreCase("y"));

	}

	static void startTimer()
	{
		startTime = (System.currentTimeMillis())/1000;
		System.out.println("Stopwatch started at "+ startTime);
	}

	static double stopTimer()
	{
		stopTime= (System.currentTimeMillis())/1000;
		double elapsedTime= stopTime- startTime;
		return elapsedTime;
	}
	static double pauseTimer()
	{
		pauseTime= (System.currentTimeMillis())/1000;
		double elapsedTime = (pauseTime- startTime);
		return elapsedTime;
	}
}
