package menuGeneratorFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EveningMenu extends IMenuGenerator
{
	public EveningMenu()
	{
		restaurant_category= new ArrayList<String>();
		restaurant_category.add("Appetizer");
		restaurant_category.add("Dinner");
		restaurant_category.add("Dessert");
		restaurant_category.add("Side Dish");
	}
	
}

