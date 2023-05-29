package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class BasePage {

	AppiumDriver<MobileElement> driver;

	public BasePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public void waitForElementClickability(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementVisibility(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void enterData(By locator, String value) throws InterruptedException {
		waitForElementVisibility(locator);
		driver.findElement(locator).clear();
		Thread.sleep(1000);
		driver.findElement(locator).sendKeys(value);
	}

	public void backToNavigate() {
		driver.navigate().back();
	}

	public void click(By locator) {
		waitForElementClickability(locator);
		driver.findElement(locator).click();
	}

	public String getText(By locator) {
		waitForElementVisibility(locator);
		return driver.findElement(locator).getText();
	}

	public Boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public Boolean isElementSelected(By locator) {
		return driver.findElement(locator).isSelected();
	}

}
