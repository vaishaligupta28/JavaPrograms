/*
Functional Programs: Program 15

@Created by : Vaishali Gupta(QT8)
*/

import java.util.Scanner;
class Quadratic
{
	public static void main(String args[])
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the coffecients of the equation (ax*x + bx +c)");
		System.out.print("a:");
		int a = sc.nextInt();
		System.out.print("b:");
		int b = sc.nextInt();
		System.out.print("c:");
		int c = sc.nextInt();

		double delta= b * b - 4 * a * c;
		double ini= -b/(float)(2*a);
		if(delta>0){		
			System.out.println("Roots of the Quandratic equation are Real and Distinct:"+ "\nRoot1 : "+ (float)(ini + Math.sqrt(delta)/(2*a)) + "\nRoot2 : " +(float)(ini - Math.sqrt(delta)/(2*a)));
		}
		else if(delta==0){
			System.out.println("Roots of the Quandratic equation are Real and Equal:"+ "\nRoot1 : Root2 : " + ini);
		}
		else {	
			System.out.println("Roots of the Quandratic equation are Imaginary:"+ "\nRoot1 : "+ ini + "+"+ (float)Math.sqrt(-delta)/(2*a) + "i"  + "\nRoot2 : " + ini + "-" + (float)Math.sqrt(-delta)/(2*a) + "i");
		}
    }
}