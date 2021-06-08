package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPages;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPages {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isMyAccountDisplayed() {
		waitForAElementVisible(driver, HomePageUI.MY_ACCOUNT_IN_HEADER);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_IN_HEADER);

	}

}
