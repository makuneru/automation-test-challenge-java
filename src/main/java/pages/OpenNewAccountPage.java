package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.ElementUtils;

public class OpenNewAccountPage extends GlobalNavigationMenu {

	WebDriver driver;
	private ElementUtils elementUtils;

    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    private WebElement ttlOpenNewAccount;

    @FindBy(id = "type")
    private WebElement ddlAccountType;

    @FindBy(id = "fromAccountId")
    private WebElement ddlFromAccount;

    @FindBy(css = "input[value='Open New Account']")
    private WebElement btnOpenNewAccount;

    @FindBy(id = "newAccountId")
    private WebElement lnkNewAccountId;

    @FindBy(xpath = "//h1[normalize-space()='Account Opened!']")
    private WebElement ttlAccountOpened;

    public String getTtlOpenNewAccount() {
        return elementUtils.getTextFromElement(ttlOpenNewAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public void selectOptionInAccountTypeDropdown(String accountType) {
        elementUtils.selectOptionInDropdownByValue(ddlAccountType, accountType, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public void selectOptionFromAccountDropdown(String account) {
        elementUtils.selectOptionInDropdown(ddlFromAccount, account, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    

    public void clickOnOpenNewAccountButton() {
        elementUtils.clickOnElement(btnOpenNewAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getLnkNewAccountIdText() {
        return elementUtils.getTextFromElement(lnkNewAccountId, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public AccountsOverviewPage clickOnNewAccountId() {
        elementUtils.clickOnElement(lnkNewAccountId, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountsOverviewPage(driver); 
    }
	
    public String getTtlAccountOpened() {
        return elementUtils.getTextFromElement(ttlAccountOpened, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public boolean isAccountOpenedTitlePresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(ttlAccountOpened));
            return true; // Element is present
        } catch (org.openqa.selenium.TimeoutException e) {
            return false; // Element is not present within the timeout
        }
    }
}
