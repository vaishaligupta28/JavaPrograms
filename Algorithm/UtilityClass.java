/*
Algorithm Programs: Program 1,2,3,4,11,12,13,14,15

@author: Vaishali Gupta(QT8)
*/
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

	/*Program 1. Anagram Program
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

	//Program 2.
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

	//palindrome check
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

	//Program 3
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

	//Program 4 i) Binary search for integers(specific element)
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

	//Program 4 ii)
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

	//Program 4 iii) insertion sort for integer
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

	//Program 4 iv) insertion sort for string
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

	//Program 4 v) bubble sort for integer
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


    //Program 4 vi) bubble sort for string
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

	//Program 11:  static function for the "day of the week" program
	public static int dayOfWeek(int d, int m, int y)
	{
		int y0, x, m0, d0;
		y0=y-((14-m)/12);
	    x=y0+(y0/4)-(y0/100)+(y0/400);
	    m0=m+(12*((14-m)/12))-2;
	    d0=(d+x+((31*m0)/12))%7;
		return d0;
	}

	//Program 12: static function for the "Temperature Conversion"
	public static void tempConversion(float temp, int option)
	{
		if(option == 1)
		{
			System.out.println("Celsius to Fahrenheit:");
			System.out.print(temp + "°C" + " = ");
			float convertTemp = (float)(temp * 1.8) + 32;
			System.out.println(convertTemp + "°F"); 
		}
		else
		{
			System.out.println("Fahrenheit to Celsius:");
			System.out.print(temp + "°F" + " = ");
			float convertTemp = (float)((temp/9)*5) - (float)((32/9)*5) ;
			System.out.println(convertTemp + "°C"); 
		}
	}

	//Program 13: static function for "monthly payment"
	public static void monthlyPayment(float p, float y, float R)
	{
		float num, total;
		float n=(float)(12*y);
		float r=(float)(R/(12*100));
		num=(p*r);
		total=(float)(num/(1-Math.pow(1+r,(-n))));
		System.out.println("The monthly Payments you would have to make over " + y +
		" years to pay off a "+ p +" principal loan amount at "+ R +" per cent "
         + "interest compounded monthly:   " + total);

	}

	static double avg(double a, double b)
	{
		return (a+b)/2;
	}
	

	//Program 14: 
	public static double sqrtPositiveNum(int c)
	{
		double epsilon = Math.exp(-15);
		double t = (double)c;
		while(Math.abs(t - (c/t)) > (epsilon * t))
		{
			t = (c/(2 * t)) + (t/2);
		}
		return t;
	}



	//Program 15:
	public static String toBinary(int dec)
	{
		int sum = 0, k=0, r, shift, c= 2;
		String bin = null;
		while(dec>0)
		{
			r = dec%2;
			sum = sum + r * (int)Math.pow(10, k++);
			dec = dec/2;
		}

		if(k <= (Math.pow(2,2)))
		{
			shift = (4 - k);
		}
		else
		{
		   while(true)
		   {
	          if((Math.pow(2, c-1)) < k  && k <= (Math.pow(2,c)))
	       	      break;
	          else
	       	      c++;
		   }

	   shift = (int)Math.pow(2, c) - k;
	   }
	   String originalString = String.valueOf(sum);
	   for(int i = 0;i<shift;i++)
	   {
	   	  bin = "0".concat(originalString);
	   	  originalString = bin;
	   }
	return bin;
  }
}





















