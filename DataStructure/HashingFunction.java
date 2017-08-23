import java.util.Scanner;
import java.io.*;
public class HashingFunction {

	private static final String FILENAME = "file6.txt";
	public static void main(String[] args)throws IOException {

		char choice;
		int readData[] = null;
		int writeData[] = null;
		Scanner sc = new Scanner(System.in);
		HashMap myHashMap = new HashMap(11);

		System.out.println("\n\n******Initial Hash Table*******\n");
		int noOfElements =myHashMap.countAndDisplayHashTable();

		int arr[]=null;
		System.out.println("\nEnter the number of elements to be inserted into the file");
		int size = sc.nextInt();
		int dataToFill[] = new int[size];

		System.out.println("Enter the elements:");
		for(int i=0;i<size;i++)
			dataToFill[i] = sc.nextInt();

		writeDataToFile(dataToFill);

		readData = readDataFromFile(size);

		for(int i=0;i<size;i++)
		{
			myHashMap.insert(readData[i]);
	    }

	    System.out.println("******Intermediate Hash Table*******\n");
		noOfElements  = myHashMap.countAndDisplayHashTable();
		
		do{
			System.out.println("\nEnter the data to be searched");
			int dataToBeSearched = sc.nextInt();

			if(myHashMap.search(dataToBeSearched)){
				myHashMap.delete(dataToBeSearched);
				System.out.println();
				System.out.println("******Hash Table*******\n");
				noOfElements = myHashMap.countAndDisplayHashTable();
			}
			else{
				myHashMap.insert(dataToBeSearched);
				System.out.println();
				System.out.println("******Hash Table*******\n");
				noOfElements = myHashMap.countAndDisplayHashTable();
			}

			writeDataToFile(myHashMap.writeChangedDataToFile(noOfElements));

			System.out.println("Do you want to continue (y/n)");
			choice = sc.next().charAt(0);
		}
		while(choice == 'y');
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

}

class HashNode
{
	int val;
	HashNode next;
	HashNode(int val)
	{
		this.val = val;
		this.next = null;
	}
}

class HashMap
{
	HashNode myBucketTable[];
	HashMap(int tableLen)
	{
		int i;
		myBucketTable = new HashNode[tableLen];
		/*for(i=0;i<tableLen;i++);
			System.out.println("---");
		    System.out.println(myBucketTable[i]);*///assigning to null; all the head values;
	}
	
	
	//inserting into the hash table
	public void insert(int new_data)
	{
		int index = hashFunction(new_data);
	    HashNode temp = myBucketTable[index], prev;
		HashNode newHashNode = new HashNode(new_data);
		
		if(myBucketTable[index] == null)
		{
			myBucketTable[index] = newHashNode;
		}
		
		else if(myBucketTable[index].next == null)
		{
			if(new_data > myBucketTable[index].val){
				myBucketTable[index].next = newHashNode;
			}
			else{
				newHashNode.next = myBucketTable[index];
				myBucketTable[index] = newHashNode;
			}
		}
		else
		{
			//if the new data is lesser than the head node
			if(new_data <= myBucketTable[index].val){
				newHashNode.next = myBucketTable[index];
				myBucketTable[index] = newHashNode;
			}
			else
			{
			    while(temp != null && new_data > temp.val)
					{
						prev = temp;
						temp = temp.next;
						if(prev.next == null)
						{
							prev.next = newHashNode;
							return;
						}
						if(new_data <= temp.val){	
						prev.next = newHashNode;
						newHashNode.next = temp;
					   }
					}
				}
			}
	    }
	
	//deleting from the hash table
	public void delete(int data)
	{
		int index = hashFunction(data);
		HashNode temp = myBucketTable[index], prev = temp; 

   		// If head node itself holds the key or multiple occurrences of data
    	while(temp != null && temp.val == data)
    	{
    		myBucketTable[index] = temp.next;   
        	temp = myBucketTable[index];        // Change Temp
	    }
 
    	// Delete occurrences other than head
    	while(temp != null)
    	{
        	while (temp != null && temp.val != data)
        	{
            	prev = temp;
            	temp = temp.next;
       		 }
 
        	if (temp == null) return;

        	prev.next = temp.next;
 
        	temp = prev.next;
        }
		
	}
	
	public boolean search(int data)
	{
		int index  = hashFunction(data);
		HashNode temp = myBucketTable[index];
		if(myBucketTable[index] == null)
			return false;
		if(myBucketTable[index].val > data)
			return false;
		while(temp != null)
		{
			if(temp.val == data){
			return true;
			}
			temp = temp.next;
		}
		return false;
	}


	int hashFunction(Integer val)
	{
        int index = val % myBucketTable.length;
        if (index < 0)

            index += myBucketTable.length;

        return index;
	}
	
	int countAndDisplayHashTable()
	{
		HashNode temp;
		int count = 0;
		for(int i = 0;i<myBucketTable.length;i++)
		{
			System.out.print("Map "+ i + ": ");
			temp = myBucketTable[i];
			if(temp == null){ System.out.println(); continue;}
			else{
				while(temp.next != null){
					count++;
					System.out.print(temp.val + " --> ");
					temp = temp.next;
				}
				System.out.print(temp.val+ "\n");
				count++;
			}
		}
		return count;
	}

    //write the changed hash table into file
    public int[] writeChangedDataToFile(int size)
    {
    	int writeData[] = new int[size];
        int k = 0;
		HashNode temp;
		for(int i = 0;i<myBucketTable.length;i++)
		{
			temp = myBucketTable[i];
			if(temp == null){ System.out.println(); continue;}
			else{
				while(temp.next != null){
					writeData[k++] = temp.val;
					temp = temp.next;
				}
			writeData[k++] = temp.val;
			}
		}
		return writeData;
    }
}

















