package com.nopcommerce.myaccount;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.nopcommerce.common.Common_Register;
import commons.AbstractTests;
import commons.PageGeneraterManager;
import pageObjects.AddressPageObject;
import pageObjects.LogInPageObject;

public class MyAccount_02_AddAddress extends AbstractTests {
	WebDriver driver;
	LogInPageObject loginPage;
	AddressPageObject addressPage;
	private String addressFirstName = "HM";
	private String addressLastName = "Hoang";
	private String addressEmail = "HM" + random() + "@gmail.com";
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
		addressPage = PageGeneraterManager.getAddressPage(driver);
	}

	@Test
	public void TC_01_AddAddress() {
		addressPage.openPageInLeftMenuInMyAccount(driver, "customer-addresses");
		addressPage.clickToAddNewButton();
		addressPage.inputToAddressFirstNameTextbox(addressFirstName);
		addressPage.inputToAddressLastNameTextbox(addressLastName);
		addressPage.inputToAddressEmailTextbox(addressEmail);
		addressPage.inputToAddressCompanyTextbox(addressCompany);
		addressPage.selectAddressCountryDropDown(addressCountry);
		addressPage.selectAddressStateDropDown(addressState);
		addressPage.inputToAddressCityTextbox(addressCity);
		addressPage.inputToAddress1Textbox(addressAddress1);
		addressPage.inputToAddress2Textbox(addressAddress2);
		addressPage.inputToZipPostalCodeTextbox(addressZipPostalCode);
		addressPage.inputToPhoneNumberTextbox(addressPhoneNumber);
		addressPage.inputToFaxNumberTextbox(addressFaxNumber);
		addressPage.clickToSaveButton();

		verifyEquals(addressPage.getValueOfAddressFullName(), addressFirstName + " " + addressLastName);
		verifyEquals(addressPage.getValueOfAddressEmail(), "Email: " + addressEmail);
		verifyEquals(addressPage.getValueOfAddressPhoneNumber(), "Phone number: " + addressPhoneNumber);
		verifyEquals(addressPage.getValueOfAddressFaxNumber(), "Fax number: " + addressFaxNumber);
		verifyEquals(addressPage.getValueOfAddressCompany(), addressCompany);
		verifyEquals(addressPage.getValueOfAddress1(), addressAddress1);
		verifyEquals(addressPage.getValueOfAddress2(), addressAddress2);
		if (addressCountry.equalsIgnoreCase("United States")) {
			verifyEquals(addressPage.getValueOfAddressCityStateZip(),
					addressCity + ", " + addressState + ", " + addressZipPostalCode);
		} else {
			verifyEquals(addressPage.getValueOfAddressCityStateZip(), addressCity + ", " + addressZipPostalCode);
		}
		verifyEquals(addressPage.getValueOfAddressCountry(), addressCountry);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

}
