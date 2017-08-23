public class Calender
{
    private static int days[]= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] months  = {"", "January", "February", "March" ,"April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

	public static void main(String args[])
	{
		int calenderArr[][];
		int day = 1;	
		int mon =Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);	

		calenderArr = calenderFill(day, mon, year);
		display(day, mon, year, calenderArr);
	}

    //filling calender data
	static int[][] calenderFill(int day, int mon, int year)
	{	
		boolean flag = false;
		int i,j,k = 1;
		int calenderArr[][] = new int[6][7];		
		int dayOfWeek = dayOfWeek(day, mon, year);		
		days[2] = febCheck(year);
		for(i=0;i<6;i++)  //no of weeks can be maximum 6 1 row for letters
		{
			for(j=0;j<7;j++)  //no.of days in a week 7
			{	
				if(i == 0)
				{
					if(j < dayOfWeek)
						calenderArr[i][j] = 0;
				    else
				    	calenderArr[i][j] = k++;
				}
				if(i > 0)
                {
                	if(k > days[mon])
                	{
                		flag = true; 
                		break;
                	}
                	else
                		calenderArr[i][j] = k++;
                }
			}
			if(flag)
				break;
		}
		return calenderArr;
	}

    //display calender
	static void display(int day, int mon, int year, int[][] calenderArr)
	{
		int i,j,k = 1;
     	int dayOfWeek = dayOfWeek(day, mon, year);	
        System.out.println("\n   " + months[mon] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
		for(i=0;i<6;i++)
		{
			for(j=0;j<7;j++)
			{
				if(i==0 && j < dayOfWeek){
					System.out.printf("   ");
				}
			    else
			    {
			    	if(calenderArr[i][j] != 0)
			    	System.out.printf("%2d", calenderArr[i][j]);    // format specifier
			        System.out.print(" ");
			    }
			}
			System.out.println();
		}
	}
	static int dayOfWeek(int d, int m, int y)
	{
		int y0, x, m0, d0;
		y0= (y-((14-m)/12));
	    x=y0+(y0/4)-(y0/100)+(y0/400);
	    m0=m+(12*((14-m)/12))-2;
	    d0=(d+x+((31*m0)/12))%7;
		return d0;
	}

	static int febCheck(int year)
	{
		if(IsALeapYear(year))
			return 29;
		else
			return 28;
	}

    static boolean IsALeapYear(int year)
	{
		if((year%400==0) || ((year%4==0) && (year%100!=0)))
			return true;
		else
			return false;
	}

}

