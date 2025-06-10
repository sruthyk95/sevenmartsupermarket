package com.sevenmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenmartsupermarket.utilities.GeneralUtility;
import com.sevenmartsupermarket.utilities.PageUtility;

public class AdminUserPage {
	WebDriver driver;
	@FindBy(xpath="(//a[contains(text(),'More info')])[1]")
	 private WebElement moreInfoButton;
	@FindBy(xpath="//a[contains(text(),'New')]")
	 private WebElement newUserButton;
	@FindBy(xpath="//input[@id='username']")
	 private WebElement userNameField;
	@FindBy(xpath="//input[@id='password']")
	 private WebElement passWordField;
	@FindBy(xpath="//select[@id='user_type']")
	 private WebElement userTypeDropDown;
	@FindBy(xpath="(//button[@type='submit'])[2]")
	 private WebElement saveButton;
	@FindBy(xpath="//table/tbody/tr[1]/td[5]/a[1]/i")
	 private WebElement statusButton;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnUserInfoButton()
	{
		moreInfoButton.click();
		newUserButton.click();
	}
	public void enterUserNameField(String userName)
	{
		userNameField.sendKeys(userName);
		
	}
	public void enterPasswordField(String passWord)
	{
		passWordField.sendKeys(passWord);	
	}
	public void selectUserType(String text)
	{
		userTypeDropDown.click();
		PageUtility pageutility=new PageUtility(driver);
		pageutility.selectByVisibleText(userTypeDropDown, text);
		
	}
	public void ClickONsave() {
		saveButton.click();	
	}
	public boolean verifyNewUserButton()
	{
		boolean b=newUserButton.isEnabled();
		return b;
		
	}
	public String verifyColourOfNew()
	{
		GeneralUtility generalutility=new GeneralUtility();
		return generalutility.get_CssValue(newUserButton, "background-color");
	
	}
	
	
	
	

}
