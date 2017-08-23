package IntellectTraining.JavaPractise.ObjectOriented;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommercialDataProcessing {

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		String symbol;
		Integer amt;
		Scanner sc;
		String filename = "IntellectTraining/JavaPractise/ObjectOriented/stocks.json";
		// StockAccount stockAccount = new StockAccount(filename);	
		LinkedListStockAccount stockAccount = new LinkedListStockAccount(filename);
		stockAccount.saveToLinkedList();
		while(true)
		{
			sc = new Scanner(System.in);
			System.out.println("\nChoose the operation: \n>Press 1 to buy the stocks\n>Press 2 to sell the stocks\n>Press any other to exit");
			int choice = sc.nextInt();

			switch(choice)
			{
				case 1 : 
				       System.out.println("Enter the company whose stocks you want to buy: ");
				       symbol = sc.next();
				       System.out.println("Enter the number of units to buy: ");
				       amt = sc.nextInt();
				       stockAccount.buy(amt, symbol);
				       //stockAccount.save();
				       System.out.println("\n\nAfter buying, the list looks like:  ");
				       stockAccount.list.displayList();			       
				       break;
				case 2:
				       System.out.println("Enter the company whose stocks you want to sell: ");
				       symbol = sc.next();
				       if((stockAccount.list.searchAccount(symbol)).num_of_shares > 0){
				       	System.out.println("Enter the number of units to sell: ");
				       	amt = sc.nextInt();
				       	stockAccount.sell(amt, symbol);
				       	//stockAccount.save();
				       	System.out.println("\n\nAfter selling, the list looks like:  ");
				       	stockAccount.list.displayList();
				       }
				       else
				       	System.out.println("Sorry!!No more units left.");
				       break;
				default:
				       stockAccount.saveToFile();
				       stockAccount.printReport();
				       System.out.println("\n\nTHE TRASACTION amounts are as:   ");
				       stockAccount.stack.display();
				       System.out.println("\n\nTHE DATE AND TIME OF TRANSACTION ARE:  ");
				       stockAccount.queue.display();
				       System.exit(0); 
			}
		}	
   	}
}



class LinkedListStockAccount {
	File file;
	private JSONParser parser;
	private JSONObject jsonObj;
	protected LinkedList list;
	protected Stack stack;
	protected Queue queue;
	LinkedListStockAccount(String filename)
	{
		try{
			file = new File(filename); 
			parser = new JSONParser();
			jsonObj = (JSONObject)parser.parse(new FileReader(filename));
			list = new LinkedList();
			stack = new Stack();
			queue = new Queue();
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}

	
	void buy(int amount, String symbol)
	{
		Account account = list.addShares(amount, symbol);
		stack.push(amount, symbol);
		queue.enqueue(symbol, account.date_and_time);
	}

	
	void sell(int amount, String symbol)
	{
		Account account = list.subtractShares(amount, symbol);
		stack.push(amount, symbol);
		queue.enqueue(symbol, account.date_and_time);
	}

	//save the changes in the json file
	@SuppressWarnings("unchecked")
	void saveToFile()
	{
		FileWriter fw = null ;
		String symbol, date_and_time;
		int num_of_shares, share_price;
		Account tempAccount = list.startAccount;
		JSONObject innerObj;
		JSONArray type = (JSONArray)jsonObj.get("stocks");
		
		for(Object oo : type)
		{
			innerObj = (JSONObject)oo;
			symbol = list.getSymbol(tempAccount);
			date_and_time = list.getDateNTime(tempAccount);
			num_of_shares = list.getShares(tempAccount);
			share_price = list.getSharePrice(tempAccount);
			
			innerObj.put("symbol", symbol);
			innerObj.put("num_of_shares", num_of_shares);
			innerObj.put("date_and_time", date_and_time);
			innerObj.put("share_price", share_price);
			tempAccount = tempAccount.nextAccount;
		 }
		try{
        	fw = new FileWriter(file);
        	fw.write(jsonObj.toJSONString());
        	System.out.println("Successfully saved to file!!");
        	fw.flush();
        	fw.close();
        }
        catch(FileNotFoundException e)
        {
        	System.out.println(e);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	  }
	
	//save the json data to linked list
	void saveToLinkedList()
	{
		JSONObject innerObj;
		//System.out.println(jsonObj.get("stocks"));
		JSONArray stocks = (JSONArray)jsonObj.get("stocks");

		for(Object oo : stocks)
		{
			innerObj = (JSONObject)oo;
			String accSymbol = String.valueOf(innerObj.get("symbol"));
			int num_of_shares = Integer.parseInt(String.valueOf(innerObj.get("num_of_shares")));
			String date_and_time = String.valueOf(innerObj.get("date_and_time"));
			int share_price = Integer.parseInt(String.valueOf(innerObj.get("share_price")));
			list.insertAccount(accSymbol, num_of_shares, date_and_time, share_price);
		}
	}
	
	//print the changed json file
	void printReport()
	{
		JSONArray type = (JSONArray)jsonObj.get("stocks");
		for(Object oo : type)
		{
			JSONObject innerObj = (JSONObject)oo;

			String symbol = (String)innerObj.get("symbol");
			Integer num_of_shares = Integer.parseInt(String.valueOf(innerObj.get("num_of_shares")));
			Integer share_price = Integer.parseInt(String.valueOf(innerObj.get("share_price")));
			String date_and_time = String.valueOf(innerObj.get("date_and_time")); 
				System.out.println("\nName of stock : "+ symbol +"\nNumber of shares : "+ num_of_shares +"\nShare Price: "+ share_price+"\nDate/Time of Transaction: "+ date_and_time);
			System.out.println("The total value of each stock:" + (num_of_shares*share_price));
		}
	}
}


class DateNTime
{
	public static String dateFormat() {
	    SimpleDateFormat sdfDate = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");//dd/MM/yyyy
	    Date now = new Date();
	    String strDate = sdfDate.format(now);
	    return strDate;
	}
}



class Account
{
	String symbol;
	int num_of_shares;
	String date_and_time;
	int share_price;
	Account nextAccount;
	Account(String symbol, int num_of_shares, String date_and_time, int share_price)
	{
		this.symbol = symbol;
		this.num_of_shares = num_of_shares;
		this.date_and_time = date_and_time;
		this.share_price = share_price;
		this.nextAccount = null;
	}
}

//Linked List Operations
class LinkedList {
	Account startAccount;
	LinkedList()
	{
		startAccount = null;
	}
	
	String getSymbol(Account acc)
	{
		return acc.symbol;
	}
	
	int getShares(Account acc)
	{
		return acc.num_of_shares;
	}
	
	String getDateNTime(Account acc)
	{
		return acc.date_and_time;
	}
	
	int getSharePrice(Account acc)
	{
		return acc.share_price;
	}

	//inserting node
	public void insertAccount(String symbol, int num_of_shares, String date_and_time, int share_price )
	{
		Account tempAccount = startAccount;
		Account new_node = new Account(symbol, num_of_shares, date_and_time, share_price);
		new_node.nextAccount = null;
		
		if(startAccount == null)
		{
			new_node.nextAccount = startAccount;
			startAccount = new_node;
		}
		else
		{
			while(tempAccount.nextAccount != null)
				{tempAccount = tempAccount.nextAccount;}
			tempAccount.nextAccount = new_node;
		}
	}

	//searching the account
	public Account searchAccount(String symbol)
	{
		Account tempAccount = startAccount;
		while(tempAccount != null)
		{
			String checkdata = tempAccount.symbol;
			if(checkdata.equalsIgnoreCase(symbol)){
				return tempAccount;
			}
			tempAccount = tempAccount.nextAccount;
		}
		return tempAccount;
	}
	
	//add shares to the account
	public Account addShares(int amount, String symbol)
	{
		Account account = searchAccount(symbol);
		account.num_of_shares += amount;
		account.date_and_time = DateNTime.dateFormat();
		return account;
	}
	
	//delete shares from account
	public Account subtractShares(int amount, String symbol)
	{
		Account account = searchAccount(symbol);

		if(account.num_of_shares >= amount){
			account.num_of_shares -= amount;
			account.date_and_time = DateNTime.dateFormat();
		}
		else{
			System.out.println("Cannot sell extra " + (amount - account.num_of_shares)+" units!!!");
			account.num_of_shares = 0;
			account.date_and_time = DateNTime.dateFormat();
		}
		return account;
	}
	
	public void displayList()
	{
		Account tempAccount = startAccount;
		while(tempAccount != null)
		{
			System.out.println("[Symbol: "+ tempAccount.symbol + ", "+"Num of shares: "+ tempAccount.num_of_shares + ", "+"Date And Time: "+ tempAccount.date_and_time + ", "+"Share price: "+ tempAccount.share_price+ "]" );
			tempAccount = tempAccount.nextAccount;
		}
	}
}


class Transaction
{
	String symbol;
	int amount;
	Transaction nextTransaction;
	Transaction(int amount, String symbol)
	{
		this.symbol = symbol;
		this.amount = amount;
		this.nextTransaction = null;
	}
}

//Stack operations
class Stack
{
	Transaction startTransaction, topTransaction;
	Stack()
	{
		startTransaction = null;
		topTransaction = null;
	}

	boolean isEmpty()
	{
		if(startTransaction == null)
			return true;
		return false;
	}

	void push(int amount, String symbol)
	{
		Transaction newTransaction = new Transaction(amount, symbol);
		//Node temp;
		if(isEmpty())
		{
			newTransaction.nextTransaction = startTransaction;
			startTransaction = newTransaction;
		}
		else
		{
			//temp = top;
			topTransaction.nextTransaction = newTransaction;
		}	
		topTransaction = newTransaction;
	}

	void display()
	{
		Transaction tempTransaction = startTransaction;
		while(tempTransaction.nextTransaction != null)
		{
			System.out.print("["+ tempTransaction.symbol + ", "+ tempTransaction.amount+ "]" + " --> ");
			tempTransaction = tempTransaction.nextTransaction;
		}
		System.out.print("["+ tempTransaction.symbol + ", "+ tempTransaction.amount+ "]" + "\n");
	}
}



class QueueNode
{
	String symbol;
	String date_and_time;
	QueueNode next;
	QueueNode(String symbol, String date_and_time)
	{
		this.symbol = symbol;
		this.date_and_time = date_and_time;
		this.next = null;
	}
}


//Queue Operations
class Queue
{
	QueueNode front, rear;
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

	void enqueue(String symbol, String date_and_time)
	{
		QueueNode new_node = new QueueNode(symbol, date_and_time);
		if(isEmpty())
		{
			front = new_node;
		}
		else
		{
			rear.next = new_node;
		}	
		rear = new_node;
	}

	void display()
	{ 
		QueueNode temp = front;
		while(temp != rear){
			System.out.print("["+ temp.symbol + ", "+ temp.date_and_time + "]" + " --> ");
			temp = temp.next;
		}
		System.out.print("["+ temp.symbol + ", "+ temp.date_and_time + "]" + "\n");
	}
}

