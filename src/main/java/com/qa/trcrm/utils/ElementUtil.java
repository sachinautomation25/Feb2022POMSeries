package com.qa.trcrm.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);

	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some error occured while creating web element: " + locator);

		}
		return element;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doGetText(By locator) {
		return driver.findElement(locator).getText();
	}

	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doQuit() {
		driver.quit();
	}

	public String getTitle(String title) {

		WebDriverWait wait = new WebDriverWait(driver, AppConstants.DEFAULT_EXPLICT_TIME_OUT);
		wait.until(ExpectedConditions.titleIs(title));

		return driver.getTitle();
	}

	public void waitForElementPresent(By locator) {
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_EXPLICT_TIME_OUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void waitForElementVisible(By locator) {
		wait = new WebDriverWait(driver, AppConstants.DEFAULT_EXPLICT_TIME_OUT);
		WebElement element = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void doActionSendkeys(By locator, String value) {
		action.sendKeys(getElement(locator), value).build().perform();
	}

	public void doActionClick(By locator) {
		action.click(getElement(locator)).build().perform();
	}
}
