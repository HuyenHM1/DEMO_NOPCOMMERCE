package pageUIs;

public class RegisterPageUI {
	public static final String REGISTER_BUTTON = "//button[@id='register-button']";
	public static final String GENDER_RADIO_BUTTON = "//div[@id='gender']//input[@id='gender-%s']";
	public static final String FIRST_NAME_TEXTBOX = "//input[@id='FirstName']";
	public static final String LAST_NAME_TEXTBOX = "//input[@id='LastName']";
	public static final String DAY_DROP_DOWN = "//select[@name='DateOfBirthDay']";
	public static final String MONTH_DROP_DOWN = "//select[@name='DateOfBirthMonth']";
	public static final String YEAR_DROP_DOWN = "//select[@name='DateOfBirthYear']";
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String COMPANY_TEXTBOX = "//input[@id='Company']";
	public static final String NEWSLETTER_CHECKBOX = "//input[@id='Newsletter']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String CONFIRM_PASSWORD_TEXTBOX = "//input[@id='ConfirmPassword']";
	public static final String ERROR_MESSAGE_WHEN_INPUT_EXIST_EMAIL = "//div[@class='message-error validation-summary-errors']//li";
	public static final String SUCCESS_MESSAGE_WHEN_REGISTER = "//div[@class='result']";
	public static final String ERROR_MESSAGE_WHEN_INPUT_PASSWORD_LESS_THAN_6_CHARS = "//span[@id='Password-error']";
}
