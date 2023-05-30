package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@text='Get Started']")
    public WebElement getStartedBtn;

    public void clickOnGetStarted() {
        clickWhenElementVisible(getStartedBtn,20);
    }

}
