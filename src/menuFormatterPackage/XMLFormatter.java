package menuFormatterPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class XMLFormatter implements IFormatter
{

	public void createOutputFile(LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>> fooditems,String restaurant_type) 
	{
		String type=null;
		if(restaurant_type.equals("1"))
			type="Diner";
		if(restaurant_type.equals("2"))
			type="AllDay";
		if(restaurant_type.equals("3"))
			type="Evening";
		StringBuilder formatmenu = new StringBuilder();
		String Country = fooditems.get("Appetizer").get(0).get("-country");
		String currency= null;
		if(Country.equals("US"))
			currency="USD";
		if(Country.equals("GB"))
			currency="GBP";
		formatmenu.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		formatmenu.append(System.getProperty("line.separator")+"<MenuItems>");
		formatmenu.append(System.getProperty("line.separator"));
		for(Map.Entry<String, ArrayList<LinkedHashMap<String,String>>> entry : fooditems.entrySet())
		{
			formatmenu.append(String.format("%-5s"," ")+"<FoodItemCategory category="+"\""+entry.getKey().toUpperCase()+"\">");

			for(LinkedHashMap<String,String> getmenus:entry.getValue())
			{
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-8s"," ")+"<MenuItem>");
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-13s"," ")+"<Name>");
				formatmenu.append(getmenus.get("name")+"</Name>");
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-13s"," ")+"<Price>");
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-17s"," "));
				formatmenu.append("<CurrencyCode>"+currency+"</CurrencyCode>");
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-17s"," "));
				formatmenu.append("<Amount>"+getmenus.get("price")+"</Amount>");
				formatmenu.append(System.getProperty("line.separator")+String.format("%-13s"," ")+"</Price>");
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-13s"," ")+"<Description>");
				formatmenu.append(getmenus.get("description")+"</Description>");
				formatmenu.append(System.getProperty("line.separator"));
				formatmenu.append(String.format("%-8s"," ")+"</MenuItem>");
			}
		}
		formatmenu.append(System.getProperty("line.separator"));
		formatmenu.append(String.format("%-5s"," ")+"</FoodItemCategory>");
		formatmenu.append(System.getProperty("line.separator"));
		formatmenu.append("</MenuItems>");
		String filename=Country+"-Menu-"+type;
		System.out.println("Enter the path to save your file");
		Scanner in = new Scanner(System.in);
		String path = in.nextLine();
		File f=new File(path.toString()+filename+".xml");
		try
		{
			FileWriter fwriter = new FileWriter(f);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write(formatmenu.toString());
			bwriter.close();
		}
		catch (Exception e)
		{
			System.out.println("File write exception occured");
		}

	}



}
