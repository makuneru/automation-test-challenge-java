package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;
import utils.CommonUtils;

public class RegistrationPage extends GlobalNavigationMenu {

    private WebDriver driver;
    private ElementUtils elementUtils;
	private CommonUtils commonUtils;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.elementUtils = new ElementUtils(driver);
        this.commonUtils = new CommonUtils();
    }

    @FindBy(id = "customer.firstName")
    private WebElement txtFirstName;

    @FindBy(id = "customer.lastName")
    private WebElement txtLastName;

    @FindBy(id = "customer.address.street")
    private WebElement txtAddress;

    @FindBy(id = "customer.address.city")
    private WebElement txtCity;

    @FindBy(id = "customer.address.state")
    private WebElement txtState;

    @FindBy(id = "customer.address.zipCode")
    private WebElement txtZipCode;

    @FindBy(id = "customer.phoneNumber")
    private WebElement txtPhoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement txtSSN;

    @FindBy(id = "customer.username")
    private WebElement txtUserName;

    @FindBy(id = "customer.password")
    private WebElement txtPassword;

    @FindBy(id = "repeatedPassword")
    private WebElement txtConfirmPassword;

    @FindBy(css = "#loginPanel > :nth-child(3) > a")
    private WebElement btnPanelRegister;

    @FindBy(css = "input[value='Register']")
    private WebElement btnRegister;

    public void doRegister(String username, String password) {
        elementUtils.clickOnElement(btnPanelRegister, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtFirstName, username, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtLastName, commonUtils.getRandomLastName(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtAddress, commonUtils.getRandomAddress(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtCity, commonUtils.getRandomCity(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtState, commonUtils.getRandomState(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtZipCode, commonUtils.getRandomZipCode(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtPhoneNumber, commonUtils.getRandomPhoneNumber(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtSSN, commonUtils.getRandomSSN(), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

        elementUtils.typeTextIntoElement(txtUserName, username, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtPassword, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        elementUtils.typeTextIntoElement(txtConfirmPassword, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

        elementUtils.clickOnElement(btnRegister, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    

    public void enterFirstName(String userName) {
    	elementUtils.typeTextIntoElement(txtFirstName, userName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterLastName(String lastName) {
        elementUtils.typeTextIntoElement(txtLastName, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterAddress(String address) {
        elementUtils.typeTextIntoElement(txtAddress, address, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterCity(String city) {
        elementUtils.typeTextIntoElement(txtCity, city, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterState(String state) {
        elementUtils.typeTextIntoElement(txtState, state, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterZipCode(String zipCode) {
        elementUtils.typeTextIntoElement(txtZipCode, zipCode, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPhoneNumber(String phoneNumber) {
        elementUtils.typeTextIntoElement(txtPhoneNumber, phoneNumber, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterSSN(String ssn) {
        elementUtils.typeTextIntoElement(txtSSN, ssn, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterUserName(String userName) {
    	elementUtils.typeTextIntoElement(txtUserName, userName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterPassword(String password) {
    	elementUtils.typeTextIntoElement(txtPassword, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterConfirmPassword(String confirmPassword) {
    	elementUtils.typeTextIntoElement(txtConfirmPassword, confirmPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
	public void clickOnRegisterButton() {
		elementUtils.clickOnElement(btnPanelRegister, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}
	
	public AccountsOverviewPage clickOnConfirmRegisterButton() {
		elementUtils.clickOnElement(btnRegister, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountsOverviewPage(driver);
	}
}
