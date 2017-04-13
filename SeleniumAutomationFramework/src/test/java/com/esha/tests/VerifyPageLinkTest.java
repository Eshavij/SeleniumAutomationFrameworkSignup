package com.esha.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.browsers.Browser;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupConfirm;
import com.automation.pages.SignupPage;

import exceptionhandling.FileNotFound;
import exceptionhandling.NoSuchElement;

public class VerifyPageLinkTest {
	WebDriver driver;
	HomePage homepage;
	LoginPage loginPage;
	SignupPage signUpPage;
	SignupConfirm signupConfirm;
	
	@BeforeClass
	public void setUp() throws IOException, FileNotFound, NoSuchElement{
		Browser b = new Browser();
		driver = b.startBrowser();
homepage=new HomePage(driver);
		
		loginPage=homepage.openHomePageUrl()
						.clickLoginButton();
		signUpPage= loginPage
				 .clickSignUp(driver);
	}
	
	@Test
	public void testVerifySignupSuccess() throws IOException, FileNotFound, NoSuchElement{
		signupConfirm = signUpPage.emailid().clickSignUpButton()
					 .verifysignup2();
	}
	
	@Test(dependsOnMethods="testVerifySignupSuccess")
	public void testVerifySignupFailure() throws NoSuchElement, IOException, FileNotFound{
		loginPage = loginPage.nav().
				navigateback(driver)
				.clickSignUp(driver)
				.emailidFromProp()
				.clickSignUpButton()
				.verifySignUpFailure();
	}
	
	@AfterClass
	public void exit(){
		driver.close();	
	}
}
