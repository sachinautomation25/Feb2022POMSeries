package com.qa.trcrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.trcrm.base.BasePage;
import com.qa.trcrm.utils.ElementUtil;
import com.qa.trcrm.utils.JavaScriptUtil;

import bsh.util.Util;

public class ContactPage extends BasePage {

	WebDriver driver;
	JavaScriptUtil jsUtil;
	ElementUtil util;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	By contacts = By.xpath("//li[@id='contactMenuLi']/a/span");
	By addPersronButton = By.cssSelector("button.hidden-xs.hidden-sm.btn.btn-danger.mr5.ng-scope.ng-binding");

	By name = By.xpath("//input[@name='name']");
	By surname = By.xpath("//input[@name='surname']");
	By email = By.xpath("//input[@id='email0']");

	By saveButton = By.cssSelector("button.btn.btn-primary.btn-large.ng-binding");

	By personAdded = By.xpath("//span[text()='Person added.']");
	
	By contactsHeader=By.xpath("(//h2[text()])[1]");
	
	public String doContactsHeader() {
		util.waitForElementPresent(contactsHeader);
		return util.doGetText(contactsHeader);
	}

	public String doAddPerson(String name2, String surname2) {
		util.waitForElementPresent(addPersronButton);
		util.doClick(addPersronButton);
		util.waitForElementPresent(name);
		util.doSendKeys(name, name2);
		util.doActionSendkeys(surname, surname2);
		util.doClick(saveButton);
		util.waitForElementPresent(personAdded);

		return util.doGetText(personAdded);
	}
	
	public void doQuit() {
		util.doQuit();
	}

}
