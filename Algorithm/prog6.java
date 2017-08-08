/*
Algorithm Programs: Program 6

@author: Vaishali Gupta(QT8)
*/

import java.io.*;
import java.util.*;
import utility.UtilityClass; 
class prog6 {

	private static final String FILENAME = "file.txt";

	public static void main(String[] args)throws IOException {


		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the data: ");
		String data = sc.nextLine(); //next line and not next

		String str;
		String delims = "[ .,?!]+";
		String[] words = null;
		FileOutputStream fout = new FileOutputStream(FILENAME);
		DataOutputStream dout = new DataOutputStream(fout);
		dout.writeUTF(data);

		dout.flush();

		FileInputStream fin = new FileInputStream(FILENAME);
		DataInputStream din = new DataInputStream(fin);
		 // available stream to be read
        while(din.available()>0) {

            // reads characters encoded with modified UTF-8
            String k = din.readUTF();
			words = k.split(delims);
       }

	   System.out.println("Enter the word to be searched!!");
	   String word = sc.next();

	   System.out.println("Searching..........\n");

	   String sortedArray[] = UtilityClass.doBubbleSort(words);
	   int check = UtilityClass.doBinarySearch(sortedArray, word);
	   if(check > 0)
		   System.out.println("Word is found at position : "+ (check+1));
	   else
		   System.out.println("Sorry!!! Word not found");
	}
 }
