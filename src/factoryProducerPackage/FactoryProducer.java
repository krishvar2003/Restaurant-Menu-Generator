package factoryProducerPackage;

import menuFormatterPackage.MenuFormatterFactory;
import menuGeneratorFormatter.AlldayMenu;
import menuGeneratorFormatter.DinerMenu;
import readerPackage.JSONFactory;
import readerPackage.ReaderFactory;
import readerPackage.XMLFactory;

public class FactoryProducer
{
	public static ReaderFactory getFactory(String file_type)
	{
		switch(file_type)
		{
		case "json": return new JSONFactory();
		case "xml":  return new XMLFactory();
		}
		return null;
	}

}
