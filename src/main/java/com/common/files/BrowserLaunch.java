package com.common.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BrowserLaunch {
	public static WebDriver driver;
	public static Properties property;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeSuite(alwaysRun=true)
	
	public void Browser_Initialization() {
	ReadPropertyFile();
	String Browsername = property.getProperty("Browsername");
	if(Browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
	}else if(Browsername.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new ChromeDriver();
	}else {
		System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
		driver = new ChromeDriver();
	}
	driver.get(property.getProperty("url"));
	}
	
	public void ReadPropertyFile() {
		property = new Properties();
		try {
			property.load(new FileInputStream("src/main/resources/PropertyFile.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("Property File is not present on location");
		} catch (IOException e) {
			System.out.println("IO Exception occurred");
		}
	}
		public static void ReportCreation() {
	    	  report = new ExtentReports("Result/Result.html", true);
		}
	
	@AfterSuite(alwaysRun=true)
	public static void Report() {
		report.endTest(test);
		report.flush();
	}
	public void CommonClose() {
		driver.quit();
	}
}
