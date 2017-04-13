package com.automation.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import exceptionhandling.NoSuchElement;
import exceptionhandling.FileNotFound;

public class HomePage {
	ReportLog log = new ReportLog();
	WebDriver driver;
	public FileInputStream fileInputstream;

	Properties properties ;

	public HomePage(WebDriver driver) throws FileNotFound, IOException {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("HomePage.properties");
	}

	public HomePage openHomePageUrl() throws FileNotFound, IOException {
		log.info("Open appdirect website");
		driver.get(properties.getProperty("website"));
		return new HomePage(driver);
	}

	public LoginPage clickLoginButton() throws NoSuchElement, FileNotFound, IOException {
		log.info("click loginIn button");
		try {
			driver.findElement(By.cssSelector(".login")).click();
		} catch (Exception e) {
			throw new NoSuchElement("Element path not  found");
		}
		return new LoginPage(driver);
	}

	public HomepageChecker check() throws FileNotFound, IOException {
		
		return new HomepageChecker(driver);

	}

	
}
