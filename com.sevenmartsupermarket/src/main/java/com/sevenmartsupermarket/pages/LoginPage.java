package com.sevenmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();

	@FindBy(xpath="//input[@name='username']\r\n")
	 private WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passWordField;
	@FindBy(xpath="//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILEPATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}//class used to initialize elements
		
	}
	public void enterUserName(String userName)
	{
		 userNameField.sendKeys(userName);	
	}
	
	public void enterPasswordField(String passWord)
	{
		passWordField.sendKeys(passWord);	
	}
	
	public void clickOnSignIn()
	{
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.elementToBeClickable(signInButton,60);
		
		signInButton.click();	 	
	}
	/*public void login(String userName,String passWord)
	{
		enterUserName(userName);
		enterPasswordField(passWord);
		clickOnSignIn();
		
	}*/
	public void login()//read from config
	{
		String userName=properties.getProperty("username");
		String passWord=properties.getProperty("password");
		enterUserName(userName);
		enterPasswordField(passWord);
		clickOnSignIn();
		
		
	}

}
