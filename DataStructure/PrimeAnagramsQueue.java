import java.util.*;
import utility.UtilityClass;
public class PrimeAnagramsQueue
{
	public static void main(String[] args)
	{
		int arr[][] = new int[30][10];
		int range = 100;
		Queue queue = new Queue();
		int data;
		Node front;
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
  			front = queue.enqueue(data);
  		}

  		System.out.println("\n\nPrime Anagrams in the range "+ 0 + "-" + 1000);	
  		while(!queue.isEmpty())
  		{
  			if(queue.front.next != null)
  			   System.out.print(queue.dequeue()  + ",");
  			else{
  				System.out.print(queue.dequeue());
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

	int dequeue()
	{
		int data;
		if(front == null){
			rear = null;
			return -1;
		}
		if(front.next == null){data = front.data; front = null; return data;}
		data = front.data;
		front = front.next;
		return data;
	}
}
