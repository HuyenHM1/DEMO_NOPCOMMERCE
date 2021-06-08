package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends AbstractPages {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGenderRadioButton(String gender) {
		waitForAElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
		clickToElement(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
	}

	public void inputToFirstNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXT_BOX);
		inputToElement(driver, CustomerInfoPageUI.FIRST_NAME_TEXT_BOX, valueToInput);
	}

	public void inputToLastNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXT_BOX);
		inputToElement(driver, CustomerInfoPageUI.LAST_NAME_TEXT_BOX, valueToInput);
	}

	public void selectDayDropDown(String day) {
		waitForAElementVisible(driver, CustomerInfoPageUI.DAY_DROP_DOWN);
		selectItemInDropDown(driver, CustomerInfoPageUI.DAY_DROP_DOWN, day);
	}

	public void selectMonthDropDown(String month) {
		waitForAElementVisible(driver, CustomerInfoPageUI.MONTH_DROP_DOWN);
		selectItemInDropDown(driver, CustomerInfoPageUI.MONTH_DROP_DOWN, month);
	}

	public void selectYearDropDown(String year) {
		waitForAElementVisible(driver, CustomerInfoPageUI.YEAR_DROP_DOWN);
		selectItemInDropDown(driver, CustomerInfoPageUI.YEAR_DROP_DOWN, year);
	}

	public void inputToEmailTextbox(String email) {
		waitForAElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		inputToElement(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputCompanyNameTextbox(String company) {
		waitForAElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		inputToElement(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, company);
	}

	public void uncheckNewsletterCheckbox() {
		waitForElementClickable(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		unCheckTheCheckbox(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

	public void clickOnSaveButton() {
		waitForElementClickable(driver, CustomerInfoPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInfoPageUI.SAVE_BUTTON);
	}

	public String getValueOfFirstNameTexbox() {
		waitForAElementVisible(driver, CustomerInfoPageUI.FIRST_NAME_TEXT_BOX);
		return getAttributeValue(driver, CustomerInfoPageUI.FIRST_NAME_TEXT_BOX, "value");
	}

	public String getValueOfLastNameTexbox() {
		waitForAElementVisible(driver, CustomerInfoPageUI.LAST_NAME_TEXT_BOX);
		return getAttributeValue(driver, CustomerInfoPageUI.LAST_NAME_TEXT_BOX, "value");
	}

	public String getValueOfDayDropdown() {
		waitForAElementVisible(driver, CustomerInfoPageUI.DAY_DROP_DOWN);
		return getSelectedItemInDropDown(driver, CustomerInfoPageUI.DAY_DROP_DOWN);
	}

	public String getValueOfMonthDropdown() {
		waitForAElementVisible(driver, CustomerInfoPageUI.MONTH_DROP_DOWN);
		return getSelectedItemInDropDown(driver, CustomerInfoPageUI.MONTH_DROP_DOWN);
	}

	public String getValueOfYearDropdown() {
		waitForAElementVisible(driver, CustomerInfoPageUI.YEAR_DROP_DOWN);
		return getSelectedItemInDropDown(driver, CustomerInfoPageUI.YEAR_DROP_DOWN);
	}

	public String getValueOfEmailTexbox() {
		waitForAElementVisible(driver, CustomerInfoPageUI.EMAIL_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getValueOfCompanyNameTexbox() {
		waitForAElementVisible(driver, CustomerInfoPageUI.COMPANY_TEXTBOX);
		return getAttributeValue(driver, CustomerInfoPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isGenderSelected(String gender) {
		waitForAElementVisible(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
		return isElementSelected(driver, CustomerInfoPageUI.GENDER_RADIO_BUTTON, gender);
	}

	public boolean isNewsletterSelected() {
		waitForAElementVisible(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInfoPageUI.NEWSLETTER_CHECKBOX);
	}

}
