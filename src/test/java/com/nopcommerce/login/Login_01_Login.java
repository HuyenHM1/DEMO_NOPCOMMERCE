package com.nopcommerce.login;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register;

import commons.AbstractTests;
import commons.PageGeneraterManager;
import pageObjects.HomePageObject;
import pageObjects.LogInPageObject;

public class Login_01_Login extends AbstractTests {
	WebDriver driver;
	HomePageObject homePage;
	LogInPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneraterManager.getHomePage(driver);
	}

	@BeforeMethod
	public void beforeMethod() {
		homePage.openPageInHeader(driver, "ico-login");
		loginPage = PageGeneraterManager.getLoginPage(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyData() {
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getInlineErrorMessage(driver, "Email"), "Please enter your email");
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPage.inputToEmailTextbox("HM@b.@c");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getInlineErrorMessage(driver, "Email"), "Wrong email");
	}

	@Test
	public void TC_03_LoginWithNotExistingEmail() {
		loginPage.inputToEmailTextbox("HM" + random() + "@gmail.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_LoginWithExistingEmailAndEmptyPassword() {
		loginPage.inputToEmailTextbox(Common_Register.email);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");

	}

	@Test
	public void TC_05_LoginWithExistingEmailAndIncorrectPassword() {
		loginPage.inputToEmailTextbox(Common_Register.email);
		loginPage.inputToPasswordTextbox("123567");
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_LoginWithValidAndCorrectEmailAndPassword() {
		loginPage.inputToEmailTextbox(Common_Register.email);
		loginPage.inputToPasswordTextbox(Common_Register.password);
		loginPage.clickToLoginButton();
		homePage = PageGeneraterManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}
}
