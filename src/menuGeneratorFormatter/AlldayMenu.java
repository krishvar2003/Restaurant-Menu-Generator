package menuGeneratorFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlldayMenu extends IMenuGenerator 
{
	public AlldayMenu()
	{
		restaurant_category= new ArrayList<String>();
		restaurant_category.add("Breakfast");
		restaurant_category.add("Snack");
		restaurant_category.add("Appetizer");
		restaurant_category.add("Lunch");
		restaurant_category.add("Dinner");
		restaurant_category.add("Dessert");
		restaurant_category.add("Side Dish");
	}
}
