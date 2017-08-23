import java.util.*;
import utility.UtilityClass;
public class AnagramicPrime2DArr
{
	public static void main(String[] args)
	{
		int arr[][] = new int[30][10];
		int range = 100;
		int i=0;
		int j = (range/100)-1;
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
  			//data = ;
  			data = Integer.valueOf(String.valueOf(itr.next()));
  			if(data > range){
   		    	range = range + 100;
   		    	j = (range/100)-1;
   		    	i=0;
   		    }
  			arr[i++][j] = data;
  		}

  		System.out.println("\n\n      Prime Anagarams in the range "+ 0 + "-" + 1000);	
  		System.out.println("\n      0-100" +  "  " + "100-200" +  "  " +"200-300" +  "  " +"300-400" +  "  " +"400-500" +  "  " +
  			"500-600" +  "  " + "600-700" +  "  " + "700-800" +  "  "+ "800-900" +  "  " + "900 - 1000");
  		for(i=0;j<30;i++)
  		{
  			for(j=0;j<10;j++){
  				if(arr[i][j] != 0){
  				    System.out.printf("%9d", arr[i][j]);
  				}
  				else{
  					System.out.print("         ");
  					continue;
  				}
  			}
  			System.out.println();
  		}
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
