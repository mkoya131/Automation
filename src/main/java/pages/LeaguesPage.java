package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LeaguesPage extends BasePage{
    public LeaguesPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@text='Continue']")
    WebElement continueBtn;

    @AndroidFindBy(xpath = "//*[@resource-id=\"com.fivemobile.thescore:id/follow_icon\"]")
    WebElement followIcon;

    @AndroidFindBy(xpath = "//*[@text='Done']")
    WebElement doneBtn;

    public void clickOnContinue() {
        clickWhenElementVisible(continueBtn,20);
    }

    public void clickOnFollowIcon() {
        clickWhenElementVisible(followIcon, 20);
    }

    public void clickOnDone() {
        clickWhenElementVisible(doneBtn, 20);
    }
}
