package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.ChangePasswordPageUI;

public class ChangePasswordPageObject extends AbstractPages {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToOldPasswordTextbox(String oldPassword) {
		waitForAElementVisible(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXT_BOX);
		inputToElement(driver, ChangePasswordPageUI.OLD_PASSWORD_TEXT_BOX, oldPassword);
	}

	public void inputToNewPasswordTextbox(String newPassword) {
		waitForAElementVisible(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXT_BOX);
		inputToElement(driver, ChangePasswordPageUI.NEW_PASSWORD_TEXT_BOX, newPassword);
	}

	public void inputToConfirNewPasswordTextbox(String confirmNewPassword) {
		waitForAElementVisible(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXT_BOX);
		inputToElement(driver, ChangePasswordPageUI.CONFIRM_NEW_PASSWORD_TEXT_BOX, confirmNewPassword);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}

	public String getSuccessMessage() {
		waitForAElementVisible(driver, ChangePasswordPageUI.SUCCESS_MESSAGE);
		return getTextElement(driver, ChangePasswordPageUI.SUCCESS_MESSAGE);
	}

	public void closeMessageBanner() {
		waitForAElementVisible(driver, ChangePasswordPageUI.CLOSE_MESSAGE_BANNER_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CLOSE_MESSAGE_BANNER_BUTTON);
	}
	
	
}
