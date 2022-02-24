package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.trcrm.base.BasePage;
import com.qa.trcrm.utils.AppConstants;
import com.qa.trcrm.utils.ElementUtil;
import com.qa.trcrm.utils.JavaScriptUtil;

public class HomePage extends BasePage {

	WebDriver driver;
	ElementUtil util;
	JavaScriptUtil jsUtil;

	By homePageHeader = By.xpath("//span[text()='Homepage']");
	By loggedInUser = By.xpath("//span[text()=' sachin sharma']");
	
	By contacts = By.xpath("//li[@id='contactMenuLi']/a");

	public HomePage(WebDriver driver) {
		this.driver = driver;
		util=new ElementUtil(driver);
		jsUtil=new JavaScriptUtil(driver);
	}

	public String getHoePageTitle() {
		return util.getTitle(AppConstants.HOME_PAGE_TITLE);
	}

	public String isHomePageHeaderExist() {
		return util.doGetText(homePageHeader);
	}

	public String isUserLoggedIn() {
		return util.doGetText(loggedInUser);
	}
	public ContactPage clickOnContacts() {
	util.waitForElementPresent(contacts);
	//util.doClick(contacts);
	jsUtil.clickElementByJS(util.getElement(contacts));
	
	return new ContactPage(driver);
	}
}
