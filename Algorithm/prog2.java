import Algorithm.utility.UtilityClass;
class Node
{
	int data;
	Node next;
	Node(sortedInsertMiddle data)
	{
		this.data = data;
	}
}

class ListOperations
{
	
	Node start = null;
	
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
				start = insertAtEnd(start);
			else
				start = insertAtBegin(start);
		}
		else
		{
			//if the new data is lesser than the head node
			if(new_data <= start.data)
				start insertAtBegin(new_data);
			else
			{
			    while(temp != null && new_data > temp.data)
					{
						prev = temp;
						temp = temp.next;
						if(temp == null)
								return (start = insertAtEnd(start));
						prev.next = new_node;
						new_node.next = temp;
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
		new_node.next = null;
		
		new_node-next = start;
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
        	// Search for the key to be deleted, keep track of the
        	// previous node as we need to change 'prev->next'
        	while (temp != null && temp.data != null)
        	{
            	prev = temp;
            	temp = temp.next;
       		 }
 
        	// If key was not present in linked list
        	if (temp == null) return start;
 
        	// Unlink the node from linked list
        	prev.next = temp.next;
 
 
       	    //Update Temp for next iteration of outer loop
        	temp = prev.next;
        }
	   	return start;
    }

    public boolean searchNode(Node start, int value)
	{
		Node temp = start;
		if(start.data > value)
			return false;
		while(temp != null)
		{
			if(temp.data == value){
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
    	while(temp != null)
    	{
    		arr[k++]= temp.data;
    	}
    	return arr;
    }
}


class OrderedLinkedList
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

		writeDataToFile(dataToFill, size);

		readData = readDataFromFile(size);

		sortedReadData = UtilityClass.doBubbleSort(readData);
		
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
				start = list.insertAtEnd(start, dataToBeSearched);
				list.display(start);
			}

			writeDataToFile(list.convert(start));
			System.out.println("\n>Press -1 to exit.\n>Press any other to continue");
			choice = sc.nextInt();
	    }   
	}


	static void writeDataToFile(int[] data)throws IOException
	{
		FileOutputStream fout = new FileOutputStream(FILENAME);
		DataOutputStream dout = new DataOutputStream(FILENAME);
		for(int i: data)
			dout.writeInt(j);
		dout.flush();
		fout.flush();
	}

	static int[] readDataFromFile(int size)throws IOException
	{
		int arr[] = new int[size];
		FileInputStream fin = new FileInputStream(FILENAME);
		DataInputStream din = new DataInputStream(FILENAME);
		while(din.available > 0)
		{
			arr[i]=din.readInt();
		}
		return arr;
	}
	
	static int readDataFromUser()
	{
		System.out.println("Enter the data to be searched!!!");
		Scanner sc = new Scanner(System.in);
		int d = sc.next();
		return d;
	}