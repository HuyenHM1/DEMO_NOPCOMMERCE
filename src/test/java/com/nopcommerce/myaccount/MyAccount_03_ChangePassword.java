package com.nopcommerce.myaccount;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_Register;

import commons.AbstractTests;
import commons.PageGeneraterManager;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LogInPageObject;
import pageObjects.CustomerInfoPageObject;

public class MyAccount_03_ChangePassword extends AbstractTests{
	private WebDriver driver;
	LogInPageObject loginPage;
	CustomerInfoPageObject myAccountPage;
	ChangePasswordPageObject changePasswordPage;
	HomePageObject homePage;
	private String newPassword = "12345678";
	
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
		myAccountPage = PageGeneraterManager.getCustomerInfoPage(driver);
	}

	@Test
	public void TC_01_ChangePassword() {
		myAccountPage.openPageInLeftMenuInMyAccount(driver, "change-password");
		changePasswordPage = PageGeneraterManager.getChangePasswordPage(driver);
		changePasswordPage.inputToOldPasswordTextbox(Common_Register.password);
		changePasswordPage.inputToNewPasswordTextbox(newPassword);
		changePasswordPage.inputToConfirNewPasswordTextbox(newPassword);
		changePasswordPage.clickToChangePasswordButton();
		verifyEquals(changePasswordPage.getSuccessMessage(), "Password was changed");
	}
	
	@Test
	public void TC_02_LoginWithNewPassword() {
		changePasswordPage.closeMessageBanner();
		changePasswordPage.openPageInHeader(driver, "ico-logout");
		homePage = PageGeneraterManager.getHomePage(driver);
		homePage.openPageInHeader(driver, "ico-login");
		loginPage = PageGeneraterManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(Common_Register.email);
		loginPage.inputToPasswordTextbox(newPassword);
		loginPage.clickToLoginButton();
		homePage = PageGeneraterManager.getHomePage(driver);
		verifyTrue(homePage.isMyAccountDisplayed());
	}
	
	@Test
	public void TC_03_LoginWithOldPassword() {
		homePage.openPageInHeader(driver, "ico-logout");
		homePage.openPageInHeader(driver, "ico-login");
		loginPage = PageGeneraterManager.getLoginPage(driver);
		loginPage.inputToEmailTextbox(Common_Register.email);
		loginPage.inputToPasswordTextbox(Common_Register.password);
		loginPage.clickToLoginButton();
		assertEquals(loginPage.getErrorMessage(),"Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		Common_Register.password = newPassword;
		closeBrowserAndDriver(driver);
	}

}
