package com.automation.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptionhandling.NoSuchElement;

public class Utils { 
	WebDriver driver;
	WebDriverWait wait;
	FileOutputStream outputStream;
	
	
	FileInputStream fileInputstream;
	Properties properties = new Properties();
	
	public  Utils(WebDriver driver) {
		this.driver = driver;
	}
		public Properties readpropertyfile (String filename) throws IOException{
			FileInputStream FileInput = new FileInputStream(new File(filename));
			properties.load(FileInput);
			return properties;
	}
	public void waitVisibilityConditionByXpath(String xpath,int time) throws NoSuchElement {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	public void waitVisibilityConditionByCssSelector(String cssSelector,int time) throws IOException {
		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
		
	}
	public void writeEmailIdInPropertyFile(String key,String value) throws IOException{
        outputStream = new FileOutputStream(new File("EmailDatabase.properties"));
        properties = new Properties();
        properties.setProperty(key, value);
        properties.store(outputStream,"Email");
	
    }
	
	public LoginPage navigateback(WebDriver driver) throws IOException, NoSuchElement{
		driver.navigate().back();
		return new LoginPage(driver);
	}
	
	
}
