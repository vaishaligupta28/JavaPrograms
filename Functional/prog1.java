import java.util.Scanner;  
class prog1
{
	public static void main(String args[])
	{
		int total_characters=0;
		boolean flag=false;//for ending when the user enters correct name

		do{
			System.out.println("Enter your name: ");
		    Scanner sc = new Scanner(System.in);
		    String username= sc.next();
		    for(int i=0;i<username.length();i++)
		    {
			  char ch= username.charAt(i);
			  if((ch>=65 && ch<=90) || (ch>=97 && ch<=122))
		    		total_characters++;
		    }
		    if(total_characters>=3)
		    {
			  flag=true;
			  System.out.println("Hello <<"+username+">>, How are you?");
		    }   
		    else
		      System.out.println("Enter minimum 3 characters.");
		}while(!flag);
	}
}