package com.Flipkart;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Flipkart.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartLoginPage {

	public static ExtentReports report;
	public static ExtentTest test;
	
	@BeforeClass (alwaysRun=true)
	public void StartTest() {
		ExtentReports reports = new ExtentReports("Result/result.html", true);
	}
	
 	@Test (description="Verify that the user is able to login with valid credentials")
 	public void TC1() {
 		test=report.startTest("Verify that the user should be able to login to application with valid credentials");
 		LoginPage loginFlipkart = new LoginPage();
 		loginFlipkart.Login("9168881042", "5apr1994");
 		if(loginFlipkart)
 		test.log(LogStatus.PASS, "User is Logged in Successfully with valid Credentials") {
 			
 		}
 	}
 


}
