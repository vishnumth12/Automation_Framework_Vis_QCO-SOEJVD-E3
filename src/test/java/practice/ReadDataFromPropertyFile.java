package practice;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws Throwable {
		
		//Step 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
	
		//Step 2: Create Object of Properties for Java.util package
		Properties p = new Properties();
		
		//Step 3: Load the file input stream into properties 
		p.load(fis);
		
		//Step 4: provide the key and read the value
		String value = p.getProperty("url");
		System.out.println(value);

	}
}
