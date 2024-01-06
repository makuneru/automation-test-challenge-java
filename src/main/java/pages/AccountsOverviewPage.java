package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonUtils;
import utils.ElementUtils;

public class AccountsOverviewPage extends GlobalNavigationMenu {

    private WebDriver driver;
	private ElementUtils elementUtils;
	
    public AccountsOverviewPage(WebDriver driver) {
    	super(driver);
    	this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    private WebElement ttlAccountOverview;

    @FindBy(css = "div[ng-if='showDetails'] h1[class='title']")
    private WebElement ttlAccountDetails;

    @FindBy(id = "accountId")
    private WebElement lblAccountNumber;

    @FindBy(id = "accountType")
    private WebElement lblAccountType;

    @FindBy(id = "balance")
    private WebElement lblBalance;

    @FindBy(id = "availableBalance")
    private WebElement lblAvailableBalance;

    public WebElement getTtlAccountOverview() {
        return ttlAccountOverview;
    }

    public WebElement getTtlAccountDetails() {
        return ttlAccountDetails;
    }

    public WebElement getLblAccountNumber() {
        return lblAccountNumber;
    }

    public WebElement getLblAccountType() {
        return lblAccountType;
    }

    public WebElement getLblBalance() {
        return lblBalance;
    }

    public WebElement getLblAvailableBalance() {
        return lblAvailableBalance;
    }

    public WebElement lnkAccountByAccountNumber(String accountNumber) {
        String linkSelector = String.format("a[href*='activity.htm?id=%s']", accountNumber);
        return driver.findElement(By.cssSelector(linkSelector));
    }
    
    public boolean isAccountsOverviewTitlePresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(ttlAccountOverview));
            return true; // Element is present
        } catch (org.openqa.selenium.TimeoutException e) {
            return false; // Element is not present within the timeout
        }
    }
    
    public String getLblAccountNumberText() {
	    return elementUtils.getTextFromElement(lblAccountNumber, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getLblAccountTypeText() {
        return lblAccountType.getText();
    }

    public String getLblBalanceText() {
        return lblBalance.getText();
    }

    public String getLblAvailableBalanceText() {
        return lblAvailableBalance.getText();
    }
    
}
