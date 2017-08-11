import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
class BankCashCounter
{
	private int totalBal = 0;
	public static void main(String args[])
	{
		int totalBal = 0;
		int noOfPeople = getRandom(4,10);
		System.out.println("The total number of people are "+ noOfPeople);
		Queue queue = new Queue();
		Node frontNode;
		int cash;
		Scanner sc = new Scanner(System.in);
		BankCashCounter myBankCashCounter = new BankCashCounter();

		//begin calculations--------
		for(int i=0;i<noOfPeople;i++)
		{
			System.out.println("\n***Person"+ (i+1)+"***");
			System.out.println(">Press 1:Deposit\n>Press 2:Withdraw");
			int choice = sc.nextInt();
			System.out.println("Enter the amount: ");
			cash = sc.nextInt();	
			frontNode = queue.enqueue(cash);
			queue.display();
			myBankCashCounter.chooseOperation(frontNode, choice);
		    frontNode = queue.dequeue();
		}
	}

	void chooseOperation(Node N, int choice)
	{
			switch(choice)
			{
				case 1:
				deposit(N.cash);
				return;
				case 2:
				withdraw(N.cash);
				return;
				default:
				System.out.println("Invalid Input");
				return;
			}
	}

	void withdraw(int amtToWithdraw)
	{
		if(totalBal >= amtToWithdraw){
			System.out.println("Withdrawing.....");
			totalBal -= amtToWithdraw;
		}
	    else
	    	System.out.println("Sorry!! Not enough balance");
	    System.out.println("The total Cash:" + totalBal);
	}
	void deposit(int amtToDeposit)
	{
		System.out.println("Depositing.......");
		totalBal += amtToDeposit;
		System.out.println("The Total Cash: "+ totalBal);

	}
	static int getRandom(int min, int max){
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}

}



class Node
{
	int cash;
	Node next;
	Node(int cash)
	{
		this.cash = cash;
		this.next = null;
	}
}


class Queue
{
	Node front, rear;
	Queue()
	{
		this.front = null;
		this.rear = null;
	}

	boolean isEmpty()
	{
		if(front ==  null)
			return true;
		return false;
	}

	Node enqueue(int data)
	{
		Node new_node = new Node(data);
		if(isEmpty())
		{
			front = new_node;
		}
		else
		{
			rear.next = new_node;
		}	
		rear = new_node;
		return front;
	}

	Node dequeue()
	{
		if(front == null){
			rear = null;
			return front;
		}
		if(front.next == null){front = null; return front;}
		front = front.next;
		return front;
	}

	int size()
	{ 
		int count = 0;
		Node temp = front;
		if(front == rear)
		   return 1;
		while(temp != rear)
		{
			count++;
			temp = temp.next;
		}
		return count+1;
	}
	void display()
	{ 
		Node temp = front;
		while(temp != rear){
			System.out.println(temp.cash + "-->");
			temp = temp.next;
		}
		System.out.println(temp.cash);
	}
}