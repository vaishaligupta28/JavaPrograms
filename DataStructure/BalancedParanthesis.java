import java.util.Scanner;
public class BalancedParanthesis
{
	public static void main(String args[])
	{
		System.out.println("Enter the equation.");
		Scanner sc = new Scanner(System.in);

		Stack stack = new Stack();
		String paran = sc.next();
		checkParanthesis(paran, stack);
	}

	static void checkParanthesis(String data, Stack s)
	{
		char ch;
		for(int i=0;i< data.length();i++){
			ch = data.charAt(i);
			if( ch == '(')
				s.push('(');
			else if(ch == ')')
				s.pop();
			else
				continue;
		}
		if(s.size() == 0)
			System.out.println("Paranthesis are balanced");
		else
			System.out.println("Paranthesis not balanced");
	}
}

class Node
{
	char data;
	Node next;
	Node(char data)
	{
		this.data = data;
	}
}

class Stack
{
	Node start, top;
	Stack()
	{
		start = null;
		top = null;
	}

	boolean isEmpty()
	{
		if(start == null)
			return true;
		return false;
	}

	void push(char item)
	{
		Node new_node = new Node(item);
		new_node.next = null;
		//Node temp;
		if(isEmpty())
		{
			new_node.next = start;
			start = new_node;
		}
		else
		{
			//temp = top;
			top.next = new_node;
		}	
		top = new_node;
	}

	void pop()
	{
		Node temp = start;
		if(temp.next == null)
			{temp = null; top = null; start=null;}
		else
		{
			while(temp.next.next != null)
				temp = temp.next;
			temp.next = null;
			top = temp;
	   }
	}
	int size()
	{ 
		int count = 0;
		Node temp = start;
		while(temp != null)
		{
			count++;
			temp = temp.next;
		}
		return count;
	}
}
