class prog16
{
	public static void main(String args[])
	{
		int t= args[0];//temp in (fahrenheit)
		int v= args[1];//wind speed in (miles/hr)
		double w;
		if(t<=50 && v<=120 && v>=3)
		{
			w = 35.74 + (0.6215 * t) + t + ((0.4275 * t) - 35.75) * Math.pow(v, 0.16);
 		}
 		System.out.println("Wind Chill"+ w);
	}
}