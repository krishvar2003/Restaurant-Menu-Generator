package readerPackage;

public class JSONFactory extends ReaderFactory
{

	public IReader getReader()
	{
		
		return new JSParser();
	}

}
