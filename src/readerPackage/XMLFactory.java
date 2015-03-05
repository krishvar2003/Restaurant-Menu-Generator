package readerPackage;

public class XMLFactory extends ReaderFactory
{

	public IReader getReader()
	{
		return new XMLParser();
	}

}
