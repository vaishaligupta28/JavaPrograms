/*
Functional Programs: Program 16

@Created by : Vaishali Gupta(QT8)
*/
class prog16
{
	public static void main(String args[])
	{
		int t= Integer.parseInt(args[0]);//temp in (fahrenheit)
		int v= Integer.parseInt(args[1]);//wind speed in (miles/hr)
		double w;
		if(t<=50 && v<=120 && v>=3)
		{
			w = 35.74 + (0.6215 * t) + t + ((0.4275 * t) - 35.75) * Math.pow(v, 0.16);
                        System.out.println("Wind Chill  "+ w);
 		}
                else
                System.out.println("Not a valid input"); 		
	}
}
