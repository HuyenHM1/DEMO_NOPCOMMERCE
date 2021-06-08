package com.nopcommerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register;

import commons.AbstractTests;
import commons.PageGeneraterManager;
import pageObjects.LogInPageObject;
import pageObjects.CustomerInfoPageObject;

public class MyAccount_01_CustomerInfo extends AbstractTests {
	WebDriver driver;
	LogInPageObject loginPage;
	CustomerInfoPageObject myAccountPage;
	private String updatedEmail = "HM123" + random() + "@gmail.com";
	private String updatedFirstName = "HM123";
	private String updatedLastName = "HM123";
	private String updatedDay = "15";
	private String updatedMonth = "September";
	private String updatedYear = "1994";
	private String updatedCompany = "NopCommerce123";
	private String updatedGender = "male";

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		loginPage = PageGeneraterManager.getLoginPage(driver);
		loginPage.openPageInHeader(driver, "ico-login");
		loginPage.inputToEmailTextbox(Common_Register.email);
		loginPage.inputToPasswordTextbox(Common_Register.password);
		loginPage.clickToLoginButton();
		loginPage.openPageInHeader(driver, "ico-account");
		myAccountPage = PageGeneraterManager.getCustomerInfoPage(driver);
	}

	@Test
	public void TC_01_UpdateCustomerInformation() {
		myAccountPage.selectGenderRadioButton(updatedGender);
		myAccountPage.inputToFirstNameTextbox(updatedFirstName);
		myAccountPage.inputToLastNameTextbox(updatedLastName);
		myAccountPage.selectDayDropDown(updatedDay);
		myAccountPage.selectMonthDropDown(updatedMonth);
		myAccountPage.selectYearDropDown(updatedYear);
		myAccountPage.inputToEmailTextbox(updatedEmail);
		myAccountPage.inputCompanyNameTextbox(updatedCompany);
		myAccountPage.uncheckNewsletterCheckbox();
		myAccountPage.clickOnSaveButton();

		verifyEquals(myAccountPage.getValueOfFirstNameTexbox(), updatedFirstName);
		verifyEquals(myAccountPage.getValueOfLastNameTexbox(), updatedLastName);
		verifyEquals(myAccountPage.getValueOfDayDropdown(), updatedDay);
		verifyEquals(myAccountPage.getValueOfMonthDropdown(), updatedMonth);
		verifyEquals(myAccountPage.getValueOfYearDropdown(), updatedYear);
		verifyEquals(myAccountPage.getValueOfEmailTexbox(), updatedEmail);
		verifyEquals(myAccountPage.getValueOfCompanyNameTexbox(), updatedCompany);
		verifyTrue(myAccountPage.isGenderSelected(updatedGender));
		verifyFalse(myAccountPage.isNewsletterSelected());
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		Common_Register.email = updatedEmail;
		closeBrowserAndDriver(driver);
	}

}
