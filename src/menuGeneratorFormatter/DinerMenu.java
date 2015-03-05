package menuGeneratorFormatter;

import java.util.ArrayList;
import java.util.HashMap;

public class DinerMenu extends IMenuGenerator
{
	public DinerMenu()
	{
		restaurant_category= new ArrayList<String>();
		restaurant_category.add("Breakfast");
		restaurant_category.add("Snack");
		restaurant_category.add("Appetizer");
		restaurant_category.add("Lunch");
		restaurant_category.add("Dessert");
	}
	
}
