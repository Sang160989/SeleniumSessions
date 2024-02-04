package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);

	}

	public void doSendkeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doElementgetText(By locator) {
		return getElement(locator).getText();
	}

	public boolean doElementisDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public String getElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getTotalElementsCount(By locator) {
		int elecount = getElements(locator).size();
		System.out.println("total elements count for " + locator + "---->" + elecount);
		return elecount;
	}

	public List<String> getElementsTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String eletext = e.getText();
			eleTextList.add(eletext);
		}
		return eleTextList;
	}

	public void getElementsAttribute(By locator, String attrName) {
		List<WebElement> elelist = getElements(locator);
		for (WebElement e : elelist) {
			String attrVal = e.getAttribute(attrName);
			System.out.println(attrVal);
		}

	}

	// --------------Select dropdown utils-------------------

	public void doSelectDropdownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropdownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public void doSelectDropdownByVisbletext(By locator, String text) {
		Select select = new Select(getElement(locator));
		select.selectByValue(text);
	}

	public List<WebElement> getDropdownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();
	}

	public int getTotalDropdownListCount(By locator) {
		int optionscount = getDropdownOptionsList(locator).size();
		System.out.println("The total count of options " + optionscount);
		return optionscount;
	}

	public List<String> getDropdownOptionsTextList(By locator) {
		List<WebElement> optionslist = getDropdownOptionsList(locator);
		List<String> optionstextlist = new ArrayList<String>();
		for (WebElement e : optionslist) {
			String text = e.getText();
			optionstextlist.add(text);
		}
		return optionstextlist;

	}

	public void selectDropdownValue(By locator, String expValue) {
		List<WebElement> optionslist = getDropdownOptionsList(locator);

		for (WebElement e : optionslist) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(expValue)) {
				e.click();
				break;
			}

		}
	}

	// ************************Wait Utils **********************//
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public Alert waitForAlertPresence(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeout) {
		return waitForAlertPresence(timeout).getText();
	}

	public void acceptAlert(int timeout) {
		waitForAlertPresence(timeout).accept();
	}

	public void dismissAlert(int timeout) {
		waitForAlertPresence(timeout).dismiss();
	}

	public void alertSendkeys(String value, int timeout) {
		waitForAlertPresence(timeout).sendKeys(value);
	}

	public void waitForFrameAndSwitchToItByNAmeOrId(String IdorName, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdorName));
	}

	public void waitForFrameAndSwitchToItByIndex(int index, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public void waitForFrameAndSwitchToItByFrameElement(WebElement ele, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
	}

	public void waitForFrameAndSwitchToItByFrameLocator(By locator, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void clickWhenReady(int timeout, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	public WebElement waitForElementToBeClickable(int timeout, By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void doClickWIthActionsAndWait(int timeout, By locator) {
		WebElement ele = waitForElementToBeClickable(timeout, locator);
		Actions act = new Actions(driver);
		act.click(ele).build().perform();
	}

}
