package IntellectTraining.JavaPractise.ObjectOriented;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
class InventoryManagement
{
	public static void main(String[] args)
	{
		JSONParser parser = new JSONParser();

		try{
			JSONObject obj = (JSONObject)parser.parse(new FileReader("IntellectTraining/JavaPractise/ObjectOriented/inventory.json"));

			JSONArray type = (JSONArray)obj.get("type");
			for(Object oo : type)
			{
				JSONObject innerObj = (JSONObject)oo;

				String name = (String)innerObj.get("name");
				Double weight = Double.parseDouble(String.valueOf(innerObj.get("weight")));;
				Integer price_per_kg = Integer.parseInt(String.valueOf(innerObj.get("price_per_kg")));;
				System.out.println("\nName : "+ name +"\nWeight : "+ weight +"\nPrice/kg: "+ price_per_kg);
				System.out.println();
			}
			System.out.println();
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
