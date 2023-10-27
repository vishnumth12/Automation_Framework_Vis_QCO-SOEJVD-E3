package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//comment
/*multiline comment*/
//DESCRIPTION GIVEN BELOW
/**
 * This class consists of generic method to read data from 
 * property file
 * @author vishnu
 */
public class PropertyFileUtility {
	
	//DESCRIPTION GIVEN BELOW
	/**
	 * This method will read data from property file and return the value to caller
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromStringPropertyFileString(String key) throws IOException{

	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}
}

