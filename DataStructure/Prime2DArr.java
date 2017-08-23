import java.util.*;	
import utility.UtilityClass;
public class Prime2DArr
{
	public static void main(String[] args)throws NumberFormatException
	{
		System.out.println("\n\n      Prime Numbers in the range "+ 0 + "-" + 1000);
		ArrayList<String> li = UtilityClass.primeNumbers(0, 1000);
		int arr[][] = new int[30][10];
		//String arr[] = new String[li.size()];
		int range = 100;
		int i=0;
		int j = (range/100)-1;
		Iterator itr=li.iterator();  
		int data;

		//while(itr.hasNext())
			//System.out.println(itr.next());
  		
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
}
