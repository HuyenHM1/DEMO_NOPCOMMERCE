package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageObjects.LogInPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneraterManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LogInPageObject getLoginPage(WebDriver driver) {
		return new LogInPageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}

}
