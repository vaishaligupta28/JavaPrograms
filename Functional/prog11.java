class Distance
{
	public static void main(String args[])
	{
		Integer x = Integer.parseInt(args[0]);
		Integer y = Integer.parseInt(args[1]);				

		double dis= Math.sqrt(x*x + y*y);
		System.out.println("Euclidena Distance of x and y from origin is: "+ dis);
	}
}