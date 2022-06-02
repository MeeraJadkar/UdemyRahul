package com.HCL.commonFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FlipkartBrowserLaunch {

	public static WebDriver driver;
	public static Properties propertyFile;
	
	public void BrowserLaunch() {
		ReadProperty();
		
		String BrowserName = propertyFile.getProperty("BrowserName");
		if(BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BrowserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src/main/resources/chromedriver.exe");
			driver = new EdgeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		driver.get(propertyFile.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
		public void ReadProperty() {
		propertyFile = new Properties();
		try {
		     propertyFile.load(new FileInputStream("src/main/resources/BrowserInput.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("File not found on location");
		} catch (IOException e) {
			System.out.println("IO exception occurred");
		}
	}


	}


