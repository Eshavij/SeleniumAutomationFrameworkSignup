package com.esha.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.automation.browsers.Browser;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;
import com.automation.pages.SignupPageChecker;
import com.automation.pages.SignupConfirm;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;

/**
 * Test Class
 * @author esha
 *
 */
public class VerifyPagesTest { 
	WebDriver driver;
	HomePage homepage;
	LoginPage loginPage;
	SignupPage signUpPage;
	SignupConfirm signupConfirm;
	
	@BeforeClass
	public void start() throws IOException, FileNotFound{
		Browser b = new Browser();
		driver = b.startBrowser();
	}
	
	@Test
	public void testVerifyHomepage() throws IOException, FileNotFound, NoSuchElement{ 
		
		homepage=new HomePage(driver);
		
		loginPage=homepage.openHomePageUrl()
						.check().homepagetitle()
						.check().loginchecker()
						.clickLoginButton();
	}
	
	@Test(dependsOnMethods="testVerifyHomepage")
	public void testVerifyloginpage() throws IOException, NoSuchElement, FileNotFound{
		signUpPage= loginPage.check().verifySignUpTitle()
							 .check().verifySignUpButtonDisplayed()
							 .clickSignUp(driver); 
	} 
				
	@Test(dependsOnMethods="testVerifyloginpage")
	public void testVerifySignUpPage() throws IOException, FileNotFound, InterruptedException, NoSuchElement{
	 signUpPage = signUpPage.check().Signuptitle()
			 					.check().signupchecker();
								
	}

	@AfterClass
	public void exit(){
		driver.close();	
	}
	
}

