import java.util.*;
import java.io.*;

class Node{

	public String data;
	public Node next;
	Node(String data)
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
	public Node insertAtEnd(Node start, String new_data)
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

	public boolean searchNode(Node start, String value)
	{
		Node temp = start;
		while(temp != null)
		{
			String checkdata = temp.data;
			if(checkdata.equalsIgnoreCase(value)){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public Node deleteNode(Node start, String val)
	{
		Node temp = start, prev = temp; 

   		// If head node itself holds the key or multiple occurrences of key
    	while (temp != null && (temp.data).equalsIgnoreCase(val))
    	{
        	start = temp.next;   
        	temp = start;        // Change Temp
	    }
 
    	// Delete occurrences other than head
    	while (temp != null)
    	{
        	// Search for the key to be deleted, keep track of the
        	// previous node as we need to change 'prev->next'
        	while (temp != null && !(temp.data).equalsIgnoreCase(val))
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

	String convert(Node start)
	{
		String arr[]= new String[100];
		for(int i=0;i<arr.length;i++)
		{
			arr[i]= "";
		}
		
		int k=0;
		String str = "";
		Node temp = start;
		while(temp != null)
		{
			arr[k++] = temp.data;
			temp = temp.next;
		}

		for(int i=0;i<arr.length;i++)
		{
			if(arr[i].equals(""))
				break;
			else
				str= str.concat(arr[i]).concat(" ");
		}
		return str;
	}
}


public class UnorderedLinkedList
{
	private static final String FILENAME = "file1.txt";
	private static final String DELIM  = " ";
	public static void main(String args[])throws IOException
	{
		
		Node start, temp;

	    ListOperations  list = new ListOperations();

	    start = list.start;

		String readData[] = null;
		String storedData;
		int choice = 0;
		String dataToBeSearched;
		
		Scanner sc  = new Scanner(System.in);
		System.out.println("Enter the data to be fillled in the file");
		String dataToFill = sc.nextLine();

		writeDataToFile(dataToFill);


		readData = readDataFromFile();


		for(int i=0;i<readData.length;i++)
		{
			if(readData[i] != "")
			start = list.insertAtEnd(start, readData[i]);
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




	static void writeDataToFile(String data)throws IOException
	{
		FileWriter fw = new FileWriter(FILENAME);
		fw.write(data);
		fw.close();
	}

	static String[] readDataFromFile()throws IOException
	{
		String str[] = new String[200];
		for(int i=0;i<str.length;i++)
		   str[i]= "";
		int k=0;
		FileReader fr = new FileReader(FILENAME);
		int i;    
        while((i=fr.read())!=-1)
        { 
        	char ch = (char)i;
            if(ch != ' ')  
                str[k] = str[k].concat(String.valueOf((char)i));
            else
            	k++;
          }
        fr.close();    
		return str;
	}
	
	static String readDataFromUser()
	{
		System.out.println("Enter the data to be searched!!!");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		return str;
	}
}

