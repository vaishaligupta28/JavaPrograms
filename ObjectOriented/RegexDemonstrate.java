package IntellectTraining.JavaPractise.ObjectOriented;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;  
import java.util.Scanner;  
import java.util.regex.Matcher;    
class RegexDemonstrate
{
	private static final String FILENAME = "file2.txt";
	public static void main(String[] args)throws IOException
	{
		String firstName, lastName, mobileNum, date;
		String readData[];
		String defaultString = "Hello <<name>>, We have your full"+
					"name as <<full name>> in our system. Your contact number is 91xxxxxxxxxx."+
					"Please,let us know in case of any clarification. Thank you BridgeLabz mm/dd/yyyy.";

		writeDataToFile(defaultString);

		User user = new User();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter First Name: ");
		firstName = sc.next();
		System.out.println("Enter Last Name: ");
		lastName = sc.next();
		System.out.println("Enter Mobile Number: ");
		mobileNum = sc.next();
		date = dateFormat();
		user.setInfo(firstName, lastName, mobileNum, date);

		writeDataToFile(convertString(defaultString, user));

		System.out.println("\n");

		readData = readDataFromFile();
		for(String str: readData)
			System.out.print(str + " ");

		System.out.println("\n");

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

	static String dateFormat()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String date = String.valueOf(dtf.format(localDate));
		return date;
	}

	static String convertString(String data, User newUser)
	{
		Matcher m;
		Pattern pattern;
		pattern = Pattern.compile("<<name>>");
		m = pattern.matcher(data);
		data = m.replaceAll(newUser.getFirstName());

		pattern = Pattern.compile("<<full name>>");
		m = pattern.matcher(data);
		data = m.replaceAll(newUser.getFirstName() + " "+ newUser.getLastName());

		pattern = Pattern.compile("xxxxxxxxxx");
		m = pattern.matcher(data);
		data = m.replaceAll(newUser.getMobileNum());

		pattern =  Pattern.compile("mm/dd/yyyy");
		m = pattern.matcher(data);
		data = m.replaceAll(newUser.getDate());
		return data;
	}
}

class User
{
	private String firstName,lastName, mobileNum, date; 
	User()
	{
		firstName = "Vaishali";
		lastName = "Gupta";
		mobileNum = "9635904585";
		date = "01/02/2016";
	}

	void setInfo(String firstName, String lastName, String mobileNum, String date)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNum = mobileNum;
		this.date = date;
	}
	String getFirstName()
	{
		return firstName;
	}
	String getLastName()
	{
		return lastName;
	}
	String getMobileNum()
	{
		return mobileNum;
	}
	String getDate()
	{
		return date;
	}
}
