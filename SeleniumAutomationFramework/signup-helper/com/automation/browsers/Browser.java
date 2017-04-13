package com.automation.browsers;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;


import com.automation.pages.ReportLog;

import exceptionhandling.FileNotFound;
/**
 * Class for selecting browser
 * @author esha
 *
 */

public class Browser {
	ReportLog log = new ReportLog();
	Properties properties = new Properties();
	WebDriver driver;
	

	public Browser() throws IOException, FileNotFound {
		try {

			FileInputStream FileInput = new FileInputStream(new File("HomePage.properties"));
			properties.load(FileInput);
		} catch (Exception e) {
			throw new FileNotFound("File not Found");
		}
	}

	public WebDriver startBrowser() {
		
			String browser = System.getProperty("browser");
			if(browser==null)
			{
				browser = properties.getProperty("browser");
			}
			
		if (browser.equalsIgnoreCase("firefox")) {
			log.info("Firefox is launched");

			System.setProperty(properties.getProperty("fdrivername"), properties.getProperty("fdriverpath"));
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			log.info("Safari is launched");
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			log.info("Chrome is launched");
			Reporter.log("Initialze the chromebrowser");
			System.setProperty(properties.getProperty("cdrivername"), properties.getProperty("cdriverpath"));
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();  
		return driver;

	}
}
