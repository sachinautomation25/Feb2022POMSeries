package com.qa.trcrm.pages;

import org.openqa.selenium.WebDriver;

import com.qa.trcrm.base.BasePage;

public class ProfilePage extends BasePage {

	WebDriver driver;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}
  public void get()
  {
  System.out.println("profile page");
  }

	public void test2()
	{
	System.out.println("test2");
	}

  public void test()
  {
  System.out.println("test");
  }

}
