package menuFormatterPackage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HTMLFormatter implements IFormatter
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
		String Country = fooditems.get("Appetizer").get(0).get("-country");
		String currency= null;
		if(Country.equals("US"))
			currency="$";
		if(Country.equals("GB"))
			currency="GBP";
		StringBuilder formatmenu = new StringBuilder();
		formatmenu.append("<HTML>");
		formatmenu.append("<HEAD>");
		formatmenu.append(String.format("%-5s"," "));
		formatmenu.append("<TITLE>MENU</TITLE>");
		formatmenu.append("</HEAD>");
		formatmenu.append("<BODY>");
		formatmenu.append(String.format("%-5s"," ")+"<CENTER>MENU</CENTER>");
		formatmenu.append(System.getProperty("line.separator"));
		for(Map.Entry<String, ArrayList<LinkedHashMap<String,String>>> entry : fooditems.entrySet())
		{
			formatmenu.append(String.format("%-5s"," ")+"<H1>"+entry.getKey().toUpperCase()+"</H1>");

			for(LinkedHashMap<String,String> getmenus:entry.getValue())
			{
				formatmenu.append(String.format("%-5s"," ")+"<UL>");
				formatmenu.append(String.format("%-8s"," ")+"<LI>");
				formatmenu.append(getmenus.get("name")+"<br>");
				formatmenu.append(String.format("%-11s"," "));
				formatmenu.append("<I>"+getmenus.get("description")+"</I>"+"<BR>");
				formatmenu.append(String.format("%-11s"," "));
				formatmenu.append(currency+getmenus.get("price")+"</LI>");
				formatmenu.append(System.getProperty("line.separator")+"</UL>");
			}
		}
		formatmenu.append("</BODY>");
		formatmenu.append(System.getProperty("line.separator"));
		formatmenu.append("</HTML>");
		String filename=Country+"-Menu-"+type;
		System.out.println("Enter the path to save your file");
		Scanner in = new Scanner(System.in);
		String path = in.nextLine();
		File f=new File(path.toString()+filename+".html");
		try
		{
			FileWriter fwriter = new FileWriter(f);
			BufferedWriter bwriter = new BufferedWriter(fwriter);
			bwriter.write(formatmenu.toString());
			bwriter.close();
		}
		catch (Exception e)
		{
			System.out.println("File writing error");
		}

	}

}
