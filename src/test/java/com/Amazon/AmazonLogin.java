package com.Amazon;

import org.testng.annotations.Test;

import com.Amazon.commonPages.AmazonLoginLocator;
import com.common.files.BrowserLaunch;
import com.common.files.Reporter;
import com.relevantcodes.extentreports.LogStatus;

public class AmazonLogin extends Reporter {

	@Test (description="User should not able to login with invalid credentials", priority=1)
	public void TC1() {
		test=report.startTest("User should unable to login with invalid credentials");
		AmazonLoginLocator login = new AmazonLoginLocator(driver);
		login.Login("9168881042", "Meeruu");
		if(login.getInvalidMsg().isDisplayed()) {
			test.log(LogStatus.PASS, "User is unable to login");
		}else {
			test.log(LogStatus.FAIL, "User is able to login in the application");
		}
	}

		@Test (description="User should able to login with valid credentials")
		public void TC2() {
			test=report.startTest("Verify that user should be able to login with valid credentials");
			AmazonLoginLocator login = new AmazonLoginLocator(driver);
			login.Login("9168881042", "meera75apr1994");
			if(login.getHomePage().isDisplayed()) {
				System.out.println(login.getHomePage().getText());
				test.log(LogStatus.PASS, "User is able to logged in Successfully");
			}else {
				test.log(LogStatus.FAIL, "User is unable to login in the application");
	}
		}
}
	
	


