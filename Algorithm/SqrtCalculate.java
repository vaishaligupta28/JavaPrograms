import utility.UtilityClass;
import java.util.Scanner;
class SqrtCalculate
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a non negative number to calculate sqaure root");
		int n = sc.nextInt();
		System.out.println("The square root is :   "+ UtilityClass.sqrtPositiveNum(n));
	}
}
