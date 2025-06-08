package com.sevenmartsupermarket.utilities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class GeneralUtility {
	public String get_Attribute(WebElement element, String attribute)
	{
		return element.getAttribute(attribute);
	}
	public String get_CssValue(WebElement element, String cssvalue)
	{
		return element.getCssValue(cssvalue);
	}
	public List<String> get_TextofElements(List<WebElement> elements){
	List <String>data=new ArrayList<String>();
	for(WebElement element:elements)
	{
	data.add(element.getText());
	
	}
	return data;
	}
	public static String get_RandomName()//generate random name
	{
	
		Faker faker=new Faker();
		return faker.name().firstName();
		
	}
	public static String get_TimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		return timeStamp;
	}


}
