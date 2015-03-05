package menuGeneratorFormatter;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public abstract class IMenuGenerator
{
	ArrayList<String> restaurant_category =null;
	public LinkedHashMap generateMenu(ArrayList<LinkedHashMap<String, String>> fooditems,String country)
	{
		int k=0;
		while(k<fooditems.size())
		{
			if(!fooditems.get(k).containsValue(country)||!(restaurant_category.contains(fooditems.get(k).get("category"))))
			{
				fooditems.remove(k);
				k=0;
				continue;
				
			}
			k++;
		}
		LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>> generatedmenu = new LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>>();
		for(int j=0;j<restaurant_category.size();j++)
		{
			ArrayList<LinkedHashMap<String,String>> listofmenus= new ArrayList<LinkedHashMap<String,String>>();
			for(int i=0;i<fooditems.size();i++)
			{
				if(fooditems.get(i).get("category").equals(restaurant_category.get(j)))
				{
					LinkedHashMap<String,String> menudescription = new LinkedHashMap<String,String>();
					menudescription.put("-country", fooditems.get(i).get("-country"));
					menudescription.put("id", fooditems.get(i).get("id"));
					menudescription.put("name", fooditems.get(i).get("name"));
					menudescription.put("description", fooditems.get(i).get("description"));
					menudescription.put("category", fooditems.get(i).get("category"));
					menudescription.put("price", fooditems.get(i).get("price"));
					listofmenus.add(menudescription);
					
				}
			}
			generatedmenu.put(restaurant_category.get(j), listofmenus);
		}

		return generatedmenu;
	}

}
