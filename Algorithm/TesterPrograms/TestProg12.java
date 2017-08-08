import java.util.Scanner;
import utility.UtilityClass;
class TestProg12
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an option : \n1:Celsius to Fahrenheit\n2:Fahrenheit to Celsius");
		int option = sc.nextInt();
		System.out.println("Enter the temperature:  ");
		float temp = sc.nextFloat();

		UtilityClass.tempConversion(temp, option);
	}
}