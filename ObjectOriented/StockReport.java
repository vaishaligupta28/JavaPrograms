package IntellectTraining.JavaPractise.ObjectOriented;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class StockReport
{
	public static void main(String[] args)
	{
		int total = 0;
		JSONParser parser = new JSONParser();

		try{
			JSONObject obj = (JSONObject)parser.parse(new FileReader("IntellectTraining/JavaPractise/ObjectOriented/stocks.json"));

			System.out.println("The total number of stocks: "+  Integer.parseInt(String.valueOf(obj.get("num_of_stocks"))));
			JSONArray type = (JSONArray)obj.get("stocks");
			for(Object oo : type)
			{
				JSONObject innerObj = (JSONObject)oo;

				String name = (String)innerObj.get("name");
				Integer num_of_shares = Integer.parseInt(String.valueOf(innerObj.get("num_of_shares")));;
				Integer share_price = Integer.parseInt(String.valueOf(innerObj.get("share_price")));;
				total +=num_of_shares*share_price;
				System.out.println("\nName : "+ name +"\nNumber of shares : "+ num_of_shares +"\nShare Price: "+ share_price);
				System.out.println("The total value of each stock:" + (num_of_shares*share_price));
			}
			System.out.println("\nThe total value of all stocks: "+ total+ "\n");
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
}
