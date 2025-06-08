package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.pages.DashBoardPage;
import com.sevenmartsupermarket.pages.LoginPage;
import com.sevenmartsupermarket.utilities.ExcelReader;
import com.sevenmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {
	 LoginPage loginpage;
	 DashBoardPage dashboardpage;
	 ExcelReader excelreader=new ExcelReader();
	@Test(groups="smoke")
	public void verifyValidLogin()
	{
		
		loginpage= new LoginPage(driver);
		loginpage.login();
		dashboardpage=new DashBoardPage(driver);
		excelreader.setExcelFile("LoginPage");
		excelreader.getCellData(0, 1);
	
		/*String st=GeneralUtility.get_RandomName();
		String str=GeneralUtility.get_RandomName();
		System.out.println(str);*/
		//String st=excelreader.getCellData(0, 1);
		//System.out.println(st);
		//Capturescreenshots.takeScreenShot(driver,"sruthy");
		
	   String actualProfileName=dashboardpage.getProfileName();
	   String expectedProfileName="Admin";
	   Assert.assertEquals(actualProfileName, expectedProfileName);
		
		
	}


}
