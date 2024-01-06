package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		webElement.click();
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public void selectOptionInDropdown(WebElement dropdownElement, String dropDownOption, long durationInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(dropdownElement));
	    
	    Select select = new Select(element);
	    select.selectByVisibleText(dropDownOption);
	}

	public void selectOptionInDropdownByValue(WebElement dropdownElement, String dropDownOption, long durationInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
	    WebElement element = wait.until(ExpectedConditions.visibilityOf(dropdownElement));
	    
	    Select select = new Select(element);
	    select.selectByValue(dropDownOption);
	}
	
	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForVisibilityOfElement(element, durationInSeconds);
		Actions actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}

	public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds) {
		WebElement webElement = null;

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable e) {
			e.printStackTrace();
		}

		return webElement;
	}

	public String getTextFromElement(WebElement element, long durationInSeconds) {
		WebElement webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
}
