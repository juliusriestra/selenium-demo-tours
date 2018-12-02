package pe.util;

import java.util.ArrayList;

public class TestUtils {
	
	static Xls_Reader reader; 
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("H:/DataExport/DataTours.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("RegContacto"); rowNum++) {
			String firstname = reader.getCellData("RegContacto", "firstname", rowNum);
			String lastname = reader.getCellData("RegContacto", "lastname", rowNum);
			String phone = reader.getCellData("RegContacto", "phone", rowNum);
			String userName = reader.getCellData("RegContacto", "userName", rowNum);
			String address1 = reader.getCellData("RegContacto", "address1", rowNum);
			String address2 = reader.getCellData("RegContacto", "address2", rowNum);
			String city = reader.getCellData("RegContacto", "city", rowNum);
			String state = reader.getCellData("RegContacto", "state", rowNum);
			String postalCode = reader.getCellData("RegContacto", "postalCode", rowNum);
			String country = reader.getCellData("RegContacto", "country", rowNum);
			String email = reader.getCellData("RegContacto", "email", rowNum);
			String password = reader.getCellData("RegContacto", "password", rowNum);
			String confirmPassword = reader.getCellData("RegContacto", "confirmPassword", rowNum);
			
			Object obj[] = {firstname,lastname,phone,userName,address1,address2,city,state,postalCode,country,email,password,confirmPassword};
			myData.add(obj);
		}
		return myData;
	}
}
