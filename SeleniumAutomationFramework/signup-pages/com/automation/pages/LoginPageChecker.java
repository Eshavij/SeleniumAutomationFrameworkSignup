package com.automation.pages;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;
/**
 * LOGINPAGECHECKER CLASS
 * @author esha
 *
 */

public class LoginPageChecker {
	WebDriver driver;
	WebDriverWait wait;
	Properties properties;

	public LoginPageChecker(WebDriver driver) throws IOException {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("LoginPage.properties");

	}

	public LoginPage verifySignUpTitle() throws NoSuchElement, IOException {
		Assert.assertEquals(driver.getTitle(), "Log In | AppDirect");
		return new LoginPage(driver);

	}

	public LoginPage verifySignUpButtonDisplayed() throws NoSuchElement, IOException {
		boolean status = true;

		try {
			status = driver.findElement(By.xpath("//*[@id='id5']/div[3]/p/a")).isDisplayed();

		} catch (Exception e) {
			throw new NoSuchElement("Element path not found\n" + e.getMessage());
		}
		Assert.assertTrue(status);
		return new LoginPage(driver);
	}
	public LoginPageChecker check() throws FileNotFound, IOException, NoSuchElement {
		new Utils(driver).waitVisibilityConditionByXpath(properties.getProperty("signupbtn"),10);
		return new LoginPageChecker(driver);
}

	/*public LoginPage waitVisibilityConditionByXpath() throws NoSuchElement, IOException {
		wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='id5']/div[3]/p/a")));
		} catch (Exception e) {
			throw new NoSuchElement("Element path not found\n" + e.getMessage());
		}
		return new LoginPage(driver);

	}
	*/
}
