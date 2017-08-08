package testutilityfunctions;
import java.util.*;
import utility.UtilityClass;
/*
To Test the Utility Functions
*/

class TestUtilityFunctions
{
	public static void main(String args[])
	{
		int k=0;
        int elapTime, index;
        int integerSortedArray[] = null;
        String stringSortedArray[] = null;
        int elapsedTimeArray[]= new int[6];
        int newElapsedArray[]= null;
	    Scanner sc = new Scanner(System.in);

	    System.out.print("Enter the size of the integer array:  ");
        int size1 = sc.nextInt();
        int integerArray[] = new int[size1];
        System.out.println("Enter the elements of the integer array: ");
        for(int i=0 ;i<size1;i++)
        	integerArray[i]=sc.nextInt();

        System.out.print("Enter the size of the string array:  ");
        int size2 = sc.nextInt();
        String stringArray[] = new String[size2];
        System.out.println("Enter the elements of the string array: ");
        for(int i=0 ;i<size2;i++)
        	stringArray[i]=sc.next();


	    while(true)
	    {
	    System.out.println("\n\nEnter your option:   \n\n>Press 1 to perform binary search on integer.\n>Press 2 to perform binary search on strings\n>Press 3 to perform insertion sort on integers.\n>Press 4 to perform insertion sort on strings\n>Press 5 to perform bubble sort on integers\n>Press 6 to perform bubble sort on strings\n>Press 7 for dispalying Elapsed time in decreasing order\n>Press any other number to exit.");
        int option = sc.nextInt();

        switch(option)
        {
        	case 1:
        	System.out.println("***********Binary Search For Integers***********\n");
        	System.out.println("Enter the element whose index is to be found");
        	int elem = sc.nextInt();
        	integerSortedArray = UtilityClass.doBubbleSort(integerArray);
        	UtilityClass.startTimer();
        	index = UtilityClass.doBinarySearch(integerSortedArray, elem);
        	elapTime = UtilityClass.stopTimer();
        	elapsedTimeArray[k++] =  elapTime;
        	if(index != -1)
        	    System.out.println("Element " + elem + " found at: " + index +"th position using binary search in time : " + elapTime + " nanoseconds");
        	else
        		System.out.println("Element not found but time spent: "+ elapTime + "microseconds");
        	break;

        	case 2:
        	System.out.println("***********Binary Search for Strings************\n");
        	System.out.println("Enter the string whose index is to be found");
        	String str = sc.next();
        	stringSortedArray = UtilityClass.doBubbleSort(stringArray);
        	UtilityClass.startTimer();
        	index = UtilityClass.doBinarySearch(stringSortedArray, str);
        	elapTime = UtilityClass.stopTimer();
        	elapsedTimeArray[k++] =  elapTime;
        	if(index != -1)
        	    System.out.println("String " + str + " found at: " + index +"th position using binary search in time : " + elapTime + " nanoseconds");
        	else
        		System.out.println("String not found but time spent: "+ elapTime + "microseconds");
        	break;

        	case 3:
        	System.out.println("********** Sorting using Insertion Sort(Integers)********");
        	UtilityClass.startTimer();
        	integerSortedArray = UtilityClass.doInsertionSort(integerArray);
        	elapTime = UtilityClass.stopTimer();
        	elapsedTimeArray[k++]= elapTime;
        	UtilityClass.display(integerSortedArray);
        	System.out.println("\nTime spent: "+ elapTime + "nanoseconds");
        	break;

        	case 4:
        	System.out.println("********** Sorting using Insertion Sort(Strings)********");
        	UtilityClass.startTimer();
        	stringSortedArray = UtilityClass.doInsertionSort(stringArray);
        	elapTime = UtilityClass.stopTimer();
        	elapsedTimeArray[k++]= elapTime;
        	UtilityClass.display(stringSortedArray);
        	System.out.println("\nTime spent: "+ elapTime);
        	break;

        	case 5:
        	System.out.println("********** Sorting using Bubble Sort(Integers)********");
        	UtilityClass.startTimer();
        	integerSortedArray = UtilityClass.doBubbleSort(integerArray);
        	elapTime = UtilityClass.stopTimer();
        	elapsedTimeArray[k++]= elapTime;
        	UtilityClass.display(integerSortedArray);
        	System.out.println("\nTime spent: "+ elapTime + "nanoseconds");
        	break;

        	case 6:
        	System.out.println("********** Sorting using Bubble Sort(Strings)********");
        	UtilityClass.startTimer();
        	stringSortedArray = UtilityClass.doBubbleSort(stringArray);
        	elapTime = UtilityClass.stopTimer();
        	elapsedTimeArray[k++]= elapTime;
        	UtilityClass.display(stringSortedArray);
        	System.out.println("\nTime spent: "+ elapTime + "nanoseconds");
        	break;

        	case 7:
        	newElapsedArray= UtilityClass.doBubbleSort(elapsedTimeArray);
        	System.out.print("Elapsed Time Array:  ");
            for(int i= 5;i>=0;i--)
            	System.out.print(newElapsedArray[i] + "   ");
        	break;

        	default:
        	System.exit(0);
        	break;
        	}

	   	}

    }
}

