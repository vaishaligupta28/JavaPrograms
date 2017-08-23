package IntellectTraining.JavaPractise.ObjectOriented;
	
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CliniqueManagement {

	private static String filename = "IntellectTraining/JavaPractise/ObjectOriented/cliniqueData.json";
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Clinique clinique = new Clinique(filename);
		ArrayList<Doctor> dList= null;
		ArrayList<Patient> pList=null;;
		HashMap<DoctorAppointment, Integer> hMap = new HashMap<DoctorAppointment, Integer>();
		clinique.saveToList();
		char reinitiate;

		Utility.displayList(clinique.doctorArrList);

		System.out.println("\n**************CLINIQUE MANAGEMENT******************");
		
        do{
        	reinitiate = 'N';
			System.out.println("\nChoose an operation:  ");
			System.out.println("1.Search for doctors.\n2.Search for patients.\n3.Make an " +
				"appointment.\n4.Print the Doctor Patient Report.\n5.Exit.");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1:
					  char flag = 'N';
				      do{
				      	System.out.println("1.Search by ID.\n2.Search by Name.\n3.Search by "+ 
				      		"Specialization\n4.Search by Availability\n5.Exit");
				      	System.out.println("Enter your choice.");
				      	int ch = sc.nextInt();
				      	dList = null;
				      	switch(ch)
				      	{
				      		case 1:
				      			  System.out.println("Enter the id: ");
				      			  int docId = sc.nextInt();
				      		      dList = SearchUtility.searchDocById(clinique.doctorArrList, docId);
				      		      Utility.displayList(dList);
				      		      break;
				      		case 2:
				      			  System.out.println("Enter the name: ");
				      			  String docName = sc.next();
				      		      dList = SearchUtility.searchDocByName(clinique.doctorArrList, docName);
				      		      Utility.displayList(dList);
				      		      break;
				      		case 3:
				      			  System.out.println("Enter the specialization: ");
				      			  String spec = sc.next();
				      		      dList = SearchUtility.searchDocBySpec(clinique.doctorArrList, spec);
				      		      Utility.displayList(dList);
				      		      break;
				      		case 4:
				      			  System.out.println("Enter the availability: ");
				      			  String avail = sc.next();
				      		      dList = SearchUtility.searchDocByAvail(clinique.doctorArrList, avail);
				      		      Utility.displayList(dList);
				      		      break;
				      		case 5:
				      			break;			      	 
				      	}
				      	System.out.println("Do you want to continue searching doctors(y/n)?");
				      	flag = sc.next().toUpperCase().charAt(0);
				      }
				      while(flag == 'Y');
				      break;

				case 2:
					  flag = 'N';
				      do{
				      	System.out.println("1.Search by ID.\n2.Search by Name.\n3.Search by"+ 
				      		"Mobile Number. \n4.Exit");
				      	System.out.println("Enter your choice.");
				      	int ch = sc.nextInt();
		                pList = null;
				      	switch(ch)
				      	{
				      		case 1:
				      			  System.out.println("Enter the id: ");
				      			  int patId = sc.nextInt();
				      		      pList = SearchUtility.searchPatById(clinique.patientArrList, patId);
				      		      Utility.displayList(pList);
				      		      break;
				      		case 2:
				      			  System.out.println("Enter the name: ");
				      			  String patName = sc.next();
				      			  pList = SearchUtility.searchPatByName(clinique.patientArrList, patName);
				      		      Utility.displayList(pList);
				      		      break;
				      		case 3:
				      			  System.out.println("Enter the mobile number: ");
				      			  String mob = sc.next();
				      		      pList = SearchUtility.searchPatByMob(clinique.patientArrList, mob);
				      		      Utility.displayList(dList);
				      		      break;
				      		case 4:
				      			break;		      	 
				      	}
				      	System.out.println("Do you want to continue searching patients(y/n)?");
				      	flag = sc.next().toUpperCase().charAt(0);
				      }
				      while(flag == 'Y');
				      break;
				      
				case 3:
					  int id = 0;
					  Date inpDate = null;
					  boolean doSetAnotherDate;
					  System.out.println("Enter the (Doctor's ID/date) for whom you wish to schedule appoitment.");
					  boolean isNotValidDocId = true;
					  //validating doc ID
					  System.out.print("Id: ");
					  while(isNotValidDocId)
					  {
						  id = sc.nextInt();					  
						  if(SearchUtility.searchDocById(clinique.doctorArrList, id) == null)
						  {
							  System.out.println("Sorry!!Doctor with Id"+ id + "does not exists.\nPlease enter correct Doctor Id: ");
						  }
						  else
							  isNotValidDocId = false;
					  }
					  do{
					  	doSetAnotherDate = false;
					 	boolean isDateValid = true;
					  	//validating date
					  	System.out.print("Date of appointment(mm-dd-YYYY): ");
					  	while(isDateValid){
						  	inpDate = Utility.parseDate(sc.next());
					      	if(inpDate == null)
					      	{
					    	  	System.out.println("Wrong date format!Re-Enter the date!!");
							 	System.out.print("Date of appointment(mm-dd-YYYY):  ");
					    	}
					      	else
					    	 	isDateValid = false;
					  		}
					  	
					  	//Checking for availability
					    int appointments = 0;;
					    int totAppointments = 0;
						DoctorAppointment newAppoint = new DoctorAppointment(id, inpDate);
						System.out.println(hMap.containsKey(newAppoint));
					  	if(hMap.containsKey(newAppoint))
					  	{
					  		System.out.println("*****");
						 	appointments = hMap.get(newAppoint); 
                            totAppointments = appointments + 1;
						 	if(appointments < 5)
						  	{
								hMap.put(newAppoint, totAppointments);
						  	}
						    else
						  	{
							  	System.out.println("Doctor with DocID: "+ newAppoint.getId() +" is occupied for the day.\nSchedule for some other date.\n");
							  	doSetAnotherDate = true;
						  	}
					  	}
					  	else
					  	{
					  		hMap.put(newAppoint, 1);	
					  	}
				 	 }
				 	 while(doSetAnotherDate);
				 	 break;

				case 4:
				      System.out.println("\n*********************DOCTOR PATIENT REPORT******************\n");
				      Utility.displayHashmap(hMap); 
				      System.out.println();
				      break;
				case 5:
				      System.out.println();
				      System.out.println("Most Popular Doctor:  ");
				      Utility.searchPopularityById(hMap, clinique.doctorArrList);
				      System.out.println("Most Popular Specialization:  ");
				      Utility.searchPopularityBySpec(hMap, clinique.doctorArrList);
				      System.exit(0);
			}
			System.out.println("Do you want to continue searching(y/n) ?");
			reinitiate = sc.next().toUpperCase().charAt(0);
		}
		while(reinitiate == 'Y');
	}
}


class Doctor {
	int doc_id;
	String doc_name;
	String spec;
	String avail;
	Doctor()
	{}
	void setId(int doc_id)
	{
		this.doc_id = doc_id;
	}
	void setName(String doc_name)
	{
		this.doc_name = doc_name;
	}
	void setSpec(String spec)
	{
		this.spec = spec;
	}
	void setAvail(String avail)
	{
		this.avail = avail;
	}
	int getId()
	{
		return doc_id;
	}
	String getName()
	{
		return doc_name;
	}
	String getSpec()
	{
		return spec;
	}
	String getAvail()
	{
		return avail;
	}
}


class Patient {
	int patient_id;
	int age;
	String patient_name;
	String mob;
	Patient()
	{}
	void setId(int patient_id)
	{
		this.patient_id = patient_id;
	}
	void setAge(int age)
	{
		this.age = age;
	}
	void setName(String patient_name)
	{
		this.patient_name = patient_name;
	}
	void setMob(String mob)
	{
		this.mob = mob;
	}
	int getId()
	{
		return patient_id;
	}
	int getAge()
	{
		return age;
	}
	String getName()
	{
		return patient_name;
	}
	String getMob()
	{
		return mob;
	}
}


class DoctorAppointment {
	Integer docId;
	Date date;
	DoctorAppointment(int docId, Date date)
	{
		this.docId = docId;
		this.date= date;
	}
	void setId(int docId)
	{
		this.docId = docId;
	}
	void setDate(Date date)
	{
		this.date = date;
	}
	int getId()
	{
		return docId;
	}
	Date getDate()
	{
		return date;
	}

	@Override
    public int hashCode() {
    	//System.out.println(docId.hashCode()+ date.hashCode() + "   333333");
        return docId.hashCode() + date.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        DoctorAppointment docAppoint = (DoctorAppointment) obj;
        //System.out.println((docAppoint.getId() == this.docId)  + "----------");
        //System.out.println("****");
       // System.out.println((docAppoint.getDate().equals(this.date))  + "/////////");
        return docAppoint.getId() == this.docId  && docAppoint.getDate().equals(this.date);
    }
}


class Clinique {
	@SuppressWarnings("unused")
	private File file;
	private JSONParser parser;
	private JSONObject jsonObj;
	protected ArrayList<Doctor> doctorArrList;
	protected ArrayList<Patient> patientArrList;
	
	Clinique(String filename)
	{
		try{
			file = new File(filename); 
			parser = new JSONParser();			
			doctorArrList = new ArrayList<Doctor>();
			patientArrList = new ArrayList<Patient>();
			try{
			jsonObj = (JSONObject)parser.parse(new FileReader(filename));
		    }
		    catch(ParseException e)
		    {System.out.println(e);}
		}
		catch(FileNotFoundException e){
			System.out.println(e);
		}
		catch (IOException e) {
            e.printStackTrace();
        } /*catch (ParseException e) {
            e.printStackTrace();
        }*/
	}

	//save the json data to array list
	void saveToList()
	{
		JSONObject innerObj;
		//System.out.println(jsonObj.get("stocks"));
		JSONArray doctorArr = (JSONArray)jsonObj.get("doctorList");
		JSONArray patientArr = (JSONArray)jsonObj.get("patientList");

		for(Object oo : doctorArr)
		{
			Doctor newDoc = new Doctor();
			innerObj = (JSONObject)oo;
			int id = Integer.parseInt(String.valueOf(innerObj.get("id")));
			newDoc.setId(id);
			String name = String.valueOf(innerObj.get("name"));
			newDoc.setName(name);
			String spec = String.valueOf(innerObj.get("spec"));
			newDoc.setSpec(spec);
			String avail = String.valueOf(innerObj.get("avail"));
			newDoc.setAvail(avail);
			doctorArrList.add(newDoc);
		}
		for(Object oo : patientArr)
		{
			Patient newPatient = new Patient();
			innerObj = (JSONObject)oo;
			int id = Integer.parseInt(String.valueOf(innerObj.get("id")));
			newPatient.setId(id);
			int age = Integer.parseInt(String.valueOf(innerObj.get("age")));
			newPatient.setAge(age);
			String name = String.valueOf(innerObj.get("name"));
			newPatient.setName(name);
			String mobNum = String.valueOf(innerObj.get("mobNum"));
			newPatient.setMob(mobNum);
			patientArrList.add(newPatient);						
		}
	}
}




class SearchUtility {
	
	    //seaching doctor by id
		static ArrayList<Doctor> searchDocById(ArrayList<Doctor> myArrayList, int id)
		{
			ArrayList<Doctor> tempArrayList = new ArrayList<Doctor>();
			for(Doctor doctor: myArrayList)
			{
				if(doctor.getId() == id)
				{
					tempArrayList.add(doctor);
				}
			}
			return tempArrayList;
		}

		//searching doc by name
		static ArrayList<Doctor> searchDocByName(ArrayList<Doctor> myArrayList, String name)
		{
			ArrayList<Doctor> tempArrayList = new ArrayList<Doctor>();
			for(Doctor doctor: myArrayList)
			{
				if((doctor.getName()).equalsIgnoreCase(name))
				{
					tempArrayList.add(doctor);
				}
			}
			return tempArrayList;
		}

		//searching doctor by spec
		static ArrayList<Doctor> searchDocBySpec(ArrayList<Doctor> myArrayList, String spec)
		{
			ArrayList<Doctor> tempArrayList = new ArrayList<Doctor>();
			for(Doctor doctor: myArrayList)
			{
				if((doctor.getSpec()).equalsIgnoreCase(spec))
				{
					tempArrayList.add(doctor);
				}
			}
			return tempArrayList;
		}

		//searching doctor by availability
		static ArrayList<Doctor> searchDocByAvail(ArrayList<Doctor> myArrayList, String avail)
		{
			ArrayList<Doctor> tempArrayList = new ArrayList<Doctor>();
			for(Doctor doctor: myArrayList)
			{
				if((doctor.getAvail().equalsIgnoreCase(avail)))
				{
					tempArrayList.add(doctor);
				}
			}
			return tempArrayList;
		}

		//searching patient by id
		static ArrayList<Patient> searchPatById(ArrayList<Patient> myArrayList, int id)
		{
			ArrayList<Patient> tempArrayList = new ArrayList<Patient>();
			for(Patient patient: myArrayList)
			{
				if(patient.getId() == id)
				{
					tempArrayList.add(patient);
				}
			}
			return tempArrayList;
		}

		//serching patient by name
		static ArrayList<Patient> searchPatByName(ArrayList<Patient> myArrayList, String name)
		{
			ArrayList<Patient> tempArrayList = new ArrayList<Patient>();
			for(Patient patient: myArrayList)
			{
				if((patient.getName()).equalsIgnoreCase(name))
				{
					tempArrayList.add(patient);
				}
			}
			return tempArrayList;
		}

		//seaching patients by mobile number
		static ArrayList<Patient> searchPatByMob(ArrayList<Patient> myArrayList, String mob)
		{
			ArrayList<Patient> tempArrayList = new ArrayList<Patient>();
			for(Patient patient: myArrayList)
			{
				if((patient.getMob()).equalsIgnoreCase(mob))
				{
					tempArrayList.add(patient);
				}
			}
			return tempArrayList;
		}
}



class Utility
{
	static Date parseDate(String date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		try {
			return sdf.parse(date);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	static String formatDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		return sdf.format(date);
	}
	static void displayList(ArrayList<?> myArrayList)
	{
		for(Object o: myArrayList)
		{
			if(o instanceof Doctor)
			{   
			    Doctor doc = (Doctor)o;
				System.out.println("[Id: "+ doc.getId() + "\nName: "+ doc.getName()+ "\nSpecialization: " + doc.getSpec() + "\nAvailability: "+ doc.getAvail()+"]");
				System.out.println();
			}
			else
			{
				Patient pat = (Patient)o;
				System.out.println("[Id: "+ pat.getId() + "\nName: "+ pat.getName()+ "\nAge: " + pat.getAge() + "\nMobile Number: "+ pat.getMob()+"]");
				System.out.println();
			}
		}
	}
	static void displayHashmap(HashMap<DoctorAppointment,Integer> myHashMap)
	{
		int k=1;
		System.out.println("    Doctor ID " + "    Date of Appointment "+ "    Total Appointments ");
		for(DoctorAppointment appoint: myHashMap.keySet())
		{
			System.out.print("      "+ appoint.getId());
			System.out.print("               "+formatDate(appoint.getDate()));
			System.out.print("                   "+ myHashMap.get(appoint).toString());
			System.out.println();
		}
	}

	static void searchPopularityById(HashMap<DoctorAppointment,Integer> myHashMap, ArrayList<Doctor> myArrayList)
	{
		Integer max = 1;
		int id = 0;
		ArrayList<Doctor> tempList = null;
		for(DoctorAppointment appoint: myHashMap.keySet())
		{
			if(myHashMap.get(appoint) >= max){
				max = myHashMap.get(appoint);  //calculating maximum patients in which 
				id =  appoint.getId();
			}
		}
		System.out.println(id);
		tempList = SearchUtility.searchDocById(myArrayList, id);
		System.out.println(tempList.get(0).getName());//will return the name of the Doctor
	}

	static void searchPopularityBySpec(HashMap<DoctorAppointment,Integer> myHashMap, ArrayList<Doctor> myArrayList)
	{
		String spec = "";
		HashMap<String ,Integer> specHashMap = new HashMap<String,Integer>();
		ArrayList<Doctor> tempList = null;
		Integer totAppointments = 0, appointments;
		for(DoctorAppointment appoint: myHashMap.keySet())
		{
			int id = appoint.getId();
			appointments = myHashMap.get(appoint);
			tempList = SearchUtility.searchDocById(myArrayList, id);
			spec = (tempList.get(0)).getSpec();
			if(!specHashMap.containsKey(spec))
			{
				totAppointments = appointments;
				specHashMap.put(spec, totAppointments);
			}
			else
			{
				totAppointments +=appointments;
				specHashMap.put(spec, totAppointments);
			}
		}
		//now i have the mapping of specialization to number of appointments, finding the specialization with max appointments
		Integer max = 1;
		for(String str: specHashMap.keySet())
		{
			if(specHashMap.get(str) >= max)
			{
				max = specHashMap.get(str);
				spec = str;
			}
		}
		System.out.println(spec);
	}
}