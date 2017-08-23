import utility.UtilityClass;
import java.util.*;

//Test program 1, 2 ,3

public class AngramDetectionAndPrime
{
	public static void main(String[] args)
	{
	   
	    ArrayList<String> list ;
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose the Operation: \n1.Check Angarams\n2.Find prime numbers in a given range.\nFind the prime numbers that are angramic palindrome.")
		int choice = sc.nextInt();

		switch(choice)
		{
			case 1:
			     System.out.println("Enter two strings");
			     System.out.print("String 1:  ");
			     String str1 = sc.next();
			     String str2 = sc.next();
			     if(UtilityClass.anagramCheck(str1, str2))
			         System.out.println("Two Strings are Palindrome");
			     else
                     System.out.println("Two Strings are Not Palindrome");

			case 2:
			    System.out.println("The prime numbers in the given range are:  ");
				list = UtilityClass.primeNumbers(1, 1000);
				for(String str: list)
				{
					System.out.println(str);
				}

			case 3:
			    System.out.println("The anagram palindromic prime numbers in the given range are:  ");
				list = UtilityClass.anagramPalindromicPrime(1, 1000);
				for(String str: list)
				{
					System.out.println(str);
				}
		}
	}
}