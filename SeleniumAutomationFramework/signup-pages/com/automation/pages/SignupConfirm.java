package com.automation.pages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;
/**
 * checker class for confirmation of signup
 * @author esha
 *
 */
public class SignupConfirm {
	ReportLog log = new ReportLog();
	WebDriver driver;
	WebDriverWait wait;
	Properties properties;
	//FileOutputStream outputStream;

	public SignupConfirm(WebDriver driver) throws IOException {
		this.driver = driver;
		properties = new Utils(driver).readpropertyfile("Signup.properties");
		
	}

	/*public SignupConfirm waitVisibilityConditionByXpath() throws IOException {
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".signupConfirmationPanel")));
		return new SignupConfirm(driver);
	}*/
	
	/*public SignupConfirm check() throws FileNotFound, IOException, NoSuchElement {
		new Utils(driver).waitVisibilityConditionByCssSelector(properties.getProperty("signupconfirmation"),10);
		return new SignupConfirm(driver);		
	} */
	/*
	public void writeEmailIdInPropertyFile(String key,String value) throws IOException{
        outputStream = new FileOutputStream(new File("EmailDatabase.properties"));
        properties = new Properties();
        properties.setProperty(key, value);
        properties.store(outputStream,"Email");
    }
	public void navigateback(String key,String value) throws IOException{
		webdriver.driver()
        outputStream = new FileOutputStream(new File("EmailDatabase.properties"));
        properties = new Properties();
        properties.setProperty(key, value);
        properties.store(outputStream,"Email");
	}
	*/
	
	public LoginPage verifySignUpFailure() throws IOException, NoSuchElement{
		
        new Utils(driver).waitVisibilityConditionByCssSelector(properties.getProperty("verifySignUpFailure"), 10);
        if(driver.findElement(By.cssSelector(properties.getProperty("verifySignUpFailure"))).isDisplayed()){
            Reporter.log("SignedUp Failed",true);
        }
        return new LoginPage(driver);
    }
	
	public SignupConfirm verifysignup2() throws IOException {
		new Utils(driver).waitVisibilityConditionByCssSelector(".signupConfirmationPanel", 10);
		if(driver.findElement(By.cssSelector(".signupConfirmationPanel")).isDisplayed()){
			Reporter.log("Success",true);
		}
	
		return new SignupConfirm(driver);
	}


}
