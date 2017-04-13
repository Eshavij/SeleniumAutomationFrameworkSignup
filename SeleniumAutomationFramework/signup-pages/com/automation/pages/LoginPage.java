package com.automation.pages;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import exceptionhandling.*;
/**
 * Page object class for login
 * @author esha
 *
 */

public class LoginPage {
	WebDriver driver;
	ReportLog log = new ReportLog();
	FileInputStream fileInputstream;
	Properties properties;

	WebDriverWait wait;

	public LoginPage(WebDriver driver) throws NoSuchElement, IOException {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("LoginPage.properties");
	}

	/*public LoginPage verifyTitle() throws NoSuchElement, IOException {
		LoginPageChecker checker = new LoginPageChecker(driver);
		checker.title();
		return new LoginPage(driver);
	}*/

	public SignupPage clickSignUp(WebDriver driver) throws NoSuchElement, IOException, FileNotFound {
		log.info("Opens signup page");
		
		try {
			driver.findElement(By.xpath(properties.getProperty("signupbtn"))).click();
		} catch (Exception e) {
			throw new NoSuchElement("Element path not found\n" + e.getMessage());
		}
		return new SignupPage(driver);
	}
	
/*	public LoginPage verifysignup() throws NoSuchElement, IOException {
		log.info("signup page is verified");
		LoginPageChecker loginchecker = new LoginPageChecker(driver);
		loginchecker.checksignupchecker();
		return new LoginPage(driver);
	}*/
	
	public LoginPageChecker check() throws FileNotFound, IOException, NoSuchElement {
		new Utils(driver).waitVisibilityConditionByXpath(properties.getProperty("signupbtn"),10);
		return new LoginPageChecker(driver);
	}
	
	public Utils nav(){
		
		return new Utils(driver);
	}

/*	public LoginPage waitVisibilityConditionByXpath() throws NoSuchElement, IOException {
		wait = new WebDriverWait(driver, 20);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(properties.getProperty("signupbtn"))));
		} catch (Exception e) {
			throw new NoSuchElement("Element not found\n" + e.getMessage());
		}
		return new LoginPage(driver);
	}
	*/
}
