import java.util.Scanner;
public class PalindromeChecker
{
	public static void main(String args[])
	{
		char ch;
		String str = "";
		Scanner sc = new Scanner(System.in);
		DeQueue dequeue = new DeQueue();
		System.out.println("Enter the string.");
		String s = sc.nextLine();
		s = s.trim().toUpperCase();
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i) != ' ')
			str = str.concat(String.valueOf(s.charAt(i)));
		}
		//System.out.println(str);
		boolean flag = false;
		char charBegin = ' ';
		char charEnd = ' ';

		//enque the elements
		if(str.length() > 1){
			for(int i=0;i<str.length();i++)
				dequeue.addFront(str.charAt(i));

			for(int i = 0;i<(str.length()/2);i++)
			{
				charBegin = dequeue.removeFront();
				//System.out.print(charBegin +"-");
				charEnd = dequeue.removeRear();
				//System.out.print(charEnd +"\n");
				if(charBegin == charEnd){
					flag = true;
				}
				else{
					flag = false;
					break;
				}
			}
			if(flag)
				System.out.println("Palindrome");
	    	else
	    		System.out.println("Not Palindrome");
	   }
	   else
	   	System.out.println("Input too small");	
	}
}



class Node
{
	char ch;
	Node next;
	Node(char ch)
	{
		this.ch = ch;
		this.next = null;
	}
}


class DeQueue
{
	Node front, rear;
	DeQueue()
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

	void addFront(char c)
	{
		Node new_node = new Node(c);
		if(isEmpty())
		{
			front = new_node;
			rear = new_node;
		}
		else
		{
			new_node.next = front;
			front = new_node;
		}
		display();
	}

	char removeFront()
	{
		char frontChar;
		frontChar = front.ch;
		front = front.next;
		//display();
		if(front == rear)
			rear = front;
		return frontChar;
	}

	char removeRear()
	{
		Node temp = front;
		char rearChar;
		if((rear == front))
		{
			rearChar = rear.ch;
			front = null;
			rear = null;
		}
		else
		{
			while(temp.next!=rear)
			{
				temp=temp.next;
			}	
		    rearChar = rear.ch;	
			rear = temp;
	    }
		return rearChar;
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
			System.out.print(temp.ch + "-->");
			temp = temp.next;
		}
		System.out.println(temp.ch);
	}
}
