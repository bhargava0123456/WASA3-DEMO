package care_genericUtilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public String datafrompropertyfile(String data) throws Exception
	{
		FileInputStream fis=new FileInputStream(".\\TestData");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value=pobj.getProperty(data);
		return value;
		
	}

}
