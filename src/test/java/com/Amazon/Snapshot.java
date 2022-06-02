package com.Amazon;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Snapshot {
	
	public static WebDriver driver;
	@Test
	public void screenshot() {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		TakesScreenshot image = (TakesScreenshot) driver;
		File srcfile = image.getScreenshotAs(OutputType.FILE);
		File destination = new File("Result/Test.png");
		try {
			FileUtils.copyFile(srcfile, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
