package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class GlobalNavigationMenu {

	WebDriver driver;
	private ElementUtils elementUtils;

    public GlobalNavigationMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.elementUtils = new ElementUtils(driver);
    }

    @FindBy(css = "a[href*='openaccount.htm']")
    private WebElement lnkOpenNewAccount;

    @FindBy(css = "a[href*='overview.htm']")
    private WebElement lnkOverview;

    @FindBy(css = "a[href*='transfer.htm']")
    private WebElement lnkTransferFunds;

    @FindBy(css = "a[href*='billpay.htm']")
    private WebElement lnkBillPay;

    @FindBy(css = "a[href*='findtrans.htm']")
    private WebElement lnkFindTransactions;

    @FindBy(css = "a[href*='updateprofile.htm']")
    private WebElement lnkUpdateContactInfo;

    @FindBy(css = "a[href*='requestloan.htm']")
    private WebElement lnkRequestLoan;

    @FindBy(css = "a[href*='logout.htm']")
    private WebElement lnkLogout;

    public void clickLnkOpenNewAccount() {
        elementUtils.clickOnElement(lnkOpenNewAccount, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkOverview() {
        elementUtils.clickOnElement(lnkOverview, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkTransferFunds() {
        elementUtils.clickOnElement(lnkTransferFunds, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkBillPay() {
        elementUtils.clickOnElement(lnkBillPay, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkFindTransactions() {
        elementUtils.clickOnElement(lnkFindTransactions, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkUpdateContactInfo() {
        elementUtils.clickOnElement(lnkUpdateContactInfo, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkRequestLoan() {
        elementUtils.clickOnElement(lnkRequestLoan, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void clickLnkLogout() {
        elementUtils.clickOnElement(lnkLogout, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
