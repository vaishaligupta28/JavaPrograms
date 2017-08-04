import java.util.Scanner;
class prog5
{
	public static void main(String args[])
	{
		double sum =0.0;
		int N;
		do{
			System.out.println("Enter a harmonic value");
		    Scanner sc= new Scanner(System.in);
		    N= sc.nextInt();
		    if(N!=0)
		    {
		    	for(int i=1;i<=N;i++)
		    	{
		    		sum= sum+ (double)(i/(float)N);
		    	}
		    	System.out.println("Sum of harmonic series: " + sum);
		    }
		    else
		    	System.out.println("Number entered should not be equal to zero.");
		}while(N==0);
	}
}