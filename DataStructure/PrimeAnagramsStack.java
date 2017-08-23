import java.util.*;
import utility.UtilityClass;
public class PrimeAnagramsStack
{
	public static void main(String[] args)
	{
		int arr[][] = new int[30][10];
		int range = 100;
		Stack stack = new Stack();
		int data;
		ArrayList<String> li = UtilityClass.primeNumbers(0, 1000);
		Iterator itr=li.iterator();  
		ArrayList<String> new_li = new ArrayList<String>();
		while(itr.hasNext())
			{
				String str = String.valueOf(itr.next());
				if(str.length() > 1){
					if(li.contains(findAnagram(str)))
					new_li.add(str);
			    }
			}
		itr=new_li.iterator();

		while(itr.hasNext()){
  			data = Integer.valueOf(String.valueOf(itr.next()));
  			stack.push(data);
  		}

  		System.out.println("\n\nPrime Anagrams in the range "+ 0 + "-" + 1000);	
  		System.out.print(stack.top.data + ",");
  		while(!stack.isEmpty())
  		{
  			if(stack.start.next.next != null)
  			   System.out.print(stack.pop()  + ",");
  			else{
  				System.out.print(stack.pop());
  				break;
  			}
  		}
  		System.out.println("\n\n");
	}
	public static String findAnagram(String str)
	{
		char[] stringToChar= str.toCharArray();
		int k =0;
		char[] reverseStringChar = new char[stringToChar.length];
		for(int i=stringToChar.length-1;i>=0;i--)
			reverseStringChar[k++] = stringToChar[i];
		String reverseString = new String(reverseStringChar);
		return reverseString;
	} 
}


class Node
{
	int data;
	Node next;
	Node(int data)
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

	void push(int data)
	{
		Node new_node = new Node(data);
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

	int pop()
	{
		int data;
		Node temp = start;
		if(temp.next == null)
			{data = temp.data; temp = null; top = null; start=null;}
		else
		{
			while(temp.next != top)
				temp = temp.next;
			data = temp.data;
			temp.next = null;
			top = temp;
	    }
	    return data;
	}
}
