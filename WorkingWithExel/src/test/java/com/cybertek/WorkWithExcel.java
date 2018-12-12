package com.cybertek;

public class WorkWithExcel {

	public static void main(String[] args) {
		
		String path = "/Users/batuhanaybak/Desktop/HTML_JS_DOM/Selenium/testing-maven/WorkingWithExel/testData.xlsx";
		Xls_Reader data = new Xls_Reader(path);
		
		int rcount = data.getRowCount("data");
		System.out.println(rcount);
		
		int ccount = data.getColumnCount("data");
		System.out.println(ccount);
		
		String cdata = data.getCellData("data", "Name", 2);
		System.out.println(cdata);
		
		data.setCellData("data1", "Name", 8, "Ozzy");
		
		
	}

	

}
