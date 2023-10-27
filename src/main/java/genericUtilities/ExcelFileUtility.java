package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author vishnu
 * This class conists of generic methods related to excel file
 * 
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel file and return the value to user
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromExcelFile(String sheetName, int rownum, int cellnum) throws Throwable{

	FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	String cellvalue = wb.getSheet(sheetName).getRow(rownum).getCell(cellnum).getStringCellValue();// for numeric cell value : getNumericCellValue
	return cellvalue;
	
	}
	
	/**
	 * This method will read multiple data from excel sheet at a time
	 * used for data provider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String SheetName) throws EncryptedDocumentException, Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object [][] data = new Object [lastRow][lastCell];
		
		for (int i= 0; i<lastRow; i++) {
			for (int j = 0; j<lastCell; j++) {
				data[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
}

