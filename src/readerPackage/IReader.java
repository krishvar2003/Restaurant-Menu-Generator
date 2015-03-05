package readerPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public interface IReader
{
	 public ArrayList ReaderParser(File file) throws SAXException, IOException, ParserConfigurationException;

}
