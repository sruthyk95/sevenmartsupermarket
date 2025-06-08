package com.sevenmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenmartsupermarket.base.Base;
import com.sevenmartsupermarket.dataproviders.TestDataProviders;
import com.sevenmartsupermarket.pages.AdminUserPage;
import com.sevenmartsupermarket.pages.LoginPage;



public class AdminUserTest extends Base {
	LoginPage loginpage;
	AdminUserPage adminuserpage;
	@Test(groups={"smoke","regression"})
	public void validateLogin()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
	}
	@Test
	public void vAalidateNewUser()
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickOnUserInfoButton();
		adminuserpage.verifyNewUserButton();
		boolean actualStatus=adminuserpage.verifyNewUserButton();
		System.out.println(actualStatus);
		boolean expectedStatus=true;
		Assert.assertEquals(actualStatus,expectedStatus);
	}

	@Test(dataProvider = "admin data",dataProviderClass = TestDataProviders.class)
	public void verifyAdminUserRegistration(String userName,String passWord)
	{
		loginpage= new LoginPage(driver);
		loginpage.login();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.clickOnUserInfoButton();
		adminuserpage.enterUserNameField(userName);
		adminuserpage.enterPasswordField(passWord);
		adminuserpage.selectUserType("Staff");
		adminuserpage.ClickONsave();
	}
	
@Test
public void validateColorOFNewButton()
{
	loginpage= new LoginPage(driver);
	loginpage.login();
	adminuserpage=new AdminUserPage(driver);
	adminuserpage.clickOnUserInfoButton();
	adminuserpage.verifyColourOfNew();
	String actualBackgroundColor=adminuserpage.verifyColourOfNew();
	System.out.println(actualBackgroundColor);
	String expectedBackGrounColor="rgba(205, 39, 55, 1)";
	Assert.assertEquals(actualBackgroundColor, expectedBackGrounColor);
	
}
}
