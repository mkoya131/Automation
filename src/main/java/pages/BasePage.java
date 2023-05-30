package pages;

import init.DriverFactory;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.List;

public class BasePage {

	AppiumDriver<MobileElement> driver;
	WebDriverWait wait;

	public BasePage(AppiumDriver<MobileElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}


	public void waitForElementClickability(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated((locator)));
		webDriverWait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementVisibility(By locator) {
		WebDriverWait webDriverWait = new WebDriverWait(driver, 60);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void enterData(WebElement element, String value) throws InterruptedException {
		getWhenElementVisible(element, 20);
		element.clear();
		Thread.sleep(1000);
		element.sendKeys(value);
	}

	public void backToNavigate() {
		driver.navigate().back();
	}

	public void click(By locator) {
		waitForElementClickability(locator);
		driver.findElement((locator)).click();
	}

	public WebElement waitForElementClickability (WebElement element, long timeOutSeconds){
		try{
			wait = new WebDriverWait(driver, timeOutSeconds);
			return wait.until(ExpectedConditions.elementToBeClickable(element));
		}catch (Exception e){
			throw e;
		}
	}

	public WebElement getWhenElementVisible(WebElement element, long timeOutSeconds){
		try{
			wait = new WebDriverWait(driver, timeOutSeconds);
			return wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e){
			throw e;
		}
	}

	public void clickWhenElementVisible(WebElement element, long timeOutSeconds){
		WebElement returnedElement = getWhenElementVisible(element, timeOutSeconds);
		try{
			returnedElement.click();
		} catch (Exception e){
			throw e;
		}
	}

	public String getText(WebElement element) {
		getWhenElementVisible(element, 20);
		return element.getText();
	}

	public Boolean isElementPresent(WebElement element) {
		return element.isDisplayed();
	}

	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

}
