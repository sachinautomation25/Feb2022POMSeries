package com.qa.trcrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage2 {

	public WebDriver driver;
	public Properties prop;

	/**
	 * This method is used to initialize the web driver on the basis of browser name
	 * 
	 * @param browserName
	 * @return this method return the driver instance
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");

		String headlessFlag = prop.getProperty("headless");
		boolean headlessFlag2 = Boolean.parseBoolean(headlessFlag);
		if (headlessFlag2) {

		}
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			if (headlessFlag2) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {

				driver = new ChromeDriver();
			}
		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			if (headlessFlag2) {
				FirefoxOptions fo = new FirefoxOptions();
				fo.addArguments("--headless");
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
			}
		} else if (browserName.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			driver = new SafariDriver();
		} else {
			System.out.println(browserName + " not found");
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

		return driver;
	}

	/**
	 * 
	 * @return this method returns properties-prop available in config.properties
	 *         file
	 */
	public Properties init_prop() {

		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\eclipse-workspace\\Feb2022POMSeries\\src\\main\\java\\com\\qa\\trcrm\\config\\config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prop;
	}

}
