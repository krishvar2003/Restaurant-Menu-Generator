package menuFormatterPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlainTextFormatter implements IFormatter
{
	public void createOutputFile(LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>> fooditems,String restaurant_type) throws IOException 
	{
		String type=null;
		if(restaurant_type.equals("1"))
			type="Diner";
		if(restaurant_type.equals("2"))
			type="AllDay";
		if(restaurant_type.equals("3"))
			type="Evening";
		String Country = fooditems.get("Appetizer").get(0).get("-country");
		String currency= null;
		if(Country.equals("US"))
			currency="$";
		if(Country.equals("GB"))
			currency="GBP";
		StringBuilder formatmenu = new StringBuilder();
		formatmenu.append("Menu");
		formatmenu.append(System.getProperty("line.separator"));
		formatmenu.append(System.getProperty("line.separator"));
		for(Map.Entry<String, ArrayList<LinkedHashMap<String,String>>> entry : fooditems.entrySet())
		{
			formatmenu.append(entry.getKey().toUpperCase());
			formatmenu.append(System.getProperty("line.separator"));
			formatmenu.append(System.getProperty("line.separator"));
			for(LinkedHashMap<String,String> getmenus:entry.getValue())
			{
				formatmenu.append(getmenus.get("name"));
				formatmenu.append(String.format("%-30s",""));
				formatmenu.append(" "+currency+" "+getmenus.get("price"));
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(getmenus.get("description"));
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(System.getProperty("line.separator"));
			}
		}
		String filename=Country+"-Menu-"+type;
		System.out.println("Enter the path to save your file");
		Scanner in = new Scanner(System.in);
		String path = in.nextLine();
		File f=new File(path.toString()+filename+".txt");
		try
		{
			FileWriter fwriter = new FileWriter(f);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write(formatmenu.toString());
			bwriter.close();
		}
		catch (Exception e)
		{
			System.out.println("File write exception");
		}

	}

}
