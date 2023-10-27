package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
		
	
		@Test(dataProvider = "getData")
		public void addProductToCart(String Name, int Price, int qty, String Model) {
			System.out.println("Phone Name is : "+Name+" Price : "+Price+" Qty : "+qty+" Model : "+Model);
		}
		
		@DataProvider
		public Object[][] getData(){
										//row, column  3 * 4 matrix
			Object[][] data = new Object[3][4]; //3 sets of data with 4 details in each set (details for each data set has to be same or colums has to be same number for each data set
			
			data[0][0]="Samsung";  //manually hardcoded data sets provided not right way we do - excel 
			data[0][1]=10000;
			data[0][2]=20;
			data[0][3]="A80";
			
			data[1][0]="Nokia";
			data[1][1]=12000;
			data[1][2]=15;
			data[1][3]="N92";
			
			data[2][0]="Apple";
			data[2][1]=15000;
			data[2][2]=15;
			data[2][3]="A5Pro";
			
			return data;
		}

	}


