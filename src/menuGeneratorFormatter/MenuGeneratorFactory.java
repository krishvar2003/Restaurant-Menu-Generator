package menuGeneratorFormatter;

public class MenuGeneratorFactory 
{
	public static IMenuGenerator getRestaurantCategory(String category)
	{
		if(category.equals("2"))
			return new AlldayMenu();
		else if(category.equals("1"))
			return new DinerMenu();
		else if(category.equals("3"))
			return new EveningMenu();
		return null;
	}
}
