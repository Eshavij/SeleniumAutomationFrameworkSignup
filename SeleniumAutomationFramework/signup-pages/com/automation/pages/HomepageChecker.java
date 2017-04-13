package com.automation.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;

public class HomepageChecker {

	WebDriver driver;
	public FileInputStream fileInputstream;
	Properties properties = new Properties();

	public HomepageChecker(WebDriver driver) throws IOException {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("Homepage.properties");
	}

	public HomePage homepagetitle() throws IOException, FileNotFound {
		Assert.assertEquals(driver.getTitle(), "AppDirect");
			return new HomePage(driver);
	}

	public HomePage loginchecker() throws IOException, NoSuchElement, FileNotFound {
		boolean status;
		
		try {
			status = driver.findElement(By.xpath("//*[@id='newnav']/header/div/menu/ul/li[3]/a/span")).isDisplayed();
		} catch (Exception e) {
			throw new NoSuchElement("Element path not found\n" + e.getMessage());
		}
		Assert.assertTrue(status);
			return new HomePage(driver);
	}

}
