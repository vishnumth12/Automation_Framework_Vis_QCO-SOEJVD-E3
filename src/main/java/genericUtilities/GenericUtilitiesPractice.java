package genericUtilities;

public class GenericUtilitiesPractice {

	public static void main(String[] args) throws Throwable {
		
		PropertyFileUtility putil = new PropertyFileUtility();
		String browser= putil.readDataFromStringPropertyFileString("browser");
		String usr= putil.readDataFromStringPropertyFileString("username");
		String url= putil.readDataFromStringPropertyFileString("url");
		String pwd= putil.readDataFromStringPropertyFileString("password");
		System.out.println("O/p : " + browser +", "+ usr +", "+ url +", "+ pwd);
		
		ExcelFileUtility excelutil = new ExcelFileUtility();
		String returnData = excelutil.readDataFromExcelFile("Organizations", 1, 1);
		System.out.println(returnData);
		
		//JavaUtility method made generic under JavaUility class
		JavaUtility j = new JavaUtility();
		//Random number class
		System.out.println(j.getRandomNumber());
		
		//Date class
		String date = j.getSystemDate();
		System.out.println(date);
		
		//Open Browser
		j.openBrowser("www.google.com");
	}
}
