package com.Flipkart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.HCL.commonFiles.FlipkartBrowserLaunch;

public class LoginPage extends FlipkartBrowserLaunch {

	public WebElement getEmailMobileText(){
		return driver.findElement(By.className("_2IX_2- VJZDxU"));
	}
	public WebElement getPasswordText() {
		return driver.findElement(By.xpath("//input[@type=\"password\"]"));
	}
	public WebElement LoginBtn() {
		return driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2HKlqd _3AWRsL\"]"));
	}
	
	public void Login(String EmailOrMobile, String Password) {
		getEmailMobileText().sendKeys(EmailOrMobile);
		getPasswordText().sendKeys(Password);
		LoginBtn().click();
	}
}
