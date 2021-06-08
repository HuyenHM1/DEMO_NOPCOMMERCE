package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTests;
import commons.PageGeneraterManager;
import pageObjects.HomePageObject;
import pageObjects.LogInPageObject;
import pageObjects.RegisterPageObject;

public class Common_Register extends AbstractTests {
	WebDriver driver;
	HomePageObject homePage;
	LogInPageObject loginPage;
	RegisterPageObject registerPage;
	public static String email = "HM" + random() + "@gmail.com";
	public static String password = "123456";
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneraterManager.getHomePage(driver);
		homePage.openPageInHeader(driver, "ico-register");
		registerPage = PageGeneraterManager.getRegisterPage(driver);
		registerPage.selectGenderRadioButton("female");
		registerPage.inputToFirstNameTextbox("HM");
		registerPage.inputToLastNameTextbox("HM");
		registerPage.selectDayDropDown("12");
		registerPage.selectMonthDropDown("December");
		registerPage.selectYearDropDown("1945");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputCompanyNameTextbox("NopCommerce");
		registerPage.selectNewsletterCheckbox();
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getSuccessMessageWhenRegister(), "Your registration completed");
		closeBrowserAndDriver(driver);
	}

}
