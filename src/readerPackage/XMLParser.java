package readerPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
public class XMLParser implements IReader
{
	public ArrayList ReaderParser(File file) throws SAXException, IOException, ParserConfigurationException
	{
		File XMLFile = new File(file.toString());
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(XMLFile);
		NodeList nList = doc.getElementsByTagName("FoodItem");
		ArrayList<LinkedHashMap<String,String>> menuitems = new ArrayList<LinkedHashMap<String,String>>();
		for (int temp = 0; temp < nList.getLength(); temp++)
		{
			Node nNode =  nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE)
			{
				Element eElement = (Element) nNode;
				LinkedHashMap<String,String> items = new LinkedHashMap<String,String>();
				items.put("-country", eElement.getAttribute("country").toString());
				items.put("id", eElement.getElementsByTagName("id").item(0).getTextContent().toString());
				items.put("name", eElement.getElementsByTagName("name").item(0).getTextContent().toString());
				items.put("price", eElement.getElementsByTagName("price").item(0).getTextContent().toString());
				items.put("description", eElement.getElementsByTagName("description").item(0).getTextContent().toString());
				items.put("category", eElement.getElementsByTagName("category").item(0).getTextContent().toString());
				menuitems.add(items);
			}
		}
		return menuitems;
	}
}
