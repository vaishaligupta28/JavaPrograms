import utility.UtilityClass;
class dayOfWeek
{
	public static void main(String args[])
	{
		int day = Integer.parseInt(args[0]);
		int month =Integer.parseInt(args[1]);
		int year = Integer.parseInt(args[2]);
		int dayOfWeek = UtilityClass.dayOfWeek(day, month, year);

		switch(dayOfWeek)
		{
			case 0:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Sunday");
			break;
			case 1:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Monday");
			break;
			case 2:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Tuesday");
			break;
			case 3:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Wednesday");
			break;
			case 4:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Thursday");
			break;
			case 5:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Friday");
			break;
			case 6:
			System.out.println(day + "/"+ month + "/" + year + " falls on : Saturday");
			break;
			default:
			System.out.println("Wrong date entered");
			System.exit(0);
		}
	}
}
