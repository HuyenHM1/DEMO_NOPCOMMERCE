package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.AddressPageUI;

public class AddressPageObject extends AbstractPages {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToAddressFirstNameTextbox(String firstName) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_FIRST_NAME_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToAddressLastNameTextbox(String lastName) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_LAST_NAME_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToAddressEmailTextbox(String email) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_EMAIL_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_EMAIL_TEXTBOX, email);
	}

	public void inputToAddressCompanyTextbox(String company) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_COMPANY_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_COMPANY_TEXTBOX, company);
	}

	public void selectAddressCountryDropDown(String country) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_COUNTRY_DROP_DOWN);
		selectItemInDropDown(driver, AddressPageUI.ADDRESS_COUNTRY_DROP_DOWN, country);
	}

	public void selectAddressStateDropDown(String state) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_STATE_DROP_DOWN);
		selectItemInDropDown(driver, AddressPageUI.ADDRESS_STATE_DROP_DOWN, state);
	}

	public void inputToAddressCityTextbox(String city) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_CITY_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_ADDRESS_1_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_ADDRESS_1_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_ADDRESS_2_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_ADDRESS_2_TEXTBOX, address2);
	}

	public void inputToZipPostalCodeTextbox(String zipPostalCode) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_ZIP_POST_CODE_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_ZIP_POST_CODE_TEXTBOX, zipPostalCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_FAX_NUMBER_TEXTBOX);
		inputToElement(driver, AddressPageUI.ADDRESS_FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AddressPageUI.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, AddressPageUI.ADDRESS_SAVE_BUTTON);
	}

	public String getValueOfAddressFullName() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_FULL_NAME_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_FULL_NAME_DISPLAY);
	}

	public String getValueOfAddressEmail() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_EMAIL_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_EMAIL_DISPLAY);

	}

	public String getValueOfAddressPhoneNumber() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_PHONE_NUMBER_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_PHONE_NUMBER_DISPLAY);
	}

	public String getValueOfAddressFaxNumber() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_FAX_NUMBER_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_FAX_NUMBER_DISPLAY);
	}

	public String getValueOfAddressCompany() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_COMPANY_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_COMPANY_DISPLAY);
	}

	public String getValueOfAddress1() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_1_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_1_DISPLAY);
	}

	public String getValueOfAddress2() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_2_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_2_DISPLAY);
	}

	public String getValueOfAddressCityStateZip() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_CITY_STATE_ZIP_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_CITY_STATE_ZIP_DISPLAY);
	}

	public String getValueOfAddressCountry() {
		waitForAElementVisible(driver, AddressPageUI.ADDRESS_COUNTRY_DISPLAY);
		return getTextElement(driver, AddressPageUI.ADDRESS_COUNTRY_DISPLAY);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, AddressPageUI.ADDRESS_ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADDRESS_ADD_NEW_BUTTON);
	}

}
