package com.Amazon.commonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AmazonLoginLocator {

	WebDriver driver;
	public AmazonLoginLocator(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getUsernameText() {
		return driver.findElement(By.id("ap_email"));
	}
	public WebElement getPasswordText() {
		return driver.findElement(By.id("ap_password"));
	}
	public WebElement getContinueBtn() {
		return driver.findElement(By.id("continue"));
	}
	public WebElement getSubmitBtn() {
		return driver.findElement(By.id("signInSubmit"));
	}
	public WebElement getSignInBtn() {
		return driver.findElement(By.xpath("//div[@class=\"nav-line-1-container\"]"));
	}
	public WebElement getHomePage() {
		return driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	}
	public WebElement getInvalidMsg() {
		return driver.findElement(By.className("a-alert-container"));
	}
	public void Login(String username, String password) {
		Actions action = new Actions(driver);
		action.moveToElement(getSignInBtn()).click().build().perform();
		getUsernameText().sendKeys(username);
		getContinueBtn().click();
		getPasswordText().sendKeys(password);
		getSubmitBtn().click();
	}

}
