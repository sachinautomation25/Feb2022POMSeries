package com.qa.trcrm.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.trcrm.base.BasePage;
import com.qa.trcrm.pages.ContactPage;
import com.qa.trcrm.pages.HomePage;
import com.qa.trcrm.pages.LoginPage;
import com.qa.trcrm.utils.AppConstants;
import com.qa.trcrm.utils.ExcelUtil;

public class ContactsPageTest {

	BasePage basePage;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContacts();

	}

	@DataProvider
	public String[][] dp() {
		String data[][] = new String[2][2];
		data[0][0] = "sachin";
		data[0][1] = "sachin";
		data[1][0] = "deepak";
		data[1][1] = "deepak'";

		return data;
	}
	@DataProvider
	public Object[][] dp2() {
		Object data[][]=ExcelUtil.getData(AppConstants.CONTACTS_SHEET_NAME);
		return data;
	}

	@Test(priority = 2,dataProvider = "dp2")
	public void verifyAddPersonTest(String name, String surname) {
		homePage.clickOnContacts();
		String text = contactPage.doAddPerson(name, surname);
		Assert.assertEquals(text, AppConstants.CONTACTS_PERSON_ADDED);
	}
	

	@Test(priority = 1)
	public void verifyContactPageHeader() {
		String text=contactPage.doContactsHeader();
		Assert.assertEquals(text, AppConstants.CONTACTS_PAGE_HEADER);
	}
	@AfterTest
	public void tearDown() {

		contactPage.doQuit();
	}

}
