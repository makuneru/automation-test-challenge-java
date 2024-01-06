package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage extends GlobalNavigationMenu {

	WebDriver driver;
	private ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
	
	@FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Log In']")
	private WebElement loginButton;

	public void enterUsername(String usernameText) {
		elementUtils.typeTextIntoElement(usernameField, usernameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void enterPassword(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public AccountsOverviewPage clickOnLoginButton() {
	    elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	    return new AccountsOverviewPage(driver);
	}

}
