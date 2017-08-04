import java.util.Scanner;
class prog3
{
	public static void main(String args[])
	{
		Integer year;
		boolean flag=false;

		do{
		System.out.println("Enter a year");
		Scanner sc= new Scanner(System.in);
		year= Integer.valueOf(sc.nextInt());
		String str_year= year.toString();
		if(str_year.length()==4)
		{
			flag=true;
			boolean check=prog3.IsALeapYear(year);
			if(check)
				System.out.println(year+ " is a leap year.");
			else
				System.out.println(year + " is not a leap year.");

		}
		else
			System.out.println("Year can only be 4 digit number!!");

		}while(!flag);
	}

	static boolean IsALeapYear(int x)
	{
		if((x%400==0) || ((x%4==0) && (x%100!=0)))// year is leap year if 1)multiple of 400 2)multiple of 4 but not 100
			return true;
		else
			return false;
	}
}