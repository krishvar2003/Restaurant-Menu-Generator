package clientPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import menuFormatterPackage.MenuFormatterFactory;
import menuGeneratorFormatter.MenuGeneratorFactory;
import readerPackage.ReaderFactory;
import factoryProducerPackage.FactoryProducer;

public class Client
{
	public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
	{
		while(true)
		{
			System.out.println("Enter the file path");
			System.out.println();
			Scanner in = new Scanner(System.in);
			System.out.flush();
			String filename = in.nextLine();
			File file = new File(filename);
			System.out.println("File you have inputted is "+filename);
			String file_ext = filename.substring(filename.lastIndexOf(".") + 1, filename.length());
			ReaderFactory rf = FactoryProducer.getFactory(file_ext);
			System.out.println("Select the country");
			System.out.println("1.US");
			System.out.println("2.GB");
			String option = in.nextLine();
			String country=null;
			if(option.equals("1"))
				country = "US";
			if(option.equals("2"))
				country="GB";
			System.out.println("Select the Restaurant Category");
			System.out.println("1.Diner");
			System.out.println("2.All day");
			System.out.println("3.Evening");
			String restaurant_category = in.nextLine();
			ArrayList<LinkedHashMap<String,String>> arr = rf.getReader().ReaderParser(file);
			LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>> generatedmenu = new LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>>();
			generatedmenu=MenuGeneratorFactory.getRestaurantCategory(restaurant_category).generateMenu(arr, country);
			System.out.println("Select The outpput file format");
			System.out.println("1.PlainText");
			System.out.println("2.HTML");
			System.out.println("3.XML");
			String output_option = in.nextLine();
			MenuFormatterFactory.getOutputFormat(output_option).createOutputFile(generatedmenu,restaurant_category);
			System.out.println("Do you want to continue y/n");
			String continueoption = in.nextLine().toLowerCase();
			if(continueoption.equals("n"))
				break;
			else
				continue;
		}
	}

}
