package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.LoginPageUI;

public class LogInPageObject extends AbstractPages {
	WebDriver driver;

	public LogInPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextbox(String valueToInput) {
		waitForAElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		inputToElement(driver, LoginPageUI.EMAIL_TEXTBOX, valueToInput);
	}

	public void inputToPasswordTextbox(String valueToInput) {
		waitForAElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		inputToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, valueToInput);
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOG_IN_BUTTON);
		clickToElement(driver, LoginPageUI.LOG_IN_BUTTON);
	}

	public String getErrorMessage() {
		waitForAElementVisible(driver, LoginPageUI.ERROR_MESSAGE_WHEN_INPUT_EMAIL_NOT_EXIST);
		return getTextElement(driver, LoginPageUI.ERROR_MESSAGE_WHEN_INPUT_EMAIL_NOT_EXIST);
	}
}
