/*
Algorithm Programs: Program 16

@author : Vaishali Gupta(QT8)
*/
import java.util.Scanner;
import utility.UtilityClass;
class Binary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the decimal number");
		int dec = sc.nextInt();

		String bin = UtilityClass.toBinary(dec);
		System.out.println("Original binary value : "+ bin);

		int len = bin.length();
		String left = bin.substring(0,len/2);
		String right = bin.substring(len/2 , len);

		String swappedString = swap(left, right);
		System.out.println("Swapped binary value : "+ swappedString);
		System.out.println("RESULTANT VALUE: "+ toDecimal(swappedString));
	}

	static String swap(String left, String right)
	{
		return right.concat(left);
	}
	static int toDecimal(String str)
	{
		int bin = Integer.parseInt(str);
	    int rem;
        int dec = 0;
     
        
        int c = 0;
     
        int temp = bin;
        while(temp > 0)
        {
           rem = temp % 10;
           temp = temp/10;
           dec += rem*Math.pow(2, c++);
        }
      return dec;
	}
}
