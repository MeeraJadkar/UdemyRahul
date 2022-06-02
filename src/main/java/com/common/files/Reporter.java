package com.common.files;

import java.io.File;
import java.util.Date;

import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;

public class Reporter extends BrowserLaunch {

	
	@BeforeTest(alwaysRun=true)
	public static void Report() {
		Date now = new Date();
		String Timestamp = now.toString().replace(":", "-");
		File file = new File("Result/"+Timestamp);
		file.mkdir();
		//filepath= file.getPath();
		//report=new ExtentReports(file.getPath(),+ "/Result.html");
	}
	public static void StartTest(String testcase) {
		test = report.startTest("Testcase") ;
		
	}
	
}
