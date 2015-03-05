package menuFormatterPackage;

public class MenuFormatterFactory
{
	public static IFormatter getOutputFormat(String format)
	{
		if(format.equals("3"))
			return new XMLFormatter();
		else if(format.equals("1"))
			return new PlainTextFormatter();
		else if(format.equals("2"))
			return new HTMLFormatter();
		return null;
	}

}
