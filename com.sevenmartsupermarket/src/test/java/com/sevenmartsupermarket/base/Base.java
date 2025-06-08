package com.sevenmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.sevenmartsupermarket.constants.Constants;
import com.sevenmartsupermarket.utilities.CaptureScreenShots;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public WebDriver driver;
	Properties properties = new Properties();
	CaptureScreenShots capturescreenshots = new CaptureScreenShots();

	public Base() {
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILEPATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initializing Browser **/
	public void initialise(String browser, String url) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}

	@Parameters("browser")
	@BeforeMethod(enabled = false)
	public void launchBrowser(String browser) {
		String url = properties.getProperty("url");

		initialise(browser, url);
	}

	@BeforeMethod(enabled = true,alwaysRun = true)
	public void launchBrowser() {
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		initialise(browser, url);
	}

	@AfterMethod(alwaysRun = true)
	public void terminateBrowser(ITestResult itestresult)// interface to check the status of a testcase,a type of
															// listner
	{
		if (itestresult.getStatus() == ITestResult.SUCCESS)// or failure
		{
			capturescreenshots.takeScreenShot(driver, itestresult.getName());// get the name of valid login
		}
//driver.close
	}

}
