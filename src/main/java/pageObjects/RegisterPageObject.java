package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPages {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnRegisterButton() {
		waitForAElementVisible(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public void inputToFirstNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		inputToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, valueToInput);
	}

	public void inputToLastNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		inputToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, valueToInput);

	}

	public void inputToEmailTextbox(String valueToInput) {
		waitForAElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		inputToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, valueToInput);

	}

	public void inputToPasswordTextbox(String valueToInput) {
		waitForAElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		inputToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, valueToInput);
	}

	public void inputToConfirmPasswordTextbox(String valueToInput) {
		waitForAElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		inputToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, valueToInput);
	}

	public String getErrorMessageWhenInputExistEmail() {
		waitForAElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_WHEN_INPUT_EXIST_EMAIL);
		return getTextElement(driver, RegisterPageUI.ERROR_MESSAGE_WHEN_INPUT_EXIST_EMAIL);

	}

	public String getErrorMessageWhenPasswordLessThan6Chars(String values) {
		waitForAElementVisible(driver, RegisterPageUI.ERROR_MESSAGE_WHEN_INPUT_PASSWORD_LESS_THAN_6_CHARS);
		return getTextElement(driver, RegisterPageUI.ERROR_MESSAGE_WHEN_INPUT_PASSWORD_LESS_THAN_6_CHARS);
	}

	public String getSuccessMessageWhenRegister() {
		waitForAElementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE_WHEN_REGISTER);
		return getTextElement(driver, RegisterPageUI.SUCCESS_MESSAGE_WHEN_REGISTER);
	}

	public void selectGenderRadioButton(String gender) {
		waitForAElementVisible(driver, RegisterPageUI.GENDER_RADIO_BUTTON, gender);
		clickToElement(driver, RegisterPageUI.GENDER_RADIO_BUTTON, gender);
	}

	public void selectDayDropDown(String day) {
		waitForAElementVisible(driver, RegisterPageUI.DAY_DROP_DOWN);
		selectItemInDropDown(driver, RegisterPageUI.DAY_DROP_DOWN, day);
	}

	public void selectMonthDropDown(String month) {
		waitForAElementVisible(driver, RegisterPageUI.MONTH_DROP_DOWN);
		selectItemInDropDown(driver, RegisterPageUI.MONTH_DROP_DOWN, month);
	}

	public void selectYearDropDown(String year) {
		waitForAElementVisible(driver, RegisterPageUI.YEAR_DROP_DOWN);
		selectItemInDropDown(driver, RegisterPageUI.YEAR_DROP_DOWN, year);
		
	}

	public void inputCompanyNameTextbox(String valueToInput) {
		waitForAElementVisible(driver, RegisterPageUI.COMPANY_TEXTBOX);
		inputToElement(driver, RegisterPageUI.COMPANY_TEXTBOX, valueToInput);
	}
	
	public void selectNewsletterCheckbox() {
		waitForAElementVisible(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);
		unCheckTheCheckbox(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);
		checkTheCheckbox(driver, RegisterPageUI.NEWSLETTER_CHECKBOX);
		
	}

}
