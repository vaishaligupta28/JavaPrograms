package utility;
import java.util.*;
/*
Needs to be public and final so that other classes may be able to use it but not override its methods.
*/
public final class UtilityClass
{
	/*
	A private constructor prevents the creation of object of the utility class
	*/
	private UtilityClass()
	{}

	/*1. Anagram Program
	*/
	public static boolean anagramCheck(String str1, String str2)
	{
		if(str1.length() == str2.length())
		{
		char[] stringToChar1= str1.toCharArray();
		char[] stringToChar2= str2.toCharArray();
		Arrays.sort(stringToChar1);
		Arrays.sort(stringToChar2);
		String sortedString1 = new String(stringToChar1);
		String sortedString2 = new String(stringToChar2);
		if(sortedString1.equalsIgnoreCase(sortedString2))
			return true;
		else
			return false;
	    }
	    else
	    	return false;
	} 

	//2.
	public static ArrayList<String> primeNumbers(int x, int y)
	{
		ArrayList<String> li = new ArrayList<String>();
		int k=0;
		for(int i=x;i<=y;i++)
		{
			int c=0;
			for(int j=2;j*j<i;j++)//agr sqrt(13) se pehle ho skte h uske roots to there is vry no chnace ki uske bd me factors hoenge
			{
				if(i%j==0)
					c++;
			}
			if(c==0)
			{
			li.add(String.valueOf(i));
		    }
		}
		return li;
	}

	//palindrome
	public static boolean isPalindrome(String st1)
	{
		int k=0;
		String s="";
		char[] ch= new char[st1.length()];
		for(int i=st1.length()-1;i>=0;i--)
		{
			s=s.concat(String.valueOf(st1.charAt(i)));
		}
		return s.equalsIgnoreCase(st1);
	}

	//3
	public static ArrayList<String> anagramPalindromicPrime(int x, int y)
	{
		ArrayList<String> li;	
		ArrayList<String> new_li= new ArrayList<String>();
		li = primeNumbers(x, y);
		for(String i: li)
		{
			if(i.length()>=1)
			{
				if(isPalindrome(i))
				{
					Iterator<String> itr = li.iterator();
					while(itr.hasNext())
					{
						String str = itr.next();
						String temp = str;
						System.out.println(anagramCheck(i, temp));
						if(anagramCheck(i, temp))
						{
							if(!new_li.contains(str))
							{
								System.out.println();
								new_li.add(str);
							}
						}
					}
					if(!new_li.contains(i))
								new_li.add(i);
				}
			}
		}
		return new_li;
	}

	//4:Binary search for integers(specific element)
	public static int doBinarySearch(int arr[], int elem)
	{
		int first=0, last=arr.length-1, middle=0;
		while(first <= last){
			middle = first + (last - first)/2;
			if(arr[middle] == elem){
				return middle+1;
			}
			else if(arr[middle]<elem)
				first = middle+1;
			else
				last = middle-1;
		}
		return -1;
	}

	//4 i)
	public static int  doBinarySearch(String arr[], String elem)
	{
		int first=0, last= arr.length-1, middle;
		while(first <= last)
		{
			middle = first + (last- first)/2;
			if(arr[middle].compareTo(elem)==0)
				return middle+ 1;
			else if(arr[middle].compareTo(elem) < 0)
				first = middle +1;
			else
				last = middle-1;
		}
		return -1;
	}

	//swap method for integers
	public static void swap(int[] array, int i, int j) 
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	//swap method for strings
	public static void swap(String[] array, int i, int j) 
	{
		String temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	//4 iii) insertion sort for integer
	public static int[] doInsertionSort(int arr[])
	{
		int j,temp;
		for(int i=1;i<arr.length;i++)
		{
			j=i-1;
			while(j>=0 && arr[j+1]<arr[j])
			{
				swap(arr, j, j+1);
				j--;
			}
		}
		return arr;
	}

	//4 iv) insertion sort for string
	public static String[] doInsertionSort(String arr[])
	{
		int j,temp;
		for(int i=1;i<arr.length;i++)
		{
			j=i-1;
			while(j>=0 && arr[j+1].compareTo(arr[j])<0)
			{
				swap(arr, j, j+1);
				j--;
			}
		}
		return arr;
	}

	//4 v) bubble sort for integer
	public static int[] doBubbleSort(int arr[])
	{
		for(int i=0 ; i<(arr.length - 1); i++)
		 {
		 	for(int j=0 ; j<arr.length - i - 1; j++)
		 	{
		 		if(arr[j]>arr[j+1]) /* For decreasing order use < */
		 		{
		 			swap(arr, j, j+1);
        		}																												
        	 }
        }
        return arr;
    }


    //4 vi) bubble sort for string
	public static String[] doBubbleSort(String arr[])
	{
		for(int i=0 ; i<(arr.length - 1); i++)
		 {
		 	for(int j=0 ; j<arr.length - i - 1; j++)
		 	{
		 		if(arr[j].compareTo(arr[j+1])>0) /* For decreasing order use < */
		 		{
		 			swap(arr, j, j+1);
        		}																												
        	 }
        }
        return arr;
    }
    
    static long startTime, stopTime;
    //start the timer
    public static void startTimer()
	{
		//startTime = (System.nanoTime()/Math.pow(10, 13))*10000000;
		startTime= System.nanoTime();
	}


	//stop the timer
	public static int stopTimer()
	{
		//stopTime= (System.nanoTime()/Math.pow(10, 13))*10000000;
		stopTime = System.nanoTime();
		int elapsedTime = (int)Math.round((stopTime - startTime));
		return elapsedTime;
	}

	public static void display(int arr[])
	{
        System.out.print("Sorted Array : ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i] + "   ");
		}
	}

	public static void display(String arr[])
	{
		System.out.print("Sorted Array: ");
		for(String s: arr)
		{
			System.out.print(s + "   ");
		}
	}
}





















