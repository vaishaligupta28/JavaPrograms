import java.util.Scanner;
import utility.UtilityClass;
class ToBinaryProgram
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a decimal number");
		int dec = sc.nextInt();
		System.out.println(UtilityClass.toBinary(dec));
	}
}
