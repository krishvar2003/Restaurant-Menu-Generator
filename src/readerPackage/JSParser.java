package readerPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSParser implements IReader
{

	public ArrayList ReaderParser(File file) 
	{
		JSONParser parser = new JSONParser();
		ArrayList<LinkedHashMap<String,String>> menuitems = new ArrayList<LinkedHashMap<String,String>>();
		try
		{
			JSONObject jsonObject =  (JSONObject) parser.parse(new FileReader(file.toString()));
			
			JSONArray fooditems= (JSONArray) jsonObject.get("FoodItemData");
			Iterator iter = fooditems.iterator();
			while (iter.hasNext())
			{
				JSONObject innerObj = (JSONObject) iter.next();
				LinkedHashMap<String,String> items = new LinkedHashMap<String,String>();
				items.put("-country", innerObj.get("-country").toString());
				items.put("id", innerObj.get("id").toString());
				items.put("name", innerObj.get("name").toString());
				items.put("price", innerObj.get("price").toString());
				items.put("description", innerObj.get("description").toString());
				items.put("category", innerObj.get("category").toString());
				
				menuitems.add(items);
			}

		}
		catch (ParseException e) 
		{
		    System.out.println("File not supported");
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found");
		} 
		catch (IOException e)
		{
			System.out.println("Exception in Input or output");
		} 
		catch (NullPointerException e) 
		{
			System.out.println("File not found");
		}

		return menuitems;
	}

}
