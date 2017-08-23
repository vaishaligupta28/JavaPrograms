/*
Functional Programs: Program 9

@author:Vaishali Gupta(QT8)
*/

import java.io.*;
import java.util.Scanner;
public class Fill2DArray
{
	public static void main(String args[])
   {
   	   PrintWriter pw= new PrintWriter(System.out);;
       int M, N, i, j;
       int arr[][] = new int[10][10];
       Scanner sc = new Scanner(System.in);
	   
       System.out.print("Enter Number of Row: ");
       M = sc.nextInt();
       System.out.print("Enter Number of Column: ");
       N = sc.nextInt();
	   
       System.out.print("Enter Array Elements : ");
       for(i=0; i<M; i++)
       {
           for(j=0; j<N; j++)
           {
               arr[i][j] = sc.nextInt();
           }
       }
	   
       System.out.print("The Array is :\n");
       for(i=0; i<M; i++)
       {
           for(j=0; j<N; j++)
           {
               pw.write(arr[i][j] +"\t");
           }
           pw.println();
       }
       pw.flush();
       pw.close();
   }
}
