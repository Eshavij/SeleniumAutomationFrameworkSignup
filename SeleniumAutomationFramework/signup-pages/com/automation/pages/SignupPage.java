package com.automation.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import exceptionhandling.NoSuchElement;
import exceptionhandling.FileNotFound;


public class SignupPage {

	public FileInputStream fileInputstream;
	Properties properties ;
	private WebDriver driver;
	String emailid="";
	
	public SignupPage(WebDriver driver) throws IOException, FileNotFound {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("Signup.properties");
	}

	public SignupPage emailidFromProp() throws IOException, FileNotFound
	{
		properties = new Utils(driver).readpropertyfile("EmailDatabase.properties");
		emailid = properties.getProperty("emailId");
		driver.findElement(By.cssSelector(".adb-text__full_width")).sendKeys(emailid);
		
		
		return new SignupPage(driver);
	}
	
	
	public SignupPage emailid() throws IOException, NoSuchElement, FileNotFound {
		Reporter.log("Enter mailid", true);
		
		WebElement input;
		try {
			emailid = (RandomStringUtils.randomAlphabetic(3, 50)).toLowerCase() + "@"
					+ (RandomStringUtils.randomAlphabetic(3)).toLowerCase() + ".com";
			input = driver.findElement(By.cssSelector(properties.getProperty("ee")));
		} catch (Exception e) {
			throw new NoSuchElement("Element path not found");
		}
		
		input.sendKeys(emailid);
		new Utils(driver).writeEmailIdInPropertyFile("emailId", emailid);
		
		return new SignupPage(driver);
	}

	public SignupPage signupsave() throws IOException, FileNotFound {
		WebElement signup = driver.findElement(By.xpath(properties.getProperty("signup")));
		signup.click();
		return new SignupPage(driver);
	}
	
	public SignupConfirm clickSignUpButton() throws IOException, FileNotFound {
		WebElement signup = driver.findElement(By.cssSelector(properties.getProperty("signup")));
		signup.click();
		return new SignupConfirm(driver);
	}

	public SignupPageChecker check() throws FileNotFound, IOException, NoSuchElement {
	//new Utils(driver).waitVisibilityConditionByXpath(properties.getProperty("signup"),10);
		
		return new SignupPageChecker(driver);
}

	
}
