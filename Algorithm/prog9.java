/*
Algorithm Programs: Program 9

@author: Vaishali Gupta(QT8)
*/
import java.util.Scanner;
class prog9
{
	public static void main(String args[])
	{
		String sortedArray[];
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the original array");
		int size = sc.nextInt();

		String arr[] = new String[size];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<size;i++)
		{
			arr[i]= sc.next();
		}

		System.out.println("\nSorted Array: ");
		sortedArray = MergeSort(arr);
		for(String s: sortedArray)
			System.out.println(s);
	}

	static  String[] MergeSort(String arr[])
	{
		int n = arr.length;
		int mid = (int)Math.floor(n / 2);
		String left_arr[] = new String[mid];
		String right_arr[] = new String[n- mid];
		if(n < 2)
			return arr;
		
		//filling left array
		for(int i=0;i<mid;i++)
			left_arr[i]= arr[i];

		//filling right array
		for(int i= mid;i<n;i++)
			right_arr[i-mid]= arr[i];

		left_arr = MergeSort(left_arr);
		right_arr = MergeSort(right_arr);
		arr = Merge(left_arr, right_arr, arr);
		return arr;
	}

	static String[] Merge(String[] left, String[] right, String[] arr)
	{
		int lLength= left.length;
		int rLength = right.length;
		int i =0, j=0, k=0;

		while(i<lLength && j<rLength)
		{
			if(left[i].compareTo(right[j])< 0)
			{
				arr[k] = left[i];
				k++;
				i++;
			}
			else
			{
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		while(i< lLength)
		{
			arr[k]= left[i];
			k++;
			i++;
		}
		while(j< rLength)
		{
			arr[k]= right[i];
			k++;
			j++;
		}
		return arr;
	}
}
