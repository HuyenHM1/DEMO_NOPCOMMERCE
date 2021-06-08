package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.MyAccountPageUIs;

public class MyAccountPageObject extends AbstractPages {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGenderRadioButton(String gender) {
		waitForAElementVisible(driver, MyAccountPageUIs.GENDER_RADIO_BUTTON, gender);
		clickToElement(driver, MyAccountPageUIs.GENDER_RADIO_BUTTON, gender);
	}

	public void inputToFirstNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, MyAccountPageUIs.FIRST_NAME_TEXT_BOX);
		inputToElement(driver, MyAccountPageUIs.FIRST_NAME_TEXT_BOX, valueToInput);
	}

	public void inputToLastNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, MyAccountPageUIs.LAST_NAME_TEXT_BOX);
		inputToElement(driver, MyAccountPageUIs.LAST_NAME_TEXT_BOX, valueToInput);
	}

	public void selectDayDropDown(String day) {
		waitForAElementVisible(driver, MyAccountPageUIs.DAY_DROP_DOWN);
		selectItemInDropDown(driver, MyAccountPageUIs.DAY_DROP_DOWN, day);
	}

	public void selectMonthDropDown(String month) {
		waitForAElementVisible(driver, MyAccountPageUIs.MONTH_DROP_DOWN);
		selectItemInDropDown(driver, MyAccountPageUIs.MONTH_DROP_DOWN, month);
	}

	public void selectYearDropDown(String year) {
		waitForAElementVisible(driver, MyAccountPageUIs.YEAR_DROP_DOWN);
		selectItemInDropDown(driver, MyAccountPageUIs.YEAR_DROP_DOWN, year);
	}

	public void inputToEmailTextbox(String email) {
		waitForAElementVisible(driver, MyAccountPageUIs.EMAIL_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.EMAIL_TEXTBOX, email);
	}

	public void inputCompanyNameTextbox(String company) {
		waitForAElementVisible(driver, MyAccountPageUIs.COMPANY_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.COMPANY_TEXTBOX, company);
	}

	public void uncheckNewsletterCheckbox() {
		waitForElementClickable(driver, MyAccountPageUIs.NEWSLETTER_CHECKBOX);
		unCheckTheCheckbox(driver, MyAccountPageUIs.NEWSLETTER_CHECKBOX);
	}

	public void clickOnSaveButton() {
		waitForElementClickable(driver, MyAccountPageUIs.SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUIs.SAVE_BUTTON);
	}

	public String getValueOfFirstNameTexbox() {
		waitForAElementVisible(driver, MyAccountPageUIs.FIRST_NAME_TEXT_BOX);
		return getAttributeValue(driver, MyAccountPageUIs.FIRST_NAME_TEXT_BOX, "value");
	}

	public String getValueOfLastNameTexbox() {
		waitForAElementVisible(driver, MyAccountPageUIs.LAST_NAME_TEXT_BOX);
		return getAttributeValue(driver, MyAccountPageUIs.LAST_NAME_TEXT_BOX, "value");
	}

	public String getValueOfDayDropdown() {
		waitForAElementVisible(driver, MyAccountPageUIs.DAY_DROP_DOWN);
		return getSelectedItemInDropDown(driver, MyAccountPageUIs.DAY_DROP_DOWN);
	}

	public String getValueOfMonthDropdown() {
		waitForAElementVisible(driver, MyAccountPageUIs.MONTH_DROP_DOWN);
		return getSelectedItemInDropDown(driver, MyAccountPageUIs.MONTH_DROP_DOWN);
	}

	public String getValueOfYearDropdown() {
		waitForAElementVisible(driver, MyAccountPageUIs.YEAR_DROP_DOWN);
		return getSelectedItemInDropDown(driver, MyAccountPageUIs.YEAR_DROP_DOWN);
	}

	public String getValueOfEmailTexbox() {
		waitForAElementVisible(driver, MyAccountPageUIs.EMAIL_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUIs.EMAIL_TEXTBOX, "value");
	}

	public String getValueOfCompanyNameTexbox() {
		waitForAElementVisible(driver, MyAccountPageUIs.COMPANY_TEXTBOX);
		return getAttributeValue(driver, MyAccountPageUIs.COMPANY_TEXTBOX, "value");
	}

	public boolean isGenderSelected(String gender) {
		waitForAElementVisible(driver, MyAccountPageUIs.GENDER_RADIO_BUTTON, gender);
		return isElementSelected(driver, MyAccountPageUIs.GENDER_RADIO_BUTTON, gender);
	}

	public boolean isNewsletterSelected() {
		waitForAElementVisible(driver, MyAccountPageUIs.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, MyAccountPageUIs.NEWSLETTER_CHECKBOX);
	}

	public void inputToAddressFirstNameTextbox(String firstName) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_FIRST_NAME_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_FIRST_NAME_TEXTBOX, firstName);
	}

	public void inputToAddressLastNameTextbox(String lastName) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_LAST_NAME_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_LAST_NAME_TEXTBOX, lastName);
	}

	public void inputToAddressEmailTextbox(String email) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_EMAIL_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_EMAIL_TEXTBOX, email);
	}

	public void inputToAddressCompanyTextbox(String company) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_COMPANY_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_COMPANY_TEXTBOX, company);
	}

	public void selectAddressCountryDropDown(String country) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_COUNTRY_DROP_DOWN);
		selectItemInDropDown(driver, MyAccountPageUIs.ADDRESS_COUNTRY_DROP_DOWN, country);
	}

	public void selectAddressStateDropDown(String state) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_STATE_DROP_DOWN);
		selectItemInDropDown(driver, MyAccountPageUIs.ADDRESS_STATE_DROP_DOWN, state);
	}

	public void inputToAddressCityTextbox(String city) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_CITY_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_CITY_TEXTBOX, city);
	}

	public void inputToAddress1Textbox(String address1) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_ADDRESS_1_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_ADDRESS_1_TEXTBOX, address1);
	}

	public void inputToAddress2Textbox(String address2) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_ADDRESS_2_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_ADDRESS_2_TEXTBOX, address2);
	}

	public void inputToZipPostalCodeTextbox(String zipPostalCode) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_ZIP_POST_CODE_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_ZIP_POST_CODE_TEXTBOX, zipPostalCode);
	}

	public void inputToPhoneNumberTextbox(String phoneNumber) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_PHONE_NUMBER_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public void inputToFaxNumberTextbox(String faxNumber) {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_FAX_NUMBER_TEXTBOX);
		inputToElement(driver, MyAccountPageUIs.ADDRESS_FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, MyAccountPageUIs.ADDRESS_SAVE_BUTTON);
		clickToElement(driver, MyAccountPageUIs.ADDRESS_SAVE_BUTTON);
	}

	public String getValueOfAddressFullName() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_FULL_NAME_DISPLAY);
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_FULL_NAME_DISPLAY);
	}

	public String getValueOfAddressEmail() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_EMAIL_DISPLAY);
		System.out.println(getTextElement(driver, MyAccountPageUIs.ADDRESS_EMAIL_DISPLAY));
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_EMAIL_DISPLAY);
		
	}

	public String getValueOfAddressPhoneNumber() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_PHONE_NUMBER_DISPLAY);
		System.out.println(getTextElement(driver, MyAccountPageUIs.ADDRESS_PHONE_NUMBER_DISPLAY));
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_PHONE_NUMBER_DISPLAY);
	}

	public String getValueOfAddressFaxNumber() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_FAX_NUMBER_DISPLAY);
		System.out.println(getTextElement(driver, MyAccountPageUIs.ADDRESS_FAX_NUMBER_DISPLAY));
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_FAX_NUMBER_DISPLAY);
	}

	public String getValueOfAddressCompany() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_COMPANY_DISPLAY);
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_COMPANY_DISPLAY);
	}

	public String getValueOfAddress1() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_1_DISPLAY);
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_1_DISPLAY);
	}

	public String getValueOfAddress2() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_2_DISPLAY);
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_2_DISPLAY);
	}

	public String getValueOfAddressCityStateZip() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_CITY_STATE_ZIP_DISPLAY);
		System.out.println(getTextElement(driver, MyAccountPageUIs.ADDRESS_CITY_STATE_ZIP_DISPLAY));
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_CITY_STATE_ZIP_DISPLAY);
	}

	public String getValueOfAddressCountry() {
		waitForAElementVisible(driver, MyAccountPageUIs.ADDRESS_COUNTRY_DISPLAY);
		return getTextElement(driver, MyAccountPageUIs.ADDRESS_COUNTRY_DISPLAY);
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, MyAccountPageUIs.ADDRESS_ADD_NEW_BUTTON);
		clickToElement(driver, MyAccountPageUIs.ADDRESS_ADD_NEW_BUTTON);
	}
}
