package practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataToPropertyFile {

	public static void main(String[] args) throws Throwable {
			
		Properties p = new Properties();
		p.setProperty("Name", "Mac");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/CommonData.properties");
		p.store(fos, "Hi");
	}
}
