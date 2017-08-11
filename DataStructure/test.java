import java.io.*;
import java.util.*;
class test
{
	private static String FILENAME = "file3.txt";
	public static void main(String args[])throws IOException
	{
		int arr[] = null;
		int writeArr[] = {1, 2, 3, 4,5 ,6};
		writeDataToFile(writeArr);
		arr = readDataFromFile(6);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	static void writeDataToFile(int[] data)throws IOException
	{
		String str = "";
		int arr[]= data;
		for(int i=0;i<arr.length;i++)
			str = str.concat(String.valueOf(arr[i]).concat(" "));
		FileOutputStream fout = new FileOutputStream(FILENAME);
		byte[] b = str.getBytes();
		fout.write(b);	
		fout.close();	
	}

	static int[] readDataFromFile(int size)throws IOException
	{
		int arr[] = new int[size];
		int k=0;
		File file = new File(FILENAME);
		Scanner sc = new Scanner(file);
		sc.useDelimiter(" ");
		while(sc.hasNext())
		{
			arr[k++] = sc.nextInt();
		}
		return arr;	    
	}
}