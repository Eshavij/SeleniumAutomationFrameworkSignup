package com.automation.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import exceptionhandling.FileNotFound;

public class SignupPageChecker {
	WebDriver driver;
	Properties properties;

	public SignupPageChecker(WebDriver driver) throws IOException {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("Signup.properties");
	}

	public SignupPage Signuptitle() throws IOException, FileNotFound {
		Assert.assertEquals(driver.getTitle(), "Sign Up for AppDirect");
		return new SignupPage(driver);
	}

	public SignupPage signupchecker() throws IOException, FileNotFound {
		boolean status = true;
		status = driver.findElement(By.cssSelector(".adb-text__full_width")).isDisplayed();
		Assert.assertTrue(status);
		return new SignupPage(driver);
	}

}
