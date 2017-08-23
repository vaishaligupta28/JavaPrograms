public class Calender2Dqueue
{
	private static int days[]= {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] months  = {"", "January", "February", "March" ,"April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

	public static void main(String[] args)
	{
		int date = 1;
		int mon =Integer.parseInt(args[0]);
		int year = Integer.parseInt(args[1]);	
		int day = dayOfWeek(date, mon, year);
		
		days[2] = febCheck(year);
		Queue queue = new Queue();
		WeekDay newWeekDay = new WeekDay(day, date);
		Week newWeek = new Week(newWeekDay);
		Week frontWeek;
		WeekDay frontWeekDay;
		
		frontWeek = queue.enqueueWeek(newWeek);  //first week added
		frontWeekDay = queue.enqueueWeekDay(newWeek, newWeekDay);//first week day added
		if(day == 6)//first week condition is itself the last day of the week, then create the new week
		{
			day = dayOfWeek(2, mon, year);
			newWeekDay = new WeekDay(day, date+1);
			newWeek = new Week(newWeekDay);
			frontWeek = queue.enqueueWeek(newWeek);
			frontWeekDay = queue.enqueueWeekDay(newWeek, newWeekDay);
		}
		boolean flag = false;
		
		
		//enqueueing the elements 
		for(date=2;date<=days[mon];date++)
		{	
			day = dayOfWeek(date, mon, year);
			if(date == 2 && day == 0)
				continue;
			newWeekDay = new WeekDay(day, date);	
			if(flag)
			{
        		newWeek = new Week(newWeekDay);
				frontWeek = queue.enqueueWeek(newWeek);
			}
			
			if(day != 6)
				flag = false;
			else
				flag = true;  //flag will tell the next iteration to create a new week
			
			frontWeekDay = queue.enqueueWeekDay(newWeek, newWeekDay);
		}
		
		//dequeing the elements and printing the data
		System.out.println("\n   " + months[mon] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
        day = dayOfWeek(1, mon, year);
        
        if(day <= 6)
        {
        	for(int d=0;d<day;d++)
        	System.out.printf("   ");
        	if(day == 6)
            {
            	System.out.printf("%2d" , frontWeek.frontWeekDay.date);
            	System.out.print(" ");
            	frontWeekDay = queue.dequeueWeekDay(frontWeek);
            	frontWeek = queue.dequeueWeek();
            	System.out.println();
            }
        }
        
        for(date=1;date<=days[mon];date++)
        {
        	day = dayOfWeek(date, mon, year); 
        	if(date == 1 && day == 6){
        		        continue;
        	}
        	if(flag){
            	frontWeek = queue.dequeueWeek();
            	System.out.println();
        	}
			
			if(day != 6)
				flag = false;
			else
				flag = true;  //flag will tell the next iteration to delete a new week
			
    		System.out.printf("%2d" , frontWeek.frontWeekDay.date);
    		System.out.print(" ");
        	frontWeekDay = queue.dequeueWeekDay(frontWeek);
        }
        System.out.println("\n");
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



class WeekDay
{
	int day;
	int date;
	WeekDay nextWeekDay;
	WeekDay(int day, int date)
	{
		this.day = day;
		this.date = date;
		this.nextWeekDay = null;
	}
}



class Week
{
	Week nextWeek;
	WeekDay frontWeekDay, rearWeekDay;
	Week(WeekDay weekDay)
	{
		this.nextWeek = null;
		this.frontWeekDay = weekDay;
		this.rearWeekDay = weekDay;
	}
}



class Queue
{
	Week frontWeek, rearWeek;
	Queue()
	{
		this.frontWeek = null;
		this.rearWeek = null;
	}

	Week enqueueWeek(Week newWeek)
	{
		if(frontWeek == null)
			frontWeek = newWeek;
		else
			rearWeek.nextWeek = newWeek;
		rearWeek = newWeek;
		return frontWeek;
	}

	WeekDay enqueueWeekDay(Week newWeek, WeekDay newWeekDay)
	{
		if(frontWeek.frontWeekDay == null)
			newWeek.frontWeekDay = newWeekDay;
		else
			newWeek.rearWeekDay.nextWeekDay = newWeekDay;
		newWeek.rearWeekDay = newWeekDay;
		return newWeek.frontWeekDay;
	}

	Week dequeueWeek()
	{
		if(frontWeek == null){
			rearWeek = null;
			return frontWeek;
		}
		if(frontWeek.nextWeek == null)
		{
			frontWeek = null; 
			return frontWeek;
		}
		frontWeek = frontWeek.nextWeek;
		return frontWeek;
	}
	
	WeekDay dequeueWeekDay(Week newWeek)
	{
		if(newWeek.frontWeekDay == null)
		{
			newWeek.rearWeekDay = null; 
			return newWeek.frontWeekDay;
		}
		if(newWeek.frontWeekDay.nextWeekDay == null)
		{
			newWeek.frontWeekDay = null; 
			return newWeek.frontWeekDay;
		}
		newWeek.frontWeekDay = newWeek.frontWeekDay.nextWeekDay;
		return newWeek.frontWeekDay;
	}
}



