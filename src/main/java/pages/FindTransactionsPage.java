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

public class FindTransactionsPage  extends GlobalNavigationMenu  {

	WebDriver driver;
	private ElementUtils elementUtils;

    public FindTransactionsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.elementUtils = new ElementUtils(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".title")
    private WebElement lblFindTransactions;

    @FindBy(css = "select[id='accountId']")
    private WebElement ddlAccount;

    @FindBy(css = "input[id='criteria.transactionId']")
    private WebElement txtTransactionById;

    @FindBy(css = "input[id='criteria.onDate']")
    private WebElement txtTransactionByDate;

    @FindBy(css = "input[id='criteria.fromDate']")
    private WebElement txtTransactionByDateRangeFromDate;

    @FindBy(css = "input[id='criteria.toDate']")
    private WebElement txtTransactionByDateRangeToDate;

    @FindBy(css = "input[id='criteria.amount']")
    private WebElement txtTransactionByAmount;

    @FindBy(css = "a[href*='transaction.htm']")
    private WebElement lnkTransaction;

    @FindBy(xpath = "//td[normalize-space()='Funds Transfer Received']")
    private WebElement lblTransactionDescription;

    @FindBy(xpath = "//span[contains(text(),'$')]")
    private WebElement lblTransactionAmount;

    public void selectOptionInAccountDropdown(String desiredOption) {
        elementUtils.selectOptionInDropdown(ddlAccount, desiredOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterTransactionId(String transactionId) {
        elementUtils.typeTextIntoElement(txtTransactionById, transactionId, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterTransactionDate(String transactionDate) {
        elementUtils.typeTextIntoElement(txtTransactionByDate, transactionDate, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterFromDate(String fromDate) {
        elementUtils.typeTextIntoElement(txtTransactionByDateRangeFromDate, fromDate, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterToDate(String toDate) {
        elementUtils.typeTextIntoElement(txtTransactionByDateRangeToDate, toDate, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterTransactionAmount(String transactionAmount) {
        elementUtils.typeTextIntoElement(txtTransactionByAmount, transactionAmount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickOnTransactionLink() {
        elementUtils.clickOnElement(lnkTransaction, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getLblTransactionDescriptionText() {
        return elementUtils.getTextFromElement(lnkTransaction, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getLblTransactionAmountText() {
        return elementUtils.getTextFromElement(lblTransactionAmount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickFindTransactionsBySearchType(String searchType) {
        String dynamicSelector = String.format("button[ng-click=\"criteria.searchType = '%s'\"]", searchType);
        elementUtils.clickOnElement(driver.findElement(By.cssSelector(dynamicSelector)), CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    
    public boolean isFindTransactionsLabelPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(lblFindTransactions));
            return true; // Element is present
        } catch (org.openqa.selenium.TimeoutException e) {
            return false; // Element is not present within the timeout
        }
    }
}
