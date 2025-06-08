package com.sevenmartsupermarket.dataproviders;

import org.testng.annotations.DataProvider;

import com.sevenmartsupermarket.utilities.ExcelReader;

public class TestDataProviders {
	
	@DataProvider(name = "admin data")
    public Object[][] getData() {
        return new Object[][] {  {"sree90@gmail","drett"},  {"mohan89@gmail","fggrrt"},  {"raju45@gmail","fhyy"}, };
          
	}     
          
	}


ExcelReader excel=new ExcelReader();
@DataProvider(name = "admins data")
public Object[][] getData() {
	return new Object[][];
    	excel.setExcelFile(adminpage);
    	return excel.getMultidimentionalData(2, 3);
}