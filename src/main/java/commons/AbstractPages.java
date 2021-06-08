package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.CommonPageUIs;

public class AbstractPages {
	WebDriver driver;
	WebElement element;
	Select select;
	WebDriverWait explicitWait;
	JavascriptExecutor javascript;
	Actions action;
	long longTimeout = 30;

	public void openURL(WebDriver driver, String uRL) {
		driver.get(uRL);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void inputToAlert(WebDriver driver, String valueToInput) {
		driver.switchTo().alert().sendKeys(valueToInput);
	}

	public void switchWindowByID(WebDriver driver, String parentWindowID) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String windowID : allWindowID) {
			if (!windowID.equals(parentWindowID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}
	}

	public void switchWindowByTitle(WebDriver driver, String titleOfWindow) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String windowID : allWindowID) {
			driver.switchTo().window(windowID);
			String titleOfRunWindow = driver.getTitle();
			if (titleOfRunWindow.equals(titleOfWindow)) {
				break;
			}
		}

	}

	public void closeAllWindowWithoutParent(WebDriver driver, String parentWindowID) {
		Set<String> allWindowID = driver.getWindowHandles();
		for (String WindowID : allWindowID) {
			if (!WindowID.equals(parentWindowID)) {
				driver.switchTo().window(WindowID);
				driver.close();
			}
			driver.switchTo().window(WindowID);
		}
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public By byXpath(String locator, String... values) {
		return By.xpath(String.format(locator, (Object[]) values));
	}

	public WebElement findElement(WebDriver driver, String locator) {
		return driver.findElement(byXpath(locator));
	}

	public WebElement findElement(WebDriver driver, String locator, String... values) {
		return driver.findElement(byXpath(locator, values));
	}

	public List<WebElement> findElements(WebDriver driver, String locator) {
		return driver.findElements(byXpath(locator));
	}

	public List<WebElement> findElements(WebDriver driver, String locator, String... values) {
		return driver.findElements(byXpath(locator, values));
	}

	public void clickToElement(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		if (driver.toString().contains("internet explorer")) {
			clickByJS(driver, locator);
			sleepInSecond(3000);
		} else {
			element.click();
		}
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		element = findElement(driver, locator, values);
		if (driver.toString().contains("internet explorer")) {
			clickByJS(driver, locator, values);
			sleepInSecond(3000);
		} else {
			element.click();
		}
	}

	public void inputToElement(WebDriver driver, String locator, String valueToInput) {
		clearData(driver, locator);
		findElement(driver, locator).sendKeys(valueToInput);
	}

	public void inputToElement(WebDriver driver, String locator, String valueToInput, String... values) {
		clearData(driver, locator);
		findElement(driver, locator, values).sendKeys(valueToInput);
	}

	public void selectItemInDropDown(WebDriver driver, String locator, String valueOfSelectedItem) {
		select = new Select(findElement(driver, locator));
		select.selectByVisibleText(valueOfSelectedItem);
	}

	public void selectItemInDropDown(WebDriver driver, String locator, String valueOfSelectedItem, String... values) {
		select = new Select(findElement(driver, locator, values));
		select.selectByVisibleText(valueOfSelectedItem);
	}

	public String getSelectedItemInDropDown(WebDriver driver, String locator) {
		select = new Select(findElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropDownMultiple(WebDriver driver, String locator) {
		select = new Select(findElement(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropDown(WebDriver driver, String parentlocator, String allLocatorInDropDown,
			String valueOfSelectedItem) {
		findElement(driver, parentlocator).click();
		waitForAllElementVisible(driver, allLocatorInDropDown);
		List<WebElement> listItemInDropDown = findElements(driver, allLocatorInDropDown);
		for (WebElement eachItem : listItemInDropDown) {
			if (eachItem.getText().equals(valueOfSelectedItem)) {
				eachItem.click();
				break;
			}
		}
	}

	public String getAttributeValue(WebDriver driver, String locator, String nameOfAttribute) {
		return findElement(driver, locator).getAttribute(nameOfAttribute);
	}

	public String getTextElement(WebDriver driver, String locator) {
		return findElement(driver, locator).getText();
	}

	public String getTextElement(WebDriver driver, String locator, String... values) {
		return findElement(driver, locator, values).getText();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		return findElements(driver, locator).size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void unCheckTheCheckbox(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void checkTheCheckbox(WebDriver driver, String locator, boolean status, String... values) {
		element = findElement(driver, locator, values);
		if (!element.isSelected() == status) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		overideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElement(driver, locator);
			overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isDisplayed();
		} catch (Exception ex) {
			overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return false;
		}

	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		overideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			element = findElement(driver, locator, values);
			overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return element.isDisplayed();
		} catch (Exception ex) {
			overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
			return false;
		}
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		return element.isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		element = findElement(driver, locator, values);
		return element.isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		return element.isEnabled();
	}

	public WebDriver switchToIFrame(WebDriver driver, String locator) {
		return driver.switchTo().frame(findElement(driver, locator));
	}

	public WebDriver SwitchToDefaultContent() {
		return driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(findElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(findElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator, String... value) {
		action = new Actions(driver);
		action.moveToElement(findElement(driver, locator, value)).perform();
	}

	public void rightClick(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(findElement(driver, locator)).perform();
	}

	public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(findElement(driver, sourceLocator), findElement(driver, targetLocator)).perform();
	}

	public void sendKeyboardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(findElement(driver, locator), key).perform();
	}

	public void scrollToBottomPage(WebDriver driver) {
		javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void scrollToElement(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickByJS(WebDriver driver, String locator) {
		element = findElement(driver, locator);
		javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", element);
	}

	public void clickByJS(WebDriver driver, String locator, String... values) {
		element = findElement(driver, locator, values);
		javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", element);
	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WebElement waitForAElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
	}

	public WebElement waitForAElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator, values)));
	}

	public List<WebElement> waitForAllElementVisible(WebDriver driver, String allLocator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(byXpath(allLocator)));
	}

	public void waitForAElementInvisible(WebDriver driver, String locator) {
		overideGlobalTimeout(driver, GlobalConstants.SHORT_TIMEOUT);
		try {
			explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		overideGlobalTimeout(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public boolean waitForAllElementInvisible(WebDriver driver, String allLocator) {
		List<WebElement> elements = findElements(driver, allLocator);
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(elements));
	}

	public WebElement waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator, values)));
	}

	public WebElement waitForAElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
	}

	public List<WebElement> waitForAllElementPresence(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(locator)));
	}

	public Alert waitForAlertPresence() {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void clearData(WebDriver driver, String locator) {
		findElement(driver, locator).clear();
	}

	public void overideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public void openPageInHeader(WebDriver driver, String values) {
		waitForElementClickable(driver, CommonPageUIs.DYNAMIC_HEADER, values);
		clickToElement(driver, CommonPageUIs.DYNAMIC_HEADER, values);
	}
	
	public String getInlineErrorMessage(WebDriver driver, String values) {
		waitForAElementVisible(driver, CommonPageUIs.DYNAMIC_INLINE_ERROR_MESSAGE, values);
		return getTextElement(driver, CommonPageUIs.DYNAMIC_INLINE_ERROR_MESSAGE, values);
	}
	
	public void openPageInLeftMenuInMyAccountPage(WebDriver driver, String itemName) {
		waitForAElementVisible(driver, CommonPageUIs.DYNAMIC_LEFT_MENU_IN_MY_ACCOUNT_PAGE, itemName);
		clickToElement(driver, CommonPageUIs.DYNAMIC_LEFT_MENU_IN_MY_ACCOUNT_PAGE, itemName);
	}
	
}
