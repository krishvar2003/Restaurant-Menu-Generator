package menuFormatterPackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public interface IFormatter
{
	void createOutputFile(LinkedHashMap<String,ArrayList<LinkedHashMap<String,String>>> fooditems,String restaurant_type) throws IOException;
	
}
