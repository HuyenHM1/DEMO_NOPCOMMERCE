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
import pageObjects.MyAccountPageObject;

public class MyAccount_01_MyAccount extends AbstractTests {
	WebDriver driver;
	LogInPageObject loginPage;
	MyAccountPageObject myAccountPage;
	private String updatedEmail = "HM123" + random() + "@gmail.com";
	private String updatedFirstName = "HM123";
	private String updatedLastName = "HM123";
	private String updatedDay = "15";
	private String updatedMonth = "September";
	private String updatedYear = "1994";
	private String updatedCompany = "NopCommerce123";
	private String updatedGender = "male";
	
	private String addressFirstName = "HM";
	private String addressLastName = "Hoang";
	private String addressEmail = "HM" + random() +"@gmail.com";
	private String addressCompany = "NopCommerce";
	private String addressCountry = "Viet Nam";
	private String addressState = "Other";
	private String addressCity = "Ha Noi";
	private String addressAddress1 = "275 Nguyen Trai";
	private String addressAddress2 = "165 Bui Xuong Trach";
	private String addressZipPostalCode = "1000";
	private String addressPhoneNumber = "0989632541";
	private String addressFaxNumber = "0985365241";

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
		myAccountPage = PageGeneraterManager.getMyAccountPage(driver);
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
		verifyEquals(myAccountPage.getValueOfLastNameTexbox(),updatedLastName);
		verifyEquals(myAccountPage.getValueOfDayDropdown(), updatedDay);
		verifyEquals(myAccountPage.getValueOfMonthDropdown(), updatedMonth);
		verifyEquals(myAccountPage.getValueOfYearDropdown(), updatedYear);
		verifyEquals(myAccountPage.getValueOfEmailTexbox(), updatedEmail);
		verifyEquals(myAccountPage.getValueOfCompanyNameTexbox(), updatedCompany);
		verifyTrue(myAccountPage.isGenderSelected(updatedGender));
		verifyFalse(myAccountPage.isNewsletterSelected());
	}
	
	@Test
	public void TC_02_AddAddress() {
		myAccountPage.openPageInLeftMenuInMyAccountPage(driver, "customer-addresses");
		myAccountPage.clickToAddNewButton();
		myAccountPage.inputToAddressFirstNameTextbox(addressFirstName);
		myAccountPage.inputToAddressLastNameTextbox(addressLastName);
		myAccountPage.inputToAddressEmailTextbox(addressEmail);
		myAccountPage.inputToAddressCompanyTextbox(addressCompany);
		myAccountPage.selectAddressCountryDropDown(addressCountry);
		myAccountPage.selectAddressStateDropDown(addressState);
		myAccountPage.inputToAddressCityTextbox(addressCity);
		myAccountPage.inputToAddress1Textbox(addressAddress1);
		myAccountPage.inputToAddress2Textbox(addressAddress2);
		myAccountPage.inputToZipPostalCodeTextbox(addressZipPostalCode);
		myAccountPage.inputToPhoneNumberTextbox(addressPhoneNumber);
		myAccountPage.inputToFaxNumberTextbox(addressFaxNumber);
		myAccountPage.clickToSaveButton();
		
		verifyEquals(myAccountPage.getValueOfAddressFullName(), addressFirstName + " " + addressLastName);
		verifyEquals(myAccountPage.getValueOfAddressEmail(), "Email: " + addressEmail);
		verifyEquals(myAccountPage.getValueOfAddressPhoneNumber(), "Phone number: " + addressPhoneNumber);
		verifyEquals(myAccountPage.getValueOfAddressFaxNumber(), "Fax number: " + addressFaxNumber);
		verifyEquals(myAccountPage.getValueOfAddressCompany(), addressCompany);
		verifyEquals(myAccountPage.getValueOfAddress1(), addressAddress1);
		verifyEquals(myAccountPage.getValueOfAddress2(), addressAddress2);
		if(addressCountry.equalsIgnoreCase("United States")) {
			verifyEquals(myAccountPage.getValueOfAddressCityStateZip(), addressCity + ", " + addressState + ", " + addressZipPostalCode);
		}else {
			verifyEquals(myAccountPage.getValueOfAddressCityStateZip(), addressCity + ", " + addressZipPostalCode);
		}
		verifyEquals(myAccountPage.getValueOfAddressCountry(), addressCountry);
		
		
		
		
		
		
		
		
		
		
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
