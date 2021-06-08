package com.nopcommerce.registration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcommerce.common.Common_Register;
import commons.AbstractTests;
import commons.PageGeneraterManager;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Registration_01_Register extends AbstractTests {
	WebDriver driver;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	String registerUrl;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(@Optional("firefox") String browserName) {
		driver = getBrowserDriver(browserName);
		homePage  = PageGeneraterManager.getHomePage(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		homePage.openPageInHeader(driver, "ico-register");
		registerPage = PageGeneraterManager.getRegisterPage(driver);
	}
	
	@Test
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getInlineErrorMessage(driver, "FirstName"), "First name is required.");
		verifyEquals(registerPage.getInlineErrorMessage(driver, "LastName"), "Last name is required.");
		verifyEquals(registerPage.getInlineErrorMessage(driver, "Email"), "Email is required.");
		verifyEquals(registerPage.getInlineErrorMessage(driver, "Password"), "Password is required.");
		verifyEquals(registerPage.getInlineErrorMessage(driver, "ConfirmPassword"), "Password is required.");
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.inputToFirstNameTextbox("HM");
		registerPage.inputToLastNameTextbox("HM");
		registerPage.inputToEmailTextbox("HM@b.com@");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getInlineErrorMessage(driver, "Email"), "Wrong email");
		
	}

	@Test
	public void TC_03_RegisterWithExistingEmail() {
		registerPage.inputToFirstNameTextbox("HM");
		registerPage.inputToLastNameTextbox("HM");
		registerPage.inputToEmailTextbox(Common_Register.email);
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getErrorMessageWhenInputExistEmail(), "The specified email already exists");
	}

	@Test
	public void TC_04_RegisterWithPasswordLessThan6Chars() {
		registerPage.inputToFirstNameTextbox("HM");
		registerPage.inputToLastNameTextbox("HM");
		registerPage.inputToEmailTextbox("HM" + random() + "@gmail.com");
		registerPage.inputToPasswordTextbox("123");
		registerPage.inputToConfirmPasswordTextbox("123");
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getErrorMessageWhenPasswordLessThan6Chars("Password"), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}

	@Test
	public void TC_05_RegisterWithConfirmPasswordNotMatchPassword() {
		registerPage.inputToFirstNameTextbox("HM");
		registerPage.inputToLastNameTextbox("HM");
		registerPage.inputToEmailTextbox("HM" + random() + "@gmail.com");
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("1234567");
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getInlineErrorMessage(driver, "ConfirmPassword"), "The password and confirmation password do not match.");
	}

	@Test
	public void TC_06_RegisterWithValidData() {
		registerPage.selectGenderRadioButton("male");
		registerPage.inputToFirstNameTextbox("HM");
		registerPage.inputToLastNameTextbox("HM");
		registerPage.selectDayDropDown("13");
		registerPage.selectMonthDropDown("November");
		registerPage.selectYearDropDown("1965");
		registerPage.inputToEmailTextbox("HM" + random() + "@gmail.com");
		registerPage.inputCompanyNameTextbox("Bank");
		registerPage.selectNewsletterCheckbox();
		registerPage.inputToPasswordTextbox("123456");
		registerPage.inputToConfirmPasswordTextbox("123456");
		registerPage.clickOnRegisterButton();
		verifyEquals(registerPage.getSuccessMessageWhenRegister(), "Your registration completed");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
