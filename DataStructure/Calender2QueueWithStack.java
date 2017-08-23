public class Calender2QueueWithStack
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
		QueueUsingStacks queue = new QueueUsingStacks();
		Stack stackWeek1 = new Stack();
		Stack stackWeek2 = new Stack();
		
		Stack stackWeekDay1 = new Stack();
		Stack stackWeekDay2 = new Stack();
		
		
		WeekDay newWeekDay = new WeekDay(day, date);
		Week newWeek = new Week(newWeekDay);
		Week topWeek;
		//topWeek = queue.enqueueWeek(stackWeek1, newWeek);
		//System.out.println(topWeek);
		WeekDay topWeekDay;
		
		topWeek = queue.enqueueWeek(stackWeek1, newWeek);  //first week added
	    topWeekDay = queue.enqueueWeekDay(stackWeekDay1, newWeek, newWeekDay);//first week day added
	    //System.out.println(topWeek + "topWeek");
		if(day == 6)//first week condition is itself the last day of the week, then create the new week
		{
			day = dayOfWeek(2, mon, year);
			newWeekDay = new WeekDay(day, date+1);
			newWeek = new Week(newWeekDay);
			topWeek = queue.enqueueWeek(stackWeek1, newWeek);
			topWeekDay = queue.enqueueWeekDay(stackWeekDay2, newWeek, newWeekDay);
		}
		boolean flag = false;
		
		//System.out.println(topWeek + "++");
		
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
				topWeek = queue.enqueueWeek(stackWeek1, newWeek);
			}
			
			if(day != 6)
				flag = false;
			else
				flag = true;  //flag will tell the next iteration to create a new week
			
			topWeekDay=queue.enqueueWeekDay(stackWeekDay1, newWeek, newWeekDay);
		}
		
		
		//dequeing the elements and printing the data
		System.out.println("\n   " + months[mon] + " " + year);
        System.out.println(" S  M Tu  W Th  F  S");
        day = dayOfWeek(1, mon, year);
        //topWeek;
        //System.out.println(topWeek + "===");
        topWeek = queue.dequeueWeek(stackWeek1, stackWeek2);
        //System.out.println(topWeek + "------");
        //topWeekDay =;
        //System.out.println(topWeek + "==");
        //weekDay = queue.dequeueWeekDay(stackWeekDay1, stackWeekDay2, topWeek);
        if(day <= 6)
        {
        	for(int d=0;d<day;d++)
        	System.out.printf("   ");
        	if(day == 6)
            {
            	System.out.printf("%2d" , 1);
            	System.out.print(" ");
            	topWeekDay = queue.dequeueWeekDay(stackWeekDay1, stackWeekDay2, topWeek);
            	topWeek = queue.dequeueWeek(stackWeek1, stackWeek2);
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
            	topWeek = queue.dequeueWeek(stackWeek1, stackWeek2);
            	System.out.println("");
        	}
			
			if(day != 6)
				flag = false;
			else
				flag = true;  //flag will tell the next iteration to delete a new week
			//System.out.println(topWeek + "--");
    		System.out.printf("%2d" , date);
    		System.out.print(" ");
        	topWeekDay = queue.dequeueWeekDay(stackWeek1, stackWeek2, topWeek);
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
	WeekDay startWeekDay;
	WeekDay topWeekDay;
	Week(WeekDay weekDay)
	{
		this.startWeekDay = weekDay;
		this.nextWeek = null;
		this.topWeekDay = weekDay;
	}
}


class Stack
{
	Week startWeek, topWeek;
	Stack()
	{
		startWeek = null;
		topWeek = null;
	}
	
	boolean isEmpty()
	{
		if(startWeek == null)
			return true;
		return false;
	}
	
	boolean isEmpty(Week newWeek)
	{
		if(newWeek.startWeekDay == null)
			return true;
		return false;
	}
	
	Week pushWeek(Week newWeek)
	{
		if(isEmpty())
		{
			newWeek.nextWeek = startWeek;
			startWeek = newWeek;
		}
		else
		{
			topWeek.nextWeek = newWeek;
		}	
		topWeek = newWeek;
		return startWeek;
	}
	
	WeekDay pushWeekDay(Week newWeek, WeekDay newWeekDay)
	{
		if(isEmpty(newWeek))
		{
			newWeek.startWeekDay.nextWeekDay = newWeekDay;
			newWeek.startWeekDay = newWeekDay;
		}
		else
		{
			newWeek.topWeekDay.nextWeekDay = newWeekDay;
		}	
		newWeek.topWeekDay = newWeekDay;
		return newWeek.startWeekDay;
	}

	Week popWeek()
	{
		Week week;
		Week tempWeek = startWeek;
		//if(tempWeek == null) 
			
		if(tempWeek.nextWeek == null)
			{week = tempWeek;tempWeek = null; topWeek = null; startWeek=null;}
		else
		{
			while(tempWeek.nextWeek != topWeek)
				tempWeek = tempWeek.nextWeek;
			week = tempWeek;
			tempWeek.nextWeek = null;			
			topWeek = tempWeek;
	   }
		return week;
	}
	
	WeekDay popWeekDay(Week newWeek)
	{
		WeekDay weekDay;
		WeekDay tempWeekDay = newWeek.startWeekDay;
		if(tempWeekDay.nextWeekDay == null)
			{weekDay = tempWeekDay; tempWeekDay = null; newWeek.topWeekDay= null; newWeek.startWeekDay = null;}
		else
		{
			while(tempWeekDay.nextWeekDay != newWeek.topWeekDay)
				tempWeekDay = tempWeekDay.nextWeekDay;
			weekDay = tempWeekDay;
			tempWeekDay.nextWeekDay = null;
			newWeek.topWeekDay = tempWeekDay;
	   }
	   return weekDay;
	}
}



class QueueUsingStacks
{
	Week enqueueWeek(Stack stack1, Week newWeek)
	{
		return stack1.pushWeek(newWeek);
	}
	
	WeekDay enqueueWeekDay(Stack stack1,Week newWeek, WeekDay newWeekDay)
	{
		return stack1.pushWeekDay(newWeek, newWeekDay);
	}
	
	Week dequeueWeek(Stack stack1, Stack stack2)
	{
		Week week;
		if(stack1.isEmpty()  && stack2.isEmpty())
			return null;
		else
		{
			while(!stack1.isEmpty()){
				week = stack1.popWeek();
				stack2.pushWeek(week);
			}
		}
	  return stack2.popWeek();
 	}
	
	WeekDay dequeueWeekDay(Stack stack1, Stack stack2, Week newWeek)
	{
		WeekDay weekDay;
		if(stack1.isEmpty()  && stack2.isEmpty())
			return null;
		else
		{
			while(!stack1.isEmpty()){
				weekDay = stack1.popWeekDay(newWeek);
				stack2.pushWeekDay(newWeek, weekDay);
			}
		}
		return stack2.popWeekDay(newWeek);
 	}	
}
