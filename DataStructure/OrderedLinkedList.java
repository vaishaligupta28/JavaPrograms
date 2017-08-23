import java.util.*;
import java.io.*;
class Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data = data;
	}
}

class ListOperations
{
	
	Node start;
	
	ListOperations()
	{
		start = null;
	}
	
	//inserting node
	public Node insertAtMiddle(Node start, int new_data)
	{
		Node temp = start, prev;
		Node new_node = new Node(new_data);
		new_node.next = null;
		
		if(start == null)
		{
			new_node.next = start;
			start = new_node;
		}
		else if(start.next ==  null)
		{
			if(new_data > start.data)
				start = insertAtEnd(start, new_data);
			else
				start = insertAtBegin(start, new_data);
		}
		else
		{
			//if the new data is lesser than the head node
			if(new_data <= start.data){
				start= insertAtBegin(start, new_data);
			}
			else
			{
			    while(temp != null && new_data > temp.data)
					{
						prev = temp;
						temp = temp.next;
						if(temp == null)
								return (start = insertAtEnd(start, new_data));
						if(new_data <= temp.data){	
						prev.next = new_node;
						new_node.next = temp;
						return start;
					   }
					}
				}
		    }
		return start;
	}


	public Node insertAtEnd(Node start, int new_data)
	{
		Node temp = start;
		Node new_node = new Node(new_data);
		new_node.next = null;
		
		if(start == null)
		{
			new_node.next = start;
			start = new_node;
		}
		else
		{
			while(temp.next != null)
				{temp = temp.next;}
			temp.next = new_node;
		}
		return start;
	}
	
	public Node insertAtBegin(Node start, int new_data)
	{
		Node temp = start;
		Node new_node = new Node(new_data);
		new_node.next = start;
		start = new_node;
		return start;
	}

	public Node deleteNode(Node start, int val)
	{
		Node temp = start, prev = temp; 

   		// If head node itself holds the key or multiple occurrences of key
    	while (temp != null && temp.data == val)
    	{
        	start = temp.next;   
        	temp = start;        // Change Temp
	    }
 
    	// Delete occurrences other than head
    	while (temp != null)
    	{
        	while (temp != null && temp.data != val)
        	{
            	prev = temp;
            	temp = temp.next;
       		 }
 
        	if (temp == null) return start;

        	prev.next = temp.next;
 
        	temp = prev.next;
        }
	   	return start;
    }

    public boolean searchNode(Node start, int val)
	{
		Node temp = start;
		if(start.data > val)
			return false;
		while(temp != null)
		{
			if(temp.data == val){
			return true;
			}
			temp = temp.next;
		}
		return false;
	}

    public int size(Node start)
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
    public int[] convert(Node start)
    {
    	Node temp =start;
    	int size = size(start);
    	int k=0;
    	int arr[] = new int[size];
    	//System.out.println(arr.leAZX Cngth);
    	while(temp != null)
    	{
    		arr[k++]= temp.data;
    		temp = temp.next;
    	}
    	return arr;
    }
    void display(Node start)
	{
		Node temp = start;
		while(temp.next != null)
		{
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println(temp.data);
	}

}


public class OrderedLinkedList
{
	private static final String FILENAME = "file2.txt";

	public static void main(String args[])throws IOException
	{
		
		Node start, temp;

	    ListOperations  list = new ListOperations();

	    start = list.start;

	    int readData[] = null;
		int sortedReadData[] = null;
		int choice = 0;
		int dataToBeSearched;
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the number of elements to be inserted into the file");
		int size = sc.nextInt();
		int dataToFill[] = new int[size];

		System.out.println("Enter the elements:");
		for(int i=0;i<size;i++)
			dataToFill[i] = sc.nextInt();

		writeDataToFile(dataToFill);

		readData = readDataFromFile(size);

		sortedReadData = doBubbleSort(readData);
		
		for(int i=0;i<size;i++)
		{
			start = list.insertAtEnd(start, sortedReadData[i]);
	    }
        list.display(start);

		while(choice != -1)
		{
			
			dataToBeSearched = readDataFromUser();

			//here you will search the data;
			if(list.searchNode(start, dataToBeSearched))
			{
				start = list.deleteNode(start, dataToBeSearched);
				list.display(start);
			}
			else
			{
				start = list.insertAtMiddle(start, dataToBeSearched);
				list.display(start);
			}

			writeDataToFile(list.convert(start));
			System.out.println("\n>Press -1 to exit.\n>Press any other to continue");
			choice = sc.nextInt();
	    }   
	}


	static void writeDataToFile(int[] data)throws IOException
	{
		String str = "";
		int arr[]= data;
		for(int i=0;i<arr.length;i++)
			str = str.concat(String.valueOf(arr[i]).concat(" "));
		FileOutputStream fout = new FileOutputStream(FILENAME);
		byte[] b = str.getBytes();
		fout.write(b);	
		fout.close();	
	}

	static int[] readDataFromFile(int size)throws IOException
	{
		int arr[] = new int[size];
		int k=0;
		File file = new File(FILENAME);
		Scanner sc = new Scanner(file);
		sc.useDelimiter(" ");
		while(sc.hasNext())
		{
			arr[k++] = sc.nextInt();
		}
		return arr;	    
	}
	
	static int readDataFromUser()
	{
		System.out.println("Enter the data to be searched!!!");
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		return d;
	}
	public static void swap(int[] array, int i, int j) 
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static int[] doBubbleSort(int arr[])
	{
		for(int i=0 ; i<(arr.length - 1); i++)
		 {
		 	for(int j=0 ; j<arr.length - i - 1; j++)
		 	{
		 		if(arr[j]>arr[j+1]) /* For decreasing order use < */
		 		{
		 			swap(arr, j, j+1);
        		}																												
        	 }
        }
        return arr;
    }
}
