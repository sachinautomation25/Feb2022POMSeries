package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.trcrm.base.BasePage;
import com.qa.trcrm.utils.AppConstants;
import com.qa.trcrm.utils.ElementUtil;

public class LoginPage extends BasePage {

	WebDriver driver;
	By username = By.id("_username");
	By password = By.id("_password");
	By loginBtn = By.xpath("//input[@type='submit']");
	By SignUpNow = By.linkText("Sign Up Now");
	By errorMessage = By.xpath("//div[@id='error']");

	ElementUtil util;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
	}

	public String getPageTitle() {
		// return driver.getTitle();
		return util.getTitle(AppConstants.LOGIN_PAGE_TITLE);
	}

	public boolean verifySignUpLink() {
		// return driver.findElement(SignUpNow).isDisplayed();
		return util.isDisplayed(SignUpNow);
	}

	public HomePage doLogin(String email, String pwd) {
		/*
		 * driver.findElement(username).clear();
		 * driver.findElement(username).sendKeys(email);
		 * driver.findElement(password).clear();
		 * driver.findElement(password).sendKeys(pwd);
		 * driver.findElement(loginBtn).click();
		 */
		util.doSendKeys(username, email);
		util.doSendKeys(password, pwd);
		util.doClick(loginBtn);

		return new HomePage(driver);
	}

	public boolean checkLoginErrorMessage() {
		return util.isDisplayed(errorMessage);
		//return driver.findElement(errorMessage).isDisplayed();
	}
	public void doQuit() {
		util.doQuit();
	}
}
